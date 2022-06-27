package com.wdke.stock.service.impl;

import com.wdke.stock.common.enums.ResponseStatusEnum;
import com.wdke.stock.common.model.ResponseVo;
import com.wdke.stock.https.WangyiStockApi;
import com.wdke.stock.service.StockInfoDayService;
import com.wdke.stock.storage.dao.StockHoldingsMapper;
import com.wdke.stock.storage.dao.StockInfoDayMapper;
import com.wdke.stock.storage.dao.StockInfoSeccondsMapper;
import com.wdke.stock.storage.entity.*;
import com.wdke.stock.web.args.StockInfoDayArgs;
import com.wdke.stock.web.interceptor.UserContext;
import com.wdke.stock.web.vo.StockEchartVo;
import com.wdke.stock.web.vo.StockInfoDayVo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: wdke
 * @Date: 2020-11-06 21:11
 * @Version: 1.0
 */
@Service
public class StockInfoDayServiceImpl implements StockInfoDayService {

    private static Logger logger = LoggerFactory.getLogger(StockInfoDayServiceImpl.class);

    @Autowired
    private WangyiStockApi wangyiStockApi;


    @Autowired
    private StockInfoDayMapper stockInfoDayMapper;

    @Autowired
    private StockInfoSeccondsMapper stockInfoSeccondsMapper;

    @Autowired
    private StockHoldingsMapper stockHoldingsMapper;


