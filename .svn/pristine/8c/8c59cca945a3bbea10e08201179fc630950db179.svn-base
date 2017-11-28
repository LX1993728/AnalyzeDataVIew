package com.anrong.wulan.admin.vo;

import java.io.Serializable;
import java.util.List;

import com.anrong.wulan.admin.po.SYSMenu;

/**
 * 封装二级菜单
 * 
 * @author liuxun
 *
 */
public class SYSMenuVO extends SYSMenu implements Serializable {

	private static final long serialVersionUID = 1L;
	// 封装列表显示字段
	private String pname; // 所属父菜单的名称
	private String level; // 显示菜单级别

	// 封装分页相关的字段(表单字段)
	private Integer p = 1; // 默认值设置为1 用来封装传入mapper的页码
	private Integer offset = 0; // 默认设置为0
	private Integer pageSize = 10; // 每页数量，默认设置为10

	// 封装菜单结果组件
	private List<SYSMenu> childMenus = null;

	public List<SYSMenu> getChildMenus() {
		return childMenus;
	}

	public void setChildMenus(List<SYSMenu> childMenus) {
		this.childMenus = childMenus;
	}

	public void copyMenuProperty(SYSMenu sysMenu) {
		this.setId(sysMenu.getId());
		this.setName(sysMenu.getName());
		this.setPid(sysMenu.getPid());
		this.setUrl(sysMenu.getUrl());
		this.setIconstyle(sysMenu.getIconstyle());
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
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

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	
}
