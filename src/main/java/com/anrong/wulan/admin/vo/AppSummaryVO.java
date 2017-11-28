package com.anrong.wulan.admin.vo;

import java.io.Serializable;


/**
 * 
 * 应用概括
 * 
 */
public class AppSummaryVO implements Serializable {

    private static final long serialVersionUID = 1L;

    // 累计用户总数
    private int totalUser;
    //样本数
    private int simple;
    //一次性用户数
    private int singleUser;
    //一次性用户/样本数
    private String singleUserRate;
    
    // 启动总数
    private int totalStart;
    // 30日启动次数
    private int thirtyStart;
    // 月活跃用户数
    //private int recentMonthActive;
    private int monthActUser;
    // 周活跃用户数
    private int weekActUser;
    // 月活跃%
    private String monthActUserRate;
    // 周活跃%
    private String weekActUserRate;
    // 近30日每日人均启动
    private String prethirtyStart;
    // 次日留存率
    private String retentionRate;


    public String getRetentionRate() {
		return retentionRate;
	}

	public void setRetentionRate(String retentionRate) {
		this.retentionRate = retentionRate;
	}

	public int getWeekActUser() {
        return weekActUser;
    }

    public void setWeekActUser(int weekActUser) {
        this.weekActUser = weekActUser;
    }

    public String getMonthActUserRate() {
        return monthActUserRate;
    }

    public void setMonthActUserRate(String monthActUserRate) {
        this.monthActUserRate = monthActUserRate;
    }

    public String getWeekActUserRate() {
        return weekActUserRate;
    }

    public void setWeekActUserRate(String weekActUserRate) {
        this.weekActUserRate = weekActUserRate;
    }

    public String getPrethirtyStart() {
        return prethirtyStart;
    }

    public void setPrethirtyStart(String prethirtyStart) {
        this.prethirtyStart = prethirtyStart;
    }

    public int getThirtyStart() {
        return thirtyStart;
    }

    public void setThirtyStart(int thirtyStart) {
        this.thirtyStart = thirtyStart;
    }

  

    public int getMonthActUser() {
        return monthActUser;
    }

    public void setMonthActUser(int monthActUser) {
        this.monthActUser = monthActUser;
    }

    public int getTotalUser() {
        return totalUser;
    }

    public void setTotalUser(int totalUser) {
        this.totalUser = totalUser;
    }

    public int getTotalStart() {
        return totalStart;
    }

    public void setTotalStart(int totalStart) {
        this.totalStart = totalStart;
    }

    public int getSimple() {
        return simple;
    }

    public void setSimple(int simple) {
        this.simple = simple;
    }

    public int getSingleUser() {
        return singleUser;
    }

    public void setSingleUser(int singleUser) {
        this.singleUser = singleUser;
    }

    public String getSingleUserRate() {
        return singleUserRate;
    }

    public void setSingleUserRate(String singleUserRate) {
        this.singleUserRate = singleUserRate;
    }

}
