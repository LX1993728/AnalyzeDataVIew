package com.anrong.wulan.admin.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {

	public static void main(String[] args) throws Exception {
		String start = "2016-09-14";
		String end = "2017-01-02";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<Date> lDate = DateUtil.findDates(start, end);
		for (Date date : lDate) {
			System.out.println(sdf.format(date));
		}
	}

	public static List<Date> findDates(String dBegin, String dEnd) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date begin = null;
		Date end = null;
		try {
			begin = sdf.parse(dBegin);
			end = sdf.parse(dEnd);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<Date> lDate = new ArrayList<Date>();
		lDate.add(begin);
		Calendar calBegin = Calendar.getInstance();
		// 使用给定的 Date 设置此 Calendar 的时间
		calBegin.setTime(begin);
		Calendar calEnd = Calendar.getInstance();
		// 使用给定的 Date 设置此 Calendar 的时间
		calEnd.setTime(end);
		// 测试此日期是否在指定日期之后
		while (end.after(calBegin.getTime())) {
			// 根据日历的规则，为给定的日历字段添加或减去指定的时间量
			calBegin.add(Calendar.DAY_OF_MONTH, 1);
			lDate.add(calBegin.getTime());
		}
		return lDate;
	}
}