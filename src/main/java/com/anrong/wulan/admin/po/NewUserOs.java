package com.anrong.wulan.admin.po;

import java.io.Serializable;
import java.util.Date;

public class NewUserOs implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String serverid;

	private String logType;

	private String appKey;

	private String appVersion;

	private String os;

	private int newUser;

	private Date statisticsDate;

	private String affiliatedOrg;

	private String affiliatedRegion;

	private int newUserCount;

	private double newUserProportion;

	private String hotOs;

	private int activeUser;

	private double newUserRate;

	private double actUserRate;

	private int start;
	
	private String thirthFast;
	
	public String getThirthFast() {
		return thirthFast;
	}

	public void setThirthFast(String thirthFast) {
		this.thirthFast = thirthFast;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getActiveUser() {
		return activeUser;
	}

	public void setActiveUser(int activeUser) {
		this.activeUser = activeUser;
	}

	public double getNewUserRate() {
		return newUserRate;
	}

	public void setNewUserRate(double newUserRate) {
		this.newUserRate = newUserRate;
	}

	public double getActUserRate() {
		return actUserRate;
	}

	public void setActUserRate(double actUserRate) {
		this.actUserRate = actUserRate;
	}

	public String getHotOs() {
		return hotOs;
	}

	public void setHotOs(String hotOs) {
		this.hotOs = hotOs;
	}

	public double getNewUserProportion() {
		return newUserProportion;
	}

	public void setNewUserProportion(double newUserProportion) {
		this.newUserProportion = newUserProportion;
	}

	public int getNewUserCount() {
		return newUserCount;
	}

	public void setNewUserCount(int newUserCount) {
		this.newUserCount = newUserCount;
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
