package com.king.dubbo.weixin.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author shenwang
 * @description 日期的工具类
 */
public class DateUtils {

    /**
     * 获取当前的日期
     * @return 日期
     */
    public static Date getCurrentDate(){
        Calendar calendar=Calendar.getInstance();
        return calendar.getTime();
    }

    /**
     * 转化日期为string
     * @param date
     * @return
     */
    public static String tranferDateToString(Date date){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString =format.format(date);
        return dateString;
    }

    /**
     * 转化string为日期
     * @param time
     * @return
     */
    public static Date tranferStringToDate(String time){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=null;
        try {
            date=simpleDateFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;

    }

    public static void main(String args[]){
       // System.out.println(tranferDateToString(getCurrentDate()));
        System.out.println(tranferStringToDate("1970-01-01 00:00:00"));
    }
}
