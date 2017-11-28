package com.anrong.wulan.admin.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.StartUserCarrierMapper;
import com.anrong.wulan.admin.po.StartUserCarrier;
import com.anrong.wulan.admin.service.StartUserCarrierService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;

@Service
public class StartUserCarrierServiceImpl extends GenericServiceImpl<StartUserCarrier, Long> implements StartUserCarrierService {

    @Resource
    private StartUserCarrierMapper startUserCarrierMapper;

    @Override
    public GenericDao<StartUserCarrier, Long> getDao() {
        return startUserCarrierMapper;
    }

 

    @Override
    public List<StartUserCarrier> selectRecord(Map<String, Object> params) {
        return startUserCarrierMapper.selectRecord(params);
    }

    


}
