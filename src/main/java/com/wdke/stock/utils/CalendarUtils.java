package com.wdke.stock.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 *
 * @Author: wdke
 * @Date: 2020-11-05 11:52
 * @Version: 1.0
 */
public class CalendarUtils {


    public static Date forwardNDay(int day) {

        //获取截止时间
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_MONTH, -day);

        return cal.getTime();
    }


    public static Date todayMorning() {

        //获取截止时间
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.HOUR_OF_DAY, 0);

        return cal.getTime();
    }

    public static Date stockDay(Integer day) {

        //获取截止时间
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.HOUR_OF_DAY, 0);
        int week = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if ( week == 4 || week == 5) {
            cal.add(Calendar.DAY_OF_MONTH, -day);
        }else if(week == 6){
            cal.add(Calendar.DAY_OF_MONTH, -day-1);
        }else{
            cal.add(Calendar.DAY_OF_MONTH, -day-2);
        }
        return cal.getTime();
    }

    public static void main(String[] args) {
        stockDay(3);
    }
}
