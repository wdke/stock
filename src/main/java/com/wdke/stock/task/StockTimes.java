package com.wdke.stock.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 股票定时任务
 *
 * @Author: wdke
 * @Date: 2020-10-21 15:47
 * @Version: 1.0
 */
@Component
public class StockTimes {

    private static Logger logger = LoggerFactory.getLogger(StockTimes.class);



    @Autowired
    private StockAsynHandle stockAsynHandle;
    //3.添加定时任务
//    @Scheduled(cron = "0/5 * * * * ?")
    //或直接指定时间间隔，例如：5秒

    /**
     * 每秒扫描
     */
//    @Scheduled(fixedRate = 1000)
//    @Scheduled(cron = "0 0/10 9,10,11,13,14,15 * * 1,2,3,4,5")
    private void detail() {


        logger.info("detail start");

        stockAsynHandle.handleStockInfoDayToday();
        try {
            Thread.sleep(180000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stockAsynHandle.calculateToday();
        logger.info("detail end");
    }

    /**
     * 每天最后处理数据
     */
    @Scheduled(cron = "0 0 15 * * 1,2,3,4,5")
    public void handleSeccondsToday() {
        logger.info("handleSeccondsToday 处理每天价格统计 satrt");

        stockAsynHandle.handleSeccondsToday();

        logger.info("handleSeccondsToday 处理每天价格统计 end");
    }


    /**
     * 每天最后处理数据
     */
    @Scheduled(cron = "0 30 11 * * 1,2,3,4,5")
    public void handleSeccondsTodayMorning() {
        logger.info("handleSeccondsTodayMorning 处理每天价格统计 satrt");

        stockAsynHandle.handleSeccondsToday();

        logger.info("handleSeccondsTodayMorning 处理每天价格统计 end");
    }
    /**
     * 每天最后处理数据
     */
    @Scheduled(cron = "0 0 16 * * 1,2,3,4,5")
    public void priceTimeHandle() {
        logger.info("priceTimeHandle 处理每天价格统计 satrt");

        handleStockInfoDayToday();
        try {
            Thread.sleep(300000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        calculateToday();


        logger.info("priceTimeHandle 处理每天价格统计 end");
    }

    /**
     * 获取半小时一次数据
     */
//    @Scheduled(fixedRate = 1000)
    @Scheduled(cron = "0 30 10,11,13,14 * * 1,2,3,4,5")
    public void handleStockInfoDayToday() {
        logger.info("handleStockInfoDayToday start ");

        stockAsynHandle.handleStockInfoDayToday();

//        getKLineData();
        logger.info("handleStockInfoDayToday end ");
    }

    /**
     * 计算数据
     */
//    @Scheduled(fixedRate = 1000)
    @Scheduled(cron = "0 0 10,11,14,15 * * 1,2,3,4,5")
    private void calculateToday() {
        logger.info("calculateToday start ");
        stockAsynHandle.calculateToday();
//        getKLineData();
        logger.info("calculateToday end ");
    }


}
