package com.anrong.wulan.admin.dao;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.StartNet;
import com.anrong.wulan.core.generic.GenericDao;

public interface StartNetMapper extends GenericDao<StartNet,Long>{


    List<StartNet> selectRecord(Map<String, Object> params);

    

}
