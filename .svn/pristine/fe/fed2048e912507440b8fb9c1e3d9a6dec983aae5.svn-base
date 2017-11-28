package com.anrong.wulan.admin.dao;

import java.util.List;

import com.anrong.wulan.admin.po.SYSMenu;
import com.anrong.wulan.admin.po.SYSPermission;
/**
 * 根据用户ID查询菜单和权限
 * @author liuxun
 *
 */
public interface SYSPermissionAndMenuMapperCustom {
	// 根据用户id查询菜单
	public List<SYSMenu> findMenuListByUserId(int userid) throws Exception;

	// 根据用户id查询权限URL
	public List<SYSPermission> findPermissionListByUserId(int userid) throws Exception;
     
	// 根据用户id 查询所有的一级菜单
	public List<SYSMenu> findLevelOneMenusByUserid(int userid);
	
	 // 根据用户id和一级菜单的ID查询它所有的子菜单
	public List<SYSMenu> findLevelTwoMenusbyUserIdAndParentId(int userid,int parentId);
	
}
