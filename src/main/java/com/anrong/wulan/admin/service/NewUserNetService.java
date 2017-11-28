package com.anrong.wulan.admin.service;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.NewUserNet;
import com.anrong.wulan.core.generic.GenericService;
import com.anrong.wulan.core.util.Page;

public interface NewUserNetService extends GenericService<NewUserNet, Long> {
	/**
	 * 联网方式echarts数据
	 * @param params
	 * @return
	 */
	List<NewUserNet> queryNetNewUser(Map<String, Object> params);
	/**
	 * 联网方式  table数据
	 * @param p
	 * @param params
	 * @return
	 */
	Page<NewUserNet> queryDetail(Integer p,Map<String, Object> params);
}
