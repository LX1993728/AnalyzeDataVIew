package com.anrong.wulan.admin.po;

import java.io.Serializable;
import java.util.Date;

public class NewUserHour implements Serializable {
    
    
    private static final long serialVersionUID = 1L;

    private Long id;

    private String serverid;
    
    private String logType;
    
    private String appKey;

    private String appVersion;

    private int newUser;
    
    private Short statisticsSign;

    private Date date;
    
    private int totalUser;
    
    private int newUserCount;
    
    private int useNum;
    
    private int durationTime;
    
    private int columnData;
    
    private double newuserAvg;
    
    private double newUserProportion;
    

	public double getNewuserAvg() {
		return newuserAvg;
	}

	public void setNewuserAvg(double newuserAvg) {
		this.newuserAvg = newuserAvg;
	}

	public double getNewUserProportion() {
		return newUserProportion;
	}

	public void setNewUserProportion(double newUserProportion) {
		this.newUserProportion = newUserProportion;
	}

	public int getColumnData() {
		return columnData;
	}

	public void setColumnData(int columnData) {
		this.columnData = columnData;
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

    public int getNewUser() {
        return newUser;
    }

    public void setNewUser(int newUser) {
        this.newUser = newUser;
    }

    public Short getStatisticsSign() {
        return statisticsSign;
    }

    public void setStatisticsSign(Short statisticsSign) {
        this.statisticsSign = statisticsSign;
    }

   

    public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getNewUserCount() {
        return newUserCount;
    }

    public void setNewUserCount(int newUserCount) {
        this.newUserCount = newUserCount;
    }


    public int getUseNum() {
        return useNum;
    }

    public void setUseNum(int useNum) {
        this.useNum = useNum;
    }

    public int getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(int durationTime) {
        this.durationTime = durationTime;
    }

    public int getTotalUser() {
        return totalUser;
    }

    public void setTotalUser(int totalUser) {
        this.totalUser = totalUser;
    }

    

}