package com.anrong.wulan.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.anrong.wulan.admin.po.User;
import com.anrong.wulan.core.generic.GenericDao;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface UserMapper extends GenericDao<User, Long>{
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    /**
     * 用户登录验证查询
     * 
     * @param record
     * @return
     */
    User authentication(@Param("record") User record);
    
    /**
     * 分页条件查询
     * 
     * @param page
     * @param example
     * @return
     */
    @SuppressWarnings("rawtypes")
	List selectPage(Map<String,Object> map, PageBounds pageBounds);
}