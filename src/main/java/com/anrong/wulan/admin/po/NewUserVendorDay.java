package com.anrong.wulan.admin.po;

import java.io.Serializable;
import java.util.Date;

public class NewUserVendorDay implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

    private String serverid;
    
    private String logType;
    
    private String appKey;

    private String appVersion;
    
    private String vendor;
    
    private int newUser;
    
    private Date statisticsDate;
    
    private int newUserTotal;
    
    private double newUserProportion;
    
    private String hotVendor;
    
    private String thirthFast;
    
    
    
	public String getThirthFast() {
		return thirthFast;
	}

	public void setThirthFast(String thirthFast) {
		this.thirthFast = thirthFast;
	}

	public String getHotVendor() {
		return hotVendor;
	}

	public void setHotVendor(String hotVendor) {
		this.hotVendor = hotVendor;
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

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
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
}
