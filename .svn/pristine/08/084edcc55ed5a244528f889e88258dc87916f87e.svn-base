package com.anrong.wulan.admin.service;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.Role;
import com.anrong.wulan.core.generic.GenericService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

/**
 * 角色 业务接口
 * 
 **/
public interface RoleService extends GenericService<Role, Long> {
    /**
     * 通过用户id 查询用户 拥有的角色
     * 
     * @param userId
     * @return
     */
    List<Role> selectRolesByUserId(Long userId);
    
    /**
     * 分页查询
     * @param param
     * @param page
     * @return
     */
    @SuppressWarnings("rawtypes")
	List selectPage(Map<String,Object> param,PageBounds page);
    
    /**
     * 根据角色标识查询
     * @param roleSign
     * @return
     */
    Role selectByRoleSign(String roleSign);
    
    /**
     * 插入角色
     * @param role
     * @param permissionIds
     * @return
     */
    boolean insert(Role role,List<Long> permissionIds);
    
    /**
     * 更新角色
     * @param role
     * @param permissionIds
     * @return
     */
    boolean update(Role role,List<Long> permissionIds);
    
    /**
     * 所有角色
     * @return
     */
    List<Role> selectAll();
}
