package com.anrong.wulan.admin.service;

import java.util.List;

import com.anrong.wulan.admin.po.SYSPermission;
import com.anrong.wulan.admin.vo.SYSPermissionVO;
import com.anrong.wulan.core.util.Page;

public interface SYSPermissionService {
	// 获取权限列表
	public List<SYSPermission> findAllPerms();

	// 根据查询条件 分页返回权限数据
	public Page<SYSPermission> getPermsByCriteria(SYSPermissionVO sysPermissionVO);

	// 添加资源
	public SYSPermission getPermissionByPrimaryKey(Integer id);

	// 获取所有的编码名称 用于校验
	public List<String> getAllCodes();

	// 更新一个系统资源
	public Boolean updatePermission(SYSPermissionVO sysPermissionVO);

	// 添加一个系统资源
	public Boolean addPermission(SYSPermissionVO sysPermissionVO);

	// 判断该资源是否已被角色绑定
	public boolean isBindRoles(Integer id);

	// 删除该资源
	public boolean deletePermission(Integer id);
}
