package com.anrong.wulan.admin.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.StartHourMapper;
import com.anrong.wulan.admin.po.StartHour;
import com.anrong.wulan.admin.service.StartHourService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;

@Service
public class StartHourServiceImpl extends GenericServiceImpl<StartHour, Long> implements StartHourService {
    @Resource
    private StartHourMapper startHourMapper;

    @Override
    public GenericDao<StartHour, Long> getDao() {
        return startHourMapper;
    }

    @Override
    public List<StartHour> selectRecord(Map<String, Object> params) {
        return startHourMapper.selectRecord(params);
    }

    @Override
    public List<StartHour> selectRecordMonth(Map<String, Object> params) {
        return startHourMapper.selectRecordMonth(params);
    }

    @Override
    public List<StartHour> queryTop10Start(Map<String, Object> params) {
        return startHourMapper.queryTop10Start(params);
    }

	@Override
	public StartHour queryStartHour(Map<String, Object> params) {
		return startHourMapper.queryStartHour(params);
	}

}
