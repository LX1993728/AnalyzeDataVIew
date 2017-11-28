package com.anrong.wulan.admin.service;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.StartUserCarrier;
import com.anrong.wulan.core.generic.GenericService;

public interface StartUserCarrierService extends GenericService<StartUserCarrier, Long> {


    List<StartUserCarrier> selectRecord(Map<String, Object> params);

   

}
