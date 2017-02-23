package com.example.chen.news.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by SchafferWang on 2016/12/29.
 */

public class TimeUtils {
    public static final String DATE_PATTERN_DEFAULT = "yyyy-MM-dd";
    public static final String TIME_PATTERN_DEFAULT = "HH:mm:ss";
    public static final String TIME_PATTERN_WITHOUT_SECOND = "HH:mm";
    public static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String DEFAULT_PATTERN_WITHOUT_SECOND = "yyyy-MM-dd HH:mm";

    /**
     * 将时间戳转为时间字符串
     * <p>格式为yyyy-MM-dd HH:mm:ss</p>
     *
     * @param millis 毫秒时间戳
     * @return 时间字符串
     */
    public static String millis2String(long millis) {
        return new SimpleDateFormat(DEFAULT_PATTERN, Locale.getDefault()).format(new Date(millis));
    }

    /**
     * 将时间戳转为时间字符串
     * <p>格式为pattern</p>
     *
     * @param millis  毫秒时间戳
     * @param pattern 时间格式
     * @return 时间字符串
     */
    public static String millis2String(long millis, String pattern) {
        return new SimpleDateFormat(pattern, Locale.getDefault()).format(new Date(millis));
    }

    /**
     * 将时间字符串转为时间戳
     * <p>time格式为yyyy-MM-dd HH:mm:ss</p>
     *
     * @param time 时间字符串
     * @return 毫秒时间戳
     */
    public static long string2Millis(String time) {
        return string2Millis(time, DEFAULT_PATTERN);
    }

    /**
     * 将时间字符串转为时间戳
     * <p>time格式为pattern</p>
     *
     * @param time    时间字符串
     * @param pattern 时间格式
     * @return 毫秒时间戳
     */
    public static long string2Millis(String time, String pattern) {
        try {
            return new SimpleDateFormat(pattern, Locale.getDefault()).parse(time).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 将时间字符串转为Date类型
     * <p>time格式为yyyy-MM-dd HH:mm:ss</p>
     *
     * @param time 时间字符串
     * @return Date类型
     */
    public static Date string2Date(String time) {
        return string2Date(time, DEFAULT_PATTERN);
    }

    /**
     * 将时间字符串转为Date类型
     * <p>time格式为pattern</p>
     *
     * @param time    时间字符串
     * @param pattern 时间格式
     * @return Date类型
     */
    public static Date string2Date(String time, String pattern) {
        return new Date(string2Millis(time, pattern));
    }

    /**
     * 将Date类型转为时间字符串
     * <p>格式为yyyy-MM-dd HH:mm:ss</p>
     *
     * @param date Date类型时间
     * @return 时间字符串
     */
    public static String date2String(Date date) {
        return date2String(date, DEFAULT_PATTERN);
    }

    /**
     * 将Date类型转为时间字符串
     * <p>格式为pattern</p>
     *
     * @param date    Date类型时间
     * @param pattern 时间格式
     * @return 时间字符串
     */
    public static String date2String(Date date, String pattern) {
        return new SimpleDateFormat(pattern, Locale.getDefault()).format(date);
    }

    /**
     * 将Date类型转为时间戳
     *
     * @param date Date类型时间
     * @return 毫秒时间戳
     */
    public static long date2Millis(Date date) {
        return date.getTime();
    }

    /**
     * 将时间戳转为Date类型
     *
     * @param millis 毫秒时间戳
     * @return Date类型时间
     */
    public static Date millis2Date(long millis) {
        return new Date(millis);
    }

    /**
     * 将一个时间戳转换成提示性时间字符串，如刚刚，1秒前
     *
     * @param millis 毫秒时间戳
     * @return
     */
    public static String convertTimeToFormat(long millis) {
        long curTime = System.currentTimeMillis() / (long) 1000;
        long time = curTime - millis;

        if (time < 60 && time >= 0) {
            return "刚刚";
        } else if (time >= 60 && time < 3600) {
            return time / 60 + "分钟前";
        } else if (time >= 3600 && time < 3600 * 24) {
            return time / 3600 + "小时前";
        } else if (time >= 3600 * 24 && time < 3600 * 24 * 30) {
            return time / 3600 / 24 + "天前";
        } else if (time >= 3600 * 24 * 30 && time < 3600 * 24 * 30 * 12) {
            return time / 3600 / 24 / 30 + "个月前";
        } else if (time >= 3600 * 24 * 30 * 12) {
            return time / 3600 / 24 / 30 / 12 + "年前";
        } else {
            return "刚刚";
        }
    }
    /**
     * 得到剩余时间
     *
     * @param millis 毫秒时间戳
     * @return
     */
    public static String getDuring(long millis) {
        Date date = new Date();
        long timeStamp = millis - date2Millis(date) / 1000;
        if (timeStamp < 60 && timeStamp >= 0) {//60秒之内
            return "即将";
        } else if (timeStamp >= 60 && timeStamp < 3600) {//一个小时之内
            return "" + timeStamp / 60 + "分钟后";
        } else if (timeStamp >= 3600 && timeStamp < 3600 * 24) {//一天之内
            return timeStamp / 3600 + "小时后";
        } else if (timeStamp >= 3600 * 24 && timeStamp < 3600 * 24 * 30) {//一个月之内
            return timeStamp / 3600 / 24 + "天后";
        } else if (timeStamp >= 3600 * 24 * 30 && timeStamp < 3600 * 24 * 30 * 12) {//一年之内
            return timeStamp / 3600 / 24 / 30 + "个月后";
        } else if (timeStamp >= 3600 * 24 * 30 * 12) {//n年后
            return timeStamp / 3600 / 24 / 30 / 12 + "年后";
        } else {
            if (timeStamp < 0) {
                return "时间已过";
            } else {
                return "很久很久以后";
            }
        }
    }


}
