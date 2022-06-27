package com.wdke.stock.service.impl;

import com.wdke.stock.common.enums.ResponseStatusEnum;
import com.wdke.stock.common.model.ResponseVo;
import com.wdke.stock.https.SinaStockApi;
import com.wdke.stock.https.WangyiStockApi;
import com.wdke.stock.service.StockService;
import com.wdke.stock.storage.dao.StockHoldingsMapper;
import com.wdke.stock.storage.entity.StockHoldings;
import com.wdke.stock.storage.entity.StockHoldingsExample;
import com.wdke.stock.storage.entity.StockInfoSecconds;
import com.wdke.stock.utils.BigDecimalUtils;
import com.wdke.stock.web.interceptor.UserContext;
import com.wdke.stock.web.vo.StockEchartVo;
import com.wdke.stock.web.vo.StockSeccodsPriceVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @Author: wdke
 * @Date: 2020-11-14 14:30
 * @Version: 1.0
 */

@Service
public class StockServiceImpl implements StockService {

    private static Logger logger = LoggerFactory.getLogger(StockServiceImpl.class);

    @Autowired
    private SinaStockApi sinaStockApi;

    @Autowired
    private WangyiStockApi stockApi;


    @Autowired
    private StockHoldingsMapper stockHoldingsMapper;

    /**
     * 获取股票信息
     *
     * @param stockCode
     * @param type
     * @return
     */
    @Override
    public StockSeccodsPriceVo get(String stockCode, Integer type) {
        try {
            return sinaStockApi.detail(stockCode, type);
        } catch (Exception e) {
            logger.info("StockSeccodsPriceVo error stockCode={} type={}", stockCode, type);
        }
        return null;
    }

    /**
     * 今日股票成交量
     *
     * @param type
     * @param stockCode
     * @return
     */
    @Override
    public ResponseVo<StockEchartVo> todayPriceVolume(Integer type, String stockCode) {
        List<StockInfoSecconds> stockInfoSecconds = stockApi.secondTodayData(type, stockCode);
        if (stockInfoSecconds.isEmpty()) {
            return new ResponseVo<>(ResponseStatusEnum.PARRAM_ERROR.getCode(), "数据不存在，或该股票已经下架。");
        }

        Long sums = stockInfoSecconds.stream().collect(Collectors.summingLong(StockInfoSecconds::getVolume));
        Map<Float, Long> data = stockInfoSecconds.stream().collect(Collectors.groupingBy(StockInfoSecconds::getPrice, Collectors.summingLong(StockInfoSecconds::getVolume)));

        Map<Float, Float> tyy = new TreeMap<>();
        data.forEach((key, val) -> {
            tyy.put(key, BigDecimalUtils.formatFloat(val * 100f / sums, 2));
        });

        StockEchartVo result = new StockEchartVo();
        result.setKeys(tyy.keySet());
        result.setValues(tyy.values());
        result.setStockCode(stockCode);
        result.setStockName(stockInfoSecconds.get(0).getStockName());
        result.setTitle(stockInfoSecconds.get(0).getStockName()+"(" + sums + ")");


        return new ResponseVo<>(ResponseStatusEnum.SUCCESS, result);
    }

    /**
     * 持仓股票的计算
     *
     * @return
     */
    @Override
    public ResponseVo<List<StockEchartVo>> todayHoldPriceVolume() {

        StockHoldingsExample example = new StockHoldingsExample();
        example.createCriteria()
                .andUserIdEqualTo(UserContext.current().getUserId());
        List<StockHoldings> stockHoldings = stockHoldingsMapper.selectByExample(example);
        List<StockEchartVo> data = new ArrayList<>();
        stockHoldings.forEach(obj -> {
            StockEchartVo stockEchartVo = todayPriceVolume(obj.getStockType(), obj.getStockCode()).getData();
            if (null != stockEchartVo) {
                data.add(stockEchartVo);
            }
        });
        return new ResponseVo<>(ResponseStatusEnum.SUCCESS, data);
    }
}
