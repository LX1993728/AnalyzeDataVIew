package com.anrong.wulan.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anrong.wulan.admin.dao.SYSPermissionMapper;
import com.anrong.wulan.admin.dao.SYSRoleMapper;
import com.anrong.wulan.admin.dao.SYSRole_MenuMapper;
import com.anrong.wulan.admin.dao.SYSRole_PermissionMapper;
import com.anrong.wulan.admin.dao.SYSRole_UserMapper;
import com.anrong.wulan.admin.po.SYSPermission;
import com.anrong.wulan.admin.po.SYSRole;
import com.anrong.wulan.admin.po.SYSRoleExample;
import com.anrong.wulan.admin.po.SYSRoleExample.Criteria;
import com.anrong.wulan.admin.po.SYSRole_Menu;
import com.anrong.wulan.admin.po.SYSRole_MenuExample;
import com.anrong.wulan.admin.po.SYSRole_Permission;
import com.anrong.wulan.admin.po.SYSRole_PermissionExample;
import com.anrong.wulan.admin.po.SYSRole_UserExample;
import com.anrong.wulan.admin.service.SYSRoleService;
import com.anrong.wulan.admin.vo.SYSRoleVO;
import com.anrong.wulan.core.util.Page;

@Service
@Transactional
public class SYSRoleServiceImpl implements SYSRoleService {
	@Autowired
	private SYSRoleMapper sysRoleMapper;

	@Autowired
	private SYSRole_MenuMapper sysRole_MenuMapper;

	@Autowired
	private SYSRole_PermissionMapper sysRole_PermissionMapper;

	@Autowired
	private SYSPermissionMapper sysPermissionMapper;

	@Autowired
	private SYSRole_UserMapper sysRole_UserMapper;

	@Override
	public List<SYSRole> findAllRoles() {
		SYSRoleExample example = new SYSRoleExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andNameIsNotNull();
		return sysRoleMapper.selectByExample(example);
	}

	@Override
	public Page<SYSRole> getRolesByCriteria(SYSRoleVO sysRoleVO) {
		// 当前要查询的下标位置
		Integer offset = (sysRoleVO.getP() - 1) * sysRoleVO.getPageSize();
		SYSRoleExample example = new SYSRoleExample();
		Criteria createCriteria = example.createCriteria();
		if (sysRoleVO.getName() != null && sysRoleVO.getName().trim().length() > 0) {
			createCriteria.andNameLike("%" + sysRoleVO.getName() + "%");
		}
		if (sysRoleVO.getCode() != null && sysRoleVO.getCode().trim().length() > 0) {
			createCriteria.andCodeLike("%" + sysRoleVO.getCode() + "%");
		}
		if (sysRoleVO.getDescription() != null && sysRoleVO.getDescription().trim().length() > 0) {
			createCriteria.andDescriptionLike("%" + sysRoleVO.getDescription() + "%");
		}
		// 查询符合条件记录的总条数
		int countByExample = sysRoleMapper.countByExample(example);
		// 查询符合条件的记录数据
		example.setCount(sysRoleVO.getPageSize());
		example.setLimitStart(offset);
		List<SYSRole> listRoles = sysRoleMapper.selectByExample(example);
		Page<SYSRole> page = new Page<>(sysRoleVO.getP(), sysRoleVO.getPageSize(), countByExample);
		page.setItems(listRoles);

		return page;
	}

	@Override
	public List<SYSPermission> getPermissionsOfRole(Integer id) {
		List<SYSPermission> sysPermissions = new ArrayList<>();
		SYSRole_PermissionExample example = new SYSRole_PermissionExample();
		example.createCriteria().andRoleidEqualTo(id);
		List<SYSRole_Permission> sysRole_Permissions = sysRole_PermissionMapper.selectByExample(example);
		for (SYSRole_Permission sysRole_Permission : sysRole_Permissions) {
			SYSPermission sysPermission = sysPermissionMapper.selectByPrimaryKey(sysRole_Permission.getPerid());
			sysPermissions.add(sysPermission);
		}
		return sysPermissions;
	}

	@Override
	public Boolean addRole(SYSRoleVO sysRoleVO) {
		int count1 = 0, count2 = 0, count3 = 0;
		// 1.首先增加一条角色数据
		SYSRole sysRole = new SYSRole();
		sysRole.setName(sysRoleVO.getName());
		sysRole.setCode(sysRoleVO.getCode());
		sysRole.setDescription(sysRoleVO.getDescription());
		count1 += sysRoleMapper.insertSelective(sysRole);

		// 2.将新增的角色和菜单进行绑定
		for (Integer menuId : sysRoleVO.getMenuIds()) {
			SYSRole_Menu sysRoleMenu = new SYSRole_Menu();
			sysRoleMenu.setMenuid(menuId);
			sysRoleMenu.setRoleid(sysRole.getId());
			count2 += sysRole_MenuMapper.insertSelective(sysRoleMenu);
		}
		// 3.将新增的角色和资源进行绑定
		for (Integer permId : sysRoleVO.getPermIds()) {
			SYSRole_Permission sysRolePerm = new SYSRole_Permission();
			sysRolePerm.setPerid(permId);
			sysRolePerm.setRoleid(sysRole.getId());
			count3 += sysRole_PermissionMapper.insertSelective(sysRolePerm);
		}
		Boolean b = (count1 == 1) && (count2 == sysRoleVO.getMenuIds().size())
				&& (count3 == sysRoleVO.getPermIds().size());
		return b;
	}

