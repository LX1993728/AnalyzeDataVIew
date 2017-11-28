package com.anrong.wulan.core.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateKit {
	/** 日期转换为自定义格式输出 */
	public static String fomatDate(Date date, String format) {
		if (date == null) {
			return "";
		}
		if (format == null || "".equals(format)) {
			return "";
		}
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
			return "";

		}
	}

	/** 字符串转换为自定义格式日期 */
	public static Date StringToDate(String date, String formatType) {
		if (date == null || "".equals(date)) {
			return null;
		}
		if (formatType == null || "".equals(formatType)) {
			return null;
		}
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(formatType);
			sdf.setLenient(false);
			return sdf.parse(date);
		} catch (Exception e) {
			return null;
		}
	}
	public static String milliseconds2String(long ms,String formatType){
		Date d = new Date(ms);
		SimpleDateFormat sdf = new SimpleDateFormat(formatType);
		
		String r= sdf.format(d);
		return r;
	}
	/**
	 * 根据传入的日期，获取相隔天数日期
	 * 
	 * @param date
	 * @param anyDay
	 *            可正可负
	 * @return
	 */
	public static Date getAnyDayByNo(Date date, int anyDay) {
		if (date == null) {
			return null;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_WEEK, anyDay);
		return c.getTime();
	}

	/**
	 * 根据传入的日期，获取相隔年数日期
	 * 
	 * @param date
	 * @param anyYear
	 *            可正可负
	 * @return
	 */
	public static Date getAnyYearByNo(Date date, int anyYear) {
		if (date == null) {
			return null;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.YEAR, anyYear);
		return c.getTime();
	}

	/**
	 * 根据传入的日期，获取相隔小时的日期
	 * 
	 * @param date
	 * @param anyHour
	 *            可正可负
	 * @return
	 */
	public static Date getAnyHourByNo(Date date, int anyHour) {
		if (date == null) {
			return null;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.HOUR_OF_DAY, anyHour);
		return c.getTime();
	}
	
	/**
	 * 根据传入的日期，获取相隔分钟的日期
	 * 
	 * @param date
	 * @param anyMinute
	 *            可正可负
	 * @return
	 */
	public static Date getAnyMinuteByNo(Date date, int anyMinute) {
		if (date == null) {
			return null;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MINUTE, anyMinute);
		return c.getTime();
	}

	/**
	 * 日期比较
	 * 
	 * @param date1
	 * @param date2
	 * @return -1:date1<date2 0:date1=date2 1:date1>date2
	 */
	public static int compareDate(Date date1, Date date2) {
		if (date1 == null) {
			return -2;
		}
		if (date2 == null) {
			return -2;
		}
		return date1.compareTo(date2);
	}

	 
	/**
	 * 取得两个时间段的时间间隔,间隔天数不包含开始天和包含结束天数 return endDate与startDate的间隔天数 throws ParseException 如果输入的日期格式不是0000-00-00 格式抛出异常
	 */
	public static int getBetweenDays(String startDate, String endDate) throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyyMMdd");
		int betweenDays = 0;
		Date d1 = format.parse(startDate);
		Date d2 = format.parse(endDate);
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(d1);
		c2.setTime(d2);
		// 保证第二个时间不小于第一个时间
		if (c1.after(c2)) {
			c1 = c2;
		}
		int betweenYears = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
		betweenDays = c2.get(Calendar.DAY_OF_YEAR) - c1.get(Calendar.DAY_OF_YEAR);
		for (int i = 0; i < betweenYears; i++) {
			c1.set(Calendar.YEAR, (c1.get(Calendar.YEAR) + 1));
			betweenDays += c1.getMaximum(Calendar.DAY_OF_YEAR);
		}
		return betweenDays;
	}


	/**
	 * 日期天数加一天
	 * 
	 * @param date
	 *            传入一个日期
	 * @return 返回加一天后的日期
	 */
	public static Date dayAdd(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, 1);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = null;
		try {
			date1 = format.parse(sdf.format(c.getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date1;
	}

	/**
	 * 时间朝前推2天 小时朝前推1小时
	 * 
	 * @param date
	 *            传入一个日期
	 * @throws 返回一个日期
	 */
	public static Date nowDateTo2Days(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.HOUR_OF_DAY, -1);
		c.add(Calendar.DAY_OF_WEEK, -2);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date1 = null;
		try {
			date1 = format.parse(sdf.format(c.getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date1;
	}
	
	public static Date nowDateTo5Days(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.HOUR_OF_DAY, -1);
		c.add(Calendar.DAY_OF_WEEK, -5);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date1 = null;
		try {
			date1 = format.parse(sdf.format(c.getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date1;
	}
	

	public static String getCurrentDate(String partten) {
		Date d = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(partten);
		return formatter.format(d);
	}

	public static String getToday() {
		Date d = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		return formatter.format(d);
	}

	public static String format(Date date, String partten) {
		SimpleDateFormat formatter = new SimpleDateFormat(partten);
		return formatter.format(date);
	}

	/**
	 * 获取传入日期对应的星期几(0-6分别表示周日-周六)
	 * @param dt
	 * @return
	 */
	public static int getWeekOfDate(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		return w;
	}

	/**
	 * 获取参数传入日期的最小时间,即当天的0时0分0秒
	 * 
	 * @param date
	 * @return
	 */
	public static Date getMinDateTime(Date date) {
		String dateStr = fomatDate(date, "yyyyMMdd");
		if (dateStr == null) {
			return null;
		}
		return StringToDate(dateStr + "000000", "yyyyMMddHHmmss");
	}

	/**
	 * 获取参数传入日期的最大时间,即当天的23时59分59秒
	 * 
	 * @param date
	 * @return
	 */
	public static Date getMaxDateTime(Date date) {
		String dateStr = fomatDate(date, "yyyyMMdd");
		if (dateStr == null) {
			return null;
		}
		return StringToDate(dateStr + "235959", "yyyyMMddHHmmss");
	}

	public static Date getStartDate(Date date)
	{
		Calendar c = Calendar.getInstance();
		if(null == date)
			c.set(1970, 1, 1);
		else
			c.setTime(date);
		
	    c.set(Calendar.HOUR_OF_DAY, 0);
	    c.set(Calendar.MINUTE, 0);
	    c.set(Calendar.SECOND, 0);
	    return c.getTime();
	}
	
	public static Date getEndDate(Date date)
	{
	    Calendar c = Calendar.getInstance();
	    if(null == date)
			c.set(2100, 1, 1);
		else
			c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        
        return c.getTime();
	}
	
	 
	
	/**
	 * 日期天数加一年
	 * 
	 * @param date
	 *            传入一个日期
	 * @return 返回加一年后的日期
	 */
	public static Date yearAdd(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.YEAR, 1);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = null;
		try {
			date1 = format.parse(sdf.format(c.getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date1;
	}
	
	/**
	 * 获得前几周的周日,n=0当前周，n>0后n周，n<0前n周
	 * @param n
	 * @return
	 */
	public static Date getSundayOfWeeks(int n){
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.WEEK_OF_YEAR, n);
		c.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
		return c.getTime();
	} 
	
	/**
	 * 获得前几周的周一,n=0当前周，n>0后n周，n<0前n周
	 * @param n
	 * @return
	 */
	public static Date getMondayOfWeeks(int n){
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.WEEK_OF_YEAR, n);
		c.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
		return c.getTime();
	} 
}
