package com.wdke.stock.service;

import com.wdke.stock.common.model.ResponseVo;
import com.wdke.stock.web.vo.StockEchartVo;
import com.wdke.stock.web.vo.StockSeccodsPriceVo;

import java.util.List;

/**
 * 股票信息获取
 *
 * @Author: wdke
 * @Date: 2020-11-14 14:30
 * @Version: 1.0
 */
public interface StockService {


    StockSeccodsPriceVo get(String stockCode,Integer type);


    ResponseVo<StockEchartVo> todayPriceVolume(Integer type,String stockCode);


    ResponseVo<List<StockEchartVo>> todayHoldPriceVolume();
}
