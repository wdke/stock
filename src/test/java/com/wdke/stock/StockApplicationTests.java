package com.wdke.stock;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class StockApplicationTests {

    @Test
    void contextLoads() {

    }


    public static void main(String[] args) {


        Date now=new Date();
        System.out.println(now.getYear());
    }

}
