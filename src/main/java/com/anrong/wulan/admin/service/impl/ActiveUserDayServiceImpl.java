package com.anrong.wulan.admin.service.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.anrong.wulan.admin.dao.ActiveUserDayMapper;
import com.anrong.wulan.admin.po.ActiveUserDay;
import com.anrong.wulan.admin.service.ActiveUserDayService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;

@Service
public class ActiveUserDayServiceImpl extends GenericServiceImpl<ActiveUserDay, Long> implements ActiveUserDayService {

	@Resource
	private ActiveUserDayMapper activeUserDayMapper;
	
	@Override
	public List<ActiveUserDay> queryActiveUserDay(Map<String, Object> map) {
		return activeUserDayMapper.queryActiveUserDay(map);
	}

	@Override
	public GenericDao<ActiveUserDay, Long> getDao() {
		return activeUserDayMapper;
	}
	
	@Override
	public List<ActiveUserDay> ActiveUserYesterday (Map<String , Object> map){
		return activeUserDayMapper.ActiveUserYesterday(map);

	}
}
