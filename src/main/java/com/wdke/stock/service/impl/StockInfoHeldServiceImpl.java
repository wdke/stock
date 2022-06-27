package com.wdke.stock.service.impl;

import com.alibaba.fastjson.JSON;
import com.wdke.stock.common.enums.ResponseStatusEnum;
import com.wdke.stock.common.model.ResponseVo;
import com.wdke.stock.service.StockInfoHeldService;
import com.wdke.stock.service.StockTradingService;
import com.wdke.stock.storage.dao.StockInfoHeldMapper;
import com.wdke.stock.storage.dao.StockInfoSnalysisMapper;
import com.wdke.stock.storage.dao.StockTradingMapper;
import com.wdke.stock.storage.entity.*;
import com.wdke.stock.utils.BigDecimalUtils;
import com.wdke.stock.web.args.StockTradingAddArgs;
import com.wdke.stock.web.interceptor.UserContext;
import com.wdke.stock.web.vo.StockInfoEarningVo;
import com.wdke.stock.web.vo.StockInfoHeldEndVo;
import com.wdke.stock.web.vo.StockInfoHeldVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

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
    private StockTradingMapper stockTradingMapper;


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
        stockInfoHeld.setUpdateDate(null);
        int i = stockInfoHeldMapper.updateByPrimaryKeySelective(stockInfoHeld);
        return new ResponseVo<>(ResponseStatusEnum.SUCCESS, i);
    }

    /**
     * 获取历史交易记录
     *
     * @return
     */
    @Override
    public ResponseVo<List<StockInfoHeldVo>> list() {
        StockInfoHeldExample stockInfoHeldExample = new StockInfoHeldExample();
        stockInfoHeldExample.createCriteria()
                .andIsendLessThan(1)
                .andUserIdEqualTo(UserContext.current().getUserId());
        stockInfoHeldExample.setOrderByClause("stock_code desc,id desc");
        List<StockInfoHeld> stockInfoHelds = stockInfoHeldMapper.selectByExample(stockInfoHeldExample);


        List<StockInfoHeldVo> result = stockInfoHelds.stream().map(obj -> {
            StockInfoHeldVo stockInfoHeldVo = new StockInfoHeldVo();
            BeanUtils.copyProperties(obj, stockInfoHeldVo);
            return stockInfoHeldVo;
        }).collect(Collectors.toList());
        return new ResponseVo<>(ResponseStatusEnum.SUCCESS, result);
    }

    /**
     * 获取历史交易记录(已经结束)
     *
     * @return
     */
    @Override
    public ResponseVo<List<StockInfoHeldEndVo>> listEnd() {
        StockInfoHeldExample stockInfoHeldExample = new StockInfoHeldExample();
        stockInfoHeldExample.createCriteria()
                .andIsendEqualTo(1)
                .andUserIdEqualTo(UserContext.current().getUserId());
        stockInfoHeldExample.setOrderByClause("update_date desc,types desc,id desc");
        List<StockInfoHeld> stockInfoHelds = stockInfoHeldMapper.selectByExample(stockInfoHeldExample);


        Map<String, StockInfoHeldEndVo> money = new HashMap<>();
        Map<String, List<StockInfoHeldVo>> data = stockInfoHelds.stream().map(obj -> {
            StockInfoHeldEndVo earning = money.get(obj.getStockCode() + obj.getStockType());
            if (earning == null) {
                earning = new StockInfoHeldEndVo();
                earning.setStockCode(obj.getStockCode());
                earning.setStockType(obj.getStockType());
                earning.setStockName(obj.getStockName());
                earning.setMoney(obj.getMoney());
            } else {
                earning.addMoney(obj.getMoney());
            }
            money.put(obj.getStockCode() + obj.getStockType(), earning);
            StockInfoHeldVo stockInfoHeldVo = new StockInfoHeldVo();
            BeanUtils.copyProperties(obj, stockInfoHeldVo);
            return stockInfoHeldVo;
        }).collect(Collectors.groupingBy(StockInfoHeldVo::getKey));

        List<StockInfoHeldEndVo> result = new ArrayList<>();
        money.forEach((key, val) -> {
            val.setDetail(data.get(key));
            val.setMoney(BigDecimalUtils.formatFloat(val.getMoney(), 2));
            result.add(val);
        });
        return new ResponseVo<>(ResponseStatusEnum.SUCCESS, result);
    }

    /**
     * 获取历史交易记录
     *
     * @param stockType
     * @param stockCode
     * @return
     */
    @Override
    public ResponseVo<List<StockInfoHeld>> list(Integer stockType, String stockCode) {

        StockInfoHeldExample stockInfoHeldExample = new StockInfoHeldExample();
        stockInfoHeldExample.createCriteria()
                .andStockCodeEqualTo(stockCode)
                .andStockTypeEqualTo(stockType)
                .andIsendLessThan(1)
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

    /**
     * 合并多次交易
     *
     * @param ids
     * @return
     */
    @Override
    @Transactional
    public ResponseVo<Integer> merge(List<Integer> ids) {

        //查询被合并的交易
        StockInfoHeldExample example = new StockInfoHeldExample();
        example.createCriteria()
                .andUserIdEqualTo(UserContext.current().getUserId())
                .andIdIn(ids);
        List<StockInfoHeld> stockInfoHelds = stockInfoHeldMapper.selectByExample(example);

        if (stockInfoHelds.size() != ids.size()) {
            logger.info("merge param【ids={}】合并失败，ids对应数据不全存在。", JSON.toJSONString(ids));
            return new ResponseVo<>(ResponseStatusEnum.PARRAM_ERROR);
        }

        String stockCode = stockInfoHelds.get(0).getStockCode();
        Integer stockType = stockInfoHelds.get(0).getStockType();
        String stockName = stockInfoHelds.get(0).getStockName();
        //处理交易ID
        List<Integer> tradingIds = new ArrayList<>();

        for (StockInfoHeld obj : stockInfoHelds) {
            if (!stockCode.equals(obj.getStockCode()) || stockType != obj.getStockType()) {
                logger.info("merge param【ids={}】合并失败，ids只能为同一只股票。", JSON.toJSONString(ids));
                return new ResponseVo<>(ResponseStatusEnum.PARRAM_ERROR);
            }
            // 买入的交易id
            if (obj.getBuyPrice() > 0 && null != obj.getBuyTradingId()) {
                tradingIds.add(obj.getBuyTradingId());
            }

            // 卖出的交易id
            if (obj.getSellingPrice() > 0 && null != obj.getSellingTradingId()) {
                tradingIds.add(obj.getSellingTradingId());
            }
        }
        StockTradingExample tradingExample = new StockTradingExample();
        tradingExample.createCriteria()
                .andUserIdEqualTo(UserContext.current().getUserId())
                .andIdIn(tradingIds);
        List<StockTrading> stockTradings = stockTradingMapper.selectByExample(tradingExample);


        if (stockTradings.size() != tradingIds.size()) {
            logger.info("merge param【ids={}】合并失败，ids对应数据不全存在。", JSON.toJSONString(ids));
            return new ResponseVo<>(ResponseStatusEnum.PARRAM_ERROR);
        }

        float buyMoney = 0f;
        float seliingMoney = 0f;
        int numbers = 0;

        // 开始计算买入卖出金额
        for (StockTrading obj : stockTradings) {
            if (obj.getTypes() == 1) {
                buyMoney += obj.getMoney() + obj.getCommission() + obj.getTransferFee() + obj.getStampDuty();
                numbers += obj.getTradingNumber();
            }
            if (obj.getTypes() == 2) {
                seliingMoney += (obj.getMoney() - obj.getCommission() - obj.getTransferFee() - obj.getStampDuty());
                numbers = numbers - obj.getTradingNumber();
            }
        }

        logger.info("计算中间值 buyMoney={},seliingMoney={},numbers={}", buyMoney, seliingMoney, numbers);
        StockTrading newStockTrading = new StockTrading();
        {
            newStockTrading.setStockCode(stockCode);
            newStockTrading.setStockType(stockType);
            newStockTrading.setStockName(stockName);
            newStockTrading.setMoney(numbers <= 0 ? seliingMoney - buyMoney : buyMoney - seliingMoney);
            newStockTrading.setTradingNumber(numbers > 0 ? numbers : (0 - numbers));
            newStockTrading.setIsend(numbers == 0 ? 1 : -1);
            newStockTrading.setTradingPrice(numbers == 0 ? 0 : BigDecimalUtils.formatFloat(newStockTrading.getMoney() / newStockTrading.getTradingNumber(), 3));
            newStockTrading.setTypes(numbers <= 0 ? 2 : 1);
            newStockTrading.setUserId(UserContext.current().getUserId());
            stockTradingMapper.insertSelective(newStockTrading);
        }
        stockTradings.forEach(obj -> {
            obj.setIsend(3);
            obj.setUpdateDate(null);
            stockTradingMapper.updateByPrimaryKeySelective(obj);
        });
        StockInfoHeld stockInfoHeld = new StockInfoHeld();
        {
            stockInfoHeld.setStockCode(stockCode);
            stockInfoHeld.setStockName(stockName);
            stockInfoHeld.setStockType(stockType);
            stockInfoHeld.setNumber(newStockTrading.getTradingNumber());
            stockInfoHeld.setTypes(newStockTrading.getTypes());
            if (newStockTrading.getTypes() == 1) {

                stockInfoHeld.setMoney(seliingMoney - buyMoney);
                stockInfoHeld.setBuyPrice(newStockTrading.getTradingPrice());
                stockInfoHeld.setBuyTradingId(newStockTrading.getId());
            } else {
                stockInfoHeld.setMoney(seliingMoney - buyMoney);
                stockInfoHeld.setSellingPrice(newStockTrading.getTradingPrice());
                stockInfoHeld.setSellingTradingId(newStockTrading.getId());
            }
            stockInfoHeld.setIsend(-1);
            stockInfoHeld.setUserId(UserContext.current().getUserId());
            stockInfoHeldMapper.insertSelective(stockInfoHeld);
        }
        stockInfoHelds.forEach(obj -> {
            obj.setIsend(2);
            obj.setUpdateDate(null);
            stockInfoHeldMapper.updateByPrimaryKey(obj);

        });
        return new ResponseVo<>(ResponseStatusEnum.SUCCESS);
    }

    /**
     * 每日做T收益
     *
     * @return
     */
    @Override
    public ResponseVo<List<StockInfoEarningVo>> holddayEaring() {

        StockInfoHeldExample stockInfoHeldExample = new StockInfoHeldExample();
        stockInfoHeldExample.createCriteria()
                .andIsendEqualTo(1)
                .andUserIdEqualTo(UserContext.current().getUserId());
        stockInfoHeldExample.setOrderByClause("update_date desc,types desc,id desc");
        List<StockInfoHeld> stockInfoHelds = stockInfoHeldMapper.selectByExample(stockInfoHeldExample);


        List<StockInfoEarningVo> result = new ArrayList<>();
        Map<String, StockInfoEarningVo> map = new HashMap<>();
        stockInfoHelds.forEach(obj -> {
            if (null == map.get(obj.operaterDay())) {
                map.put(obj.operaterDay(), new StockInfoEarningVo(obj.operaterDay()));
                result.add(map.get(obj.operaterDay()));
            }
            StockInfoEarningVo stockInfoEarningVo = map.get(obj.operaterDay());
            stockInfoEarningVo.addMoney(obj.getMoney());
            stockInfoEarningVo.addTimes();

        });

        return new ResponseVo<>(ResponseStatusEnum.SUCCESS, result);
    }
}
