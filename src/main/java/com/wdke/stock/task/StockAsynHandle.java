package com.wdke.stock.task;

import com.wdke.stock.service.*;
import com.wdke.stock.storage.dao.StockInfoSnalysisMapper;
import com.wdke.stock.storage.entity.StockInfoSnalysis;
import com.wdke.stock.storage.entity.StockInfoSnalysisExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * 股票异步多线程处理
 *
 * @Author: wdke
 * @Date: 2020-10-31 02:43
 * @Version: 1.0
 */
@Component
public class StockAsynHandle {

    private static Logger logger = LoggerFactory.getLogger(StockAsynHandle.class);


    @Autowired
    private StockInfoSnalysisMapper stockInfoSnalysisMapper;

    @Autowired
    private Executor executor;


    @Autowired
    private StockInfoYearService stockInfoYearService;

    @Autowired
    private StockInfoMonthService stockInfoMonthService;

    @Autowired
    private StockInfoMonthDiffService stockInfoMonthDiffService;


    /**
     * 处理年度信息
     */
    @Async("executor")
    public void handleYearAll() {
        logger.info("handleYearAll 加载每年每天的股价数据 start");
        long start = System.currentTimeMillis();
        StockInfoSnalysisExample example = new StockInfoSnalysisExample();
        example.setOrderByClause("stock_code desc");
        List<StockInfoSnalysis> stockInfoSnalyses = stockInfoSnalysisMapper.selectByExample(example);

        logger.info("handleYearAll 加载每年每天的股价数据 start size={}", stockInfoSnalyses.size());
        stockInfoSnalyses.forEach(obj -> {
            logger.info("handleYearAll 加载每年每天的股价数据 股票代码={},股票名称={}", obj.getStockCode(), obj.getStockName());

            executor.execute(() -> {
                stockInfoYearService.handle(obj.getStockCode(), obj.getStockType());
            });

        });
        logger.info("handleYearAll 加载每年每天的股价数据 end times={}秒", (System.currentTimeMillis() - start) / 1000);
    }


    /**
     * 处理年度信息
     */
    @Async("executor")
    public void handleMonthAll() {
        logger.info("handleMonthAll 加载每年每天的股价数据 start");
        long start = System.currentTimeMillis();
        StockInfoSnalysisExample example = new StockInfoSnalysisExample();
        example.setOrderByClause("stock_code desc");
        List<StockInfoSnalysis> stockInfoSnalyses = stockInfoSnalysisMapper.selectByExample(example);

        logger.info("handleMonthAll 加载每年每天的股价数据 start size={}", stockInfoSnalyses.size());
        stockInfoSnalyses.forEach(obj -> {
            logger.info("handleMonthAll 加载每年每天的股价数据 股票代码={},股票名称={}", obj.getStockCode(), obj.getStockName());

            executor.execute(() -> {
                stockInfoMonthService.handle(obj.getStockCode(), obj.getStockType());
            });

        });
        logger.info("handleMonthAll 加载每年每天的股价数据 end times={}秒", (System.currentTimeMillis() - start) / 1000);
    }

    /**
     * 处理年度差异信息
     */
    @Async("executor")
    public void handleMonthDiff() {
        logger.info("handleMonthDiff 加载每年每天的股价数据 start");
        long start = System.currentTimeMillis();
        StockInfoSnalysisExample example = new StockInfoSnalysisExample();
        example.setOrderByClause("stock_code desc");
        List<StockInfoSnalysis> stockInfoSnalyses = stockInfoSnalysisMapper.selectByExample(example);

        logger.info("handleMonthDiff 加载每年每天的股价数据 start size={}", stockInfoSnalyses.size());
        stockInfoSnalyses.forEach(obj -> {
            logger.info("handleMonthDiff 加载每年每天的股价数据 股票代码={},股票名称={}", obj.getStockCode(), obj.getStockName());

            executor.execute(() -> {
                stockInfoMonthDiffService.handle(obj.getStockCode(), obj.getStockType());
            });

        });
        logger.info("handleMonthDiff 加载每年每天的股价数据 end times={}秒", (System.currentTimeMillis() - start) / 1000);
    }





}
