package com.wdke.stock.threads;


import com.wdke.stock.https.SinaStockApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 扫描接口
 *
 * @Author: wdke
 * @Date: 2020-10-19 10:57
 * @Version: 1.0
 */
@Component
public class StockThread extends Thread {

    private static Logger logger = LoggerFactory.getLogger(StockThread.class);

    @Autowired
    private SinaStockApi sinaStockApi;


    @Override
    public void run() {

        float times = 0f;
        while (true) {
//            if ((times >= 9.5 && times <= 11.5) || (times >= 13 && times < 15.0)) {
            //海航控股
//            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                logger.error("线程休眠出错", e);
            } catch (Exception e) {
                logger.error("处理数据出错", e);
            }
        }
        // ...
    }
}
