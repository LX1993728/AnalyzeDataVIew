package com.anrong.wulan.admin.service;

import java.util.Map;

import com.anrong.wulan.admin.po.BootstrapPage;
import com.anrong.wulan.admin.po.NewStartDetailData;
import com.anrong.wulan.core.generic.GenericService;

public interface NewStartDetailDataService extends GenericService<NewStartDetailData, Long> {
    
//    List<NewStartDetailData> queryDetailDataByPage(Map<String, Object> params,PageBounds pageBounds);
	//Page<NewStartDetailData> queryUserDetailCount(Integer p,Map<String, Object> params);
    BootstrapPage<NewStartDetailData> queryUserDetailCount(Integer p,Integer s,Map<String, Object> params);
}