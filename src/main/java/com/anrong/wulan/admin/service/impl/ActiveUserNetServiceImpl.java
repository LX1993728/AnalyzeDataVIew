package com.anrong.wulan.admin.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.ActiveUserNetMapper;
import com.anrong.wulan.admin.po.ActiveUserNet;
import com.anrong.wulan.admin.service.ActiveUserNetService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;

@Service
public class ActiveUserNetServiceImpl extends GenericServiceImpl<ActiveUserNet, Long> implements ActiveUserNetService {

    @Resource
    private ActiveUserNetMapper activeUserNetMapper;

    @Override
    public GenericDao<ActiveUserNet, Long> getDao() {
        return activeUserNetMapper;
    }

 

    @Override
    public List<ActiveUserNet> selectRecord(Map<String, Object> params) {
        return activeUserNetMapper.selectRecord(params);
    }

    


}
