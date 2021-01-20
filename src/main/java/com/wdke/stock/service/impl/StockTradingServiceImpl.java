package com.wdke.stock.service.impl;

import com.wdke.stock.common.enums.ResponseStatusEnum;
import com.wdke.stock.common.model.ResponseVo;
import com.wdke.stock.service.StockHoldingsService;
import com.wdke.stock.service.StockTradingService;
import com.wdke.stock.storage.dao.StockInfoSnalysisMapper;
import com.wdke.stock.storage.dao.StockTradingMapper;
import com.wdke.stock.storage.entity.StockInfoSnalysis;
import com.wdke.stock.storage.entity.StockInfoSnalysisKey;
import com.wdke.stock.storage.entity.StockTrading;
import com.wdke.stock.storage.entity.StockTradingExample;
import com.wdke.stock.web.args.StockTradingAddArgs;
import com.wdke.stock.web.interceptor.UserContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: wdke
 * @Date: 2020-10-23 14:09
 * @Version: 1.0
 */

@Service
public class StockTradingServiceImpl implements StockTradingService {

    private static Logger logger = LoggerFactory.getLogger(StockTradingServiceImpl.class);

    @Autowired
    private StockTradingMapper stockTradingMapper;

    @Autowired
    private StockInfoSnalysisMapper stockInfoSnalysisMapper;


    @Autowired
    private StockHoldingsService stockHoldingsService;


    /**
     * 新增股票交易数据
     *
     * @param stockTradingAddArgs
     * @return
     */
    @Override
    @Transactional
    public ResponseVo<Integer> add(StockTradingAddArgs stockTradingAddArgs) {
        StockInfoSnalysisKey stockInfoSnalysisKey = new StockInfoSnalysisKey();
        if (stockTradingAddArgs.getStockCode().startsWith("sh")) {

            stockInfoSnalysisKey.setStockCode(stockTradingAddArgs.getStockCode().substring(2));
            stockInfoSnalysisKey.setStockType(0);
        }
        if (stockTradingAddArgs.getStockCode().startsWith("sz")) {

            stockInfoSnalysisKey.setStockCode(stockTradingAddArgs.getStockCode().substring(2));
            stockInfoSnalysisKey.setStockType(1);
        } else if (null == stockTradingAddArgs.getStockType()) {
            return new ResponseVo<>(ResponseStatusEnum.PARRAM_ERROR.getCode(), "");
        } else {

            stockInfoSnalysisKey.setStockCode(stockTradingAddArgs.getStockCode());
            stockInfoSnalysisKey.setStockType(stockTradingAddArgs.getStockType());
        }

        logger.info("money={},rate={},getCommission={}",stockTradingAddArgs.getMoney(),UserContext.current().getCommissionRate(),stockTradingAddArgs.getCommission());
        StockInfoSnalysis stockInfoSnalysis = stockInfoSnalysisMapper.selectByPrimaryKey(stockInfoSnalysisKey);

        StockTrading stockTrading = new StockTrading();
        {
            BeanUtils.copyProperties(stockTradingAddArgs, stockTrading);
            stockTrading.setStockType(stockInfoSnalysisKey.getStockType());
            stockTrading.setStockCode(stockInfoSnalysisKey.getStockCode());
        }

        if (null != stockInfoSnalysis) {
            stockTrading.setStockName(stockInfoSnalysis.getStockName());
        }
        stockTrading.setUserId(UserContext.current().getUserId());
        //加仓
        if (stockTradingAddArgs.getTypes() == 1) {
            stockTrading.setStampDuty(0F);
            stockHoldingsService.addStorehouse(stockInfoSnalysisKey.getStockCode(), stockInfoSnalysisKey.getStockType(), stockTradingAddArgs.getTradingNumber(), stockTradingAddArgs.getBuyMoney(), true);
        } else if (stockTradingAddArgs.getTypes() == 2) {
            //卖出
            stockHoldingsService.underweight(stockInfoSnalysisKey.getStockCode(), stockInfoSnalysisKey.getStockType(), stockTradingAddArgs.getTradingNumber(), stockTradingAddArgs.getSelltMoney(), true);
        }
        //计算实际花费
        int result = stockTradingMapper.insertSelective(stockTrading);


        return new ResponseVo<>(ResponseStatusEnum.SUCCESS, stockTrading.getId());
    }


