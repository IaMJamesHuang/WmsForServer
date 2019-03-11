package com.kt.james.wmsforserver.util;


import java.util.Calendar;
import java.util.Date;

public class TimeUtils {

    /*
     * 获取本月第一天
     */
    public static Date getFirstDayThisMonth() {
        Calendar cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        return cale.getTime();
    }

    /*
     * 获取本月最后一天
     */
    public static Date getLastDayThisMonth() {
        Calendar cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 1);
        cale.add(Calendar.DAY_OF_MONTH, 0);
        return cale.getTime();
    }

    /*
     * 获取上个月第一天
     */
    public static Date getFirstDayLastMonth() {
        Calendar cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, -1);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        return cale.getTime();
    }

    /*
     * 获取上个月最后一天
     */
    public static Date getLastDayLastMonth() {
        Calendar calendar=Calendar.getInstance();
        int month=calendar.get(Calendar.MONTH);
        calendar.set(Calendar.MONTH, month-1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }

    /*
     * 获取上个月的今天，如今天日期大于上个月，则获取上个月的最后一天
     */
    public static Date getCurrentDayLastMonth() {
        Calendar calendar=Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month=calendar.get(Calendar.MONTH);
        calendar.set(Calendar.MONTH, month-1);
        int max = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        if (day > max) {
            day = max;
        }
        calendar.set(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }

}
