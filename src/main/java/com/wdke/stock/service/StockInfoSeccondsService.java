package com.wdke.stock.service;

import com.wdke.stock.common.model.ResponseVo;
import com.wdke.stock.web.vo.StockEchartVo;

import java.util.List;

/**
 * @Author: wdke
 * @Date: 2020-11-06 16:45
 * @Version: 1.0
 */
public interface StockInfoSeccondsService {


    void handle(Integer type,String stock);

    ResponseVo<StockEchartVo> comparingThreeDays(Integer type, String stockCode);

    ResponseVo<List<StockEchartVo>> comparingThreeDaysHole();
}
