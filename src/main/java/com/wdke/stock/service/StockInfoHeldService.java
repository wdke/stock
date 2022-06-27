package com.wdke.stock.service;

import com.wdke.stock.common.model.ResponseVo;
import com.wdke.stock.storage.entity.StockInfoHeld;
import com.wdke.stock.web.args.StockTradingAddArgs;
import com.wdke.stock.web.vo.StockInfoEarningVo;
import com.wdke.stock.web.vo.StockInfoHeldEndVo;
import com.wdke.stock.web.vo.StockInfoHeldVo;

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
     * 获取历史交易记录(未结束)
     *
     * @return
     */
    ResponseVo<List<StockInfoHeldVo>> list();


    /**
     * 获取历史交易记录(已经结束)
     *
     * @return
     */
    ResponseVo<List<StockInfoHeldEndVo>> listEnd();

    /**
     * 获取历史交易记录
     *
     * @param stockType
     * @param stockCode
     * @return
     */
    ResponseVo<List<StockInfoHeld>> list(Integer stockType, String stockCode);

    /**
     * 删除数据
     *
     * @param id
     * @return
     */
    ResponseVo<Integer> delete(Integer id);

    /**
     * 合并多次交易
     *
     * @param ids
     * @return
     */
    ResponseVo<Integer> merge(List<Integer> ids);

    /**
     * 每日的做T收益
     *
     * @return
     */
    ResponseVo<List<StockInfoEarningVo>> holddayEaring();
}
