package com.anrong.wulan.admin.service.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.anrong.wulan.admin.dao.DurationHourMapper;
import com.anrong.wulan.admin.po.DurationHour;
import com.anrong.wulan.admin.service.DurationHourService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;
import com.anrong.wulan.core.util.Page;

@Service
public class DurationHourServiceImpl extends
		GenericServiceImpl<DurationHour, Long> implements DurationHourService {

	@Resource
	private DurationHourMapper durationHourMapper;

	@Override
	public GenericDao<DurationHour, Long> getDao() {
		return durationHourMapper;
	}

	@Override
	public List<DurationHour> selectRecordMonth(Map<String, Object> params) {
		return durationHourMapper.selectRecordMonth(params);
	}

	@Override
	public List<DurationHour> queryAvgSingleUseTime(Map<String, Object> map) {
		return durationHourMapper.queryDurationHourCount(map);
	}

	@Override
	public DurationHour queryDurationHour(Map<String, Object> params) {
		return durationHourMapper.queryDurationHour(params);
	}


	@Override
	public Page<DurationHour> queryDurationHourCount(Integer p,
			Map<String, Object> params) {
		int totalsize = durationHourMapper.queryDurationHourCount(params).size();
		 Page<DurationHour> page = new Page<>(p,6,totalsize);
		 params.put("size",6);
		 params.put("start",page.getStart());
		 
		 List<DurationHour> list = durationHourMapper.queryAvgSingleUseTime(params);
	        page.setItems(list);
		return page;
	}

}
