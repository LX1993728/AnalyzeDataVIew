package com.anrong.wulan.core.el;

import java.text.SimpleDateFormat;
import java.util.TimeZone;
/**
 * 格式化时间差
 * @author liuxun
 *
 */
public class FormatDateTime {
	// 
	public static String ftdBySeconds(Long seconds) {
		SimpleDateFormat formatter= new SimpleDateFormat("HH:mm:ss");
		formatter.setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
		return formatter.format(seconds.longValue()*1000);
	}
	
//	public static void main(String[] args) {
//		System.out.println(FormatDateTime.ftdBySeconds(3600l));
//	}
}
