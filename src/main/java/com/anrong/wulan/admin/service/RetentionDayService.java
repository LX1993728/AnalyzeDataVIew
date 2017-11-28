package com.anrong.wulan.admin.service;

import java.util.List;
import java.util.Map;
import com.anrong.wulan.admin.po.RetentionUserHour;
import com.anrong.wulan.core.generic.GenericService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface RetentionDayService extends GenericService<RetentionUserHour, Long> {

	List<RetentionUserHour> listRetent(Map<String, Object> params);

	List<RetentionUserHour> listAllAvg(Map<String, Object> params);

	List<RetentionUserHour> queryTop10Retention(Map<String, Object> params, PageBounds pageBounds);
}
