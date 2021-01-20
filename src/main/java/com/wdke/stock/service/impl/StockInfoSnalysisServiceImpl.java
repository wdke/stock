package com.wdke.stock.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wdke.stock.common.model.ResponseVo;
import com.wdke.stock.service.StockInfoSnalysisService;
import com.wdke.stock.storage.dao.StockHoldingsMapper;
import com.wdke.stock.storage.dao.StockInfoDayMapper;
import com.wdke.stock.storage.dao.StockInfoSnalysisMapper;
import com.wdke.stock.storage.entity.*;
import com.wdke.stock.utils.BigDecimalUtils;
import com.wdke.stock.web.args.StockInfoSnalysisArgs;
import com.wdke.stock.web.interceptor.UserContext;
import com.wdke.stock.web.vo.StockInfoVo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 股票分析
 *
 * @Author: wdke
 * @Date: 2020-11-09 09:46
 * @Version: 1.0
 */
@Service
public class StockInfoSnalysisServiceImpl implements StockInfoSnalysisService {


    private static Logger logger = LoggerFactory.getLogger(StockInfoSnalysisServiceImpl.class);

    @Autowired
    private StockInfoSnalysisMapper stockInfoSnalysisMapper;


    @Autowired
    private StockInfoDayMapper stockInfoDayMapper;

    @Autowired
    private StockHoldingsMapper stockHoldingsMapper;

    /**
     * 处理
     */
    @Override
    public void handle(StockInfoSnalysis obj) {
        if (obj == null) {
            logger.info("handle 股票代码为空。");
            return;
        }
        List<StockInfoDay> stockInfoDays = null;

        StockInfoDayExample example = new StockInfoDayExample();
        example.createCriteria()
                .andStockCodeEqualTo(obj.getStockCode())
                .andStockTypeEqualTo(obj.getStockType());
        example.setOrderByClause("day asc");
        stockInfoDays = stockInfoDayMapper.selectByExample(example);


        if (null == stockInfoDays || stockInfoDays.isEmpty()) {
            logger.info("stockInfoSnalyses stockInfoDays数据为空 股票代码={} 股票名称={}", obj.getStockCode(), obj.getStockName());
            return;
        }
        logger.info("handle 开始计算 股票代码={} 股票名称={}。", obj.getStockCode(), obj.getStockName());

        //处理最近一天数据
        StockInfoDay stockInfoDay = stockInfoDays.get(stockInfoDays.size() - 1);


        //最近30天跌涨天数
        handleDaysNear(stockInfoDays, obj);

        //计算最好的上升日期和下降日期
        buySellTime(stockInfoDays, obj);

        //持续跌涨天数
        handleContineDays(stockInfoDays, obj);

        calculateAveragePrice(stockInfoDays, obj);
        calculateDiff(stockInfoDays, obj);
        handleHistoryHigh(stockInfoDays, obj);
        handleHistoryLow(stockInfoDays, obj);
        handleNearHigh(stockInfoDays, obj);
        handleNearLow(stockInfoDays, obj);

        //基础数据
        obj.setBaseNumber(stockInfoDays.size());

        //计算所有的跌涨天数
        stockInfoDays.sort(Comparator.comparing(StockInfoDay::getDifferences));
        handleDays(stockInfoDays, obj);

        obj.setLastClose(stockInfoDay.getClose());
        obj.setLastLow(stockInfoDay.getLow());
        obj.setLastHigh(stockInfoDay.getHigh());
        obj.setLastOpen(stockInfoDay.getOpen());
        obj.setLastVolume(stockInfoDay.getVolume());
        obj.setLastDate(stockInfoDay.getDay());
        obj.setDiff(stockInfoDay.getDifferences());

        //处理最近一天数据占比
        stockInfoDays.sort(Comparator.comparing(StockInfoDay::getClose));
        int closeIndex = calculateTodayIndex(stockInfoDays, stockInfoDay.getClose(), obj.getLastCloseIndex());
        obj.setLastCloseIndex(closeIndex);
        int openIndex = calculateTodayIndex(stockInfoDays, stockInfoDay.getOpen(), obj.getLastOpenIndex());
        obj.setLastOpenIndex(openIndex);
        int highIndex = calculateTodayIndex(stockInfoDays, stockInfoDay.getHigh(), obj.getLastHighIndex());
        obj.setLastHighIndex(highIndex);
        int lowIndex = calculateTodayIndex(stockInfoDays, stockInfoDay.getLow(), obj.getLastLowIndex());
        obj.setLastLowIndex(lowIndex);

        //处理最近一天成交量占比
        stockInfoDays.sort(Comparator.comparing(StockInfoDay::getVolume));
        int valumeIndex = calculateTodayValomeIndex(stockInfoDays, stockInfoDay.getVolume(), obj.getLastLowIndex());
        obj.setLastVolumeIndex(valumeIndex);
        stockInfoDays.clear();
        stockInfoDay = null;
        obj.setUpdateDate(null);
        obj.setCreateDate(null);
        stockInfoSnalysisMapper.updateByPrimaryKeySelective(obj);
    }

