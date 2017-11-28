package com.anrong.wulan.admin.vo;

import java.io.Serializable;
/**
 * 保存用户的身份权限信息
 * @author liuxun
 *
 */
import java.util.List;

import com.anrong.wulan.admin.po.Permission;
import com.anrong.wulan.admin.po.SYSMenu;
import com.anrong.wulan.admin.po.SYSPermission;

public class ActiveUserVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private int userId; // 用户ID
	private String username; // 用户姓名

	private List<SYSMenuVO> menus; // 菜单
	private List<SYSPermission> permissions; // 权限(资源)

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<SYSMenuVO> getMenus() {
		return menus;
	}

	public void setMenus(List<SYSMenuVO> menus) {
		this.menus = menus;
	}

	public List<SYSPermission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<SYSPermission> permissions) {
		this.permissions = permissions;
	}

	@Override
	public String toString() {
		return this.getUsername();
	}
	

}
