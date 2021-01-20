package com.wdke.stock.service.impl;

import com.wdke.stock.common.enums.ResponseStatusEnum;
import com.wdke.stock.common.model.PageParam;
import com.wdke.stock.common.model.ResponseVo;
import com.wdke.stock.service.StockInfoMonthService;
import com.wdke.stock.storage.dao.StockInfoDayMapper;
import com.wdke.stock.storage.dao.StockInfoMonthMapper;
import com.wdke.stock.storage.entity.StockInfoDay;
import com.wdke.stock.storage.entity.StockInfoDayExample;
import com.wdke.stock.storage.entity.StockInfoMonth;
import com.wdke.stock.storage.entity.StockInfoMonthExample;
import com.wdke.stock.utils.BigDecimalUtils;
import com.wdke.stock.web.args.StockInfoMonthArgs;
import com.wdke.stock.web.vo.StockEchartVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: wdke
 * @Date: 1/8/21 10:03 AM
 * @Version: 1.0
 */
@Service
public class StockInfoMonthServiceImpl implements StockInfoMonthService {

    private static Logger logger = LoggerFactory.getLogger(StockInfoMonthServiceImpl.class);

    @Autowired
    private StockInfoDayMapper stockInfoDayMapper;
    @Autowired
    private StockInfoMonthMapper stockInfoMonthMapper;

    /**
     * 根据股票计算
     *
     * @param stockCode
     * @param type
     */
    @Override
    public void handle(String stockCode, Integer type) {
        logger.info("handle start stockCode={},type={}", stockCode, type);
        StockInfoDayExample example = new StockInfoDayExample();
        example.createCriteria()
                .andStockCodeEqualTo(stockCode)
                .andStockTypeEqualTo(type);
        example.setOrderByClause("day asc");
        List<StockInfoDay> stockInfoDays = stockInfoDayMapper.selectByExample(example);

        if (stockInfoDays.isEmpty()) {
            logger.info("handle end 数据为空 stockCode={},type={}", stockCode, type);
            return;
        }
        Map<Integer, List<StockInfoDay>> map = stockInfoDays.stream().collect(Collectors.groupingBy(StockInfoDay::getMonth));


        List<StockInfoMonth> stockInfoMonths = new ArrayList<>();
        map.forEach((key, value) -> {
            StockInfoMonth stockInfoMonth = buySellTime(value);
            if (null != stockInfoMonth) {
                stockInfoMonths.add(stockInfoMonth);
            }
        });

        if (!stockInfoMonths.isEmpty()) {
            logger.info("handle 开始保存 stockCode={},type={},size={}", stockCode, type, stockInfoMonths.size());
            stockInfoMonthMapper.batchInsert(stockInfoMonths);
        }

        logger.info("handle start 完成 stockCode={},type={}", stockCode, type);
    }

