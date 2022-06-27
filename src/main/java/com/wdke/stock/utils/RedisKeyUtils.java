package com.wdke.stock.utils;

/**
 * @Author: wdke
 * @Date: 2020-10-21 17:07
 * @Version: 1.0
 */
public class RedisKeyUtils {


    /**
     * 股票信息key
     *
     * @param sockCode
     * @return
     */
    public static String stockInfoKey(String sockCode) {
        return new StringBuilder("String#").append(sockCode).append("#info").toString();
    }

    public static String stockLineDataKey(String userId) {
        return new StringBuilder("String#").append(userId).append("#linedata").toString();
    }


    public static String stockTodayPriceKey(String sockCode, String time) {
        return new StringBuilder("hash#").append(sockCode).append("#").append(time).append("#price").toString();
    }


    public static String stockInfoMaxIdKey(String maxCode) {
        return new StringBuilder("maxId#").append("#").append(maxCode).toString();
    }


    public static String stockInfoListKey(Long userId) {
        return new StringBuilder("stock#info#").append(userId).toString();
    }


    public static String stockInfoTaskListKey() {

        return new StringBuilder("task#stock#info").toString();
    }
}
