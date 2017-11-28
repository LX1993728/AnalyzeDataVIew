package com.anrong.wulan.admin.dao;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.StartUserCarrier;
import com.anrong.wulan.core.generic.GenericDao;

public interface StartUserCarrierMapper extends GenericDao<StartUserCarrier,Long>{


    List<StartUserCarrier> selectRecord(Map<String, Object> params);

    

}
