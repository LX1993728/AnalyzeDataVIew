package com.anrong.wulan.admin.dao;

import java.util.List;

import com.anrong.wulan.admin.po.UserApp;
import com.anrong.wulan.core.generic.GenericDao;

public interface UserAppMapper extends GenericDao<UserApp, Long> {

	/**
	 * 
	 * @param userId
	 * @param level
	 * @return
	 */
	List<UserApp> selectByUserId(Long userId);
	int insertSelective(UserApp userApp);
	int deleteByPrimaryKey(Long userAppId);
}