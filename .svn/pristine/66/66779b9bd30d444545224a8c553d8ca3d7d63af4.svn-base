package com.anrong.wulan.admin.dao;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.Permission;
import com.anrong.wulan.core.generic.GenericDao;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface PermissionMapper extends GenericDao<Permission, Long> {
    int deleteByPrimaryKey(Long id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
    
    /**
     * 通过角色id 查询角色 拥有的权限
     * 
     * @param roleId
     * @return
     */
    List<Permission> selectPermissionsByRoleId(Long roleId);
    
    /**
     * 分页查询
     * @param param
     * @param page
     * @return
     */
    @SuppressWarnings("rawtypes")
	List selectPage(Map<String,Object> param,PageBounds page);
    
    /**
     * 根据标识查询
     * @param record
     * @return
     */
    Permission selectByPermissionSign(String permissionSign);
    
    /**
     * 查询所有的permission
     * @return
     */
    List<Permission> selectAll();
}