    /**
     * 数据列表
     *
     * @param args
     * @return
     */
    @Override
    public PageInfo<StockInfoSnalysis> list(StockInfoSnalysisArgs args) {

        PageHelper.startPage(args.getCurrent(), args.getPageSize());
        if (args.getIsHold()) {
            StockHoldingsExample example = new StockHoldingsExample();
            example.createCriteria().andUserIdEqualTo(UserContext.current().getUserId());
            List<StockHoldings> stockHoldings = stockHoldingsMapper.selectByExample(example);
            List<String> stockNames = stockHoldings.stream().map(StockHoldings::getStockName).collect(Collectors.toList());
            StockInfoSnalysisExample snalysisExample = new StockInfoSnalysisExample();
            snalysisExample.createCriteria().andStockNameIn(stockNames);
            List<StockInfoSnalysis> stockInfoSnalyses = stockInfoSnalysisMapper.selectByExample(snalysisExample);

            PageInfo pageInfo = new PageInfo(stockInfoSnalyses);

            return pageInfo;
        }

        StockInfoSnalysisExample example = new StockInfoSnalysisExample();
        StockInfoSnalysisExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(args.getStockName())) {
            criteria.andStockNameLike(args.getStockName() + "%");
        }
        if (null != args.getNowPrice()) {
            criteria.andLastCloseLessThanOrEqualTo(args.getNowPrice());
        }

        if (null != args.getLastDate()) {
            criteria.andLastDateGreaterThan(args.getLastDate());
        }

        if (null != args.getLessClose()) {
            criteria.andLastCloseWeghtGreaterThan(args.getLessClose());
        }

        if (null != args.getMoreClose()) {
            criteria.andLastCloseWeghtLessThanOrEqualTo(args.getMoreClose());
        }

        example.setOrderByClause(args.getOrderBy() == null ? "diff desc,diff3 desc,diff5 desc,diff30 desc" : args.getOrderBy());
        List<StockInfoSnalysis> stockInfoSnalyses = stockInfoSnalysisMapper.selectByExample(example);
//        stockInfoSnalyses.forEach(obj -> {
//            Float diff = stockInfoDayService.stockInfoDiffCount(obj.getStockCode(), obj.getStockType(), args.getDay());
//            obj.setDiff(diff);
//
//        });
        PageInfo pageInfo = new PageInfo(stockInfoSnalyses);

