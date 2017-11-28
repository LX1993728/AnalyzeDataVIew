package com.anrong.wulan.admin.dao;

import java.util.List;
import java.util.Map;
import com.anrong.wulan.admin.po.VisitUserHour;
import com.anrong.wulan.core.generic.GenericDao;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface ReturnVisitDayMapper extends GenericDao<VisitUserHour, Long> {

	List<VisitUserHour> listRetent(Map<String, Object> params);

	List<VisitUserHour> selectMounth(Map<String, Object> params, PageBounds pageBounds);

	List<VisitUserHour> queryTop10Retention(Map<String, Object> params, PageBounds pageBounds);
}
