package com.cn.unit.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.cn.common._Tool;

/**
 * 时间工具类
 * @author 10011037@qq.com
 * 2016-02-12
 */
public class DateUtil {
	
	public static final String YYYYMM = "yyyyMM";
	public static final String YYYYMMDD = "yyyyMMdd";
	public static final String YYMMDDHHMMSS = "yyMMddHHmmss";
	public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

	public static final String YYYY_MM = "yyyy-MM";
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	public static final String YY_MM = "yy-MM";
	public static final String Y_M_D = "yyyy/MM/dd";
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	public static final String Y_M_D_H_M_S = "yyyy/MM/dd HH:mm:ss";
	public static final String H_M_S = "HH:mm:ss";
	public static final String H_M = "HH:mm";
	
	public static final String TIME_FLASH_START = " 00:00:00";
	public static final String TIME_FLASH_END = " 23:59:59";
	
	
	/**
     * 获取系统时间
     */
    public static Date getSystemDate() {
		return new Date();
	}
    
    /**
	 * 把时间转换为日期
	 * @param time 时间(2016-11-11 12:12:15.797)
	 * @return 日期字符串(2016-11-11)
	 */
	public static String getDateByTime(String time) {
		String date = time;
		if(_Tool.isEmpty(time)){
			time = getStrByDate(null, YYYY_MM_DD_HH_MM_SS);
		}
		date = time.substring(0, time.indexOf(" "));
		return date;
	}
    
