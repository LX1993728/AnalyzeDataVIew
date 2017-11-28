package com.anrong.wulan.admin.service.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.BackUserDayMapper;
import com.anrong.wulan.admin.po.BackUserDay;
import com.anrong.wulan.admin.service.BackUserDayService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;

@Service
public class BackUserDayServiceImpl extends GenericServiceImpl<BackUserDay, Long> implements BackUserDayService {
	@Resource
	private BackUserDayMapper backUserDayMapper;

	@Override
	public GenericDao<BackUserDay, Long> getDao() {
		return backUserDayMapper;
	}

	@Override
	public List<BackUserDay> selectBack(Map<String, Object> params) {
		return backUserDayMapper.selectBack(params);
	}

}
