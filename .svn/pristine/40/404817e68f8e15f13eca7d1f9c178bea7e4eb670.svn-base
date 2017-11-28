package com.anrong.wulan.admin.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.ActiveUserHourMapper;
import com.anrong.wulan.admin.po.ActiveUserHour;
import com.anrong.wulan.admin.service.ActiveUserHourService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;

@Service
public class ActiveUserHourServiceImpl extends GenericServiceImpl<ActiveUserHour, Long> implements   ActiveUserHourService{

    @Resource
    private ActiveUserHourMapper activeUserHourMapper;
    
    @Override
    public GenericDao<ActiveUserHour, Long> getDao() {
        return activeUserHourMapper;
    }

//	时段分析今天活跃用户
	@Override
	public List<ActiveUserHour> queryActUserTimeToday(Map<String, Object> params) {
		return activeUserHourMapper.queryActUserTimeToday(params);

	}

//	时段分析昨天活跃用户
	@Override
	public List<ActiveUserHour> queryActUserTimeYestaday(Map<String, Object> params) {
		return activeUserHourMapper.queryActUserTimeYestaday(params);

	}

}
