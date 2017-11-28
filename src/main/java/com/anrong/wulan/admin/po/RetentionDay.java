package com.anrong.wulan.admin.po;

import java.io.Serializable;
import java.util.Date;

public class RetentionDay implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private Long id;
    private String serverid;	//用于服务器标识
    private String logType;	//日志收集类型包括：Android，IOS，WinPhone，WepAPP等
    private String appKey;	//APP生成应用唯一标识UUID
    private String appVersion;	//APP应用版本信息
    private int oneDayRetention;	//次日留存
    private int sevenDayRetention;	//7日留存
    private int thirtyDayRetention;	//30日留存
    private Date ststisticsDate;	//统计日期
    private String affiliatedOrg;	//组织机构
    private String affiliatedRegion;	//行政地区

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