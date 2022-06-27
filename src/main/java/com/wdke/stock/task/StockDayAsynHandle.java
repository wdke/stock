package com.wdke.stock.task;

import com.wdke.stock.service.StockInfoDayService;
import com.wdke.stock.service.StockInfoSeccondsService;
import com.wdke.stock.storage.dao.StockHoldingsMapper;
import com.wdke.stock.storage.dao.StockInfoSnalysisMapper;
import com.wdke.stock.storage.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

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
public class StockDayAsynHandle {


    private static Logger logger = LoggerFactory.getLogger(StockDayAsynHandle.class);


    @Autowired
    private StockInfoDayService stockInfoDayService;

    @Autowired
    private StockInfoSeccondsService stockInfoSeccondsService;


    @Autowired
    private Executor executor;

    @Autowired
    private StockInfoSnalysisMapper stockInfoSnalysisMapper;

    @Autowired
    private StockHoldingsMapper stockHoldingsMapper;

    /**
     * 处理年度信息
     *
     * @param year
     */
    @Async("executor")
    public void handleByYear(Integer year) {
        logger.info("加载每年每天的股价数据 start year={}", year);
        long start = System.currentTimeMillis();
        StockInfoSnalysisExample example = new StockInfoSnalysisExample();
        example.setOrderByClause("stock_code desc");
        List<StockInfoSnalysis> stockInfoSnalyses = stockInfoSnalysisMapper.selectByExample(example);

        logger.info("加载每年每天的股价数据 start size={}", stockInfoSnalyses.size());
        stockInfoSnalyses.forEach(obj -> {
            logger.info("加载每年每天的股价数据 股票代码={},股票名称={} year={}", obj.getStockCode(), obj.getStockName(), year);

            executor.execute(() -> {
                stockInfoDayService.handle( obj.getStockType(), year, obj.getStockCode());
            });

        });
        logger.info("加载每年每天的股价数据 end year={} times={}秒", year, (System.currentTimeMillis() - start) / 1000);
    }

    /**
     * 处理所有当天数据
     */
    @Async("executor")
    public void handleToday() {
        logger.info("handleToday start ");
        List<StockInfoSnalysis> stockInfoSnalyses = stockInfoSnalysisMapper.selectByExample(new StockInfoSnalysisExample());
        stockInfoSnalyses.forEach(obj -> {
            executor.execute(() -> {
                stockInfoSeccondsService.handle(obj.getStockType(), obj.getStockCode());
                stockInfoDayService.handleTodaySave(obj.getStockType(), obj.getStockCode());

            });
        });
//        getKLineData();
        logger.info("handleToday end ");
    }


    /**
     * 处理持有当天数据
     */
    @Async("executor")
    public void handleHeldToday() {
        logger.info("handleHeldToday start ");
        StockHoldingsExample example = new StockHoldingsExample();
        example.createCriteria().andUserIdEqualTo(1L);
        List<StockHoldings> stockHoldings = stockHoldingsMapper.selectByExample(example);
        stockHoldings.forEach(obj -> {
            executor.execute(() -> {

                stockInfoSeccondsService.handle(obj.getStockType(), obj.getStockCode());
                stockInfoDayService.handleTodaySave(obj.getStockType(), obj.getStockCode());

            });
        });
//        getKLineData();
        logger.info("handleHeldToday end ");
    }


    /**
     * 计算买卖时间
     */
    @Async("executor")
    public void buySellTimeAll() {

        List<StockInfoSnalysis> stockInfoSnalyses = stockInfoSnalysisMapper.selectByExample(null);
        stockInfoSnalyses.forEach(obj -> {
            executor.execute(() -> {
                stockInfoSeccondsService.handle(obj.getStockType(), obj.getStockCode());
                stockInfoDayService.buySellTimeAll(obj.getStockType(), obj.getStockCode());
            });
        });
    }




}
