package com.anrong.wulan.admin.po;

import java.io.Serializable;
import java.util.Date;

public class StartHour implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String serverid;

    private String logType;

    private String appKey;

    private String appVersion;

    private int start;

    private Short statisticsSign;

    private Date statisticsDate;

    private int startCount;

    // 启动总数
    private int totalStart;

    // 30日启动次数
    private int thirtyStart;
    
    private double starttimeAvg;
    
    private double startProportion;
    
    private double highTimeStartPer;
    
    private double lowTimeStartPer;
    
    private double StartBySignPerTotal;
    

    public double getStartBySignPerTotal() {
		return StartBySignPerTotal;
	}

	public void setStartBySignPerTotal(double startBySignPerTotal) {
		StartBySignPerTotal = startBySignPerTotal;
	}

	public double getHighTimeStartPer() {
		return highTimeStartPer;
	}

	public void setHighTimeStartPer(double highTimeStartPer) {
		this.highTimeStartPer = highTimeStartPer;
	}

	public double getLowTimeStartPer() {
		return lowTimeStartPer;
	}

	public void setLowTimeStartPer(double lowTimeStartPer) {
		this.lowTimeStartPer = lowTimeStartPer;
	}

	public double getStartProportion() {
		return startProportion;
	}

	public void setStartProportion(double startProportion) {
		this.startProportion = startProportion;
	}

	public double getStarttimeAvg() {
		return starttimeAvg;
	}

	public void setStarttimeAvg(double starttimeAvg) {
		this.starttimeAvg = starttimeAvg;
	}

	public int getThirtyStart() {
        return thirtyStart;
    }

    public void setThirtyStart(int thirtyStart) {
        this.thirtyStart = thirtyStart;
    }

    public int getTotalStart() {
        return totalStart;
    }

    public void setTotalStart(int totalStart) {
        this.totalStart = totalStart;
    }

    public int getStartCount() {
        return startCount;
    }

    public void setStartCount(int startCount) {
        this.startCount = startCount;
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

    public Short getStatisticsSign() {
        return statisticsSign;
    }

    public void setStatisticsSign(Short statisticsSign) {
        this.statisticsSign = statisticsSign;
    }

    public Date getStatisticsDate() {
        return statisticsDate;
    }

    public void setStatisticsDate(Date statisticsDate) {
        this.statisticsDate = statisticsDate;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

}