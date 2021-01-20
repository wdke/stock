package com.wdke.stock.task;

import com.wdke.stock.service.*;
import com.wdke.stock.storage.dao.StockInfoSnalysisMapper;
import com.wdke.stock.storage.entity.StockInfoDay;
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
    private StockInfoSeccondsService stockInfoSeccondsService;

    @Autowired
    private StockInfoSnalysisMapper stockInfoSnalysisMapper;

    @Autowired
    private StockInfoSnalysisService stockInfoSnalysisService;

    @Autowired
    private StockInfoDayService stockInfoDayService;

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
     *
     * @param year
     */
    @Async("executor")
    public void handleDayByYear(Integer year) {
        logger.info("加载每年每天的股价数据 start year={}", year);
        long start = System.currentTimeMillis();
        StockInfoSnalysisExample example = new StockInfoSnalysisExample();
        example.setOrderByClause("stock_code desc");
        List<StockInfoSnalysis> stockInfoSnalyses = stockInfoSnalysisMapper.selectByExample(example);

        logger.info("加载每年每天的股价数据 start size={}", stockInfoSnalyses.size());
        stockInfoSnalyses.forEach(obj -> {
            logger.info("加载每年每天的股价数据 股票代码={},股票名称={} year={}", obj.getStockCode(), obj.getStockName(), year);

            executor.execute(() -> {
                handleDayByYear(year, obj.getStockType(), obj.getStockCode());
            });

        });
        logger.info("加载每年每天的股价数据 end year={} times={}秒", year, (System.currentTimeMillis() - start) / 1000);
    }


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

    /**
     * 处理年度
     *
     * @param year
     * @param type
     * @param stockCode
     */
    @Async("executor")
    public void handleDayByYear(Integer year, Integer type, String stockCode) {
        logger.info("加载每年每天的股价数据 start year={},type={},stockCode={}", year, type, stockCode);

        stockInfoDayService.handle(type, year, stockCode);

        logger.info("加载每年每天的股价数据 end year={},type={},stockCode={}", year, type, stockCode);
    }


    /**
     * 处理所有当天数据
     */
    @Async("executor")
    public void handleStockInfoDayToday() {
        logger.info("handleStockInfoDayToday start ");
        List<StockInfoSnalysis> stockInfoSnalyses = stockInfoSnalysisMapper.selectByExample(new StockInfoSnalysisExample());
        stockInfoSnalyses.forEach(obj -> {
            executor.execute(() -> {
                handleStockInfoDayToday(obj.getStockType(), obj.getStockCode());
            });
        });
//        getKLineData();
        logger.info("handleStockInfoDayToday end ");
    }

    /**
     * 处理当天数据
     */
    @Async("executor")
    public void handleStockInfoDayToday(Integer type, String stockCOde) {
        logger.info("handleStockInfoDayToday 处理当天数据 start");
        long start = System.currentTimeMillis();
        logger.info("handleStockInfoDayToday 处理当天数据 股票代码={} ", stockCOde);

        try {

            StockInfoDay stockInfoDay = stockInfoDayService.handleTodaySave(type, stockCOde);

        } catch (Exception e) {
            logger.error("handleStockInfoDayToday 处理当天数据 出错", e);
        }
        logger.info("handleStockInfoDayToday 处理当天数据 end times={}秒", (System.currentTimeMillis() - start) / 1000);

    }

    /**
     * 处理当天数据
     */
    @Async("executor")
    public void handleSeccondsToday() {
        logger.info("处理当天数据 start");
        long start = System.currentTimeMillis();

        List<StockInfoSnalysis> stockInfoSnalyses = stockInfoSnalysisMapper.selectByExample(new StockInfoSnalysisExample());
        stockInfoSnalyses.forEach(obj -> {
            logger.info("处理当天数据 股票代码={} 股票名称={}", obj.getStockCode(), obj.getStockName());
            try {

                executor.execute(() -> {
                    stockInfoSeccondsService.handle(obj.getStockType(), obj.getStockCode());
                });

            } catch (Exception e) {
                logger.error("处理当天数据 出错", e);
            }
        });
        logger.info("处理当天数据 end times={}秒", (System.currentTimeMillis() - start) / 1000);

    }

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
                stockInfoSnalysisService.handle(obj);
            });
        });
        logger.info("计算当天数据 结束 耗时{}秒", (System.currentTimeMillis() - start) / 1000);
    }


    /**
     * 计算买卖时间
     */
    @Async("executor")
    public void buySellTimeAll() {

        List<StockInfoSnalysis> stockInfoSnalyses = stockInfoSnalysisMapper.selectByExample(null);
        stockInfoSnalyses.forEach(obj -> {
            executor.execute(() -> {
                stockInfoDayService.buySellTimeAll(obj.getStockType(), obj.getStockCode());
            });
        });
    }
}
