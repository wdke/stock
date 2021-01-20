package com.wdke.stock.service.impl;

import com.wdke.stock.common.enums.ResponseStatusEnum;
import com.wdke.stock.common.model.ResponseVo;
import com.wdke.stock.service.StockInfoMonthDiffService;
import com.wdke.stock.storage.dao.StockInfoMonthDiffMapper;
import com.wdke.stock.storage.dao.StockInfoMonthMapper;
import com.wdke.stock.storage.entity.StockInfoMonth;
import com.wdke.stock.storage.entity.StockInfoMonthDiff;
import com.wdke.stock.storage.entity.StockInfoMonthDiffExample;
import com.wdke.stock.storage.entity.StockInfoMonthExample;
import com.wdke.stock.utils.BigDecimalUtils;
import com.wdke.stock.web.args.StockInfoMonthArgs;
import com.wdke.stock.web.vo.StockEchartVo;
import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 按照月份统计比较
 *
 * @Author: wdke
 * @Date: 1/18/21 3:48 PM
 * @Version: 1.0
 */
@Service
public class StockInfoMonthDiffServiceImpl implements StockInfoMonthDiffService {

    private static Logger logger = LoggerFactory.getLogger(StockInfoMonthDiffServiceImpl.class);

    @Autowired
    private StockInfoMonthMapper stockInfoMonthMapper;


    @Autowired
    private StockInfoMonthDiffMapper stockInfoMonthDiffMapper;


    /**
     * 处理接口
     *
     * @param stockCode
     * @param type
     */
    @Override
    public void handle(String stockCode, Integer type) {

        logger.info("handle start stockCode={},type={}", stockCode, type);
        StockInfoMonthExample example = new StockInfoMonthExample();
        example.createCriteria()
                .andStockCodeEqualTo(stockCode)
                .andStockTypeEqualTo(type);
        example.setOrderByClause("year desc,month desc ");
        List<StockInfoMonth> stockInfoMonths = stockInfoMonthMapper.selectByExample(example);

        if (stockInfoMonths.isEmpty()) {
            logger.info("handle start stockCode={},type={} 数据为空，不处理。", stockCode, type);
            return;
        }

        List<StockInfoMonthDiff> diffs = new ArrayList<>();
        int size = stockInfoMonths.size();
        for (int i = 0; i < size; i++) {

            StockInfoMonthDiff stockInfoMonthDiff = new StockInfoMonthDiff();
            StockInfoMonth thisMonth = stockInfoMonths.get(i);
            stockInfoMonthDiff.setStockCode(thisMonth.getStockCode());
            stockInfoMonthDiff.setStockName(thisMonth.getStockName());
            stockInfoMonthDiff.setStockType(thisMonth.getStockType());
            stockInfoMonthDiff.setDiff(thisMonth.getDifferences());
            stockInfoMonthDiff.setYear(thisMonth.getYear());
            stockInfoMonthDiff.setMonth(thisMonth.getMonth());
            if (i + 1 < size) {
                StockInfoMonth lastMonth = stockInfoMonths.get(i + 1);
                //同比上个月
                diffLastMonth(stockInfoMonthDiff, thisMonth, lastMonth);
            }
            if (i + 12 < size) {
                //同比去年
                StockInfoMonth lastYear = stockInfoMonths.get(i + 12);
                diffLastYear(stockInfoMonthDiff, thisMonth, lastYear);
            }

            diffs.add(stockInfoMonthDiff);
        }

        if (!diffs.isEmpty()) {
            stockInfoMonthDiffMapper.batchInsert(diffs);
        }

    }

