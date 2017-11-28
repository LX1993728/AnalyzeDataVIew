package com.anrong.wulan.admin.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.SingleUserMapper;
import com.anrong.wulan.admin.po.SingleUser;
import com.anrong.wulan.admin.service.SingleUserService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;
@Service
public class SingleUserServiceImpl extends GenericServiceImpl<SingleUser, Long> implements  SingleUserService{
 
    @Resource
    private SingleUserMapper singleUserMapper;
    
    @Override
    public GenericDao<SingleUser, Long> getDao() {
        return singleUserMapper;
    }

}
