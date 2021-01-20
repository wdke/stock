package com.wdke.stock.service;

import com.wdke.stock.common.model.ResponseVo;
import com.wdke.stock.storage.entity.StockInfoHeld;
import com.wdke.stock.web.args.StockTradingAddArgs;

import java.util.List;

/**
 * 历史每笔持仓
 *
 * @Author: wdke
 * @Date: 1/12/21 2:12 PM
 * @Version: 1.0
 */
public interface StockInfoHeldService {


    /**
     * 新增交易
     *
     * @param stockTradingAddArgs
     */
    ResponseVo<Integer> add(StockTradingAddArgs stockTradingAddArgs);


    /**
     * 办结活动数据
     *
     * @param id
     * @param price
     * @return
     */
    ResponseVo<Integer> toEnd(Integer id, Float price);


    /**
     * 获取历史交易记录
     *
     * @return
     */
    ResponseVo<List<StockInfoHeld>> list();

    /**
     * 删除数据
     *
     * @param id
     * @return
     */
    ResponseVo<Integer> delete(Integer id);
}
