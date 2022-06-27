package com.wdke.stock.task.times;

import com.wdke.stock.task.StockDayAsynHandle;
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
public class StockDayTimes {

    private static Logger logger = LoggerFactory.getLogger(StockDayTimes.class);



    @Autowired
    private StockDayAsynHandle stockDayAsynHandle;

    //3.添加定时任务
//    @Scheduled(cron = "0/5 * * * * ?")
    //或直接指定时间间隔，例如：5秒
//    @Scheduled(fixedRate = 1000)
    @Scheduled(cron = "0 1/5 9,10,11,13,14,15 * * 1,2,3,4,5")
    private void handleHeldToday() {


        logger.info("detail start");
        stockDayAsynHandle.handleHeldToday();
        logger.info("detail end");
    }


    /**
     * 获取半小时一次数据
     */
//    @Scheduled(fixedRate = 1000)
    @Scheduled(cron = "0 1 10,11,14,15 * * 1,2,3,4,5")
    public void handleToday00() {
        logger.info("handleToday00 start ");

        stockDayAsynHandle.handleToday();

//        getKLineData();
        logger.info("handleToday00 end ");
    }


    @Scheduled(cron = "0 31 10,11,13,14 * * 1,2,3,4,5")
    public void handleToday30() {
        logger.info("handleToday30 start ");

        stockDayAsynHandle.handleToday();

//        getKLineData();
        logger.info("handleToday30 end ");
    }
}
