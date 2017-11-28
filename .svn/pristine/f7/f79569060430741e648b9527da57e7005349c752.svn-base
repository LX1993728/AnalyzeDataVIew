package com.anrong.wulan.admin.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.anrong.wulan.admin.po.User;

/**
 * 系统用户包装类——用来封装包含别的信息的用户 (充当查询VO，结果VO，传入参数的VO)
 * 
 * @author liuxun
 *
 */
public class SYSUserVO extends User implements Serializable {
	private static final long serialVersionUID = 1L;
	// 封装查询的字段
	private Integer roleId; // 用来封装查询的字段

	// 封装传入mapper的参数
	private Integer p = 1; // 默认值设置为1 用来封装传入mapper的页码
	private Integer offset = 0; // 默认设置为0
	private Integer pageSize = 10; // 每页数量，默认设置为10

	// 用来封装表单的数据
	private List<Integer> roleIds = null;
	private List<Integer> appIds = null;

	public List<Integer> getAppIds() {
		return this.appIds == null? (this.appIds=new ArrayList<>()):this.appIds;
	}

	public void setAppIds(List<Integer> appIds) {
		this.appIds = appIds;
	}

	public List<Integer> getRoleIds() {
		return this.roleIds == null? (this.roleIds=new ArrayList<>()):this.roleIds;
	}

	public void setRoleIds(List<Integer> roleIds) {
		this.roleIds = roleIds;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

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
	
	public void setUserProperty(User user) {
		super.setId(user.getId());
		super.setState(user.getState());
		super.setUsername(user.getUsername());
		super.setCreateTime(user.getCreateTime());
	}

}