    /**
     * 获取统计图数据
     *
     * @param args
     * @return
     */
    @Override
    public ResponseVo<List<StockEchartVo>> monthListEchart(StockInfoMonthArgs args) {

        if (null == args.getYear()) {
            args.setYear(Integer.valueOf(DateFormatUtils.format(new Date(),"yyyy"))-2);
        }
        StockInfoMonthDiffExample example = new StockInfoMonthDiffExample();
        example.createCriteria()
//                .andMonthEqualTo(args.getMonth())
                .andYearGreaterThanOrEqualTo(args.getYear())
                .andStockCodeEqualTo(args.getStockCode())
                .andStockTypeEqualTo(args.getStockType());
        example.setOrderByClause("year desc,month desc");
        List<StockInfoMonthDiff> diffs = stockInfoMonthDiffMapper.selectByExample(example);


        Map<Integer, List<StockInfoMonthDiff>> data = diffs.stream().collect(Collectors.groupingBy(StockInfoMonthDiff::getYear));

        List<String> legends = new ArrayList<>();
        List<Integer> keys = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12);
        List<StockEchartVo> list=new ArrayList<>();

        //最低同比
        List<List<Float>> lowList = new ArrayList<>();
        {

            StockEchartVo lowVo = new StockEchartVo(args.getStockCode(),"最低环比");
            lowVo.setKeys(keys);
            lowVo.setLegend(legends);
            lowVo.setData(lowList);
            list.add(lowVo);
        }


        //最高同比
        List<List<Float>> highList = new ArrayList<>();
        {

            StockEchartVo highVo = new StockEchartVo(args.getStockCode(),"最高环比");
            highVo.setKeys(keys);
            highVo.setLegend(legends);
            highVo.setData(highList);
            list.add(highVo);
        }

        //收盘同比
        List<List<Float>> closeList = new ArrayList<>();
        {

            StockEchartVo closeVo = new StockEchartVo(args.getStockCode(),"收盘环比");
            closeVo.setKeys(keys);
            closeVo.setLegend(legends);
            closeVo.setData(closeList);
            list.add(closeVo);
        }



        //收盘同比
        List<List<Float>> openList = new ArrayList<>();
        {

            StockEchartVo openVo = new StockEchartVo(args.getStockCode(),"开盘环比");
            openVo.setKeys(keys);
            openVo.setLegend(legends);
            openVo.setData(openList);
            list.add(openVo);
        }

        //最低同比
        List<List<Float>> lowYearList = new ArrayList<>();
        {

            StockEchartVo lowYearVo = new StockEchartVo(args.getStockCode(),"最低同比");
            lowYearVo.setKeys(keys);
            lowYearVo.setLegend(legends);
            lowYearVo.setData(lowYearList);
            list.add(lowYearVo);
        }


        //最高同比
        List<List<Float>> highYearList = new ArrayList<>();
        {

            StockEchartVo highYearVo = new StockEchartVo(args.getStockCode(),"最高同比");
            highYearVo.setKeys(keys);
            highYearVo.setLegend(legends);
            highYearVo.setData(highYearList);
            list.add(highYearVo);
        }

        //收盘同比
        List<List<Float>> closeYearList = new ArrayList<>();
        {

            StockEchartVo closeYearVo = new StockEchartVo(args.getStockCode(),"收盘同比");
            closeYearVo.setKeys(keys);
            closeYearVo.setLegend(legends);
            closeYearVo.setData(closeYearList);
            list.add(closeYearVo);
        }



