package com.anrong.wulan.admin.po;

import java.io.Serializable;
import java.util.Date;

public class UserTimesLost implements Serializable {

	private static final long serialVersionUID = 1L;
	private Date ststisticsDate; // 统计日期
	private int countinuousDay;// 持续天数7天、14天、30天
	private int lost_0_3_S; // 0-3S
	private int lost_4_10_S; // 4-10S
	private int lost_11_30_S; // 11-30S
	private int lost_31_60_S; // 31-60S
	private int lost_1_3_M; // 1-3min
	private int lost_3_10_M; // 3-10min
	private int lost_10_30_M; // 10-30min
	private int lost_30_60_M; // 30-60min
	private int lost_60_M_UP; // 大于1hour

	public Date getStstisticsDate() {
		return ststisticsDate;
	}

	public void setStstisticsDate(Date ststisticsDate) {
		this.ststisticsDate = ststisticsDate;
	}

	public int getCountinuousDay() {
		return countinuousDay;
	}

	public void setCountinuousDay(int countinuousDay) {
		this.countinuousDay = countinuousDay;
	}

	public int getLost_0_3_S() {
		return lost_0_3_S;
	}

	public void setLost_0_3_S(int lost_0_3_S) {
		this.lost_0_3_S = lost_0_3_S;
	}

	public int getLost_4_10_S() {
		return lost_4_10_S;
	}

	public void setLost_4_10_S(int lost_4_10_S) {
		this.lost_4_10_S = lost_4_10_S;
	}

	public int getLost_11_30_S() {
		return lost_11_30_S;
	}

	public void setLost_11_30_S(int lost_11_30_S) {
		this.lost_11_30_S = lost_11_30_S;
	}

	public int getLost_31_60_S() {
		return lost_31_60_S;
	}

	public void setLost_31_60_S(int lost_31_60_S) {
		this.lost_31_60_S = lost_31_60_S;
	}

	public int getLost_1_3_M() {
		return lost_1_3_M;
	}

	public void setLost_1_3_M(int lost_1_3_M) {
		this.lost_1_3_M = lost_1_3_M;
	}

	public int getLost_3_10_M() {
		return lost_3_10_M;
	}

	public void setLost_3_10_M(int lost_3_10_M) {
		this.lost_3_10_M = lost_3_10_M;
	}

	public int getLost_10_30_M() {
		return lost_10_30_M;
	}

	public void setLost_10_30_M(int lost_10_30_M) {
		this.lost_10_30_M = lost_10_30_M;
	}

	public int getLost_30_60_M() {
		return lost_30_60_M;
	}

	public void setLost_30_60_M(int lost_30_60_M) {
		this.lost_30_60_M = lost_30_60_M;
	}

	public int getLost_60_M_UP() {
		return lost_60_M_UP;
	}

	public void setLost_60_M_UP(int lost_60_M_UP) {
		this.lost_60_M_UP = lost_60_M_UP;
	}

}