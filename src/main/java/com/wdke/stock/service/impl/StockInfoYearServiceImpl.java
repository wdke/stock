package com.wdke.stock.service.impl;

import com.wdke.stock.service.StockInfoYearService;
import com.wdke.stock.storage.dao.StockInfoDayMapper;
import com.wdke.stock.storage.dao.StockInfoYearMapper;
import com.wdke.stock.storage.entity.StockInfoDay;
import com.wdke.stock.storage.entity.StockInfoDayExample;
import com.wdke.stock.storage.entity.StockInfoYear;
import com.wdke.stock.utils.BigDecimalUtils;
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
public class StockInfoYearServiceImpl implements StockInfoYearService {

    private static Logger logger = LoggerFactory.getLogger(StockInfoYearServiceImpl.class);

    @Autowired
    private StockInfoDayMapper stockInfoDayMapper;
    @Autowired
    private StockInfoYearMapper stockInfoYearMapper;

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
        example.createCriteria().andStockCodeEqualTo(stockCode)
                .andStockTypeEqualTo(type);
        example.setOrderByClause("day asc");
        List<StockInfoDay> stockInfoDays = stockInfoDayMapper.selectByExample(example);

        if (stockInfoDays.isEmpty()) {
            logger.info("handle end 数据为空 stockCode={},type={}", stockCode, type);
            return;
        }
        Map<Integer, List<StockInfoDay>> map = stockInfoDays.stream().collect(Collectors.groupingBy(StockInfoDay::getYear));


        List<StockInfoYear> stockInfoYears = new ArrayList<>();
        map.forEach((key, value) -> {
            StockInfoYear stockInfoYear = buySellTime(value);
            if (null != stockInfoYear) {
                stockInfoYears.add(stockInfoYear);
            }
        });

        if (!stockInfoYears.isEmpty()) {
            logger.info("handle 开始保存 stockCode={},type={},size={}", stockCode, type, stockInfoYears.size());
            stockInfoYearMapper.batchInsert(stockInfoYears);
        }

        logger.info("handle start 完成 stockCode={},type={}", stockCode, type);
    }

    /**
     * 计算买入最佳时机
     *
     * @param stockInfoDays
     */
    @Override
    public StockInfoYear buySellTime(List<StockInfoDay> stockInfoDays) {

        if (null == stockInfoDays || stockInfoDays.isEmpty()) {
            return null;
        }

        int length = stockInfoDays.size();

        StockInfoYear stockInfoYear = new StockInfoYear();
        {

            StockInfoDay stockInfoDay = stockInfoDays.get(0);
            stockInfoYear.setStockCode(stockInfoDay.getStockCode());
            stockInfoYear.setStockType(stockInfoDay.getStockType());
            stockInfoYear.setStockName(stockInfoDay.getStockName());
            stockInfoYear.setYear(stockInfoDay.getYear());
            stockInfoYear.setOpen(stockInfoDay.getClose());
            stockInfoYear.setClose(stockInfoDays.get(length - 1).getClose());
            stockInfoYear.setHigh(stockInfoYear.getClose());
            stockInfoYear.setHignTime(stockInfoDay.getDay());
            stockInfoYear.setLow(stockInfoYear.getClose());
            stockInfoYear.setLowTime(stockInfoDays.get(length - 1).getDay());
        }
        float min = Integer.MAX_VALUE, max = 0, failPrice = 0, failMax = 0, high = 0, low = stockInfoDays.get(length - 1).getClose();
        int start = 0, end = 0, maxStart = 0, failStart = 0, failEnd = 0, failMaxStart = 0;
        for (int i = 0; i < length; i++) {
            StockInfoDay stockInfoDay = stockInfoDays.get(i);
            float price = stockInfoDay.getClose();

            if (high < stockInfoDay.getClose()) {
                high = stockInfoDay.getClose();
                stockInfoYear.setHigh(high);
                stockInfoYear.setHignTime(stockInfoDay.getDay());
            }
            if (low > stockInfoDay.getClose()) {
                low = stockInfoDay.getClose();
                stockInfoYear.setLow(low);
                stockInfoYear.setLowTime(stockInfoDay.getDay());
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
            stockInfoYear.setBuyTime(stockInfoDays.get(maxStart).getDay());
            stockInfoYear.setSellTime(stockInfoDays.get(end).getDay());
        } else {

            stockInfoYear.setBuyTime(0);
            stockInfoYear.setSellTime(0);
        }
        if (failMaxStart != failEnd) {
            stockInfoYear.setFailTime(stockInfoDays.get(failMaxStart).getDay());
            stockInfoYear.setFailEndTime(stockInfoDays.get(failEnd).getDay());
        } else {
            stockInfoYear.setFailTime(0);
            stockInfoYear.setFailEndTime(0);
        }

        stockInfoYear.setDifferences(BigDecimalUtils.formatFloat((stockInfoYear.getClose()-stockInfoYear.getOpen())/stockInfoYear.getOpen() , 2));
        stockInfoYear.setNetProfit(BigDecimalUtils.formatFloat(max-failMax , 2));
        stockInfoYear.setBuyMoney(BigDecimalUtils.formatFloat(max , 2));
        stockInfoYear.setFailMoney(BigDecimalUtils.formatFloat(failMax , 2));

        stockInfoYear.setBuyMoneyRate(BigDecimalUtils.formatFloat(max / stockInfoDays.get(maxStart).getClose(), 2));
        stockInfoYear.setFailMoneyRate(BigDecimalUtils.formatFloat(failMax / stockInfoDays.get(failMaxStart).getClose(), 2));


        return stockInfoYear;
    }

}
