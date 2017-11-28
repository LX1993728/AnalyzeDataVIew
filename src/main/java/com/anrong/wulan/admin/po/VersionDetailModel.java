package com.anrong.wulan.admin.po;


public class VersionDetailModel{
	
	private String os;

	private int newUser;

	private int activeUser;

	private int startTime;

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

	public int getActiveUser() {
		return activeUser;
	}

	public void setActiveUser(int activeUser) {
		this.activeUser = activeUser;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	
}
