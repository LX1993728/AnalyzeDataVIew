package com.anrong.wulan.admin.service;

import java.util.List;
import java.util.Map;
import com.anrong.wulan.admin.po.TimeDetailData;
import com.anrong.wulan.core.generic.GenericService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface TimeDetailDataService extends GenericService<TimeDetailData, Long> {
	List<TimeDetailData> getTimeDetailData(Map<String, Object> params,PageBounds pageBounds);
}
