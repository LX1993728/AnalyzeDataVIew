package com.anrong.wulan.admin.vo;

import java.io.Serializable;

public class EquipmentModelVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String vendor1;
	
	private String operateSys1;

	private int newUser;

	private String newUserProportion;

	private int startTime;

	private String hotModel;

	private String thirthFast;



	public String getVendor1() {
		return vendor1;
	}

	public void setVendor1(String vendor1) {
		this.vendor1 = vendor1;
	}

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

	public String getHotModel() {
		return hotModel;
	}

	public void setHotModel(String hotModel) {
		this.hotModel = hotModel;
	}

	public String getThirthFast() {
		return thirthFast;
	}

	public void setThirthFast(String thirthFast) {
		this.thirthFast = thirthFast;
	}

}
