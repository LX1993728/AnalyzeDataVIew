package com.anrong.wulan.admin.vo;

import java.io.Serializable;

public class AppGeneralizeVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 近七日活跃设备*/
	private Integer sevenActive = 0;
	/** 近30日活跃设备*/
	private Integer thirtyActive = 0;
	/** 近七日活跃设备上下浮动*/
	private double sevenActiveFloat = 0.00;
	/** 近30日活跃设备上下浮动*/
	private double thirtyActiveFloat = 0.00;
	/** 单设备日均使用时长*/
	private String averageDaily = "00:00:00";
	/** 单设备日均使用时长浮动*/
	private double averageDailyFloat = 0.00;
	/** 总设备数*/
	private Integer sum = 0;
	//昨日新增
	private Integer yesterdayNewSum = 0;
	//昨日此时新增
	private Integer yesterdayMomentNewSum = 0;
	//今日新增
	private Integer todayNewSum = 0;
	//昨日活跃
	private Integer yesterdayActiveSum = 0;
	//昨日此时活跃
	private Integer yesterdayMomentActiveSum = 0;
	//今日活跃
	private Integer todayActiveSum = 0;
	
	
	public Integer getSevenActive() {
		return sevenActive;
	}
	public void setSevenActive(Integer sevenActive) {
		this.sevenActive = sevenActive;
	}
	public Integer getThirtyActive() {
		return thirtyActive;
	}
	public void setThirtyActive(Integer thirtyActive) {
		this.thirtyActive = thirtyActive;
	}
	public double getSevenActiveFloat() {
		return sevenActiveFloat;
	}
	public void setSevenActiveFloat(double sevenActiveFloat) {
		this.sevenActiveFloat = sevenActiveFloat;
	}
	public double getThirtyActiveFloat() {
		return thirtyActiveFloat;
	}
	public void setThirtyActiveFloat(double thirtyActiveFloat) {
		this.thirtyActiveFloat = thirtyActiveFloat;
	}
	public String getAverageDaily() {
		return averageDaily;
	}
	public void setAverageDaily(String averageDaily) {
		this.averageDaily = averageDaily;
	}
	public double getAverageDailyFloat() {
		return averageDailyFloat;
	}
	public void setAverageDailyFloat(double averageDailyFloat) {
		this.averageDailyFloat = averageDailyFloat;
	}
	public Integer getSum() {
		return sum;
	}
	public void setSum(Integer sum) {
		this.sum = sum;
	}
	public Integer getYesterdayNewSum() {
		return yesterdayNewSum;
	}
	public void setYesterdayNewSum(Integer yesterdayNewSum) {
		this.yesterdayNewSum = yesterdayNewSum;
	}
	public Integer getYesterdayMomentNewSum() {
		return yesterdayMomentNewSum;
	}
	public void setYesterdayMomentNewSum(Integer yesterdayMomentNewSum) {
		this.yesterdayMomentNewSum = yesterdayMomentNewSum;
	}
	public Integer getTodayNewSum() {
		return todayNewSum;
	}
	public void setTodayNewSum(Integer todayNewSum) {
		this.todayNewSum = todayNewSum;
	}
	public Integer getYesterdayActiveSum() {
		return yesterdayActiveSum;
	}
	public void setYesterdayActiveSum(Integer yesterdayActiveSum) {
		this.yesterdayActiveSum = yesterdayActiveSum;
	}
	public Integer getYesterdayMomentActiveSum() {
		return yesterdayMomentActiveSum;
	}
	public void setYesterdayMomentActiveSum(Integer yesterdayMomentActiveSum) {
		this.yesterdayMomentActiveSum = yesterdayMomentActiveSum;
	}
	public Integer getTodayActiveSum() {
		return todayActiveSum;
	}
	public void setTodayActiveSum(Integer todayActiveSum) {
		this.todayActiveSum = todayActiveSum;
	}
	
	
}
