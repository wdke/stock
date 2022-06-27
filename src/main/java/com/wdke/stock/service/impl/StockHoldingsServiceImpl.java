package com.wdke.stock.service.impl;

import com.alibaba.fastjson.JSON;
import com.wdke.stock.common.enums.ResponseStatusEnum;
import com.wdke.stock.common.logger.AccessLog;
import com.wdke.stock.common.model.ResponseVo;
import com.wdke.stock.service.StockHoldingsService;
import com.wdke.stock.service.StockInfoSnalysisService;
import com.wdke.stock.service.StockService;
import com.wdke.stock.storage.dao.StockHoldingsMapper;
import com.wdke.stock.storage.dao.StockInfoDayMapper;
import com.wdke.stock.storage.dao.StockInfoSnalysisMapper;
import com.wdke.stock.storage.entity.*;
import com.wdke.stock.utils.BigDecimalUtils;
import com.wdke.stock.web.interceptor.UserContext;
import com.wdke.stock.web.vo.HeldAllMsgVo;
import com.wdke.stock.web.vo.StockCurrentHoldPriceVo;
import com.wdke.stock.web.vo.StockSeccodsPriceVo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 股票持仓情况
 *
 * @Author: wdke
 * @Date: 2020-11-04 10:33
 * @Version: 1.0
 */
@Service
public class StockHoldingsServiceImpl implements StockHoldingsService {

    private static Logger logger = LoggerFactory.getLogger(StockHoldingsServiceImpl.class);

    @Autowired
    private StockInfoSnalysisMapper stockInfoSnalysisMapper;


    @Autowired
    private StockHoldingsMapper stockHoldingsMapper;


    @Autowired
    private StockService stockService;


    @Autowired
    private StockInfoSnalysisService stockInfoSnalysisService;


    @Autowired
    private StockInfoDayMapper stockInfoDayMapper;

    /**
     * 新增持仓
     *
     * @param stockCode
     * @param number
     * @param money
     * @return
     */
    @Override
    public StockHoldings buyAdd(String stockCode, Integer number, Float money) {

        if (StringUtils.isEmpty(stockCode)) {
            return null;
        }
        if (stockCode.startsWith("sh")) {
            return buyAdd(stockCode.substring(2), 0, number, money);
        }
        if (stockCode.startsWith("sz")) {
            return buyAdd(stockCode.substring(2), 1, number, money);
        }
        return null;
    }

    /**
     * 新增买入仓位
     *
     * @param stockCode
     * @param stockType
     * @param number
     * @param money
     * @return
     */
    @Override
    public StockHoldings buyAdd(String stockCode, Integer stockType, Integer number, Float money) {
        //校验股票是否存在
        StockInfoSnalysisKey key = new StockInfoSnalysisKey();
        key.setStockCode(stockCode);
        key.setStockType(stockType);
        StockInfoSnalysis stockInfo = stockInfoSnalysisMapper.selectByPrimaryKey(key);

        if (null == stockInfo) {
            logger.info("buyAdd 股票信息不存在，股票代码={} userId={}", stockCode, UserContext.current().getUserId());
            return null;
        }
        //判断是否已经存在
        StockHoldingsExample stockHoldingsExample = new StockHoldingsExample();
        stockHoldingsExample.createCriteria()
                .andStockCodeEqualTo(stockCode)
                .andUserIdEqualTo(UserContext.current().getUserId());
        List<StockHoldings> stockHoldingList = stockHoldingsMapper.selectByExample(stockHoldingsExample);
        if (!stockHoldingList.isEmpty()) {
            logger.info("buyAdd 股票持仓已经存在，股票代码={} userId={}", stockCode, UserContext.current().getUserId());
            return null;
        }
        StockHoldings stockHoldings = new StockHoldings();
        stockHoldings.setStockCode(stockCode);
        stockHoldings.setStockName(stockInfo.getStockName());
        stockHoldings.setStockType(stockType);
        stockHoldings.setHoldNumber(number);

        stockHoldings.setBuyMoney(money);
        stockHoldings.setUserId(UserContext.current().getUserId());
        int i = stockHoldingsMapper.insertSelective(stockHoldings);

        logger.info("buyAdd 股票新增成功，股票代码={},userId={}", stockCode, UserContext.current().getUserId());
        return stockHoldings;
    }

