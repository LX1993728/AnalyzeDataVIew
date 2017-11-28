package com.anrong.wulan.admin.service;

import java.util.List;
import com.anrong.wulan.admin.po.UserApp;
import com.anrong.wulan.core.generic.GenericService;

public interface UserAppService extends GenericService<UserApp, Long> {
	/**
	 * 根据用户查询appInfoId
	 * 
	 * @param userId
	 * @return
	 */
	List<UserApp> selectByUserId(Long userId);
}
