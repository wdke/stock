package com.wdke.stock.service.impl;

import com.wdke.stock.common.enums.ResponseStatusEnum;
import com.wdke.stock.common.model.ResponseVo;
import com.wdke.stock.https.WangyiStockApi;
import com.wdke.stock.service.StockInfoSeccondsService;
import com.wdke.stock.storage.dao.StockHoldingsMapper;
import com.wdke.stock.storage.dao.StockInfoSeccondsMapper;
import com.wdke.stock.storage.entity.StockHoldings;
import com.wdke.stock.storage.entity.StockHoldingsExample;
import com.wdke.stock.storage.entity.StockInfoSecconds;
import com.wdke.stock.storage.entity.StockInfoSeccondsExample;
import com.wdke.stock.utils.CalendarUtils;
import com.wdke.stock.web.interceptor.UserContext;
import com.wdke.stock.web.vo.StockEchartVo;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: wdke
 * @Date: 2020-11-06 16:46
 * @Version: 1.0
 */
@Service
public class StockInfoSeccondsServiceImpl implements StockInfoSeccondsService {

    private static Logger logger = LoggerFactory.getLogger(StockInfoSeccondsServiceImpl.class);
    @Autowired
    private WangyiStockApi wangyiStockApi;


    @Autowired
    private StockInfoSeccondsMapper stockInfoSeccondsMapper;
    @Autowired
    private StockHoldingsMapper stockHoldingsMapper;


    /**
     * 股票入库处理
     *
     * @param type
     * @param stockCode
     */
    @Override
    public void handle(Integer type, String stockCode) {
        if (StringUtils.isEmpty(stockCode)) {

            logger.info("handle 股票代码错误 stockCode={}", stockCode);
            return;
        }
        List<StockInfoSecconds> stockInfoSecconds = wangyiStockApi.secondTodayData(type, stockCode);

        logger.info("handle 查出代码数量 stockCode={} size={}", stockCode, stockInfoSecconds.size());

        if (stockInfoSecconds.isEmpty()) {
            return;
        }

        try {
            stockInfoSeccondsMapper.batchInsert(stockInfoSecconds);
        } catch (Exception e) {
            logger.error("handle 保存时出错 股票代码={}", stockCode, e);
        }

    }

    /**
     * 三日对比图
     *
     * @param type
     * @param stockCode
     * @return
     */
    @Override
    public ResponseVo<StockEchartVo> comparingThreeDays(Integer type, String stockCode) {

        StockInfoSeccondsExample example = new StockInfoSeccondsExample();
        logger.info("comparingThreeDays lessTime={},greaTime={}", DateFormatUtils.format(CalendarUtils.todayMorning(), "yyyyMMddHHmm"), DateFormatUtils.format(CalendarUtils.stockDay(3), "yyyyMMddHHmm"));
        example.createCriteria()
                .andStockTypeEqualTo(type)
                .andStockCodeEqualTo(stockCode)
                .andSeccondsGreaterThanOrEqualTo(Long.valueOf(DateFormatUtils.format(CalendarUtils.stockDay(3), "yyyyMMddHHmm")))
                .andSeccondsLessThan(Long.valueOf(DateFormatUtils.format(CalendarUtils.todayMorning(), "yyyyMMddHHmm")));
        example.setOrderByClause("secconds asc");
        List<StockInfoSecconds> stockInfoSecconds = stockInfoSeccondsMapper.selectByExample(example);
        if (stockInfoSecconds.isEmpty()) {
            return new ResponseVo<>(ResponseStatusEnum.SUCCESS);
        }
        Map<Long, List<StockInfoSecconds>> map = stockInfoSecconds.stream().collect(Collectors.groupingBy(obj -> obj.getSecconds() / 10000));

        StockEchartVo vo = new StockEchartVo();
        List<String> legend = new ArrayList<>();
        List<List<Float>> data = new ArrayList<>();
        map.forEach((key, val) -> {
            legend.add(key.toString());
            List<Float> one = val.stream().map(StockInfoSecconds::getPrice).collect(Collectors.toList());
            data.add(one);
            if (vo.getKeys() == null) {
                List<Long> keys = val.stream().map(obj -> obj.getSecconds() % 10000).collect(Collectors.toList());
                vo.setKeys(keys);
            }
        });
        vo.setLegend(legend);
        vo.setData(data);
        vo.setStockCode(stockInfoSecconds.get(0).getStockCode());
        vo.setTitle("三日对比");
        vo.setStockName(stockInfoSecconds.get(0).getStockName());
        return new ResponseVo<>(ResponseStatusEnum.SUCCESS, vo);
    }

    /**
     * 持仓的三日对比
     *
     * @return
     */
    @Override
    public ResponseVo<List<StockEchartVo>> comparingThreeDaysHole() {


        StockHoldingsExample example = new StockHoldingsExample();
        example.createCriteria()
                .andUserIdEqualTo(UserContext.current().getUserId());
        List<StockHoldings> stockHoldings = stockHoldingsMapper.selectByExample(example);
        List<StockEchartVo> data = new ArrayList<>();
        stockHoldings.forEach(obj -> {
            StockEchartVo stockEchartVo = comparingThreeDays(obj.getStockType(), obj.getStockCode()).getData();
            if (null != stockEchartVo) {
                data.add(stockEchartVo);
            }
        });
        return new ResponseVo<>(ResponseStatusEnum.SUCCESS, data);
    }

}
