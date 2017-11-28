package com.anrong.wulan.admin.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anrong.wulan.admin.dao.RoleMapper;
import com.anrong.wulan.admin.dao.RolePermissionMapper;
import com.anrong.wulan.admin.po.Role;
import com.anrong.wulan.admin.po.RolePermission;
import com.anrong.wulan.admin.service.RoleService;
import com.anrong.wulan.core.entity.UserException;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

/**
 * 角色Service实现类
 *
 */
@Service
public class RoleServiceImpl extends GenericServiceImpl<Role, Long> implements RoleService {

    @Resource
    private RoleMapper roleMapper;
    @Resource
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public GenericDao<Role, Long> getDao() {
        return roleMapper;
    }

    @Override
    public List<Role> selectRolesByUserId(Long userId) {
        return roleMapper.selectRolesByUserId(userId);
    }

	@SuppressWarnings("rawtypes")
	@Override
	public List selectPage(Map<String, Object> param, PageBounds page) {		 
		return roleMapper.selectPage(param,page);
	}
	
	/**
	 * 删除角色时同时将角色与权限的关联关系表也删除
	 * 
	 */
	@Transactional
	@Override
	public int delete(Long id) {
		//同时将role_permission
		rolePermissionMapper.deleteByRoleId(id);
		return super.delete(id);
	}

	@Override
	public Role selectByRoleSign(String roleSign) {
		return roleMapper.selectByRoleSign(roleSign);
	}
	
	@Transactional
	@Override
	public boolean insert(Role role, List<Long> permissionIds) {
		 int i= this.insert(role);
		 if(i!=1){
			 return false;
		 }
		 Long roleId = role.getId();
		 for(Long permissionId : permissionIds){
			 RolePermission rolePermission = new RolePermission();
			 rolePermission.setPermissionId(permissionId);
			 rolePermission.setRoleId(roleId);
			 rolePermissionMapper.insert(rolePermission);
		 }
		return true;
	}

	@Transactional
	@Override
	public boolean update(Role role, List<Long> permissionIds) {
		int i = this.update(role);
		if(i!=1){
			throw new UserException("更新角色失败");
		}
		 Long roleId = role.getId();
		rolePermissionMapper.deleteByRoleId(roleId);
		for(Long permissionId : permissionIds){
			 RolePermission rolePermission = new RolePermission();
			 rolePermission.setPermissionId(permissionId);
			 rolePermission.setRoleId(roleId);
			 rolePermissionMapper.insert(rolePermission);
		 }
		return true;
	}

	@Override
	public List<Role> selectAll() {
		return roleMapper.selectAll();
	}

}
