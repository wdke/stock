package com.wdke.stock.https;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wdke.stock.storage.entity.StockInfoDay;
import com.wdke.stock.storage.entity.StockInfoSecconds;
import com.wdke.stock.utils.BigDecimalUtils;
import com.wdke.stock.utils.OkHttpUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 新浪股票信息调用
 *
 * @Author: wdke
 * @Date: 2020-10-16 17:11
 * @Version: 1.0
 */
@Service
public class WangyiStockApi {

    private static Logger logger = LoggerFactory.getLogger(WangyiStockApi.class);


    private SimpleDateFormat sdfH = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 今日的每秒钟数据
     *
     * @param type
     * @param stockCode
     * @return
     */
    public List<StockInfoSecconds> secondTodayData(Integer type, String stockCode) {
        StringBuilder url = new StringBuilder("http://img1.money.126.net/data/hs/time/today/")
                .append(type)
                .append(stockCode)
                .append(".json");
        String result = null;
        try {
            result = OkHttpUtils.httpGet(url.toString());
        } catch (Exception e) {
            logger.info("secondTodayData 获取失败stockCode={} msg={}", stockCode, e.getMessage());
        }

        JSONObject jsonObject = JSON.parseObject(result, JSONObject.class);
        if (StringUtils.isEmpty(result)) {
            logger.info("secondTodayData 获取失败stockCode={} ", stockCode);
            return new ArrayList<>();
        }
        JSONArray data = jsonObject.getJSONArray("data");
        List<StockInfoSecconds> list = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            JSONArray jsonArray = data.getJSONArray(i);
            StockInfoSecconds stockInfoSecconds = new StockInfoSecconds();
            stockInfoSecconds.setStockType(type);
            stockInfoSecconds.setStockCode(stockCode);
            stockInfoSecconds.setSecconds(jsonObject.getLongValue("date") * 10000 + jsonArray.getLongValue(0));
            stockInfoSecconds.setYestClose(jsonObject.getFloat("yestclose"));
            stockInfoSecconds.setStockName(jsonObject.getString("name"));
            stockInfoSecconds.setPrice(jsonArray.getFloat(1));
            stockInfoSecconds.setAvePrice(jsonArray.getFloat(2));
            stockInfoSecconds.setVolume(jsonArray.getLong(3));
            list.add(stockInfoSecconds);
        }
        return list;
    }

    /**
     * 今日的每秒钟数据
     *
     * @param type
     * @param stockCode
     * @return
     */
    public StockInfoDay dayTodayData(Integer type, String stockCode) {
        StringBuilder url = new StringBuilder("http://img1.money.126.net/data/hs/time/today/")
                .append(type)
                .append(stockCode)
                .append(".json");
        String result = null;
        try {
            result = OkHttpUtils.httpGet(url.toString());
        } catch (Exception e) {
            logger.info("dayTodayData 获取失败stockCode={} msg={}", stockCode, e.getMessage());
        }

        JSONObject jsonObject = JSON.parseObject(result, JSONObject.class);
        if (StringUtils.isEmpty(result)) {
            logger.info("dayTodayData 获取失败stockCode={} ", stockCode);
            return null;
        }
        float yestclose = jsonObject.getFloatValue("yestclose");
        StockInfoDay stockInfoDay = new StockInfoDay();
        stockInfoDay.setDay(jsonObject.getIntValue("date"));
        stockInfoDay.setStockCode(stockCode);
        stockInfoDay.setStockType(type);
        stockInfoDay.setYestClose(yestclose);
        stockInfoDay.setStockName(jsonObject.getString("name"));
        stockInfoDay.setVolume(jsonObject.getLongValue("lastVolume"));
        JSONArray data = jsonObject.getJSONArray("data");
        if (null != data) {
            stockInfoDay.setClose(data.getJSONArray(data.size() - 1).getFloat(1));

            stockInfoDay.setOpen(data.getJSONArray(0).getFloat(1));
        }

//        JSONArray data = jsonObject.getJSONArray("data");
        float max = 0, min = 0;
        int maxTime = 0, minTime = 0;
        for (int i = 0; i < data.size(); i++) {
            JSONArray jsonArray = data.getJSONArray(i);
            if (i == 0) {
                minTime = jsonArray.getIntValue(0);
                min = jsonArray.getFloat(1);
                max = min;
                maxTime = minTime;

            }
            if (max < jsonArray.getFloat(1)) {
                max = jsonArray.getFloat(1);
                maxTime = jsonArray.getIntValue(0);
            }

            if (min > jsonArray.getFloat(1)) {
                min = jsonArray.getFloat(1);
                minTime = jsonArray.getIntValue(0);

            }
        }
        stockInfoDay.setHigh(max);
        stockInfoDay.setHignTime(maxTime);
        stockInfoDay.setLow(min);
        stockInfoDay.setLowTime(minTime);

        stockInfoDay.setDifferences(BigDecimalUtils.formatFloat(100 * (stockInfoDay.getClose() - yestclose) / yestclose, 2));
        return stockInfoDay;
    }

    /**
     * 今日的每秒钟数据
     *
     * @param type
     * @param stockCode
     * @return
     */
    public List<StockInfoSecconds> second4daysData(Integer type, String stockCode) {
        StringBuilder url = new StringBuilder("http://img1.money.126.net/data/hs/time/4days/")
                .append("/")
                .append(type)
                .append(stockCode)
                .append(".json");


        String result = null;
        try {
            result = OkHttpUtils.httpGet(url.toString());
        } catch (Exception e) {
            logger.info("secondTodayData 获取失败stockCode={} msg={}", stockCode, e.getMessage());

        }
        if (StringUtils.isEmpty(result)) {

            return new ArrayList<>();
        }

        JSONObject resultData = JSON.parseObject(result, JSONObject.class);

        JSONArray allData = resultData.getJSONArray("data");


        List<StockInfoSecconds> list = new ArrayList<>();
        for (int m = 0; m < allData.size(); m++) {
            JSONObject dayData = allData.getJSONObject(m);
            JSONArray secPrice = dayData.getJSONArray("data");
            for (int i = 0; i < secPrice.size(); i++) {
                JSONArray price = secPrice.getJSONArray(i);
                StockInfoSecconds stockInfoSecconds = new StockInfoSecconds();
                stockInfoSecconds.setStockCode(stockCode);
                stockInfoSecconds.setStockName(resultData.getString("name"));
                stockInfoSecconds.setStockType(type);
                stockInfoSecconds.setSecconds(resultData.getLongValue("date") * 10000 + price.getLongValue(0));
                stockInfoSecconds.setYestClose(dayData.getFloat("yestclose"));
                stockInfoSecconds.setVolume(price.getLong(3));
                stockInfoSecconds.setPrice(price.getFloat(1));
                stockInfoSecconds.setAvePrice(price.getFloat(2));
                list.add(stockInfoSecconds);
            }
        }

        return list;
    }

    /**
     * 获取每天的数据
     *
     * @param type
     * @param year
     * @param stockCode
     * @return
     */
    public List<StockInfoDay> dayData(Integer type, Integer year, String stockCode) {
        StringBuilder url = new StringBuilder("http://img1.money.126.net/data/hs/kline/day/history/")
                .append(year).append("/")
                .append(type)
                .append(stockCode)
                .append(".json");

        String result = null;
        try {
            result = OkHttpUtils.httpGet(url.toString());
        } catch (Exception e) {
            logger.info("dayData 获取失败stockCode={} msg={}", stockCode, e.getMessage());

        }
        if (StringUtils.isEmpty(result)) {
            return new ArrayList<>();
        }

        JSONObject resultData = JSON.parseObject(result, JSONObject.class);
        JSONArray data = resultData.getJSONArray("data");

        List<StockInfoDay> list = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {

            StockInfoDay stockInfoDay = new StockInfoDay();
            stockInfoDay.setStockCode(stockCode);
            stockInfoDay.setStockName(resultData.getString("name"));
            stockInfoDay.setStockType(type);
            stockInfoDay.setDay(data.getJSONArray(i).getIntValue(0));
            stockInfoDay.setOpen(data.getJSONArray(i).getFloatValue(1));
            stockInfoDay.setClose(data.getJSONArray(i).getFloatValue(2));
            stockInfoDay.setHigh(data.getJSONArray(i).getFloatValue(3));
            stockInfoDay.setLow(data.getJSONArray(i).getFloatValue(4));
            stockInfoDay.setVolume(data.getJSONArray(i).getLongValue(5));
            stockInfoDay.setDifferences(data.getJSONArray(i).getFloatValue(6));
            if (i - 1 > 0) {
                stockInfoDay.setYestClose(data.getJSONArray(i-1).getFloatValue(2));
            }
            list.add(stockInfoDay);

        }

        return list;
    }

}
