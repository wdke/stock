package com.wdke.stock.utils;

/**
 * @Author: wdke
 * @Date: 2020-11-14 14:02
 * @Version: 1.0
 */
public class JavaTypeUtils {

    /**
     * java 类型转换
     *
     * @param value
     * @return
     */
    public static float toFloat(String value) {

        try {
            return Float.valueOf(value);
        }catch (Exception e){
            return 0F;
        }
    }


    public static int toInt(String value) {

        try {
            return Integer.valueOf(value);
        }catch (Exception e){
            return 0;
        }
    }


    public static long toLong(String value) {

        try {
            return Long.valueOf(value);
        }catch (Exception e){
            return 0;
        }
    }
}
