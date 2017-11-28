package com.anrong.wulan.admin.po;

import java.io.Serializable;
import java.util.Date;

public class StartOs implements Serializable  {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String serverid;
    
    private String logType;
    
    private String appKey;

    private String appVersion;
    
    private String os;
    
    private int start;
    
    private Date statisticsDate;
    
    private String affiliatedOrg;

    private String affiliatedRegion;
    
    
    private int newUserCount;
    
    private int startTotal;
    
   

	public int getStartTotal() {
		return startTotal;
	}

	public void setStartTotal(int startTotal) {
		this.startTotal = startTotal;
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

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }
    
    
}
