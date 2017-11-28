package com.anrong.wulan.admin.vo;

import com.anrong.wulan.admin.po.SYSPermission;

/**
 * 封装与资源相关的信息
 * 
 * @author liuxun
 *
 */
public class SYSPermissionVO extends SYSPermission {
	// 封装分页相关的字段(表单字段)
	private Integer p = 1; // 默认值设置为1 用来封装传入mapper的页码
	private Integer offset = 0; // 默认设置为0
	private Integer pageSize = 10; // 每页数量，默认设置为10

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

}