    /**
	 * 把字符串转换为日期
	 * @param time 时间(2016-11-11 12:12:15.797)
	 * @return 日期字符串(2016-11-11)
	 */
	public static Date getStrByTime(String timeStr, String formatType) {
		if(_Tool.isEmpty(formatType)){
			formatType = YYYY_MM_DD_HH_MM_SS;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(formatType);
		Date date = null;
		try {
			date = sdf.parse(timeStr);
		} catch (ParseException e) {
			date = new Date();
		}
		return date;
	}
	
	/**
	 * 把时间转为字符串
	 * @param date 时间
	 * @param formatType 时间格式(字符串)
	 * @return 时间字符串
	 */
	public static String getStrByDate(Date date, String formatType) {
		if(date == null){
			date = new Date();
		}
		if(_Tool.isEmpty(formatType)){
			formatType = YYYY_MM_DD_HH_MM_SS;
		}
		SimpleDateFormat formatter = new SimpleDateFormat(formatType);
		String dateString = formatter.format(date);
		return dateString;
	}
	
	/**
	 * 把字符串转为字符串
	 * @param date 时间
	 * @param formatType 时间格式(字符串)
	 * @return 时间字符串
	 */
	public static String getStrByStr(String timeStr, String formatType) {
		SimpleDateFormat formatter = new SimpleDateFormat(formatType);
		String dateString = formatter.format(getStrByTime(timeStr, YYYY_MM_DD_HH_MM_SS));
		return dateString;
	}
	
	/**
	 * 把Long类型转换为时间String类型
	 * @param currentTime 时间戳
	 * @param formatType 时间格式(字符串)
	 * @return 时间字符串
	 */
	public static String getStrByLong(Long currentTime, String formatType) {
		Date date = new Date(currentTime);
 		return getStrByDate(date, formatType);
 	}
	
	/**
	 * 获取当前系统时间的日
	 */
	public static int getDateBySystemDate() {
		Calendar cal = Calendar.getInstance();
		int date = cal.get(Calendar.DATE);
		return date;
	}
	
	/**
	 * 获取季度第几个月份,不是几月
	 * @param month 月份
	 * @param isQuarterStart 是否获取该月份的季度开始的第几个月份
	 * @return 季度一年四季， 第一季度：2月-4月， 第二季度：5月-7月， 第三季度：8月-10月， 第四季度：11月-1月
	 */
	public static int getQuarterInMonth(int month, boolean isQuarterStart) {
        int months[] = { 1, 4, 7, 10 };
        if (!isQuarterStart) {
            months = new int[] { 3, 6, 9, 12 };
        }
        if (month >= 2 && month <= 4)
            return months[0];
        else if (month >= 5 && month <= 7)
            return months[1];
        else if (month >= 8 && month <= 10)
            return months[2];
        else
            return months[3];
    }
	
	/**
     * 获取当前时间的不同格式
     * @param mark 类型(year年份,month月份,cycle周,week星期,date日期,hour小时,minute分钟,second秒)
     * @return 当前时间的不同格式
     */
    public static int getGoalFormat(String date, String mark){
    	Calendar cal = Calendar.getInstance();
    	if(date != null){
        	cal.setTime(getStrByTime(date, YYYY_MM_DD));
    	}
    	int goal = 0;
    	if("year".equals(mark)){
    		goal = cal.get(Calendar.YEAR);
    	}else if("month".equals(mark)){
    		goal = cal.get(Calendar.MONTH)+1;
    	}else if("cycle".equals(mark)){
    		goal = cal.get(Calendar.WEEK_OF_YEAR);
    	}else if("week".equals(mark)){
    		// 1是星期日、2是星期一、3是星期二、4是星期三、5是星期四、6是星期五、7是星期六 
    		goal = cal.get(Calendar.DAY_OF_WEEK);
    	}else if("date".equals(mark)){
    		goal = cal.get(Calendar.DATE);
    	}else if("hour".equals(mark)){
    		goal = cal.get(Calendar.HOUR);
    	}else if("minute".equals(mark)){
    		goal = cal.get(Calendar.MINUTE);
    	}else if("second".equals(mark)){
    		goal = cal.get(Calendar.SECOND);
    	}
		return goal;
    }
	
    /**
     * 获取固定距离的时间
     * @param distance 距离大小
     * @param formatType 时间格式(字符串)
     * @param mark 距离类型(year年份,month月份,week星期,date日期,minute分钟)
     * @return 获取不同月份
     */
    public static String getDifferentTime(String date, Integer distance, String formatType, String mark){
    	Calendar c = Calendar.getInstance();
    	if(!_Tool.isEmpty(date)){
    		c.setTime(DateUtil.getStrByTime(date, formatType));
    	}
    	if("year".equals(mark)){
        	c.add(Calendar.YEAR, distance);
    	}else if("month".equals(mark)){
    		c.add(Calendar.MONTH, distance);
    	}else if("week".equals(mark)){
    		c.add(Calendar.DAY_OF_WEEK, distance);
    	}else if("date".equals(mark)){
    		c.add(Calendar.DATE, distance);
    	}else if("hour".equals(mark)){
    		c.add(Calendar.HOUR, distance);
    	}else if("minute".equals(mark)){
    		c.add(Calendar.MINUTE, distance);
    	}else if("second".equals(mark)){
    		c.add(Calendar.SECOND, distance);
    	}
    	String time = getStrByDate(c.getTime(), formatType);
    	return time;
    }
	
    /**
     * 获取两时间差
     * @param date1 时间1
     * @param date2 时间2
     * @param mark 单位类型(day天,hour小时,minute分钟,second秒钟)
     * @return 两时间差
     */
    public static int getTimeDifferent(String date1, String date2, String mark){
    	if(date1 == null){
    		date1 = getStrByDate(null, null);
    	}
    	if(date2 == null){
    		date2 = getStrByDate(null, null);
    	}
    	
    	Date time1 = null;
    	Date time2 = null;
    	if(date1.indexOf(":") >= 0 && (date1.indexOf("-") >= 0 || date1.indexOf("/") >= 0)){
        	time1 = getStrByTime(date1, YYYY_MM_DD_HH_MM_SS);
    		time2 = getStrByTime(date2, YYYY_MM_DD_HH_MM_SS);
    	}else if(date1.indexOf(":") >= 0){
        	time1 = getStrByTime(date1, H_M);
    		time2 = getStrByTime(date2, H_M);
    	}else{
        	time1 = getStrByTime(date1, YYYY_MM_DD);
    		time2 = getStrByTime(date2, YYYY_MM_DD);
    	}
		long time = time2.getTime() - time1.getTime();
		 
    	int total = 0;
    	if("second".equals(mark)){
    		total = new Long(time / 1000).intValue();
    	}else if("minute".equals(mark)){
    		total = new Long(time / (1000 * 60)).intValue();
    	}else if("hour".equals(mark)){
    		total = new Long(time / (1000 * 60 * 60)).intValue();
    	}else if("day".equals(mark)){
    		total = new Long(time / (1000 * 60 * 60 * 24)).intValue();
    	}
        return total;
    }
    
    /**
     * 获取本周第一天
     * @return
     */
    public static String getNowWeekStart(String formatType){
    	Calendar calendar = new GregorianCalendar();
		calendar.set(Calendar.DAY_OF_WEEK, 2);
		return DateUtil.getStrByDate(calendar.getTime(), formatType);
    }
    
    /**
     * 获取本周最后一天
     * @return
     */
    public static String getNowWeekEnd(String formatType){
    	Calendar calendar = new GregorianCalendar();  
		calendar.set(Calendar.DAY_OF_WEEK, 7);  
		return DateUtil.getStrByDate(calendar.getTime(), formatType);
    }
    
    /**
     * 获取本月第一天
     * @return
     */
    public static String getNowMonthStart(String formatType){
    	Calendar calendar = new GregorianCalendar();  
		calendar.set(Calendar.DAY_OF_MONTH, 1);  
		return DateUtil.getStrByDate(calendar.getTime(), formatType);
    }
    
    /**
     * 获取本月最后一天
     * @return
     */
    public static String getNowMonthEnd(String formatType){
    	Calendar calendar = new GregorianCalendar();  
    	calendar.add(Calendar.MONTH, 1);  
        calendar.set(Calendar.DAY_OF_MONTH, 0);  
		return DateUtil.getStrByDate(calendar.getTime(), formatType);
    }
    
    
    /**
     * 获取本季度第一天
     * @return
     */
    public static String getNowQuarterStart(){
    	Calendar calendar = new GregorianCalendar();  
    	calendar.setTime(new Date());  
    	
        int month = getQuarterInMonth(calendar.get(Calendar.MONTH), true);  
        calendar.set(Calendar.MONTH, month);  
        calendar.set(Calendar.DAY_OF_MONTH, 1); 
		return DateUtil.getStrByDate(calendar.getTime(), YYYY_MM_DD);
    }
    
    /**
     * 获取本季度最后一天
     * @return
     */
    public static String getNowQuarterEnd(){
    	Calendar calendar = new GregorianCalendar();  
    	calendar.setTime(new Date());  
        int month = getQuarterInMonth(calendar.get(Calendar.MONTH), false);  
        calendar.set(Calendar.MONTH, month + 1);  
        calendar.set(Calendar.DAY_OF_MONTH, 0);  
		return DateUtil.getStrByDate(calendar.getTime(), YYYY_MM_DD);
    }
    
    
    /**
     * 获取本年第一天
     * @return
     */
    public static String getNowYearStart(){
        Calendar calendar = new GregorianCalendar(); 
        calendar.setTime(new Date());  
        int year = calendar.get(Calendar.YEAR);
        calendar.clear();
        calendar.set(Calendar.YEAR, year);  
		return DateUtil.getStrByDate(calendar.getTime(), YYYY_MM_DD);
    }
    
    /**
     * 获取本年度最后一天
     * @return
     */
    public static String getNowYearEnd(){
    	Calendar calendar = new GregorianCalendar(); 
        calendar.setTime(new Date());  
        int year = calendar.get(Calendar.YEAR);
        calendar.clear();
        calendar.set(Calendar.YEAR, year);  
        calendar.roll(Calendar.DAY_OF_YEAR, -1);  
		return DateUtil.getStrByDate(calendar.getTime(), YYYY_MM_DD);
    }
    
    /**
     * 获取第几周
     */
    public static int getWeekByYear(String timeStr) {
    	Date date = null;
    	if(_Tool.isEmpty(timeStr)){
    		date = new Date();
    	}else{
    		date = getStrByTime(timeStr, YYYY_MM_DD);
    	}
    	Calendar calendar = Calendar.getInstance();
    	calendar.setFirstDayOfWeek(Calendar.MONDAY);
    	calendar.setTime(date);
    	return calendar.get(Calendar.WEEK_OF_YEAR);
    }
    
    /**
     * 获取最近一个星期一
     */
    public static String getLatelyMon(String date, String formatType, Integer mark){
    	Calendar cal = Calendar.getInstance();
    	if (_Tool.isEmpty(date)) {
    		cal.setTime(new Date(System.currentTimeMillis()));
    	}else {
    		cal.setTime(new Date(getStrByTime(date, YYYY_MM_DD).getTime()));
    	}
    	int c = cal.get(Calendar.DAY_OF_WEEK);
    	int distance = mark > 0 ? (c==1 ? (c-7) : (2-c)) : (c==1 ? -13 : (-c-5));
    	String dateTime = getDifferentTime(null, distance, formatType, "date");
    	return dateTime;
    }
    
    /**
     * 日期比较(time1>=time2)
     * @param DATE1
     * @param DATE2
     * @return
     */
    public static boolean compareDate(String time1, String time2) {
    	if(_Tool.isEmpty(time1)){
    		time1 = getStrByDate(null, null);
    	}
    	if(_Tool.isEmpty(time2)){
    		time2 = getStrByDate(null, null);
    	}
        DateFormat df = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        try {
            Date dt1 = df.parse(time1);
            Date dt2 = df.parse(time2);
            if (dt1.getTime() > dt2.getTime()) {
                return true;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }
    
    /**
     * 获取下一个星期一
     
    public static String getCatchMon(String date, String formatType){
    	Calendar cal = Calendar.getInstance();
    	if (Tool.isEmpty(date)) {
    		cal.setTime(new Date(System.currentTimeMillis()));
    	} else {
    		cal.setTime(new Date(getStrByTime(date, YYYY_MM_DD).getTime()));
    	}
    	int c = cal.get(Calendar.DAY_OF_WEEK);
    	String dateTime = null;
		dateTime = getDifferentDate(c==1 ? c : (9-c), formatType);
    	return dateTime;
    }*/
	
    /**
     * 测试方法
     */
	public static void main(String[] args){
		System.out.println(DateUtil.getStrByDate(null, DateUtil.YYYY_MM_DD));
		System.out.println(DateUtil.getDifferentTime("10:00", -16, DateUtil.H_M, "minute"));
		// 类型(year年份,month月份,cycle周,week星期,date日期,hour小时,minute分钟,second秒)
		System.out.println(DateUtil.getGoalFormat(null, "week"));
		
		System.out.println(compareDate("2017-9-6 10:00:10", "2017-9-6 10:00:11"));
		System.out.println(DateUtil.getStrByStr("2018-9-1", "yyyy年MM月dd日"));
		
		//
		/*Calendar c = Calendar.getInstance();
		c.setTime(DateUtil.getStrByTime("10:00", DateUtil.H_M));
		c.add(Calendar.MINUTE, -6);
		String time = getStrByDate(c.getTime(), DateUtil.H_M);
		System.out.println(time);*/
	}
	
}