        //收盘同比
        List<List<Float>> openYearList = new ArrayList<>();
        {

            StockEchartVo openYearVo = new StockEchartVo(args.getStockCode(),"开盘同比");
            openYearVo.setKeys(keys);
            openYearVo.setLegend(legends);
            openYearVo.setData(openYearList);
            list.add(openYearVo);
        }
        data.forEach((key,val)->{
            legends.add(key.toString());
            List<Float> low = new ArrayList<>();
            lowList.add(low);
            List<Float> high = new ArrayList<>();
            highList.add(low);
            List<Float> close = new ArrayList<>();
            closeList.add(close);
            List<Float> open = new ArrayList<>();
            openList.add(open);


            List<Float> lowYear = new ArrayList<>();
            lowYearList.add(lowYear);
            List<Float> highYear = new ArrayList<>();
            highYearList.add(highYear);
            List<Float> closeYear = new ArrayList<>();
            closeYearList.add(closeYear);
            List<Float> openYear = new ArrayList<>();
            openYearList.add(openYear);
            {

                int size = val.size() - 1;
                for (int i = size; i >= 0; i--) {
                    StockInfoMonthDiff obj = val.get(i);
                    low.add(obj.getLastMonthDiffLow()==null?0:obj.getLastMonthDiffLow());
                    open.add(obj.getLastMonthDiffOpen()==null?0:obj.getLastMonthDiffOpen());
                    high.add(obj.getLastMonthDiffHigh()==null?0:obj.getLastMonthDiffHigh());
                    close.add(obj.getLastMonthDiffClose()==null?0:obj.getLastMonthDiffClose());

                    lowYear.add(obj.getLastYearDiffLow()==null?0:obj.getLastYearDiffLow());
                    openYear.add(obj.getLastYearDiffOpen()==null?0:obj.getLastYearDiffOpen());
                    highYear.add(obj.getLastYearDiffHigh()==null?0:obj.getLastYearDiffHigh());
                    closeYear.add(obj.getLastYearDiffClose()==null?0:obj.getLastYearDiffClose());
                }

            }
        });
        return new ResponseVo<>(ResponseStatusEnum.SUCCESS, list);
    }


    /**
     * 计算上个月差异
     *
     * @param stockInfoMonthDiff
     * @param thisMonth
     * @param lastMonth
     */
    public void diffLastMonth(StockInfoMonthDiff stockInfoMonthDiff, StockInfoMonth thisMonth, StockInfoMonth lastMonth) {

        //同比上个月
        stockInfoMonthDiff.setLastMonthDiffOpen(BigDecimalUtils.diff(thisMonth.getOpen(), lastMonth.getOpen()));
        stockInfoMonthDiff.setLastMonthDiffClose(BigDecimalUtils.diff(thisMonth.getClose(), lastMonth.getClose()));
        stockInfoMonthDiff.setLastMonthDiffHigh(BigDecimalUtils.diff(thisMonth.getHigh(), lastMonth.getHigh()));
        stockInfoMonthDiff.setLastMonthDiffLow(BigDecimalUtils.diff(thisMonth.getLow(), lastMonth.getLow()));
        stockInfoMonthDiff.setLastMonthDiffBuyMoney(BigDecimalUtils.diff(thisMonth.getBuyMoney(), lastMonth.getBuyMoney()));
        stockInfoMonthDiff.setLastMonthDiffFailMoney(BigDecimalUtils.diff(thisMonth.getFailMoney(), lastMonth.getFailMoney()));
        stockInfoMonthDiff.setLastMonthDiffNetProfit(BigDecimalUtils.diff(thisMonth.getNetProfit(), lastMonth.getNetProfit()));


    }


    /**
     * 计算去年差异
     *
     * @param stockInfoMonthDiff
     * @param thisMonth
     * @param lastMonth
     */
    public void diffLastYear(StockInfoMonthDiff stockInfoMonthDiff, StockInfoMonth thisMonth, StockInfoMonth lastMonth) {

        //同比去年
        stockInfoMonthDiff.setLastYearDiffOpen(BigDecimalUtils.diff(thisMonth.getOpen(), lastMonth.getOpen()));
        stockInfoMonthDiff.setLastYearDiffClose(BigDecimalUtils.diff(thisMonth.getClose(), lastMonth.getClose()));
        stockInfoMonthDiff.setLastYearDiffHigh(BigDecimalUtils.diff(thisMonth.getHigh(), lastMonth.getHigh()));
        stockInfoMonthDiff.setLastYearDiffLow(BigDecimalUtils.diff(thisMonth.getLow(), lastMonth.getLow()));
        stockInfoMonthDiff.setLastYearDiffBuyMoney(BigDecimalUtils.diff(thisMonth.getBuyMoney(), lastMonth.getBuyMoney()));
        stockInfoMonthDiff.setLastYearDiffFailMoney(BigDecimalUtils.diff(thisMonth.getFailMoney(), lastMonth.getFailMoney()));
        stockInfoMonthDiff.setLastYearDiffNetProfit(BigDecimalUtils.diff(thisMonth.getNetProfit(), lastMonth.getNetProfit()));
    }



}