    /**
     * 获取股票一年数据
     *
     * @param type
     * @param year
     * @param stockCode
     */
    @Override
    public void handle(Integer type, Integer year, String stockCode) {
        if (StringUtils.isEmpty(stockCode)) {

            logger.info("handle 股票代码错误 stockCode={}", stockCode);
            return;
        }

        List<StockInfoDay> stockInfoDays = wangyiStockApi.dayData(type, year, stockCode);
        stockInfoDays.forEach(obj -> {
            if (obj.getDay() > 20201104) {
                buySellTime(obj);
            }
        });
        if (!stockInfoDays.isEmpty()) {

            logger.info("handle 查出代码数量 stockCode={} size={}", stockCode, stockInfoDays.size());

            try {
                stockInfoDayMapper.batchInsert(stockInfoDays);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 每日计算
     *
     * @param type
     * @param stockCode
     * @return
     */
    @Override
    public StockInfoDay handleToday(Integer type, String stockCode) {
        if (StringUtils.isEmpty(stockCode)) {

            logger.info("handleToday 股票代码错误 stockCode={}", stockCode);
            return null;
        }


        StockInfoDay stockInfoDays = wangyiStockApi.dayTodayData(type, stockCode);

        buySellTime(stockInfoDays);
        return stockInfoDays;
    }

    /**
     * 每日计算保存
     *
     * @param type
     * @param stockCode
     * @return
     */
    @Override
    public StockInfoDay handleTodaySave(Integer type, String stockCode) {
        if (StringUtils.isEmpty(stockCode)) {

            logger.info("handleToday 股票代码错误 stockCode={}", stockCode);
            return null;
        }
        StockInfoDay stockInfoDays = wangyiStockApi.dayTodayData(type, stockCode);
        if (null == stockInfoDays) {
            return null;
        }

        StockInfoDayKey stockInfoDayKey = new StockInfoDayKey();
        stockInfoDayKey.setStockCode(stockCode);
        stockInfoDayKey.setStockType(type);
        stockInfoDayKey.setDay(stockInfoDays.getDay());
        StockInfoDay stockInfoDay = stockInfoDayMapper.selectByPrimaryKey(stockInfoDayKey);

        if (null == stockInfoDay) {

            buySellTime(stockInfoDays);
            stockInfoDayMapper.insertSelective(stockInfoDays);
        } else {
            buySellTime(stockInfoDays);
            stockInfoDayMapper.updateByPrimaryKeySelective(stockInfoDays);
        }

        return stockInfoDays;
    }

    /**
     * 按照天统计
     *
     * @param stockCode
     * @param type
     * @param day
     * @return
     */
    @Override
    public Float stockInfoDiffCount(String stockCode, Integer type, Integer day) {
        StockInfoDayExample example = new StockInfoDayExample();
        example.createCriteria()
                .andStockCodeEqualTo(stockCode)
                .andStockTypeEqualTo(type);
        example.setOffset(0);
        example.setLimit(day);
        example.setOrderByClause("day desc");
        List<StockInfoDay> stockInfoDays = stockInfoDayMapper.selectByExample(example);
        Float diffs = stockInfoDays.stream().map(e -> e.getDifferences()).reduce(Float::sum).get();
        return diffs;
    }

    /**
     * 计算最佳买入和卖出时间
     *
     * @param stockInfoDay
     */
    @Override
    public void buySellTime(StockInfoDay stockInfoDay) {

        StockInfoSeccondsExample example = new StockInfoSeccondsExample();
        example.createCriteria()
                .andStockCodeEqualTo(stockInfoDay.getStockCode())
                .andStockTypeEqualTo(stockInfoDay.getStockType())
                .andSeccondsGreaterThanOrEqualTo(stockInfoDay.getDay() * 10000L).andSeccondsLessThan(stockInfoDay.getDay() * 10000L + 1510);
        example.setOrderByClause("secconds asc");
        List<StockInfoSecconds> stockInfoSecconds = stockInfoSeccondsMapper.selectByExample(example);

        if (stockInfoSecconds.isEmpty()) {
            return;
        }
        int length = stockInfoSecconds.size();

        float min = Integer.MAX_VALUE, max = 0, failPrice = 0, failMax = 0;
        int start = 0, end = 0, maxStart = 0, failStart = 0, failEnd = 0, failMaxStart = 0;
        for (int i = 0; i < length; i++) {
            float price = stockInfoSecconds.get(i).getPrice();

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
            if (null == stockInfoDay.getLowTime() && price == stockInfoDay.getLow()) {
                stockInfoDay.setLowTime((int) (stockInfoSecconds.get(i).getSecconds() % 10000));
            }
            if (null == stockInfoDay.getHignTime() && price == stockInfoDay.getHigh()) {
                stockInfoDay.setHignTime((int) (stockInfoSecconds.get(i).getSecconds() % 10000));
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
            stockInfoDay.setBuyTime((int) (stockInfoSecconds.get(maxStart).getSecconds() % 10000));
            stockInfoDay.setSellTime((int) (stockInfoSecconds.get(end).getSecconds() % 10000));
        } else {

            stockInfoDay.setBuyTime(0);
            stockInfoDay.setSellTime(0);
        }
        if (failMaxStart != failEnd) {
            stockInfoDay.setFailTime((int) (stockInfoSecconds.get(failMaxStart).getSecconds() % 10000));
            stockInfoDay.setFailEndTime((int) (stockInfoSecconds.get(failEnd).getSecconds() % 10000));
        } else {
            stockInfoDay.setFailTime(0);
            stockInfoDay.setFailEndTime(0);
        }


    }

    /**
     * 计算所有的
     *
     * @param type
     * @param stockCode
     */
    @Override
    public void buySellTimeAll(Integer type, String stockCode) {
        logger.info("buySellTimeAll type={},股票代码={}", type, stockCode);

        StockInfoDayExample example = new StockInfoDayExample();
        example.createCriteria().andStockCodeEqualTo(stockCode)
                .andStockTypeEqualTo(type).andDayGreaterThan(20201104);
        List<StockInfoDay> stockInfoDays = stockInfoDayMapper.selectByExample(example);
        for (StockInfoDay day : stockInfoDays) {
            buySellTime(day);
        }
        if (stockInfoDays.size() > 0) {
            stockInfoDayMapper.batchInsert(stockInfoDays);
        }
    }

    /**
     * 计算单个
     *
     * @param type
     * @param stockCode
     * @return
     */
    @Override
    public ResponseVo<StockEchartVo> buySellCont(Integer type, String stockCode) {
        StockInfoDayExample example = new StockInfoDayExample();
        example.createCriteria()
                .andStockTypeEqualTo(type)
                .andStockCodeEqualTo(stockCode)
                .andDayGreaterThanOrEqualTo(20201106);
        example.setOrderByClause("day asc");
        List<StockInfoDay> stockInfoDays = stockInfoDayMapper.selectByExample(example);
        if (stockInfoDays.isEmpty()) {
            return new ResponseVo<>(ResponseStatusEnum.PARRAM_ERROR);
        }
        List<Integer> key = stockInfoDays.stream().map(StockInfoDay::getDay).collect(Collectors.toList());
        List<Integer> valus = stockInfoDays.stream().map(StockInfoDay::getBuyTime).collect(Collectors.toList());
        List<Integer> valus2 = stockInfoDays.stream().map(StockInfoDay::getSellTime).collect(Collectors.toList());
        List<Integer> valus3 = stockInfoDays.stream().map(StockInfoDay::getFailTime).collect(Collectors.toList());
        List<Integer> valus4 = stockInfoDays.stream().map(StockInfoDay::getFailEndTime).collect(Collectors.toList());

        StockEchartVo result = new StockEchartVo();
        result.setKeys(key);
        List<List<Integer>> data = new ArrayList<>();
        data.add(valus);
        data.add(valus2);
        data.add(valus3);
        data.add(valus4);
        result.setData(data);
        result.setStockCode(stockCode);
        result.setStockName(stockInfoDays.get(0).getStockName());
        result.setTitle("股票最佳交易");
        List<String> legend = new ArrayList<>();
        legend.add("上升开始");
        legend.add("上升终止");
        legend.add("下降开始");
        legend.add("下降终止");
        result.setLegend(legend);
        return new ResponseVo<>(ResponseStatusEnum.SUCCESS, result);
    }

    /**
     * 持仓买入卖出
     *
     * @return
     */
    @Override
    public ResponseVo<List<StockEchartVo>> buySellContHole() {


        StockHoldingsExample example = new StockHoldingsExample();
        example.createCriteria()
                .andUserIdEqualTo(UserContext.current().getUserId());
        List<StockHoldings> stockHoldings = stockHoldingsMapper.selectByExample(example);
        List<StockEchartVo> data = new ArrayList<>();
        stockHoldings.forEach(obj -> {
            StockEchartVo stockEchartVo = buySellCont(obj.getStockType(), obj.getStockCode()).getData();
            if (null != stockEchartVo) {
                data.add(stockEchartVo);
            }
        });
        return new ResponseVo<>(ResponseStatusEnum.SUCCESS, data);
    }


    /**
     * 获取持仓的列表分析
     *
     * @return
     */
    @Override
    public ResponseVo<List<StockInfoDayVo>> heldList(StockInfoDayArgs args) {

        StockHoldingsExample holdingsExample = new StockHoldingsExample();
        holdingsExample.createCriteria()
                .andUserIdEqualTo(UserContext.current().getUserId());
        List<StockHoldings> stockHoldings = stockHoldingsMapper.selectByExample(holdingsExample);
        if (stockHoldings.isEmpty()) {
            logger.info("heldList 关注为空。");
            return new ResponseVo<>(ResponseStatusEnum.SUCCESS);
        }

        List<StockInfoDayVo> result=new ArrayList<>();
        stockHoldings.forEach(obj -> {
            StockInfoDayVo stockInfoDayVo=new StockInfoDayVo();
            StockInfoDayExample example = new StockInfoDayExample();
            example.createCriteria()
                    .andBuyTimeIsNotNull()
                    .andStockTypeEqualTo(obj.getStockType())
                    .andStockCodeEqualTo(obj.getStockCode());
            example.setLimit(10);
            example.setOffset(0);
            example.setOrderByClause(" day desc");
            List<StockInfoDay> stockInfoDays = stockInfoDayMapper.selectByExample(example);
            stockInfoDayVo.setStockCode(obj.getStockCode());
            stockInfoDayVo.setStockName(obj.getStockName());
            stockInfoDayVo.setStockType(obj.getStockType());
            stockInfoDayVo.setStockInfoDays(stockInfoDays);
            result.add(stockInfoDayVo);

        });
        return new ResponseVo<>(ResponseStatusEnum.SUCCESS, result);
    }
}
