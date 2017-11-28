package com.anrong.wulan.admin.dao;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.NewUserNet;
import com.anrong.wulan.core.generic.GenericDao;

public interface NewUserNetMapper extends GenericDao<NewUserNet, Long> {

	//查询echarts
	List<NewUserNet> queryNetNewUser(Map<String, Object> params);

	//联网方式查询分页
	List<NewUserNet> queryDetail(Map<String, Object> params);
	//联网方式查询总数
	List<NewUserNet> queryCount(Map<String, Object> params);

}
