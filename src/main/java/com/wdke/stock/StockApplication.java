package com.wdke.stock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.wdke.stock.storage.dao")
@EnableTransactionManagement
@EnableScheduling
@EnableConfigurationProperties
public class StockApplication {


    public static void main(String[] args) {
        SpringApplication.run(StockApplication.class, args);
    }

}
