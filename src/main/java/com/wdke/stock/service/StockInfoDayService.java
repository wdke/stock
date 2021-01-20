package com.wdke.stock.service;

import com.wdke.stock.common.model.ResponseVo;
import com.wdke.stock.storage.entity.StockInfoDay;
import com.wdke.stock.web.vo.StockEchartVo;

import java.util.List;

/**
 * @Author: wdke
 * @Date: 2020-11-06 21:10
 * @Version: 1.0
 */
public interface StockInfoDayService {


    void handle(Integer type, Integer year, String stockCode);



    StockInfoDay handleToday(Integer type, String stockCode);



    StockInfoDay handleTodaySave(Integer type, String stockCode);


    /**
     * 股票信息接口
     *
     * @param stockCode
     * @param type
     * @param day
     * @return
     */

    Float stockInfoDiffCount(String stockCode, Integer type, Integer day);



    void buySellTime(StockInfoDay stockInfoDay);


    void buySellTimeAll(Integer type, String stockCode);

    ResponseVo<StockEchartVo> buySellCont(Integer type,String stockCode);

    ResponseVo<List<StockEchartVo>> buySellContHole();
}
