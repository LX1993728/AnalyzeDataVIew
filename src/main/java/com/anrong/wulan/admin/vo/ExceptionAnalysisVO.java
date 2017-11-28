package com.anrong.wulan.admin.vo;

import java.io.Serializable;

public class ExceptionAnalysisVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String date1;
	private int exceptionCount;
	private int businessExceptionCount;
	private int sysExceptionCount;
	private String useTimeProportion;
	private String startTimeProportion;
	
	private int totalException;
	private String todayMostExceptionName;
	private String todayMostExceptionPosition;
	
	private String todayCompareYesterday;
	private String todayCOmpareWeek;
	private String todayCompareMonth;
	
	private String exceptionName;
	private int exceptionTime;
	private String exceptionDetail;
	public String getDate1() {
		return date1;
	}
	public void setDate1(String date1) {
		this.date1 = date1;
	}
	public int getExceptionCount() {
		return exceptionCount;
	}
	public void setExceptionCount(int exceptionCount) {
		this.exceptionCount = exceptionCount;
	}
	public int getBusinessExceptionCount() {
		return businessExceptionCount;
	}
	public void setBusinessExceptionCount(int businessExceptionCount) {
		this.businessExceptionCount = businessExceptionCount;
	}
	public int getSysExceptionCount() {
		return sysExceptionCount;
	}
	public void setSysExceptionCount(int sysExceptionCount) {
		this.sysExceptionCount = sysExceptionCount;
	}
	public String getUseTimeProportion() {
		return useTimeProportion;
	}
	public void setUseTimeProportion(String useTimeProportion) {
		this.useTimeProportion = useTimeProportion;
	}
	public String getStartTimeProportion() {
		return startTimeProportion;
	}
	public void setStartTimeProportion(String startTimeProportion) {
		this.startTimeProportion = startTimeProportion;
	}
	public int getTotalException() {
		return totalException;
	}
	public void setTotalException(int totalException) {
		this.totalException = totalException;
	}
	public String getTodayMostExceptionName() {
		return todayMostExceptionName;
	}
	public void setTodayMostExceptionName(String todayMostExceptionName) {
		this.todayMostExceptionName = todayMostExceptionName;
	}
	public String getTodayMostExceptionPosition() {
		return todayMostExceptionPosition;
	}
	public void setTodayMostExceptionPosition(String todayMostExceptionPosition) {
		this.todayMostExceptionPosition = todayMostExceptionPosition;
	}
	public String getTodayCompareYesterday() {
		return todayCompareYesterday;
	}
	public void setTodayCompareYesterday(String todayCompareYesterday) {
		this.todayCompareYesterday = todayCompareYesterday;
	}
	public String getTodayCOmpareWeek() {
		return todayCOmpareWeek;
	}
	public void setTodayCOmpareWeek(String todayCOmpareWeek) {
		this.todayCOmpareWeek = todayCOmpareWeek;
	}
	public String getTodayCompareMonth() {
		return todayCompareMonth;
	}
	public void setTodayCompareMonth(String todayCompareMonth) {
		this.todayCompareMonth = todayCompareMonth;
	}
	public String getExceptionName() {
		return exceptionName;
	}
	public void setExceptionName(String exceptionName) {
		this.exceptionName = exceptionName;
	}
	public int getExceptionTime() {
		return exceptionTime;
	}
	public void setExceptionTime(int exceptionTime) {
		this.exceptionTime = exceptionTime;
	}
	public String getExceptionDetail() {
		return exceptionDetail;
	}
	public void setExceptionDetail(String exceptionDetail) {
		this.exceptionDetail = exceptionDetail;
	}
}
