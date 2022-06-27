package com.wdke.stock.service;

import com.github.pagehelper.PageInfo;
import com.wdke.stock.common.model.ResponseVo;
import com.wdke.stock.storage.entity.StockInfoDay;
import com.wdke.stock.storage.entity.StockInfoSnalysis;
import com.wdke.stock.web.args.StockInfoSnalysisArgs;
import com.wdke.stock.web.vo.StockInfoVo;

import java.util.List;

/**
 * 计算
 *
 * @Author: wdke
 * @Date: 2020-11-09 09:46
 * @Version: 1.0
 */
public interface StockInfoSnalysisService {


    void handle(StockInfoSnalysis stockInfoSnalysis);


    PageInfo<StockInfoSnalysis> list(StockInfoSnalysisArgs args);

    /**
     * 关键字搜索
     *
     * @param words
     * @return
     */
    ResponseVo<List<StockInfoVo>> searchStockInfoList(String words);


    /**
     *
     * 计算历史最高
     * @param stockInfoDays
     * @param obj
     */
    void handleHistoryHigh(List<StockInfoDay> stockInfoDays, StockInfoSnalysis obj);


    void handleHistoryLow(List<StockInfoDay> stockInfoDays, StockInfoSnalysis obj);

    void handleNearHigh(List<StockInfoDay> stockInfoDays, StockInfoSnalysis obj);

    void handleNearLow(List<StockInfoDay> stockInfoDays, StockInfoSnalysis obj);

    void handleContineDays(List<StockInfoDay> stockInfoDays, StockInfoSnalysis obj);

    void handleDays(List<StockInfoDay> stockInfoDays, StockInfoSnalysis obj);

    void handleDaysNear(List<StockInfoDay> stockInfoDays, StockInfoSnalysis obj);

    int calculateTodayIndex(List<StockInfoDay> stockInfoDays, float price, int index);


    Integer binarySearch(List<StockInfoDay> stockInfoDays, float target);

    Integer calculateTodayValomeIndex(List<StockInfoDay> stockInfoDays, long valome, int index);

    void calculateDiff(List<StockInfoDay> stockInfoDays, StockInfoSnalysis obj);

    void calculateAveragePrice(List<StockInfoDay> stockInfoDays, StockInfoSnalysis obj);


    void buySellTime(List<StockInfoDay> stockInfoDays, StockInfoSnalysis obj);
}



