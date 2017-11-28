package com.anrong.wulan.admin.dao;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.Role;
import com.anrong.wulan.core.generic.GenericDao;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface RoleMapper extends GenericDao<Role, Long> {
    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    /**
     * 通过用户id 查询用户 拥有的角色
     * 
     * @param id
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
     * 根据标识查询
     * @param record
     * @return
     */
    Role selectByRoleSign(String roleSign);
    
    /**
     * 查询全部
     * @return
     */
    List<Role> selectAll();
}