package com.anrong.wulan.admin.po;

import java.io.Serializable;

public class OperateSystemData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String operateSys1;

	private int newUser;

	private String newUserProportion;

	private int startTime;

	public String getOperateSys1() {
		return operateSys1;
	}

	public void setOperateSys1(String operateSys1) {
		this.operateSys1 = operateSys1;
	}

	public int getNewUser() {
		return newUser;
	}

	public void setNewUser(int newUser) {
		this.newUser = newUser;
	}

	public String getNewUserProportion() {
		return newUserProportion;
	}

	public void setNewUserProportion(String newUserProportion) {
		this.newUserProportion = newUserProportion;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	
	
}
