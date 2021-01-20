package com.wdke.stock.service.impl;

import com.alibaba.fastjson.JSON;
import com.wdke.stock.common.enums.ResponseStatusEnum;
import com.wdke.stock.common.model.ResponseVo;
import com.wdke.stock.service.StockTradingService;
import com.wdke.stock.service.StockInfoHeldService;
import com.wdke.stock.storage.dao.StockInfoHeldMapper;
import com.wdke.stock.storage.dao.StockInfoSnalysisMapper;
import com.wdke.stock.storage.entity.StockInfoHeld;
import com.wdke.stock.storage.entity.StockInfoHeldExample;
import com.wdke.stock.storage.entity.StockInfoSnalysis;
import com.wdke.stock.storage.entity.StockInfoSnalysisKey;
import com.wdke.stock.web.args.StockTradingAddArgs;
import com.wdke.stock.web.interceptor.UserContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 历史每笔持仓
 *
 * @Author: wdke
 * @Date: 1/12/21 2:13 PM
 * @Version: 1.0
 */
@Service
public class StockInfoHeldServiceImpl implements StockInfoHeldService {

    private static Logger logger = LoggerFactory.getLogger(StockInfoHeldServiceImpl.class);


    @Autowired
    private StockInfoHeldMapper stockInfoHeldMapper;


    @Autowired
    private StockInfoSnalysisMapper stockInfoSnalysisMapper;

    @Autowired
    private StockTradingService stockTradingService;

    /**
     * 新增交易
     *
     * @param stockTradingAddArgs
     */
    @Override
    public ResponseVo<Integer> add(StockTradingAddArgs stockTradingAddArgs) {
        StockInfoSnalysisKey stockInfoSnalysisKey = new StockInfoSnalysisKey();
        if (stockTradingAddArgs.getStockCode().startsWith("sh")) {
            logger.info("add sh param={}", JSON.toJSONString(stockTradingAddArgs));

            stockInfoSnalysisKey.setStockCode(stockTradingAddArgs.getStockCode().substring(2));
            stockInfoSnalysisKey.setStockType(0);
        }
        if (stockTradingAddArgs.getStockCode().startsWith("sz")) {
            logger.info("add sz param={}", JSON.toJSONString(stockTradingAddArgs));

            stockInfoSnalysisKey.setStockCode(stockTradingAddArgs.getStockCode().substring(2));
            stockInfoSnalysisKey.setStockType(1);
        } else if (null == stockTradingAddArgs.getStockType()) {
            return new ResponseVo<>(ResponseStatusEnum.PARRAM_ERROR.getCode(), "");
        } else {

            logger.info("add 空的 param={}", JSON.toJSONString(stockTradingAddArgs));

            stockInfoSnalysisKey.setStockCode(stockTradingAddArgs.getStockCode());
            stockInfoSnalysisKey.setStockType(stockTradingAddArgs.getStockType());
        }
        StockInfoSnalysis stockInfoSnalysis = stockInfoSnalysisMapper.selectByPrimaryKey(stockInfoSnalysisKey);

        ResponseVo<Integer> stockTradingResult = stockTradingService.add(stockTradingAddArgs);
        if (!stockTradingResult.isSuccess()) {
            logger.info("add stockTradingResult={}", JSON.toJSONString(stockTradingResult));
            return stockTradingResult;
        }


        StockInfoHeld stockInfoHeld = new StockInfoHeld();
        {
            stockInfoHeld.setStockCode(stockTradingAddArgs.getStockCode());
            stockInfoHeld.setStockType(stockTradingAddArgs.getStockType());
            stockInfoHeld.setNumber(stockTradingAddArgs.getTradingNumber());
            stockInfoHeld.setTypes(stockTradingAddArgs.getTypes());
            if (stockTradingAddArgs.getTypes() == 1) {

                stockInfoHeld.setMoney(-stockTradingAddArgs.getBuyMoney());
                stockInfoHeld.setBuyPrice(stockTradingAddArgs.getTradingPrice());
                stockInfoHeld.setBuyTradingId(stockTradingResult.getData());
            } else {

                stockInfoHeld.setMoney(stockTradingAddArgs.getSelltMoney());
                stockInfoHeld.setSellingPrice(stockTradingAddArgs.getTradingPrice());
                stockInfoHeld.setSellingTradingId(stockTradingResult.getData());
            }
            if (null != stockInfoSnalysis) {
                stockInfoHeld.setStockName(stockInfoSnalysis.getStockName());
            }
        }
        stockInfoHeld.setUserId(UserContext.current().getUserId());

        int i = stockInfoHeldMapper.insertSelective(stockInfoHeld);
        return new ResponseVo<>(ResponseStatusEnum.SUCCESS);

    }

