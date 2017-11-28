package com.anrong.wulan.admin.vo;

import java.util.ArrayList;
import java.util.List;

import com.anrong.wulan.admin.po.SYSRole;

/**
 * 封装与角色相关的信息
 * 
 * @author liuxun
 *
 */
public class SYSRoleVO extends SYSRole {

	// 用来封装分页设置数据
	private Integer p = 1; // 默认值设置为1 用来封装页码
	private Integer offset = 0; // 默认设置为0
	private Integer pageSize = 10; // 每页数量，默认设置为10

	// 用来封装表单的数据
	private List<Integer> menuIds = null;
	private List<Integer> permIds = null;

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

	public List<Integer> getMenuIds() {
		return this.menuIds == null? (this.menuIds=new ArrayList<>()):this.menuIds;
	}

	public void setMenuIds(List<Integer> menuIds) {
		this.menuIds = menuIds;
	}

	public List<Integer> getPermIds() {
		return this.permIds == null? (this.permIds=new ArrayList<>()):this.permIds;
	}

	public void setPermIds(List<Integer> permIds) {
		this.permIds = permIds;
	}

}
