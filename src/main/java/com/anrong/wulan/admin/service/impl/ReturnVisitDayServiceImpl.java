package com.anrong.wulan.admin.service.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.anrong.wulan.admin.dao.ReturnVisitDayMapper;
import com.anrong.wulan.admin.po.VisitUserHour;
import com.anrong.wulan.admin.service.ReturnVisitDayService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

@Service
public class ReturnVisitDayServiceImpl extends GenericServiceImpl<VisitUserHour, Long>
		implements ReturnVisitDayService {
	@Resource
	private ReturnVisitDayMapper returnVisitDayMapper;

	@Override
	public GenericDao<VisitUserHour, Long> getDao() {
		return returnVisitDayMapper;
	}

	@Override
	public List<VisitUserHour> listRetent(Map<String, Object> params) {
		return returnVisitDayMapper.listRetent(params);
	}

	@Override
	public List<VisitUserHour> selectMounth(Map<String, Object> params, PageBounds pageBounds) {
		return returnVisitDayMapper.selectMounth(params, pageBounds);
	}

	@Override
	public List<VisitUserHour> queryTop10Retention(Map<String, Object> params, PageBounds pageBounds) {
		return returnVisitDayMapper.queryTop10Retention(params, pageBounds);
	}

}
