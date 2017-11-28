package com.anrong.wulan.admin.service;

import java.util.Map;

import com.anrong.wulan.admin.po.UserDaysLost;
import com.anrong.wulan.core.generic.GenericService;

public interface UserDaysLostService extends GenericService<UserDaysLost, Long> {

	UserDaysLost selectDay(Map<String, Object> params);

}
