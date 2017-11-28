package com.anrong.wulan.admin.dao;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.RetentionLostBackUser;
import com.anrong.wulan.core.generic.GenericDao;

public interface RetentionLostBackDetailMapper extends
GenericDao<RetentionLostBackUser, Long>{
//查询总数
List<RetentionLostBackUser> queryDetailCount(Map<String, Object> params);
//分页查询
List<RetentionLostBackUser> queryDetail(Map<String, Object> params);
}
