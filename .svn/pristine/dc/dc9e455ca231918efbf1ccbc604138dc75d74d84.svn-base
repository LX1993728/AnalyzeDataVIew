package com.anrong.wulan.admin.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.StartOsMapper;
import com.anrong.wulan.admin.po.StartOs;
import com.anrong.wulan.admin.service.StartOsService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

@Service
public class StartOsServiceImpl extends GenericServiceImpl<StartOs, Long> implements StartOsService {

    @Resource
    private StartOsMapper startOsMapper;

    @Override
    public GenericDao<StartOs, Long> getDao() {
        return startOsMapper;
    }

    @Override
    public List<StartOs> queryVersionOs(Map<String, Object> params) {
        return startOsMapper.queryVersionOs(params);
    }

    @Override
    public StartOs queryNewUserCount(Map<String, Object> params) {
        return startOsMapper.queryNewUserCount(params);
    }

    @Override
    public List<StartOs> queryAllVersionOs(Map<String, Object> params) {
        return startOsMapper.queryAllVersionOs(params);
    }

    @Override
    public List<StartOs> selectRecord(Map<String, Object> params) {
        return startOsMapper.selectRecord(params);
    }

    @Override
    public StartOs selectStartByVerOs(Map<String, Object> params) {
        return startOsMapper.selectStartByVerOs(params);
    }

	@Override
	public List<StartOs> queryStartTimeTotal(Map<String, Object> params) {
		return startOsMapper.queryStartTimeTotal(params);
	}

	@Override
	public List<StartOs> selectRecordByPage(Map<String, Object> params,
			PageBounds pageBounds) {
		return startOsMapper.selectRecordByPage(params,pageBounds);
	}


}
