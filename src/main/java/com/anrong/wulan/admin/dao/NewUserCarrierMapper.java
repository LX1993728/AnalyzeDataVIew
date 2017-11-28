package com.anrong.wulan.admin.dao;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.NewUserCarrier;
import com.anrong.wulan.core.generic.GenericDao;

public interface NewUserCarrierMapper extends GenericDao<NewUserCarrier, Long> {

	List<NewUserCarrier> selectRecord(Map<String, Object> params);

	List<NewUserCarrier>  queryDetail(Map<String, Object> params);

	List<NewUserCarrier> queryCount(Map<String, Object> params);

}
