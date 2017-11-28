package com.anrong.wulan.admin.dao;

import com.anrong.wulan.admin.po.PermissionMenu;
import com.anrong.wulan.core.generic.GenericDao;

public interface PermissionMenuMapper extends GenericDao<PermissionMenu,Long>{
    int deleteByPrimaryKey(Long id);

    int insert(PermissionMenu record);

    int insertSelective(PermissionMenu record);

    PermissionMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PermissionMenu record);

    int updateByPrimaryKey(PermissionMenu record);
    
    /**
     * 查询被关联次数
     * @param record
     * @return
     */
    int countBySelective(PermissionMenu record);
    
    /**
     * 按权限id删除
     * @param permissionId
     * @return
     */
    int deleteByPermissionId(Long permissionId);
}