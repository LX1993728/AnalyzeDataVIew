package com.anrong.wulan.admin.service.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.anrong.wulan.admin.dao.RetentionDayMapper;
import com.anrong.wulan.admin.po.RetentionUserHour;
import com.anrong.wulan.admin.service.RetentionDayService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

@Service
public class RetentionDayServiceImpl extends GenericServiceImpl<RetentionUserHour, Long>
		implements RetentionDayService {
	@Resource
	private RetentionDayMapper retentionDayMapper;

	@Override
	public GenericDao<RetentionUserHour, Long> getDao() {
		return retentionDayMapper;
	}

	@Override
	public List<RetentionUserHour> listRetent(Map<String, Object> params) {
		return retentionDayMapper.listRetent(params);
	}

	@Override
	public List<RetentionUserHour> listAllAvg(Map<String, Object> params) {
		return retentionDayMapper.listAllAvg(params);
	}

	@Override
	public List<RetentionUserHour> queryTop10Retention(Map<String, Object> params, PageBounds pageBounds) {
		return retentionDayMapper.queryTop10Retention(params, pageBounds);
	}

}
