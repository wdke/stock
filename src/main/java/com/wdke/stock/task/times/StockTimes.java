package com.wdke.stock.task.times;

import com.wdke.stock.task.StockSnalysisAsynHandle;
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
    private StockSnalysisAsynHandle stockSnalysisAsynHandle;

    //3.添加定时任务
//    @Scheduled(cron = "0/5 * * * * ?")
    //或直接指定时间间隔，例如：5秒


    @Scheduled(cron = "30 1/5 9,10,11,13,14,15 * * 1,2,3,4,5")
    private void handleHeldToday() {


        logger.info("detail start");
        stockSnalysisAsynHandle.calculateHeldToday();
        logger.info("detail end");
    }


    /**
     * 每天最后处理数据
     */
    @Scheduled(cron = "0 1 10,11,14,15 * * 1,2,3,4,5")
    public void calculateToday00() {
        logger.info("calculateToday00 处理每天价格统计 satrt");


        stockSnalysisAsynHandle.calculateToday();


        logger.info("calculateToday00 处理每天价格统计 end");
    }


    /**
     * 计算数据
     */
    @Scheduled(cron = "0 31 10,11,13,14 * * 1,2,3,4,5")
    private void calculateToday30() {
        logger.info("calculateToday30 start ");
        stockSnalysisAsynHandle.calculateToday();
//        getKLineData();
        logger.info("calculateToday30 end ");
    }


}
