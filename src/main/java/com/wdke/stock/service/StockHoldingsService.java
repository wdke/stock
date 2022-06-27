package com.wdke.stock.service;

import com.wdke.stock.common.model.ResponseVo;
import com.wdke.stock.storage.entity.StockHoldings;
import com.wdke.stock.web.vo.HeldAllMsgVo;
import com.wdke.stock.web.vo.StockCurrentHoldPriceVo;

import java.util.List;

/**
 * 股票持仓情况
 *
 * @Author: wdke
 * @Date: 2020-11-04 10:33
 * @Version: 1.0
 */
public interface StockHoldingsService {


    /**
     * 新增买入持仓
     *
     * @param stockCode
     * @param number
     * @param money
     * @return
     */
    StockHoldings buyAdd(String stockCode, Integer number, Float money);


    /**
     * 新增买入持仓
     *
     * @param stockCode
     * @param stockType
     * @param number
     * @param money
     * @return
     */
    StockHoldings buyAdd(String stockCode, Integer stockType, Integer number, Float money);

    /**
     * 新增卖出持仓
     *
     * @param stockCode
     * @param number
     * @param money
     * @return
     */
    StockHoldings sellAdd(String stockCode, Integer number, Float money);

    /**
     * 新增卖出持仓
     *
     * @param stockCode
     * @param stockType
     * @param number
     * @param money
     * @return
     */
    StockHoldings sellAdd(String stockCode, Integer stockType, Integer number, Float money);


    /**
     * 加仓
     *
     * @param stockCode
     * @param num
     * @param money
     * @param type
     * @return
     */
    StockHoldings addStorehouse(String stockCode, Integer num, Float money, boolean type);


    /**
     * 加仓
     *
     * @param stockCode
     * @param stockType
     * @param num
     * @param money
     * @param type
     * @return
     */
    StockHoldings addStorehouse(String stockCode, Integer stockType, Integer num, Float money, boolean type);

    /**
     * 减仓
     *
     * @param stockCode
     * @param num
     * @param money
     * @param type
     * @return
     */
    StockHoldings underweight(String stockCode, Integer num, Float money, boolean type);


    /**
     * 减仓
     *
     * @param stockCode
     * @param stockType
     * @param num
     * @param money
     * @param type
     * @return
     */
    StockHoldings underweight(String stockCode, Integer stockType, Integer num, Float money, boolean type);

    /**
     * 查询用书所有列表
     *
     * @return
     */
    ResponseVo<List<StockCurrentHoldPriceVo>> list();


    /**
     * 根据股票ID获取详情
     *
     * @param stockCode
     * @return
     */
    ResponseVo<StockCurrentHoldPriceVo> detail(String stockCode);


    /**
     * 根据持仓ID获取详情
     *
     * @param id
     * @return
     */
    ResponseVo<StockCurrentHoldPriceVo> detail(Integer id);

    /**
     * 关注股票
     *
     * @param type
     * @param stockCode
     * @return
     */
    ResponseVo<Integer> focus(Integer type, String stockCode);

    /**
     * 取消关注
     *
     * @param id
     * @return
     */
    ResponseVo<Integer> delete(Integer id);

    /**
     * 持仓总信息情况
     *
     * @return
     */
    ResponseVo<HeldAllMsgVo> heldAllMsg();
}
