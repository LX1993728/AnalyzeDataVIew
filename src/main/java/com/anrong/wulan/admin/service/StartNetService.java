package com.anrong.wulan.admin.service;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.StartNet;
import com.anrong.wulan.core.generic.GenericService;

public interface StartNetService extends GenericService<StartNet, Long> {


    List<StartNet> selectRecord(Map<String, Object> params);

   

}
