package com.wdke.stock.task;

import com.wdke.stock.service.StockInfoDayService;
import com.wdke.stock.service.StockInfoSeccondsService;
import com.wdke.stock.service.StockInfoSnalysisService;
import com.wdke.stock.storage.dao.StockHoldingsMapper;
import com.wdke.stock.storage.dao.StockInfoSnalysisMapper;
import com.wdke.stock.storage.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * 每天的处理情况
 *
 * @Author: wdke
 * @Date: 2/3/21 2:31 PM
 * @Version: 1.0
 */
@Component
public class StockSnalysisAsynHandle {
    private static Logger logger = LoggerFactory.getLogger(StockSnalysisAsynHandle.class);


    @Autowired
    private Executor executor;

    @Autowired
    private StockInfoSnalysisMapper stockInfoSnalysisMapper;

    @Autowired
    private StockInfoSnalysisService stockInfoSnalysisService;


    @Autowired
    private StockInfoDayService stockInfoDayService;

    @Autowired
    private StockInfoSeccondsService stockInfoSeccondsService;


    @Autowired
    private StockHoldingsMapper stockHoldingsMapper;

    /**
     * 计算当天数据
     */
    @Async("executor")
    public void calculateToday() {
        logger.info("计算当天数据 开始");

        long start = System.currentTimeMillis();

        List<StockInfoSnalysis> stockInfoSnalyses = stockInfoSnalysisMapper.selectByExample(new StockInfoSnalysisExample());

        stockInfoSnalyses.forEach(obj -> {

            executor.execute(() -> {
                stockInfoSeccondsService.handle(obj.getStockType(), obj.getStockCode());
                stockInfoDayService.handleTodaySave(obj.getStockType(), obj.getStockCode());
                stockInfoSnalysisService.handle(obj);
            });
        });
        logger.info("计算当天数据 结束 耗时{}秒", (System.currentTimeMillis() - start) / 1000);
    }


    /**
     * 计算当天数据
     */
    @Async("executor")
    public void calculateHeldToday() {
        logger.info("calculateHeldToday 计算当天数据 开始");

        long start = System.currentTimeMillis();
        StockHoldingsExample example = new StockHoldingsExample();
        example.createCriteria().andUserIdEqualTo(1L);
        List<StockHoldings> stockHoldings = stockHoldingsMapper.selectByExample(example);

        stockHoldings.forEach(obj -> {

            executor.execute(() -> {
                calculate(obj.getStockType(), obj.getStockCode());
            });
        });
        logger.info("calculateHeldToday 计算当天数据 结束 耗时{}秒", (System.currentTimeMillis() - start) / 1000);
    }


    /**
     * 计算当天数据
     */
    @Async("executor")
    @Transactional
    public void calculate(Integer type, String stockCode) {
        logger.info("calculateHeldToday 计算当天数据 开始");

        long start = System.currentTimeMillis();

        stockInfoSeccondsService.handle(type,stockCode);

        stockInfoDayService.handleTodaySave(type, stockCode);

        StockInfoSnalysisKey key = new StockInfoSnalysisKey();
        {
            key.setStockCode(stockCode);
            key.setStockType(type);
        }
        StockInfoSnalysis stockInfoSnalysis = stockInfoSnalysisMapper.selectByPrimaryKey(key);
        stockInfoSnalysisService.handle(stockInfoSnalysis);
        logger.info("calculateHeldToday 计算当天数据 结束 耗时{}秒", (System.currentTimeMillis() - start) / 1000);
    }

}
