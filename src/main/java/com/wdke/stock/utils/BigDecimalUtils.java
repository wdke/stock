package com.wdke.stock.utils;

import java.math.BigDecimal;

/**
 * @Author: wdke
 * @Date: 2020-11-04 12:44
 * @Version: 1.0
 */
public class BigDecimalUtils {

    public static float diff(float one, float last) {
        double num = 0;
        if (0 == last) {
            return 0;
        }
        num = (one - last)/ last;
        BigDecimal bigDecimal = new BigDecimal(num);
        return bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
    }

    public static double format(double num, int newScale) {
        BigDecimal bigDecimal = new BigDecimal(num);
        return bigDecimal.setScale(newScale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }


    public static float formatFloat(double num, int newScale) {
        BigDecimal bigDecimal = new BigDecimal(num);
        return bigDecimal.setScale(newScale, BigDecimal.ROUND_HALF_UP).floatValue();
    }


    public static String formatString(double num, int newScale) {
        BigDecimal bigDecimal = new BigDecimal(num);
        return bigDecimal.setScale(newScale, BigDecimal.ROUND_HALF_UP).toString();
    }
}
