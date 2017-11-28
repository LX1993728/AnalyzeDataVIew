package com.anrong.wulan.admin.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anrong.wulan.admin.dao.PermissionMapper;
import com.anrong.wulan.admin.dao.PermissionMenuMapper;
import com.anrong.wulan.admin.po.Permission;
import com.anrong.wulan.admin.po.PermissionMenu;
import com.anrong.wulan.admin.service.PermissionService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

/**
 * 权限Service实现类
 *
 */
@Service
public class PermissionServiceImpl extends GenericServiceImpl<Permission, Long> implements PermissionService {

    @Resource
    private PermissionMapper permissionMapper;
    @Resource
    private PermissionMenuMapper permissionMenuMapper;


    @Override
    public GenericDao<Permission, Long> getDao() {
        return permissionMapper;
    }

    @Override
    public List<Permission> selectPermissionsByRoleId(Long roleId) {
        return permissionMapper.selectPermissionsByRoleId(roleId);
    }

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List selectPage(Map<String, Object> param,PageBounds page) {
		return permissionMapper.selectPage(param, page);
	}

	@Override
	public Permission selectByPermissionSign(String permissionSign) {
		return permissionMapper.selectByPermissionSign(permissionSign);
	}

	@Override
	public List<Permission> selectAll() {
		return permissionMapper.selectAll();
	}

	@Override
	@Transactional
	public boolean insert(Permission permission, List<Long> menuIds) {
		int i =insert(permission);
		if(i!=1){
			return false;
		}
		if(menuIds !=null){
			for(Long menuId:menuIds){
				PermissionMenu pm = new PermissionMenu();
				pm.setPermissionId(permission.getId());
				pm.setMenuId(menuId);
				permissionMenuMapper.insertSelective(pm);
			}			
		}
		return true;
	}

	@Transactional
	@Override
	@CacheEvict(value="menuCache",allEntries=true)
	public boolean update(Permission permission, List<Long> menuIds) {
		
		int i =this.update(permission);
		if(i!=1){
			return false;
		}
		permissionMenuMapper.deleteByPermissionId(permission.getId());
		if(menuIds !=null){
			for(Long menuId:menuIds){
				PermissionMenu pm = new PermissionMenu();
				pm.setPermissionId(permission.getId());
				pm.setMenuId(menuId);
				permissionMenuMapper.insertSelective(pm);
			}			
		}
		return true;
	}
	
	@Transactional
	@Override
	public int delete(Long id) { 
		permissionMenuMapper.deleteByPermissionId(id);
		return super.delete(id);
	}
	
}
