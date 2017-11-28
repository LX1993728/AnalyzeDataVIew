package com.anrong.wulan.admin.dao;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.ActiveUserCarrier;
import com.anrong.wulan.core.generic.GenericDao;

public interface ActiveUserCarrierMapper extends GenericDao<ActiveUserCarrier,Long>{


    List<ActiveUserCarrier> selectRecord(Map<String, Object> params);

    

}
