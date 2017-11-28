package com.anrong.wulan.admin.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.StartNetMapper;
import com.anrong.wulan.admin.po.StartNet;
import com.anrong.wulan.admin.service.StartNetService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;

@Service
public class StartNetServiceImpl extends GenericServiceImpl<StartNet, Long> implements StartNetService {

    @Resource
    private StartNetMapper startNetMapper;

    @Override
    public GenericDao<StartNet, Long> getDao() {
        return startNetMapper;
    }

 

    @Override
    public List<StartNet> selectRecord(Map<String, Object> params) {
        return startNetMapper.selectRecord(params);
    }

    


}
