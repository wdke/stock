package com.wdke.stock.service;

import com.wdke.stock.storage.entity.StockInfoDay;
import com.wdke.stock.storage.entity.StockInfoYear;

import java.util.List;

/**
 * @Author: wdke
 * @Date: 2020-11-06 21:10
 * @Version: 1.0
 */
public interface StockInfoYearService {


    /**
     * 根据股票计算
     *
     * @param stockCode
     * @param type
     */
    void handle(String stockCode, Integer type);


    /**
     * 计算买卖时间
     *
     * @param stockInfoDays
     */
    StockInfoYear buySellTime(List<StockInfoDay> stockInfoDays);

}
