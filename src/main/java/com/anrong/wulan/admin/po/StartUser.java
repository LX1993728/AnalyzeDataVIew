package com.anrong.wulan.admin.po;

import java.io.Serializable;
import java.util.Date;

public class StartUser implements Serializable {

	private static final long serialVersionUID = 1L;
	private int start_1; // 启动一次人数
	private int start_2_3; // 启动2~3次人数
	private int start_4_5; // 启动4~5次人数
	private int start_6_10; // 启动6~10次人数
	private int start_11_20; // 启动11~20次人数
	private int start_21_50; // 启动21~50次人数
	private int startGreater_50; // 启动大于50次
	private int countDay; // 日启动总次数
	private int countUserDay; // 活跃用户
	private String logType;//日志收集类型包括：Android，IOS，WinPhone，WepAPP等
	private String appKey;//APP生成应用唯一标识UUID
	private String appVersion;//APP应用版本信息
	private Date statisticsDate;	//统计日期
	private double averageDay; // 人均日启动次数

	public double getAverageDay() {
		return averageDay;
	}

	public void setAverageDay(double averageDay) {
		this.averageDay = averageDay;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public int getCountUserDay() {
		return countUserDay;
	}

	public void setCountUserDay(int countUserDay) {
		this.countUserDay = countUserDay;
	}

	public Date getStatisticsDate() {
		return statisticsDate;
	}

	public void setStatisticsDate(Date statisticsDate) {
		this.statisticsDate = statisticsDate;
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

	public int getStart_1() {
		return start_1;
	}

	public void setStart_1(int start_1) {
		this.start_1 = start_1;
	}

	public int getStart_2_3() {
		return start_2_3;
	}

	public void setStart_2_3(int start_2_3) {
		this.start_2_3 = start_2_3;
	}

	public int getStart_4_5() {
		return start_4_5;
	}

	public void setStart_4_5(int start_4_5) {
		this.start_4_5 = start_4_5;
	}

	public int getStart_6_10() {
		return start_6_10;
	}

	public void setStart_6_10(int start_6_10) {
		this.start_6_10 = start_6_10;
	}

	public int getStart_11_20() {
		return start_11_20;
	}

	public void setStart_11_20(int start_11_20) {
		this.start_11_20 = start_11_20;
	}

	public int getStart_21_50() {
		return start_21_50;
	}

	public void setStart_21_50(int start_21_50) {
		this.start_21_50 = start_21_50;
	}

	public int getStartGreater_50() {
		return startGreater_50;
	}

	public void setStartGreater_50(int startGreater_50) {
		this.startGreater_50 = startGreater_50;
	}

	public int getCountDay() {
		return countDay;
	}

	public void setCountDay(int countDay) {
		this.countDay = countDay;
	}

}