package com.anrong.wulan.admin.service;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.Permission;
import com.anrong.wulan.core.generic.GenericService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

/**
 * 权限 业务接口
 * 
 **/
public interface PermissionService extends GenericService<Permission, Long> {

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
    List<Permission> selectPage(Map<String,Object> param,PageBounds page);
    
    /**
     * 根据权限标识查询
     * @param permissionSign
     * @return
     */
    Permission selectByPermissionSign(String permissionSign);
    
    
    /**
     * 获得所有的权限
     * @return
     */
    List<Permission> selectAll();
    
    /**
     * 插入权限及菜单id
     * @param permission
     * @param menuIds
     * @return
     */
    boolean insert(Permission permission,List<Long> menuIds);
    
    /**
     * 更新
     * @param permission
     * @param menuIds
     * @return
     */
    boolean update(Permission permission,List<Long> menuIds);

}
