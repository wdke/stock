package com.wdke.stock.service;

import com.wdke.stock.common.model.ResponseVo;
import com.wdke.stock.web.args.StockInfoMonthArgs;
import com.wdke.stock.web.vo.StockEchartVo;

import java.util.List;

/**
 * 按照月份统计比较
 *
 * @Author: wdke
 * @Date: 1/18/21 3:48 PM
 * @Version: 1.0
 */
public interface StockInfoMonthDiffService {


    /**
     * 根据股票计算
     *
     * @param stockCode
     * @param type
     */
    void handle(String stockCode, Integer type);


    /**
     * 获取统计图表
     *
     * @param args
     * @return
     */
    ResponseVo<List<StockEchartVo>> monthListEchart(StockInfoMonthArgs args);

}
