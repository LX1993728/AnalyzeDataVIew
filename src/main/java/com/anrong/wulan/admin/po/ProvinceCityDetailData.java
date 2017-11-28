package com.anrong.wulan.admin.po;

import java.io.Serializable;

public class ProvinceCityDetailData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String region1;
	private int newUserTotal;
	private int acttiveUserTotal;
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

	public int getActtiveUserTotal() {
		return acttiveUserTotal;
	}

	public void setActtiveUserTotal(int acttiveUserTotal) {
		this.acttiveUserTotal = acttiveUserTotal;
	}

	public int getStartTimeTotal() {
		return startTimeTotal;
	}

	public void setStartTimeTotal(int startTimeTotal) {
		this.startTimeTotal = startTimeTotal;
	}

}
