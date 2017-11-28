package com.anrong.wulan.admin.dao;

import com.anrong.wulan.admin.po.UserRole;
import com.anrong.wulan.core.generic.GenericDao;

public interface UserRoleMapper extends GenericDao<UserRole, Long>{
    int deleteByPrimaryKey(Long id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
    
    /**
     * 查询被关联次数
     * @param record
     * @return
     */
    int countBySelective(UserRole record);
    
    /**
     * 根据userId查询
     * @param userId
     * @return
     */
    int deleteByUserId(Long userId);
    
}