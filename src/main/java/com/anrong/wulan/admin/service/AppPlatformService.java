package com.anrong.wulan.admin.service;

import java.util.List;

import com.anrong.wulan.admin.po.AppPlatform;
import com.anrong.wulan.core.generic.GenericService;

public interface AppPlatformService extends GenericService<AppPlatform, Long> {

	List<AppPlatform> getAppPlatform(String appKey);

}
