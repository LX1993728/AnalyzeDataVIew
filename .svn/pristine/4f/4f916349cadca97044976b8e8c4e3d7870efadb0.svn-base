package com.anrong.wulan.admin.service;

import java.util.List;

import com.anrong.wulan.admin.po.SYSMenu;
import com.anrong.wulan.admin.po.SYSPermission;
import com.anrong.wulan.admin.vo.SYSMenuVO;

/**
 * 用户认证授权服务接口
 * 
 * @author liuxun
 *
 */
public interface SYSService {
	// 根据用户id查询菜单
	public List<SYSMenu> findMenuListByUserId(int userid) throws Exception;

	// 根据用户id查询权限
	public List<SYSPermission> findPermissionListByUserId(int userid) throws Exception;

	// 根据用户ID查询具有的所有一级菜单
	public List<SYSMenuVO> findLevelOneMenusByUserId(int userid);

	// 强制清除指定用户的Session(需要在修改用户信息以及角色绑定后 强制用户重新登录)
	public void clearUserShiroSessionByUserName(String username);
	
	// 强制清除所有用户的Session (在涉及角色、权限、菜单的修改和新增时需要强制所有用户(自己除外)重新登录)
	public void clearAllUserShiroSessions();
}
