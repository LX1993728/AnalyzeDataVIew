package com.anrong.wulan.admin.po;

public class NewStartDetailData {

	private String date;
	private int newUserCount;
	private int activeUser;
	private double avgUserTime;
	private int startCount;
	private int totalUserCount;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getNewUserCount() {
		return newUserCount;
	}

	public void setNewUserCount(int newUserCount) {
		this.newUserCount = newUserCount;
	}

	public int getActiveUser() {
		return activeUser;
	}

	public void setActiveUser(int activeUser) {
		this.activeUser = activeUser;
	}

	public int getTotalUserCount() {
		return totalUserCount;
	}

	public void setTotalUserCount(int totalUserCount) {
		this.totalUserCount = totalUserCount;
	}

	public double getAvgUserTime() {
		return avgUserTime;
	}

	public void setAvgUserTime(double avgUserTime) {
		this.avgUserTime = avgUserTime;
	}

	public int getStartCount() {
		return startCount;
	}

	public void setStartCount(int startCount) {
		this.startCount = startCount;
	}
}
