package com.anrong.wulan.admin.dao;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.ActiveUserNet;
import com.anrong.wulan.core.generic.GenericDao;

public interface ActiveUserNetMapper extends GenericDao<ActiveUserNet,Long>{


    List<ActiveUserNet> selectRecord(Map<String, Object> params);

    

}