    /**
     * 计算买入最佳时机
     *
     * @param stockInfoDays
     */
    @Override
    public StockInfoMonth buySellTime(List<StockInfoDay> stockInfoDays) {

        if (null == stockInfoDays || stockInfoDays.isEmpty()) {
            return null;
        }

        int length = stockInfoDays.size();

        StockInfoMonth stockInfoMonth = new StockInfoMonth();
        {

            StockInfoDay stockInfoDay = stockInfoDays.get(0);
            stockInfoMonth.setStockCode(stockInfoDay.getStockCode());
            stockInfoMonth.setStockType(stockInfoDay.getStockType());
            stockInfoMonth.setStockName(stockInfoDay.getStockName());
            stockInfoMonth.setOpen(stockInfoDay.getClose());
            stockInfoMonth.setYear(stockInfoDay.getMonth() / 100);
            stockInfoMonth.setMonth(stockInfoDay.getMonth() % 100);
            stockInfoMonth.setClose(stockInfoDays.get(length - 1).getClose());


            stockInfoMonth.setHigh(stockInfoMonth.getClose());
            stockInfoMonth.setHignTime(stockInfoDay.getDay());
            stockInfoMonth.setLow(stockInfoMonth.getClose());
            stockInfoMonth.setLowTime(stockInfoDays.get(length - 1).getDay());
        }
        float min = Integer.MAX_VALUE, max = 0, failPrice = 0, failMax = 0, high = 0, low = stockInfoDays.get(length - 1).getClose();
        int start = 0, end = 0, maxStart = 0, failStart = 0, failEnd = 0, failMaxStart = 0;
        for (int i = 0; i < length; i++) {
            StockInfoDay stockInfoDay = stockInfoDays.get(i);
            float price = stockInfoDay.getClose();

            if (high < stockInfoDay.getClose()) {
                high = stockInfoDay.getClose();
                stockInfoMonth.setHigh(high);
                stockInfoMonth.setHignTime(stockInfoDay.getDay());
            }
            if (low > stockInfoDay.getClose()) {
                low = stockInfoDay.getClose();
                stockInfoMonth.setLow(low);
                stockInfoMonth.setLowTime(stockInfoDay.getDay());
            }
            //计算上升最佳时机
            if (price < min) {
                min = price;
                start = i;
            }

            if (max < (price - min)) {
                max = price - min;
                end = i;
                maxStart = start;
            }

            //计算下降最佳时机
            if (price > failPrice) {
                failPrice = price;
                failStart = i;
            }

            if (failMax < (failPrice - price)) {
                failMax = failPrice - price;
                failEnd = i;
                failMaxStart = failStart;
            }
        }
        if (maxStart != end) {
            stockInfoMonth.setBuyTime(stockInfoDays.get(maxStart).getDay());
            stockInfoMonth.setSellTime(stockInfoDays.get(end).getDay());
        } else {

            stockInfoMonth.setBuyTime(0);
            stockInfoMonth.setSellTime(0);
        }
        if (failMaxStart != failEnd) {
            stockInfoMonth.setFailTime(stockInfoDays.get(failMaxStart).getDay());
            stockInfoMonth.setFailEndTime(stockInfoDays.get(failEnd).getDay());
        } else {
            stockInfoMonth.setFailTime(0);
            stockInfoMonth.setFailEndTime(0);
        }
        stockInfoMonth.setDifferences(BigDecimalUtils.formatFloat((stockInfoMonth.getClose() - stockInfoMonth.getOpen()) / stockInfoMonth.getOpen(), 2));
        stockInfoMonth.setNetProfit(BigDecimalUtils.formatFloat(max - failMax, 2));
        stockInfoMonth.setBuyMoney(BigDecimalUtils.formatFloat(max, 2));
//        stockInfoMonth.setFailMoney(failMax);
        stockInfoMonth.setFailMoney(BigDecimalUtils.formatFloat(failMax, 2));

        stockInfoMonth.setBuyMoneyRate(BigDecimalUtils.formatFloat(max / stockInfoDays.get(maxStart).getClose(), 2));
//        stockInfoMonth.setFailMoney(failMax);
        stockInfoMonth.setFailMoneyRate(BigDecimalUtils.formatFloat(failMax / stockInfoDays.get(failMaxStart).getClose(), 2));

        return stockInfoMonth;
    }

    /**
     * 获取每月的统计数据
     *
     * @param args
     * @param pageParam
     * @return
     */
    @Override
    public ResponseVo<StockEchartVo> monthListEchart(StockInfoMonthArgs args, PageParam pageParam) {

        StockInfoMonthExample example = new StockInfoMonthExample();
        example.createCriteria()
                .andStockCodeEqualTo(args.getStockCode())
                .andStockTypeEqualTo(args.getStockType());
        example.setOrderByClause("year desc, month desc ");
        example.setOffset((pageParam.getCurrent() - 1) * pageParam.getPageSize());
        example.setLimit(pageParam.getPageSize());
        List<StockInfoMonth> stockInfoMonths = stockInfoMonthMapper.selectByExample(example);
        if (stockInfoMonths.isEmpty()) {
            return new ResponseVo<>(ResponseStatusEnum.PARRAM_ERROR);
        }
        StockEchartVo stockEchartVo = new StockEchartVo();
        stockEchartVo.setTitle(stockInfoMonths.get(0).getStockName());
        stockEchartVo.setStockCode(args.getStockCode());
        stockEchartVo.setStockName(stockInfoMonths.get(0).getStockName());
        List<Integer> keys = new ArrayList<>();
        List<Float> prices = new ArrayList<>();
        List<Float> buyMoney = new ArrayList<>();
        List<Float> failMoney = new ArrayList<>();
        for (int i = stockInfoMonths.size() - 1; i >= 0; i--) {
            StockInfoMonth obj = stockInfoMonths.get(i);
            keys.add(obj.getMonth());
            buyMoney.add(obj.getBuyMoneyRate());
            failMoney.add(obj.getFailMoneyRate());
            prices.add(obj.getClose());
        }

        List<List<Float>> values = new ArrayList<>();
        values.add(prices);
        values.add(buyMoney);
        values.add(failMoney);
        stockEchartVo.setKeys(keys);
        stockEchartVo.setData(values);


        List<String> legend = new ArrayList<>();
        legend.add("价格");
        legend.add("最大收益");
        legend.add("最大亏损");
        stockEchartVo.setLegend(legend);
        return new ResponseVo<>(ResponseStatusEnum.SUCCESS, stockEchartVo);
    }

}
