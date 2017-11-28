package com.anrong.wulan.admin.service;


import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.SingleUser;
import com.anrong.wulan.core.generic.GenericService;

public interface DisposableUserService extends GenericService<SingleUser, Long> {

	
	List<SingleUser> selectSingleusers(Map<String, Object> params) ;
}

