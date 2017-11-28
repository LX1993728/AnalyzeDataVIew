package com.anrong.wulan.admin.service;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.ModelInvoke;
import com.anrong.wulan.core.generic.GenericService;
import com.anrong.wulan.core.util.Page;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface ModelInvokeService extends GenericService<ModelInvoke, Long> {

	List<ModelInvoke> queryTop10Model(Map<String, Object> params);
	
	List<ModelInvoke> queryTop10ModelASC(Map<String, Object> params);

	List<ModelInvoke> selectRecord(Map<String, Object> params);
	
	List<ModelInvoke> selectRecordUnder(Map<String, Object> params);
	
	List<ModelInvoke> selectRecordASC(Map<String, Object> params);

	List<ModelInvoke> queryTop10ModelDetail(Map<String, Object> params,
			PageBounds pageBounds);

	List<ModelInvoke> selectRecordByCustom(Map<String, Object> params);

	List<ModelInvoke> queryTop10ModelDetailByCustom(Map<String, Object> params,
			PageBounds pageBounds);

	Page<ModelInvoke> queryDetail(Integer p,Map<String, Object> params);

}