    /**
     * 新增卖出持仓
     *
     * @param stockCode
     * @param number
     * @param money
     * @return
     */
    @Override
    public StockHoldings sellAdd(String stockCode, Integer number, Float money) {

        if (StringUtils.isEmpty(stockCode)) {
            return null;
        }
        if (stockCode.startsWith("sh")) {
            return sellAdd(stockCode.substring(2), 0, number, money);
        }
        if (stockCode.startsWith("sz")) {
            return sellAdd(stockCode.substring(2), 1, number, money);
        }
        return null;
    }

    /**
     * 新增卖出持仓
     *
     * @param stockCode
     * @param stockType
     * @param number
     * @param money
     * @return
     */
    @Override
    public StockHoldings sellAdd(String stockCode, Integer stockType, Integer number, Float money) {
        //校验股票是否存在
        StockInfoSnalysisKey key = new StockInfoSnalysisKey();
        key.setStockCode(stockCode);
        key.setStockType(stockType);
        StockInfoSnalysis stockInfo = stockInfoSnalysisMapper.selectByPrimaryKey(key);

        if (null == stockInfo) {
            logger.info("sellAdd 股票信息不存在，股票代码={} userId={}", stockCode, UserContext.current().getUserId());
            return null;
        }
        //判断是否已经存在
        StockHoldingsExample stockHoldingsExample = new StockHoldingsExample();
        stockHoldingsExample.createCriteria()
                .andStockCodeEqualTo(stockCode)
                .andStockTypeEqualTo(stockType)
                .andUserIdEqualTo(UserContext.current().getUserId());
        List<StockHoldings> stockHoldingList = stockHoldingsMapper.selectByExample(stockHoldingsExample);
        if (!stockHoldingList.isEmpty()) {
            logger.info("sellAdd 股票持仓已经存在，股票代码={} userId={}", stockCode, UserContext.current().getUserId());
            return null;
        }
        StockHoldings stockHoldings = new StockHoldings();
        stockHoldings.setStockCode(stockCode);
        stockHoldings.setStockType(stockType);
        stockHoldings.setStockName(stockInfo.getStockName());
        stockHoldings.setHoldNumber(-number);

        stockHoldings.setBuyMoney(-money);
        stockHoldings.setUserId(UserContext.current().getUserId());
        int i = stockHoldingsMapper.insertSelective(stockHoldings);

        logger.info("sellAdd 股票新增成功，股票代码={},userId={}", stockCode, UserContext.current().getUserId());
        return stockHoldings;
    }

    /**
     * 加仓
     *
     * @param stockCode
     * @param number
     * @param money
     * @return
     */
    @Override
    public StockHoldings addStorehouse(String stockCode, Integer number, Float money, boolean type) {

        if (StringUtils.isEmpty(stockCode)) {
            return null;
        }
        if (stockCode.startsWith("sh")) {
            return addStorehouse(stockCode.substring(2), 0, number, money, true);
        }
        if (stockCode.startsWith("sz")) {
            return addStorehouse(stockCode.substring(2), 1, number, money, true);
        }
        return null;
    }

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
    @Override
    public StockHoldings addStorehouse(String stockCode, Integer stockType, Integer num, Float money, boolean type) {
        //判断是否已经存在
        StockHoldingsExample stockHoldingsExample = new StockHoldingsExample();
        stockHoldingsExample.createCriteria()
                .andStockCodeEqualTo(stockCode)
                .andStockTypeEqualTo(stockType)
                .andUserIdEqualTo(UserContext.current().getUserId());
        List<StockHoldings> stockHoldingList = stockHoldingsMapper.selectByExample(stockHoldingsExample);
        if (stockHoldingList.isEmpty()) {
            logger.info("addStorehouse 股票持仓不存在存在，股票代码={} userId={}", stockCode, UserContext.current().getUserId());
            return buyAdd(stockCode, stockType, num, money);
        }
        //从新计算持仓，并且更新
        StockHoldings stockHoldings = stockHoldingList.get(0);

        //买入
        if (type) {

            stockHoldings.setHoldNumber(stockHoldings.getHoldNumber() + num);
            stockHoldings.setBuyMoney(stockHoldings.getBuyMoney() + money);
        } else {//撤销

            stockHoldings.setHoldNumber(stockHoldings.getHoldNumber() - num);
            stockHoldings.setBuyMoney(stockHoldings.getBuyMoney() - money);
        }
        stockHoldingsMapper.updateByPrimaryKeySelective(stockHoldings);
        return stockHoldings;
    }

