package com.wdke.stock.handles;

import com.wdke.stock.service.StockInfoDayService;
import com.wdke.stock.storage.dao.StockInfoSnalysisMapper;
import com.wdke.stock.storage.entity.StockInfoSnalysis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 启动后执行方法
 *
 * @Author: wdke
 * @Date: 2020-08-10 16:51
 * @Version: 1.0
 */
@Component
public class AfterServiceStarted implements ApplicationRunner {
    private static final Logger logger = LoggerFactory.getLogger(AfterServiceStarted.class);


    @Autowired
    private StockInfoSnalysisMapper stockInfoSnalysisMapper;

    @Autowired
    private StockInfoDayService stockInfoDayService;


    /**
     * 会在服务启动完成后立即执行
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("starting");
        logger.info("Successful service end!");

    }


    public static void main(String[] args) {
        String code="sz000011";
        System.out.println(code.substring(2));
    }


}

