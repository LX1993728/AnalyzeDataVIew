package com.anrong.wulan.admin.dao;

import java.util.List;
import java.util.Map;
import com.anrong.wulan.admin.po.RetentionUserHour;
import com.anrong.wulan.core.generic.GenericDao;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface RetentionDayMapper extends GenericDao<RetentionUserHour, Long> {

	List<RetentionUserHour> listRetent(Map<String, Object> params);

	List<RetentionUserHour> listAllAvg(Map<String, Object> params);

	List<RetentionUserHour> queryTop10Retention(Map<String, Object> params, PageBounds pageBounds);
}
