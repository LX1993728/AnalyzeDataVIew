package com.anrong.wulan.admin.service;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.ActiveUserOs;
import com.anrong.wulan.core.generic.GenericService;

public interface ActiveUserOsService extends GenericService<ActiveUserOs, Long> {


	List<ActiveUserOs> queryActiveUserTotal(Map<String, Object> params);
}
