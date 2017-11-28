package com.anrong.wulan.admin.service;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.StaticUser;
import com.anrong.wulan.core.generic.GenericService;

public interface UserPortraitService extends
GenericService<StaticUser, Long> {

	List<StaticUser> queryUserPortrait(Map<String, Object> params);
}
