package com.anrong.wulan.admin.dao;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.SingleUser;
import com.anrong.wulan.core.generic.GenericDao;


public interface DisposableUserMapper extends GenericDao<SingleUser,Long> {
	
	
	List<SingleUser> selectSingleusers(Map<String, Object> params);
	
}
