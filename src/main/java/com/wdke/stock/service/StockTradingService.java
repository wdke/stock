package com.wdke.stock.service;

import com.wdke.stock.common.model.ResponseVo;
import com.wdke.stock.storage.entity.StockTrading;
import com.wdke.stock.web.args.StockTradingAddArgs;

import java.util.List;

/**
 * @Author: wdke
 * @Date: 2020-10-23 14:08
 * @Version: 1.0
 */
public interface StockTradingService {


    ResponseVo<Integer> add(StockTradingAddArgs stockTradingAddArgs);


    ResponseVo<List<StockTrading>> list();


    ResponseVo<Integer> delete(Integer id);

    /**
     * 撤销操作
     *
     * @param id
     * @return
     */
    ResponseVo<Integer> undo(Integer id);


    /**
     * 交易结单
     * @param id
     * @return
     */
    ResponseVo<Integer> complete(Integer id);
}