    /**
     * 减仓操作
     *
     * @param stockCode
     * @param number
     * @param money
     * @param type
     * @return
     */
    @Override
    public StockHoldings underweight(String stockCode, Integer number, Float money, boolean type) {

        if (StringUtils.isEmpty(stockCode)) {
            return null;
        }
        if (stockCode.startsWith("sh")) {
            return underweight(stockCode.substring(2), 0, number, money, true);
        }
        if (stockCode.startsWith("sz")) {
            return underweight(stockCode.substring(2), 1, number, money, true);
        }
        return null;
    }

    /**
     * 减仓
     *
     * @param stockCode
     * @param stockType
     * @param number
     * @param money
     * @param type
     * @return
     */
    @Override
    public StockHoldings underweight(String stockCode, Integer stockType, Integer number, Float money, boolean type) {
        //判断是否已经存在
        StockHoldingsExample stockHoldingsExample = new StockHoldingsExample();
        stockHoldingsExample.createCriteria()
                .andStockCodeEqualTo(stockCode)
                .andStockTypeEqualTo(stockType)
                .andUserIdEqualTo(UserContext.current().getUserId());
        List<StockHoldings> stockHoldingList = stockHoldingsMapper.selectByExample(stockHoldingsExample);
        if (stockHoldingList.isEmpty()) {
            logger.info("underweight 股票持仓不存在存在，股票代码={} userId={}", stockCode, UserContext.current().getUserId());
            return sellAdd(stockCode, stockType, number, money);
        }
        //从新计算持仓，并且更新
        StockHoldings stockHoldings = stockHoldingList.get(0);

        //卖出
        if (type) {

            stockHoldings.setHoldNumber(stockHoldings.getHoldNumber() - number);
            stockHoldings.setSellMoney(stockHoldings.getSellMoney() + money);
        } else {//撤销

            stockHoldings.setHoldNumber(stockHoldings.getHoldNumber() + number);
            stockHoldings.setSellMoney(stockHoldings.getSellMoney() - money);
        }
        stockHoldingsMapper.updateByPrimaryKeySelective(stockHoldings);

        return stockHoldings;
    }

    /**
     * 获取数据列表
     *
     * @return
     */
    @Override
    public ResponseVo<List<StockCurrentHoldPriceVo>> list() {
        StockHoldingsExample example = new StockHoldingsExample();
        example.createCriteria()
                .andUserIdEqualTo(UserContext.current().getUserId());
        example.setOrderByClause("hold_number desc");
        List<StockHoldings> stockHoldings = stockHoldingsMapper.selectByExample(example);

        if (stockHoldings.isEmpty()) {

            logger.info("list 数据列表为空");
            return new ResponseVo<>(ResponseStatusEnum.DATA_EMPTY);
        }

        List<StockCurrentHoldPriceVo> data = stockHoldings.stream().map(obj -> {
            StockCurrentHoldPriceVo vo = new StockCurrentHoldPriceVo();
            BeanUtils.copyProperties(obj, vo);

            //处理返回值
            StockSeccodsPriceVo stock = stockService.get(obj.getStockCode(), obj.getStockType());
            vo.setStock(stock);
            if (null != stock) {
                vo.setYesterdayClosingPrice(Float.valueOf(stock.getYestClose()));
                vo.setCurrentTimePrice(Float.valueOf(stock.getClose()));
                vo.setHistoryLowPrice(Float.valueOf(stock.getLow()));
                vo.setHistoryHightPrice(Float.valueOf(stock.getHigh()));
            }
            return vo;
        }).collect(Collectors.toList());

        return new ResponseVo<>(ResponseStatusEnum.SUCCESS, data);
    }

