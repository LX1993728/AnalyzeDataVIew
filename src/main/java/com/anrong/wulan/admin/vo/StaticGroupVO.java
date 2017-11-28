package com.anrong.wulan.admin.vo;

import com.anrong.wulan.admin.po.StaticGroup;

public class StaticGroupVO extends StaticGroup{
    // 用来封装分页设置数据
    private Integer p = 1; // 默认值设置为1 用来封装页码
    private Integer offset = 0; // 默认设置为0
    private Integer pageSize = 10; // 每页数量，默认设置为10

    //用户属性
    private String property;
    // 搜索时间范围
    private String startDate;
    private String endDate;
    //详情
    private String details;
    public Integer getP() {
        return p;
    }

    public void setP(Integer p) {
        this.p = p;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
