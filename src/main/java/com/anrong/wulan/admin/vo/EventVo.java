package com.anrong.wulan.admin.vo;

import java.io.Serializable;

public class EventVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String modelName;

	private int statisticsInvokeNum;

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public int getStatisticsInvokeNum() {
		return statisticsInvokeNum;
	}

	public void setStatisticsInvokeNum(int statisticsInvokeNum) {
		this.statisticsInvokeNum = statisticsInvokeNum;
	}

}