	@Override
	public SYSRole getRolesByPrimaryId(Integer id) {
		return sysRoleMapper.selectByPrimaryKey(id);
	}

	@Override
	public Boolean updateRole(SYSRoleVO sysRoleVO) {

		int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0;

		// 1.首先修改角色基本信息
		SYSRole sysRole = new SYSRole();
		sysRole.setId(sysRoleVO.getId());
		sysRole.setName(sysRoleVO.getName());
		sysRole.setCode(sysRoleVO.getCode());
		sysRole.setDescription(sysRoleVO.getDescription());
		count1 += sysRoleMapper.updateByPrimaryKeySelective(sysRole);

		// 2.查询该角色原先绑定的所有菜单，并全部解除绑定
		SYSRole_MenuExample sysRoleMenuExample = new SYSRole_MenuExample();
		sysRoleMenuExample.createCriteria().andRoleidEqualTo(sysRole.getId());
		List<SYSRole_Menu> sysRole_menus = sysRole_MenuMapper.selectByExample(sysRoleMenuExample);
		for (SYSRole_Menu sysRole_Menu : sysRole_menus) {
			count2 += sysRole_MenuMapper.deleteByPrimaryKey(sysRole_Menu.getId());
		}

		// 3.查询该角色原先绑定的所有权限资源，并全部解除绑定
		SYSRole_PermissionExample sysRolePermExample = new SYSRole_PermissionExample();
		sysRolePermExample.createCriteria().andRoleidEqualTo(sysRole.getId());
		List<SYSRole_Permission> sysRole_Perms = sysRole_PermissionMapper.selectByExample(sysRolePermExample);
		for (SYSRole_Permission sysRole_Permission : sysRole_Perms) {
			count3 += sysRole_PermissionMapper.deleteByPrimaryKey(sysRole_Permission.getId());
		}

		// 4.遍历新的菜单ID数组，重新绑定新的菜单
		for (Integer menuId : sysRoleVO.getMenuIds()) {
			SYSRole_Menu sysRoleMenu = new SYSRole_Menu();
			sysRoleMenu.setMenuid(menuId);
			sysRoleMenu.setRoleid(sysRole.getId());
			count4 += sysRole_MenuMapper.insertSelective(sysRoleMenu);
		}

		// 5.遍历新的权限资源的ID数组吧，重新绑定新的权限资源
		for (Integer permId : sysRoleVO.getPermIds()) {
			SYSRole_Permission sysRolePerm = new SYSRole_Permission();
			sysRolePerm.setPerid(permId);
			sysRolePerm.setRoleid(sysRole.getId());
			count5 += sysRole_PermissionMapper.insertSelective(sysRolePerm);
		}
		Boolean b = (count1 == 1) && (count2 == sysRole_menus.size()) && (count3 == sysRole_Perms.size())
				&& (count4 == sysRoleVO.getMenuIds().size()) && (count5 == sysRoleVO.getPermIds().size());
		return b;
	}

	@Override
	public Boolean deleteRole(Integer id) {
		int count1 = 0, count2 = 0, count3 = 0;
		// 0.首先判断该角色是否被用户绑定 如果绑定则

		// 1.先解除该角色和原先菜单的绑定
		SYSRole_MenuExample sysRoleMenuExample = new SYSRole_MenuExample();
		sysRoleMenuExample.createCriteria().andRoleidEqualTo(id);
		List<SYSRole_Menu> sysRole_menus = sysRole_MenuMapper.selectByExample(sysRoleMenuExample);
		for (SYSRole_Menu sysRole_Menu : sysRole_menus) {
			count1 += sysRole_MenuMapper.deleteByPrimaryKey(sysRole_Menu.getId());
		}

		// 2.解除该角色和原先资源权限的绑定
		SYSRole_PermissionExample sysRolePermExample = new SYSRole_PermissionExample();
		sysRolePermExample.createCriteria().andRoleidEqualTo(id);
		List<SYSRole_Permission> sysRole_Perms = sysRole_PermissionMapper.selectByExample(sysRolePermExample);
		for (SYSRole_Permission sysRole_Permission : sysRole_Perms) {
			count2 += sysRole_PermissionMapper.deleteByPrimaryKey(sysRole_Permission.getId());
		}

		// 3.删除该角色
		count3 += sysRoleMapper.deleteByPrimaryKey(id);

		Boolean flag = (count1 == sysRole_menus.size()) && (count2 == sysRole_Perms.size()) && (count3 == 1);

		return flag;
	}

	@Override
	public Boolean isBindUsers(Integer id) {
		SYSRole_UserExample example = new SYSRole_UserExample();
		example.createCriteria().andRoleidEqualTo(id);
		int count = sysRole_UserMapper.countByExample(example);
		return count == 0 ? false : true;
	}

}
