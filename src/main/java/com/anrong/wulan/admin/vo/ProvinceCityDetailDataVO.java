package com.anrong.wulan.admin.vo;

import java.io.Serializable;

public class ProvinceCityDetailDataVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String region1;
	private int newUserTotal;
	private double newUserProportion;
	private int acttiveUserTotal;
	private double activeUserProportion;
	private int startTimeTotal;
	public String getRegion1() {
		return region1;
	}
	public void setRegion1(String region1) {
		this.region1 = region1;
	}
	public int getNewUserTotal() {
		return newUserTotal;
	}
	public void setNewUserTotal(int newUserTotal) {
		this.newUserTotal = newUserTotal;
	}
	public double getNewUserProportion() {
		return newUserProportion;
	}
	public void setNewUserProportion(double newUserProportion) {
		this.newUserProportion = newUserProportion;
	}
	public int getActtiveUserTotal() {
		return acttiveUserTotal;
	}
	public void setActtiveUserTotal(int acttiveUserTotal) {
		this.acttiveUserTotal = acttiveUserTotal;
	}
	public double getActiveUserProportion() {
		return activeUserProportion;
	}
	public void setActiveUserProportion(double activeUserProportion) {
		this.activeUserProportion = activeUserProportion;
	}
	public int getStartTimeTotal() {
		return startTimeTotal;
	}
	public void setStartTimeTotal(int startTimeTotal) {
		this.startTimeTotal = startTimeTotal;
	}
	
	

}
