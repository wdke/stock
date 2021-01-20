package com.wdke.stock.utils;

import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

/**
 * 校验
 *
 * @Author: wdke
 * @Date: 2020-10-23 11:03
 * @Version: 1.0
 */
public class CheckUtils {


    /*

     * 判断是否为整数

     * @param str 传入的字符串

     * @return 是整数返回true,否则返回false

     */





    public static boolean isInteger(String str) {

        Pattern pattern = compile("^[-\\+]?[\\d]*$");

        return pattern.matcher(str).matches();

    }


    public static boolean isNumeric(String str){

        Pattern pattern = compile("[0-9]*");

        return pattern.matcher(str).matches();

    }

}
