package com.anrong.wulan.admin.po;

import java.io.Serializable;
import java.util.Date;

public class NewUserRegionDay implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String serverid;

	private String logType;

	private String appKey;

	private String appVersion;

	private String region;

	private int newUser;

	private Date statisticsDate;
	
	// 新增用户总数
	private int newUserTotal;
	// 新增占比
	private double newUserProportion;
	//地区总数
	private int provinceCount;
	//省
	private String province;


	public int getProvinceCount() {
		return provinceCount;
	}

	public void setProvinceCount(int provinceCount) {
		this.provinceCount = provinceCount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getServerid() {
		return serverid;
	}

	public void setServerid(String serverid) {
		this.serverid = serverid;
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

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public int getNewUser() {
		return newUser;
	}

	public void setNewUser(int newUser) {
		this.newUser = newUser;
	}

	public Date getStatisticsDate() {
		return statisticsDate;
	}

	public void setStatisticsDate(Date statisticsDate) {
		this.statisticsDate = statisticsDate;
	}

	public int getNewUserTotal() {
		return newUserTotal;
	}

	public void setNewUserTotal(int newUserTotal) {
		this.newUserTotal = newUserTotal;
	}

	public double getNewUserProportion() {
		return newUserProportion;
	}

	public void setNewUserProportion(double newUserProportion) {
		this.newUserProportion = newUserProportion;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	
}
