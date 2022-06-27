package com.wdke.stock.threads;

/**
 * 测试类
 *
 * @Author: wdke
 * @Date: 2020-10-19 11:20
 * @Version: 1.0
 */
public class TestThread {
    public static void main(String[] args) {

        StockThread stockThread = new StockThread();
        stockThread.start();
    }
}
