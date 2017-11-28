package com.anrong.wulan.admin.po;

import java.io.Serializable;
import java.util.Date;

public class RetentionUserHour implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private int oneDayRetention;	//次日留存
    private int sevenDayRetention;	//7日留存
    private int thirtyDayRetention;	//30日留存
    private Date ststisticsDate;	//统计日期
    private int newUser;			//新增用户
    private double oneRates;	//次日 留存率
    private double sevenRates;	// 7日  留存率
    private double thirtyRates;	// 30日  留存率
	private String logType;//日志收集类型包括：Android，IOS，WinPhone，WepAPP等
	private String appKey;//APP生成应用唯一标识UUID
	private String appVersion;//APP应用版本信息
	
	public int getNewUser() {
		return newUser;
	}
	public void setNewUser(int newUser) {
		this.newUser = newUser;
	}
	public String getLogType() {
		return logType;
	}
	public void setLogType(String logType) {
		this.logType = logType;
	}
	public String getAppKey() {
		return appKey;
	}
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}
	public String getAppVersion() {
		return appVersion;
	}
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}
	public int getOneDayRetention() {
		return oneDayRetention;
	}
	public void setOneDayRetention(int oneDayRetention) {
		this.oneDayRetention = oneDayRetention;
	}
	public int getSevenDayRetention() {
		return sevenDayRetention;
	}
	public void setSevenDayRetention(int sevenDayRetention) {
		this.sevenDayRetention = sevenDayRetention;
	}
	public int getThirtyDayRetention() {
		return thirtyDayRetention;
	}
	public void setThirtyDayRetention(int thirtyDayRetention) {
		this.thirtyDayRetention = thirtyDayRetention;
	}
	public Date getStstisticsDate() {
		return ststisticsDate;
	}
	public void setStstisticsDate(Date ststisticsDate) {
		this.ststisticsDate = ststisticsDate;
	}
	public double getOneRates() {
		return oneRates;
	}
	public void setOneRates(double oneRates) {
		this.oneRates = oneRates;
	}
	public double getSevenRates() {
		return sevenRates;
	}
	public void setSevenRates(double sevenRates) {
		this.sevenRates = sevenRates;
	}
	public double getThirtyRates() {
		return thirtyRates;
	}
	public void setThirtyRates(double thirtyRates) {
		this.thirtyRates = thirtyRates;
	}
    
}