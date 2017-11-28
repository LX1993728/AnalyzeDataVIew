package com.anrong.wulan.admin.service;

import java.util.Map;
import com.anrong.wulan.admin.po.RetentionLostBackUser;
import com.anrong.wulan.core.generic.GenericService;
import com.anrong.wulan.core.util.Page;

public interface RetentionLostBackUserService extends
GenericService<RetentionLostBackUser, Long> {
	Page<RetentionLostBackUser> queryUserDetailCount(Integer p,Map<String, Object> params);
}