    /**
     * 办结
     *
     * @param id
     * @param price
     * @return
     */
    @Override
    public ResponseVo<Integer> toEnd(Integer id, Float price) {
        logger.info("toEnd param【id={},price={}】", id, price);

        StockInfoHeld stockInfoHeld = stockInfoHeldMapper.selectByPrimaryKey(id);

        if (null == stockInfoHeld || null == stockInfoHeld.getUserId() || !stockInfoHeld.getUserId().equals(UserContext.current().getUserId())) {

            return new ResponseVo<>(ResponseStatusEnum.PARRAM_ERROR);
        }
        StockTradingAddArgs stockTradingAddArgs = new StockTradingAddArgs();
        {
            stockTradingAddArgs.setStockCode(stockInfoHeld.getStockCode());
            stockTradingAddArgs.setStockName(stockInfoHeld.getStockName());
            stockTradingAddArgs.setStockType(stockInfoHeld.getStockType());
            stockTradingAddArgs.setTradingNumber(stockInfoHeld.getNumber());
            stockTradingAddArgs.setTradingPrice(price);
            if (stockInfoHeld.getTypes() == 1) {
                stockTradingAddArgs.setTypes(2);
                stockInfoHeld.setSellingPrice(price);
                stockInfoHeld.setMoney(stockInfoHeld.getMoney() + stockTradingAddArgs.getSelltMoney());
            } else {
                stockTradingAddArgs.setTypes(1);
                stockInfoHeld.setBuyPrice(price);
                stockInfoHeld.setMoney(stockInfoHeld.getMoney() - stockTradingAddArgs.getBuyMoney());
            }

        }
        ResponseVo<Integer> stockTradingResult = stockTradingService.add(stockTradingAddArgs);
        if (!stockTradingResult.isSuccess()) {
            return stockTradingResult;
        }
        if (stockTradingAddArgs.getTypes() == 1) {
            stockInfoHeld.setBuyTradingId(stockTradingResult.getData());
        } else {
            stockInfoHeld.setSellingTradingId(stockTradingResult.getData());
        }
        stockInfoHeld.setIsend(1);
        int i = stockInfoHeldMapper.updateByPrimaryKeySelective(stockInfoHeld);
        return new ResponseVo<>(ResponseStatusEnum.SUCCESS, i);
    }

    /**
     * @return
     */
    @Override
    public ResponseVo<List<StockInfoHeld>> list() {
        StockInfoHeldExample stockInfoHeldExample = new StockInfoHeldExample();
        stockInfoHeldExample.createCriteria()
                .andUserIdEqualTo(UserContext.current().getUserId());
        stockInfoHeldExample.setOrderByClause("isend asc,types desc,id desc");
        List<StockInfoHeld> stockInfoHelds = stockInfoHeldMapper.selectByExample(stockInfoHeldExample);


        return new ResponseVo<>(ResponseStatusEnum.SUCCESS, stockInfoHelds);
    }

    /**
     * 删除数据
     *
     * @param id
     * @return
     */
    @Override
    public ResponseVo<Integer> delete(Integer id) {
        logger.info("delete param【id={}】", id);

        StockInfoHeld stockInfoHeld = stockInfoHeldMapper.selectByPrimaryKey(id);

        if (null == stockInfoHeld || !UserContext.current().getUserId().equals(stockInfoHeld.getUserId())) {

            logger.info("delete param【id={}】删除失败，数据不存在", id);
            return new ResponseVo<>(ResponseStatusEnum.PARRAM_ERROR);
        }
        stockInfoHeldMapper.deleteByPrimaryKey(id);
        if (null != stockInfoHeld.getBuyTradingId()) {
            logger.info("delete 删除交易流水 param【BuyTradingId={}】", stockInfoHeld.getBuyTradingId());
            stockTradingService.delete(stockInfoHeld.getBuyTradingId());
        }

        if (null != stockInfoHeld.getSellingTradingId()) {
            logger.info("delete 删除交易流水 param【SellingTradingId={}】", stockInfoHeld.getSellingTradingId());
            stockTradingService.delete(stockInfoHeld.getSellingTradingId());
        }
        return new ResponseVo<>(ResponseStatusEnum.SUCCESS);
    }
}
