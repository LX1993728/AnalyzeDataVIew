package com.anrong.wulan.admin.vo;

import java.io.Serializable;

public class RetentionDayVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int newUser; // 新增用户
	private int oneDayRetention; // 次日留存
	private int sevenDayRetention; // 7日留存
	private int thirtyDayRetention; // 30日留存
	private String ststisticsDate; // 统计日期
	private String oneRates; // 次日留存率
	private String sevenRates; // 7日留存率
	private String thirtyRates; // 30日留存率
	private String averagePeriod; // 时期内平均
	private String overallAverage; // 总体平均
	private String retentionRates; // 次日留存率 7日留存率 30日留存率
	private String retentionGeneral; // 次日留存概况 7日留存概况 30日留存概况
	private String retentionDetail; // 次日留存明细 7日留存明细 30日留存明细

	public String getRetentionRates() {
		return retentionRates;
	}

	public void setRetentionRates(String retentionRates) {
		this.retentionRates = retentionRates;
	}

	public String getRetentionGeneral() {
		return retentionGeneral;
	}

	public void setRetentionGeneral(String retentionGeneral) {
		this.retentionGeneral = retentionGeneral;
	}

	public String getRetentionDetail() {
		return retentionDetail;
	}

	public void setRetentionDetail(String retentionDetail) {
		this.retentionDetail = retentionDetail;
	}

	public int getNewUser() {
		return newUser;
	}

	public void setNewUser(int newUser) {
		this.newUser = newUser;
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

	public String getStstisticsDate() {
		return ststisticsDate;
	}

	public void setStstisticsDate(String ststisticsDate) {
		this.ststisticsDate = ststisticsDate;
	}

	public String getAveragePeriod() {
		return averagePeriod;
	}

	public void setAveragePeriod(String averagePeriod) {
		this.averagePeriod = averagePeriod;
	}

	public String getOverallAverage() {
		return overallAverage;
	}

	public void setOverallAverage(String overallAverage) {
		this.overallAverage = overallAverage;
	}

	public String getOneRates() {
		return oneRates;
	}

	public void setOneRates(String oneRates) {
		this.oneRates = oneRates;
	}

	public String getSevenRates() {
		return sevenRates;
	}

	public void setSevenRates(String sevenRates) {
		this.sevenRates = sevenRates;
	}

	public String getThirtyRates() {
		return thirtyRates;
	}

	public void setThirtyRates(String thirtyRates) {
		this.thirtyRates = thirtyRates;
	}

}