    @Override
    public ResponseVo<StockCurrentHoldPriceVo> detail(String stockCode) {
        StockHoldingsExample example = new StockHoldingsExample();
        example.createCriteria()
                .andStockCodeEqualTo(stockCode)
                .andUserIdEqualTo(UserContext.current().getUserId());
        List<StockHoldings> stockHoldings = stockHoldingsMapper.selectByExample(example);

        if (stockHoldings.isEmpty()) {

            logger.info("detail 数据详情为空");
            return new ResponseVo<>(ResponseStatusEnum.DATA_EMPTY);
        }

        StockCurrentHoldPriceVo result = new StockCurrentHoldPriceVo();
        BeanUtils.copyProperties(stockHoldings.get(0), result);

        //处理返回值
        initStockCurrentHoldPriceVo(result);
        return new ResponseVo<>(ResponseStatusEnum.SUCCESS, result);
    }

    /**
     * 根据持仓ID获取详情
     *
     * @param id
     * @return
     */
    @Override
    public ResponseVo<StockCurrentHoldPriceVo> detail(Integer id) {

        StockHoldings stockHoldings = stockHoldingsMapper.selectByPrimaryKey(id);
        if (null == stockHoldings || !stockHoldings.getUserId().equals(UserContext.current().getUserId())) {
            logger.info("detail 数据详情为空");
            return new ResponseVo<>(ResponseStatusEnum.DATA_EMPTY);
        }

        StockCurrentHoldPriceVo result = new StockCurrentHoldPriceVo();
        BeanUtils.copyProperties(stockHoldings, result);

        //处理返回值
        initStockCurrentHoldPriceVo(result);
        return new ResponseVo<>(ResponseStatusEnum.SUCCESS, result);
    }

    /**
     * 关注股票
     *
     * @param type
     * @param stockCode
     * @return
     */
    @Override
    public ResponseVo<Integer> focus(Integer type, String stockCode) {

        StockHoldingsExample example = new StockHoldingsExample();
        example.createCriteria()
                .andUserIdEqualTo(UserContext.current().getUserId())
                .andStockCodeEqualTo(stockCode)
                .andStockTypeEqualTo(type);
        List<StockHoldings> stockHoldings1 = stockHoldingsMapper.selectByExample(example);

        if (!stockHoldings1.isEmpty()) {

            logger.info("已经关注，无需从新关注。");
            return new ResponseVo<>(ResponseStatusEnum.DATA_EMPTY);
        }
        StockInfoSnalysisKey stockInfoSnalysisKey = new StockInfoSnalysisKey();
        stockInfoSnalysisKey.setStockType(type);
        stockInfoSnalysisKey.setStockCode(stockCode);
        StockInfoSnalysis stockInfoSnalysis = stockInfoSnalysisMapper.selectByPrimaryKey(stockInfoSnalysisKey);
        if (null == stockInfoSnalysis) {

            logger.info("股票已经被删除，无需从新关注。");
            return new ResponseVo<>(ResponseStatusEnum.PARRAM_ERROR);
        }
        StockHoldings stockHoldings = new StockHoldings();
        stockHoldings.setStockType(type);
        stockHoldings.setStockCode(stockCode);
        stockHoldings.setStockName(stockInfoSnalysis.getStockName());
        stockHoldings.setUserId(UserContext.current().getUserId());
        int i = stockHoldingsMapper.insertSelective(stockHoldings);
        return new ResponseVo<>(ResponseStatusEnum.SUCCESS, stockHoldings.getId());
    }

