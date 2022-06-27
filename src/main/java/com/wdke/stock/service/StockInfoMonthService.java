package com.wdke.stock.service;

import com.wdke.stock.common.model.PageParam;
import com.wdke.stock.common.model.ResponseVo;
import com.wdke.stock.storage.entity.StockInfoDay;
import com.wdke.stock.storage.entity.StockInfoMonth;
import com.wdke.stock.web.args.StockInfoMonthArgs;
import com.wdke.stock.web.vo.StockEchartVo;

import java.util.List;

/**
 * @Author: wdke
 * @Date: 2020-11-06 21:10
 * @Version: 1.0
 */
public interface StockInfoMonthService {


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
    StockInfoMonth buySellTime(List<StockInfoDay> stockInfoDays);


    /**
     * 获取每月的统计数据
     *
     * @param args
     * @param pageParam
     * @return
     */
    ResponseVo<StockEchartVo> monthListEchart(StockInfoMonthArgs args, PageParam pageParam);

}
