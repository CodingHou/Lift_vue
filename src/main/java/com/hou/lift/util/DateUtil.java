package com.hou.lift.util;


import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Author: sigon
 * Time: 15-3-6 上午10:46
 * Project: aunewtop-common
 */
public class DateUtil {
    private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);

    private static SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static int settleHour = 18;

    public static String getNowDate(){
        return date.format(new Date());
    }
    public static String getNowDatetime(){
        return datetime.format(new Date());
    }

    public static Date calcDateByYear(Date date, Integer years){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, years);
        return calendar.getTime();
    }
    public static Date calcDateByDays(String dateStr, Integer days) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date.parse(dateStr));
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }
    public static Date calcDateByDays(Integer days){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }
    public static Date calcDateByDays(Date date,Integer days){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }
    public static String date2String(Date date, String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static Date formatDate(String dateStr) throws Exception{
        return date.parse(dateStr);
    }
    public static Date formatDatetime(String dateStr) throws Exception{
        return datetime.parse(dateStr);
    }

    public static Date string2Date(String date, String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date dateResult = null;
        try{
            dateResult = sdf.parse(date);
        }catch (Exception e){
            logger.error("parse error:"+date+","+format,e);
        }

        return dateResult;
    }
    /**
     * @param date 规定的过期日期
     * @param day  规定的提示日期间隔
     *将现在的时间与规定的过期日期比较，
     *当两者间隔小于提示日期间隔时，返回true，否则返回false
     * */
    public static Boolean compareDate(Date date, int day) {
        Calendar c = Calendar.getInstance(); 
        c.add(Calendar.DATE, day);
        return c.getTime().after(date);
    }
    public static String nextDay(String day){
        try {
            if(StringUtils.isNotBlank(day)){
                Date date1 =  date.parse(day);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date1);
                calendar.add(Calendar.DAY_OF_MONTH,1);
                return date.format(calendar.getTime());
            }
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return day;
    }

    public static String longToTime(Long longValue, String format){
        Date d = new Date(longValue);
        return date2String(d, format);
    }

    public static Date calcDateByHours(Integer hours){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR_OF_DAY, hours);      //24小时
        return calendar.getTime();
    }

    public static Date calcDateByHours(Date date, Integer hours){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hours);
        return calendar.getTime();
    }

    public static Date calcDateStartTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date calcDateEndTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    public static void main(String[] args){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(sdf.format(new Date()));
        System.out.println(sdf.format(new Date(1457345100653L)));
    }
    public static String string2String(String date,SimpleDateFormat sdf) throws ParseException {
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(sdf.parse(date));
        Date d = calendar.getTime();
        return sdf.format(d);
    }
}
