package com.anrong.wulan.admin.po;

import java.io.Serializable;
import java.util.Date;

public class SingleUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String serverid;

    private String logType;

    private String appKey;

    private String appVersion;

    private Short statisticsSign;

    private int singleUser;

    private int sample;

    private Date statisticsDate;

    public int getSample() {
        return sample;
    }

    public void setSample(int sample) {
        this.sample = sample;
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

    public int getSingleUser() {
        return singleUser;
    }

    public void setSingleUser(int singleUser) {
        this.singleUser = singleUser;
    }


    public Date getStatisticsDate() {
        return statisticsDate;
    }

    public void setStatisticsDate(Date statisticsDate) {
        this.statisticsDate = statisticsDate;
    }

}
