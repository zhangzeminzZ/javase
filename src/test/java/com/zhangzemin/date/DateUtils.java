package com.zhangzemin.date;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * @author zhangzemin
 * @date 2020/3/6 23:19
 */
public class DateUtils {
    /**
     * 获取当前系统时间(毫秒数)
     */
    @Test
    public void getNowDate(){
        //方式一
        Date date = new Date();
        System.err.println(date.getTime());

        //方式二
        System.err.println(System.currentTimeMillis());

        //转换成指定的格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String current = sdf.format(System.currentTimeMillis());
        System.err.println(current);
    }

    /**
     * 日期转字符串、字符串转日期
     */
    @Test
    public void stringOrDateChange(){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //1、日期转字符串
            Calendar calendar = Calendar.getInstance();
            Date date = calendar.getTime();
            String dateStringParse = sdf.format(date);
            System.err.println(dateStringParse);

            //2、字符串转日期
            String dateString = "2020-03-06 23:36:47";
            Date dateParse = sdf.parse(dateString);
            System.err.println(dateParse);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将日期转换成中文年月日时分秒
     */
    @Test
    public void dateToChinese(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        Date date = new Date();
        String dateStr = sdf.format(date);
        System.err.println(dateStr);
    }

    /**
     * 将指定日期转换成带周的格式
     */
    @Test
    public void dateToWeek(){
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date d1 = df.parse("2020-03-06 23:43:40");
            //指定日期
            Calendar cal = df.getCalendar();
            //当前时间
            Calendar cas = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);//获取年份
            int month=cal.get(Calendar.MONTH);//获取月份
            int day=cal.get(Calendar.DATE);//获取日
            int hour=cal.get(Calendar.HOUR);//小时
            int minute=cal.get(Calendar.MINUTE);//分
            int second=cal.get(Calendar.SECOND);//秒
            int WeekOfYear = cal.get(Calendar.DAY_OF_WEEK);//一周的第几天
            System.out.println("现在的时间是：公元"+year+"年"+month+"月"+day+"日 "+hour+"时"+minute+"分"+second+"秒 星期"+WeekOfYear);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取当前时间显示，上午，下午
     */
    @Test
    public void getAmAndPm(){
        Date date = new Date();
        DateFormat df1 = DateFormat.getDateInstance();//日期格式，精确到日
        System.out.println(df1.format(date));

        DateFormat df2 = DateFormat.getDateTimeInstance();//可以精确到时分秒
        System.out.println(df2.format(date));

        DateFormat df3 = DateFormat.getTimeInstance();//只显示出时分秒
        System.out.println("只显示出时分秒:"+df3.format(date));

        DateFormat df4 = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL); //显示日期，周，上下午，时间(精确到秒)
        System.out.println("显示日期，周，上下午，时间(精确到秒):"+df4.format(date));

        DateFormat df5 = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG); //显示日期,上下午，时间(精确到秒)
        System.out.println("显示日期,上下午，时间(精确到秒):"+df5.format(date));

        DateFormat df6 = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT); //显示日期，上下午,时间(精确到分)  
        System.out.println("显示日期，上下午,时间(精确到分):"+df6.format(date));

        DateFormat df7 = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM); //显示日期，时间(精确到分)  
        System.out.println("显示日期，时间(精确到分):"+df7.format(date));
    }


    /**
     * 时间秒转化为多少天小时分秒
     */
    @Test
    public void formatSeconds(){
        long seconds = 100000000L;
        String timeStr = seconds + "秒";
        if(seconds > 60){
            long second = seconds % 60;
            long min = seconds / 60;
            timeStr = min + "分" + second + "秒";
            if(min > 60){
                min = (seconds / 60) % 60;
                long hour = (seconds / 60) / 60;
                timeStr = hour + "小时" + min + "分" + second + "秒";
                if(hour>24){
                    hour = ((seconds / 60) / 60) % 24;
                    long day = (((seconds / 60) / 60) / 24);
                    timeStr = day + "天" + hour + "小时" + min + "分" + second + "秒";
                }
            }
        }
        System.err.println(timeStr);
    }
}
