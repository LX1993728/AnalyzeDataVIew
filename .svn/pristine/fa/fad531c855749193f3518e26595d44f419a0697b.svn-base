package com.anrong.wulan.admin.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.NewUserRegionMapper;
import com.anrong.wulan.admin.po.NewUserRegion;
import com.anrong.wulan.admin.service.NewUserRegionService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;

@Service
public class NewUserRegionServiceImpl extends GenericServiceImpl<NewUserRegion, Long> implements NewUserRegionService {

    @Resource
    private NewUserRegionMapper newUserRegionMapper;

    @Override
    public GenericDao<NewUserRegion, Long> getDao() {
        return newUserRegionMapper;
    }

    @Override
    public List<NewUserRegion> queryTop10Region(Map<String, Object> params) {
        return newUserRegionMapper.queryTop10Region(params);
    }

}
