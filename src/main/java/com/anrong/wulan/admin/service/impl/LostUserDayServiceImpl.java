package com.anrong.wulan.admin.service.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.LostUserDayMapper;
import com.anrong.wulan.admin.po.LostUserDay;
import com.anrong.wulan.admin.service.LostUserDayService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;

@Service
public class LostUserDayServiceImpl extends GenericServiceImpl<LostUserDay, Long> implements LostUserDayService {
	@Resource
	private LostUserDayMapper lostUserDayMapper;

	@Override
	public GenericDao<LostUserDay, Long> getDao() {
		return lostUserDayMapper;
	}

	@Override
	public List<LostUserDay> selectLost(Map<String, Object> params) {
		return lostUserDayMapper.selectLost(params);
	}

}
