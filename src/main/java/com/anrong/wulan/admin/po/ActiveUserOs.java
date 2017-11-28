package com.anrong.wulan.admin.po;

import java.io.Serializable;
import java.util.Date;

public class ActiveUserOs implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String serverid;

	private String logType;

	private String appKey;

	private String appVersion;

	private String os;

	private int activeUser;

	private Date statisticsDate;

	private String affiliatedOrg;

	private String affiliatedRegion;

	private int actUserCount;

	private double actUserRate;

	public double getActUserRate() {
		return actUserRate;
	}

	public void setActUserRate(double actUserRate) {
		this.actUserRate = actUserRate;
	}

	public int getActUserCount() {
		return actUserCount;
	}

	public void setActUserCount(int actUserCount) {
		this.actUserCount = actUserCount;
	}

	public int getActiveUser() {
		return activeUser;
	}

	public void setActiveUser(int activeUser) {
		this.activeUser = activeUser;
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

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public Date getStatisticsDate() {
		return statisticsDate;
	}

	public void setStatisticsDate(Date statisticsDate) {
		this.statisticsDate = statisticsDate;
	}

	public String getAffiliatedOrg() {
		return affiliatedOrg;
	}

	public void setAffiliatedOrg(String affiliatedOrg) {
		this.affiliatedOrg = affiliatedOrg;
	}

	public String getAffiliatedRegion() {
		return affiliatedRegion;
	}

	public void setAffiliatedRegion(String affiliatedRegion) {
		this.affiliatedRegion = affiliatedRegion;
	}

}