        return pageInfo;
    }

    /**
     * 关键字搜索
     *
     * @param words
     * @return
     */
    @Override
    public ResponseVo<List<StockInfoVo>> searchStockInfoList(String words) {
        return null;
    }

    /**
     * 计算历史最高
     *
     * @param stockInfoDays
     * @param obj
     */
    @Override
    public void handleHistoryHigh(List<StockInfoDay> stockInfoDays, StockInfoSnalysis obj) {

        if (stockInfoDays.isEmpty()) {
            return;
        }
        int size = stockInfoDays.get(obj.getHighIndex()).getHigh().equals(obj.getHighPrice()) ? (obj.getBaseNumber() - 1) : 0;
        for (int i = stockInfoDays.size() - 1; i >= size; i--) {
            if (size != 0 && stockInfoDays.get(i).getDay() <= obj.getLastDate()) {
                break;
            }
            if (stockInfoDays.get(i).getHigh() >= obj.getHighPrice()) {
                obj.setHighPrice(stockInfoDays.get(i).getHigh());
                obj.setHighIndex(i);
                obj.setHighDay(stockInfoDays.get(i).getDay());
            }

        }

    }

    /**
     * 计算历史最低
     *
     * @param stockInfoDays
     * @param obj
     */
    @Override
    public void handleHistoryLow(List<StockInfoDay> stockInfoDays, StockInfoSnalysis obj) {

        int size = stockInfoDays.get(obj.getLowIndex()).getLow().equals(obj.getLowPrice()) ? (obj.getBaseNumber() == 0 ? 0 : (obj.getBaseNumber() - 1)) : 0;
        if (obj.getLowPrice() == 0 || obj.getLowIndex() == 0 || obj.getLowDay() == 0) {
            obj.setLowPrice(stockInfoDays.get(stockInfoDays.size() - 1).getLow());
            obj.setLowDay(stockInfoDays.get(stockInfoDays.size() - 1).getDay());
        }
        for (int i = stockInfoDays.size() - 1; i >= size; i--) {
            if (size != 0 && stockInfoDays.get(i).getDay() <= obj.getLastDate()) {
                break;
            }
            if (stockInfoDays.get(i).getLow() < obj.getLowPrice()) {
                obj.setLowPrice(stockInfoDays.get(i).getLow());
                obj.setLowIndex(i);
                obj.setLowDay(stockInfoDays.get(i).getDay());
            }

        }

    }

    /**
     * 计算30天内最高
     *
     * @param stockInfoDays
     * @param obj
     */
    @Override
    public void handleNearHigh(List<StockInfoDay> stockInfoDays, StockInfoSnalysis obj) {

        int size = stockInfoDays.size() - obj.getHighIndexNear() > 30 ? stockInfoDays.size() - 30 :
                (stockInfoDays.get(obj.getHighIndexNear()).getHigh().equals(obj.getHighPriceNear()) ?
                        (obj.getBaseNumber() == 0 ? 0 : (obj.getBaseNumber() - 1)) : (stockInfoDays.size() - 30 > 0 ? stockInfoDays.size() - 30 : 0));
        for (int i = stockInfoDays.size() - 1; i >= size; i--) {
            if (size != 30 && stockInfoDays.get(i).getDay() <= obj.getLastDate()) {
                break;
            }
            if (stockInfoDays.get(i).getHigh() >= obj.getHighPriceNear()) {
                obj.setHighPriceNear(stockInfoDays.get(i).getHigh());
                obj.setHighIndexNear(i);
                obj.setHighDayNear(stockInfoDays.get(i).getDay());
            }

        }

    }

    /**
     * 计算30天内最低
     *
     * @param stockInfoDays
     * @param obj
     */
    @Override
    public void handleNearLow(List<StockInfoDay> stockInfoDays, StockInfoSnalysis obj) {

        int size = stockInfoDays.size() - obj.getLowIndexNear() > 30 ? stockInfoDays.size() - 30 : (stockInfoDays.get(obj.getLowIndexNear()).getLow().equals(obj.getLowPriceNear()) ? (obj.getBaseNumber() == 0 ? 0 : (obj.getBaseNumber() - 1)) : (stockInfoDays.size() - 30 > 0 ? stockInfoDays.size() - 30 : 0));
        if (obj.getLowPriceNear() == 0 || obj.getLowIndexNear() == 0 || obj.getLowDayNear() == 0) {
            obj.setLowPriceNear(stockInfoDays.get(stockInfoDays.size() - 1).getLow());
            obj.setLowDayNear(stockInfoDays.get(stockInfoDays.size() - 1).getDay());
        }
        for (int i = stockInfoDays.size() - 1; i >= size; i--) {
            if (size != 30 && stockInfoDays.get(i).getDay() <= obj.getLastDate()) {
                break;
            }
            if (stockInfoDays.get(i).getLow() < obj.getLowPriceNear()) {
                obj.setLowPriceNear(stockInfoDays.get(i).getLow());
                obj.setLowIndexNear(i);
                obj.setLowDayNear(stockInfoDays.get(i).getDay());
            }
        }

    }

    /**
     * 计算持续时间
     *
     * @param stockInfoDays
     * @param obj
     */
    @Override
    public void handleContineDays(List<StockInfoDay> stockInfoDays, StockInfoSnalysis obj) {

        if (stockInfoDays.isEmpty()) {
            return;
        }
        int falling = 0, rising = 0;
        boolean sign = false;
        for (int i = stockInfoDays.size() - 1; i >= 0; i--) {
            if (falling > 0 && rising > 0) {
                break;
            }
            if (stockInfoDays.get(i).getDifferences() >= 0) {
                rising++;
                sign = true;
                continue;
            }

            if (stockInfoDays.get(i).getDifferences() < 0) {
                falling++;
                sign = false;
                continue;
            }
        }
        if (sign) {
            obj.setContinueDays(-falling);
        } else {
            obj.setContinueDays(rising);
        }

    }


    /**
     * 处理时跌涨天数
     *
     * @param stockInfoDays
     * @param obj
     */
    @Override
    public void handleDays(List<StockInfoDay> stockInfoDays, StockInfoSnalysis obj) {

        if (stockInfoDays.isEmpty()) {
            return;
        }

        int n = stockInfoDays.size();
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (0 <= stockInfoDays.get(mid).getDifferences()) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        obj.setRisingDays(n - ans);
        obj.setFallDays(n);

    }

    /**
     * 计算最近的数据
     *
     * @param stockInfoDays
     * @param obj
     */
    @Override
    public void handleDaysNear(List<StockInfoDay> stockInfoDays, StockInfoSnalysis obj) {

        if (stockInfoDays.isEmpty()) {
            return;
        }
        int length = stockInfoDays.size();

        int failing = 0, rising = 0;
        for (int i = length - 1; i > (length - 30 > 0 ? length - 30 : 0); i--) {
            StockInfoDay stockInfoDay = stockInfoDays.get(i);
            if (stockInfoDay.getDifferences() > 0) {

                rising++;
            }
            if (stockInfoDay.getDifferences() < 0) {
                failing++;
            }
        }
        obj.setFallDaysNear(failing);
        obj.setRisingDaysNear(rising);

    }


    /**
     * 计算今日各个价格的位置
     *
     * @param stockInfoDays
     * @param price
     * @param index
     * @return
     */
    @Override
    public int calculateTodayIndex(List<StockInfoDay> stockInfoDays, float price, int index) {

        if (stockInfoDays.isEmpty()) {
            return 0;
        }

        if (index == 0) {
            return binarySearch(stockInfoDays, price);
        }
        int length = stockInfoDays.size();
        int i = index - 1;
        while (i > 1 && i < length - 1) {
            if (stockInfoDays.get(i).getClose().equals(price)) {
                break;
            }

            if (stockInfoDays.get(i).getClose() > price && stockInfoDays.get(i - 1).getClose() <= price) {
                i--;
                break;
            }
            if (price > stockInfoDays.get(i).getClose() && price <= stockInfoDays.get(i + 1).getClose()) {
                i++;
                continue;
            }
            if (stockInfoDays.get(i).getClose() > price) {
                i--;
                continue;
            }
            if (price > stockInfoDays.get(i).getClose()) {
                i++;
                continue;
            }
            break;
        }

        return i + 1;
    }

    /**
     * 计算数据插入位置
     *
     * @param stockInfoDays
     * @param target
     * @return
     */
    @Override
    public Integer binarySearch(List<StockInfoDay> stockInfoDays, float target) {
        int n = stockInfoDays.size();
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= stockInfoDays.get(mid).getClose()) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }


    /**
     * 计算成交量
     *
     * @param stockInfoDays
     * @param valome
     * @param index
     * @return
     */
    public Integer calculateTodayValomeIndex(List<StockInfoDay> stockInfoDays, long valome, int index) {

        if (stockInfoDays.isEmpty()) {
            return 0;
        }

        if (index == 0) {
            int n = stockInfoDays.size();
            int left = 0, right = n - 1, ans = n;
            while (left <= right) {
                int mid = ((right - left) >> 1) + left;
                if (valome <= stockInfoDays.get(mid).getVolume()) {
                    right = mid - 1;
                    ans = mid;
                } else {
                    left = mid + 1;
                }
            }
            return ans;
        }
        int length = stockInfoDays.size();
        int i = index - 1;
        while (i > 0 && i < length - 1) {
            if (stockInfoDays.get(i).getVolume().equals(valome)) {
                break;
            }

            if (stockInfoDays.get(i).getVolume() > valome) {
                i--;
                continue;
            }
            if (valome > stockInfoDays.get(i).getVolume()) {
                i++;
                continue;
            }
        }

        return i + 1;
    }


    /**
     * 计算平均价格
     *
     * @param stockInfoDays
     * @param obj
     * @return
     */
    public void calculateDiff(List<StockInfoDay> stockInfoDays, StockInfoSnalysis obj) {

        if (stockInfoDays.isEmpty()) {
            return;
        }

        int length = stockInfoDays.size();
        float diff3 = 0, diff5 = 0, diff30 = 0;
        if (length >= 3 && stockInfoDays.get(length - 1).getClose() > 0) {
            diff3 = BigDecimalUtils.formatFloat((stockInfoDays.get(length - 1).getClose() - stockInfoDays.get(length - 3).getClose()) * 100 / stockInfoDays.get(length - 3).getClose(), 2);
        }
        if (length >= 5 && stockInfoDays.get(length - 5).getClose() > 0) {
            diff5 = BigDecimalUtils.formatFloat((stockInfoDays.get(length - 1).getClose() - stockInfoDays.get(length - 5).getClose()) * 100 / stockInfoDays.get(length - 5).getClose(), 2);
        }
        if (length >= 30 && stockInfoDays.get(length - 30).getClose() > 0) {
            diff30 = BigDecimalUtils.formatFloat((stockInfoDays.get(length - 1).getClose() - stockInfoDays.get(length - 30).getClose()) * 100 / stockInfoDays.get(length - 30).getClose(), 2);
        }
        obj.setDiff3(diff3);
        obj.setDiff5(diff5);
        obj.setDiff30(diff30);

    }

    /**
     * 计算平均价格
     *
     * @param stockInfoDays
     * @param obj
     * @return
     */
    public void calculateAveragePrice(List<StockInfoDay> stockInfoDays, StockInfoSnalysis obj) {

        if (stockInfoDays.isEmpty()) {
            return;
        }
        if (obj.getAveragePrice() == 0 || stockInfoDays.size() - obj.getBaseNumber() > 5) {

            double sum = 0;
            for (StockInfoDay stockInfoDay : stockInfoDays) {

                sum += stockInfoDay.getClose();
            }
            obj.setAveragePrice(BigDecimalUtils.formatFloat(sum / stockInfoDays.size(), 3));
            return;

        }
        double sum = obj.getAveragePrice() * obj.getBaseNumber();

        for (int i = stockInfoDays.size() - 1; i > 0; i--) {
            if (obj.getLastDate() <= stockInfoDays.get(i).getDay()) {
                break;
            }
            sum += stockInfoDays.get(i).getClose();
        }

        obj.setAveragePrice(BigDecimalUtils.formatFloat(sum / stockInfoDays.size(), 3));

    }

    /**
     * 计算买入卖出时机
     *
     * @param stockInfoDays
     * @param obj
     */
    @Override
    public void buySellTime(List<StockInfoDay> stockInfoDays, StockInfoSnalysis obj) {

        if (stockInfoDays.isEmpty()) {
            return;
        }
        int length = stockInfoDays.size();
        int start = (length - 30) < 0 ? 0 : (length - 30);
        int end = start, maxStart = start, failStart = start, failEnd = start, failMaxStart = start;
        float min = Integer.MAX_VALUE, max = 0, failMaxPrice = 0, failMax = 0;
        for (int i = start; i < length; i++) {
            float price = stockInfoDays.get(i).getOpen();
            //计算上升最佳买入卖出
            if (price < min) {
                min = price;
                start = i;
            }

            if (max < (price - min)) {
                max = price - min;
                end = i;
                maxStart = start;
            }

            //计算下降最多的天数
            if (price > failMaxPrice) {
                failMaxPrice = price;
                failStart = i;
            }
            if (failMax < (failMaxPrice - price)) {
                failMax = failMaxPrice - price;
                failEnd = i;
                failMaxStart = failStart;
            }
        }
        if (maxStart == end) {
            obj.setBuyStart(0);
            obj.setBuyEnd(0);
        } else {

            obj.setBuyStart(stockInfoDays.get(maxStart).getDay());
            obj.setBuyEnd(stockInfoDays.get(end).getDay());
        }


        if (failMaxStart == failEnd) {
            obj.setSellStart(0);
            obj.setSellEnd(0);
        } else {

            obj.setSellStart(stockInfoDays.get(failMaxStart).getDay());
            obj.setSellEnd(stockInfoDays.get(failEnd).getDay());
        }


    }
}