    /**
     * 取消关注
     *
     * @param id
     * @return
     */
    @Override
    public ResponseVo<Integer> delete(Integer id) {
        StockHoldings stockHoldings = stockHoldingsMapper.selectByPrimaryKey(id);
        if (null == stockHoldings || !stockHoldings.getUserId().equals(UserContext.current().getUserId())) {
            logger.info("delete 数据不存在 id={}", id);
            return new ResponseVo<>(ResponseStatusEnum.PARRAM_ERROR);
        }
        AccessLog.getLogger().info("delete  id={},stockHoldings={}", id, JSON.toJSONString(stockHoldings));
        return new ResponseVo<>(ResponseStatusEnum.SUCCESS);
    }

    /**
     * 总持仓情况
     *
     * @return
     */
    @Override
    public ResponseVo<HeldAllMsgVo> heldAllMsg() {
        StockHoldingsExample example = new StockHoldingsExample();
        example.createCriteria().andUserIdEqualTo(UserContext.current().getUserId());
        List<StockCurrentHoldPriceVo> stockHoldings = list().getData();

        float buyMoney = 0f, sellMoney = 0f, lost = 0f, todayEarnings = 0f, cost = 0f;

        for (StockCurrentHoldPriceVo vo : stockHoldings) {
            buyMoney += vo.getBuyMoney();
            sellMoney += vo.getSellMoney();
            lost += vo.getHoldingEarnings();
            todayEarnings += vo.getTodayEarnings();
            cost += vo.getCurrentTimePrice() * vo.getHoldNumber();
        }
        HeldAllMsgVo result = new HeldAllMsgVo();
        result.setMoney(BigDecimalUtils.formatFloat(buyMoney - sellMoney, 2));
        result.setCost(BigDecimalUtils.formatFloat(cost, 2));
        result.setLost(BigDecimalUtils.formatFloat(lost, 2));
        result.setTodayLost(BigDecimalUtils.formatFloat(todayEarnings, 2));
        return new ResponseVo<>(ResponseStatusEnum.SUCCESS, result);
    }


    /**
     * 初始化返回值
     *
     * @param stockCurrentHoldPriceVo
     */
    private void initStockCurrentHoldPriceVo(StockCurrentHoldPriceVo stockCurrentHoldPriceVo) {

        StockSeccodsPriceVo stock = stockService.get(stockCurrentHoldPriceVo.getStockCode(), stockCurrentHoldPriceVo.getStockType());
        if (null != stock) {
            stockCurrentHoldPriceVo.setYesterdayClosingPrice(Float.valueOf(stock.getYestClose()));
            stockCurrentHoldPriceVo.setCurrentTimePrice(Float.valueOf(stock.getClose()));
            stockCurrentHoldPriceVo.setHistoryHightPrice(Float.valueOf(stock.getHigh()));
            stockCurrentHoldPriceVo.setHistoryLowPrice(Float.valueOf(stock.getLow()));
        }

        StockInfoDayExample example = new StockInfoDayExample();
        example.createCriteria()
                .andStockTypeEqualTo(stockCurrentHoldPriceVo.getStockType())
                .andStockCodeEqualTo(stockCurrentHoldPriceVo.getStockCode());
        example.setOrderByClause("close asc");
        List<StockInfoDay> data = stockInfoDayMapper.selectByExample(example);
        if (data.size() > 0) {

            int i = stockInfoSnalysisService.binarySearch(data, stockCurrentHoldPriceVo.getCurrentTimePrice());
            int index = stockInfoSnalysisService.binarySearch(data, stockCurrentHoldPriceVo.getCurrentPrice());
            stockCurrentHoldPriceVo.setCurrentPricePercentage(BigDecimalUtils.formatString(i * 100.0 / data.size(), 2));
            stockCurrentHoldPriceVo.setHoldPricePercentage(BigDecimalUtils.formatString(index * 100.0 / data.size(), 2));

        }

    }

}
