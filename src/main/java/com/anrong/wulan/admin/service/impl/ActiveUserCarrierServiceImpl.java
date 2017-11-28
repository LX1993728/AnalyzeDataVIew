package com.anrong.wulan.admin.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.ActiveUserCarrierMapper;
import com.anrong.wulan.admin.po.ActiveUserCarrier;
import com.anrong.wulan.admin.service.ActiveUserCarrierService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;

@Service
public class ActiveUserCarrierServiceImpl extends GenericServiceImpl<ActiveUserCarrier, Long> implements ActiveUserCarrierService {

    @Resource
    private ActiveUserCarrierMapper activeUserCarrierMapper;

    @Override
    public GenericDao<ActiveUserCarrier, Long> getDao() {
        return activeUserCarrierMapper;
    }

 

    @Override
    public List<ActiveUserCarrier> selectRecord(Map<String, Object> params) {
        return activeUserCarrierMapper.selectRecord(params);
    }

    


}
