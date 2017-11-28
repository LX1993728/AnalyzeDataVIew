package com.anrong.wulan.admin.service;

import java.util.List;

import com.anrong.wulan.admin.po.SYSMenu;
import com.anrong.wulan.admin.vo.SYSMenuVO;
import com.anrong.wulan.core.util.Page;
/**
 * 菜单业务逻辑定义
 * @author liuxun
 *
 */
public interface SYSMenuService {
   // 获取菜单列表
	public List<SYSMenu> findAllMenus();

	//获取某角色下的菜单列表
	public List<SYSMenu> findMenusByRoleId(Integer id);

	// 根据条件查询菜单（分页返回）
	public Page<SYSMenuVO> getMenusByCriteria(SYSMenuVO sysMenuVO);

	// 查询系统菜单和所有的一级菜单
	public List<SYSMenu> getLevalOneMenus();

	// 根据主键获取具体菜单信息
	public SYSMenu getMenuByPrimaryKey(Integer id);

	// 获取所有的菜单名称 用于校验
	public List<String> getAllMenuNames();

	// 添加菜单
	public Boolean addMenu(SYSMenuVO sysMenuVO);

	// 修改菜单
	public Boolean updateMenu(SYSMenuVO sysMenuVO);

	// 查看某菜单是否已被角色绑定
	public boolean isBindRoles(Integer id);

	// 查看某菜单下是否有子菜单
	public boolean isHasChildMenus(Integer id);

	// 删除菜单
	public boolean deleteMenu(Integer id);

	
}
