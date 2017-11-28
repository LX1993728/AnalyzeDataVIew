package com.anrong.wulan.admin.dao;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.ModelInvoke;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.util.Page;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface ModelInvokeMapper extends GenericDao<ModelInvoke, Long> {

	List<ModelInvoke> queryTop10ModelASC(Map<String, Object> params);

	List<ModelInvoke> selectRecordASC(Map<String, Object> params);

	List<ModelInvoke> queryTop10ModelDetail(Map<String, Object> params,
			PageBounds pageBounds);

	List<ModelInvoke> selectRecordByCustom(Map<String, Object> params);

	List<ModelInvoke> queryTop10ModelDetailByCustom(Map<String, Object> params,
			PageBounds pageBounds);
	
	List<ModelInvoke> selectRecord(Map<String, Object> params);
	//模块echars TOP
	List<ModelInvoke> selectRecordTop(Map<String, Object> params);
	
	//模块echars under
	List<ModelInvoke> selectRecordUnder(Map<String, Object> params);
	
	//模块统计查询所有
	List<ModelInvoke> queryDetail(Map<String, Object> params);
	//模块统计查询总数
	List<ModelInvoke> queryCount(Map<String, Object> params);
	//首页
	List<ModelInvoke> queryTop10Model(Map<String, Object> params);
	Page<ModelInvoke> queryUserDetailCount(Integer p,Map<String, Object> params);


}
