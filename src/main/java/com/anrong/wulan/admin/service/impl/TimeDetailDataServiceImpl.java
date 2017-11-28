package com.anrong.wulan.admin.service.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.anrong.wulan.admin.dao.TimeDetailDataMapper;
import com.anrong.wulan.admin.po.TimeDetailData;
import com.anrong.wulan.admin.service.TimeDetailDataService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
@Service
public class TimeDetailDataServiceImpl extends GenericServiceImpl<TimeDetailData, Long>
		implements TimeDetailDataService {

    @Resource
    private TimeDetailDataMapper timeDetailDataMapper;
   

	@Override
	public GenericDao<TimeDetailData, Long> getDao() {
		return null;
	}


	@Override
	public List<TimeDetailData> getTimeDetailData(Map<String, Object> params,
			PageBounds pageBounds) {
		return timeDetailDataMapper.getTimeDetailData(params, pageBounds);
	}


}
