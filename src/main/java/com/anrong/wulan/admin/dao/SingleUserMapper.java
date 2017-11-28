package com.anrong.wulan.admin.dao;

import java.util.Map;

import com.anrong.wulan.admin.po.SingleUser;
import com.anrong.wulan.core.generic.GenericDao;

public interface SingleUserMapper extends GenericDao<SingleUser,Long> {

    SingleUser querySingleUser(Map<String, Object> map);

}
