package com.anrong.wulan.admin.dao;

import com.anrong.wulan.admin.po.RolePermission;
import com.anrong.wulan.core.generic.GenericDao;

public interface RolePermissionMapper extends GenericDao<RolePermission, Long>{
    int deleteByPrimaryKey(Long id);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    RolePermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);
    
    /**
     * 查询被关联次数
     * @param record
     * @return
     */
    int countBySelective(RolePermission record);
    
    /**
     * 按角色id删除
     * @param roleId
     * @return
     */
    int deleteByRoleId(Long roleId);
    
}