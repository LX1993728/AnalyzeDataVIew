package com.anrong.wulan.admin.vo;

import java.io.Serializable;

public class ChartVo implements Serializable {
	private String rowObj;
	private String columnObj;
	public String getRowObj() {
		return rowObj;
	}
	public void setRowObj(String rowObj) {
		this.rowObj = rowObj;
	}
	public String getColumnObj() {
		return columnObj;
	}
	public void setColumnObj(String columnObj) {
		this.columnObj = columnObj;
	}
	
}