    /**
     * 获取所有交易记录
     *
     * @return
     */
    @Override
    public ResponseVo<List<StockTrading>> list() {
        StockTradingExample stockTradingExample = new StockTradingExample();
        stockTradingExample.createCriteria()
                .andUserIdEqualTo(UserContext.current().getUserId())
                .andIdNotEqualTo(2);
        stockTradingExample.setOrderByClause("isend asc,id desc");
        List<StockTrading> stockTradings = stockTradingMapper.selectByExample(stockTradingExample);
        return new ResponseVo<>(ResponseStatusEnum.SUCCESS, stockTradings);
    }


    /**
     * 删除数据
     *
     * @param id
     * @return
     */
    @Override
    @Transactional
    public ResponseVo<Integer> delete(Integer id) {
        StockTrading stockTrading = stockTradingMapper.selectByPrimaryKey(id);
        //判断数据是否存在
        if (null == stockTrading || !stockTrading.getUserId().equals(UserContext.current().getUserId())) {
            logger.info("delete 数据不存在，删除失败。id={}", id);
            return new ResponseVo<>(ResponseStatusEnum.ERROR.getCode(), "数据不存在或已经被删除");
        }
        //如果是已结单的直接删除
        if (stockTrading.getIsend() != 0) {
            int result = stockTradingMapper.deleteByPrimaryKey(id);
            logger.info("delete 删除数据。id={}，nums", id, result);
            return new ResponseVo<>(ResponseStatusEnum.SUCCESS, result);
        }
        int result = stockTradingMapper.deleteByPrimaryKey(id);
        float money = stockTrading.getMoney() + stockTrading.getCommission() + stockTrading.getTransferFee();
        if (stockTrading.getTypes() == 1) {
            //减仓
            stockHoldingsService.addStorehouse(stockTrading.getStockCode(), stockTrading.getStockType(), stockTrading.getTradingNumber(), money, false);

        } else if (stockTrading.getTypes() == 2) {
            //加仓
            stockHoldingsService.underweight(stockTrading.getStockCode(), stockTrading.getStockType() , stockTrading.getTradingNumber(), money + stockTrading.getStampDuty(), false);

        }
        return new ResponseVo<>(ResponseStatusEnum.SUCCESS, result);
    }

    /**
     * 撤销操作
     *
     * @param id
     * @return
     */
    @Override
    public ResponseVo<Integer> undo(Integer id) {
        StockTrading stockTrading = stockTradingMapper.selectByPrimaryKey(id);
        //判断数据是否存在
        if (null == stockTrading || !stockTrading.getUserId().equals(UserContext.current().getUserId())) {
            logger.info("undo 数据不存在，撤销失败。id={}", id);
            return new ResponseVo<>(ResponseStatusEnum.ERROR.getCode(), "数据不存在或已经被删除");
        }
        //如果是已结单的直接删除
        if (stockTrading.getIsend() != 0) {
            logger.info("数据已经非结单操作，不可变更。id={}", id);
            return new ResponseVo<>(ResponseStatusEnum.SUCCESS);
        }
        stockTrading.setIsend(2);

        if (stockTrading.getTypes() == 1) {
            //减仓
            float money = stockTrading.getMoney() + stockTrading.getCommission() + stockTrading.getTransferFee();
            stockHoldingsService.addStorehouse(stockTrading.getStockCode(),stockTrading.getStockType(), stockTrading.getTradingNumber(), money, false);

        } else if (stockTrading.getTypes() == 2) {
            //加仓
            float money = stockTrading.getMoney() - stockTrading.getCommission() - stockTrading.getTransferFee() - stockTrading.getStampDuty();
            stockHoldingsService.underweight(stockTrading.getStockCode(),stockTrading.getStockType(), stockTrading.getTradingNumber(), money, false);

        }
        int result = stockTradingMapper.updateByPrimaryKeySelective(stockTrading);
        return new ResponseVo<>(ResponseStatusEnum.SUCCESS, result);
    }

    /**
     * 交易结单
     *
     * @param id
     * @return
     */
    @Override
    public ResponseVo<Integer> complete(Integer id) {
        StockTrading stockTrading = stockTradingMapper.selectByPrimaryKey(id);
        //判断数据是否存在
        if (null == stockTrading || !stockTrading.getUserId().equals(UserContext.current().getUserId())) {
            logger.info("end 数据不存在，删除失败。id={}", id);
            return new ResponseVo<>(ResponseStatusEnum.ERROR.getCode(), "数据不存在或已经被删除");
        }
        stockTrading.setIsend(1);

        int result = stockTradingMapper.updateByPrimaryKeySelective(stockTrading);

        return new ResponseVo<>(ResponseStatusEnum.SUCCESS, result);
    }
}
