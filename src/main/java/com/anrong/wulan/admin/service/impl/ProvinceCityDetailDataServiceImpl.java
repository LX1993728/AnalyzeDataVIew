package com.anrong.wulan.admin.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.ProvinceCityDetailDataMapper;
import com.anrong.wulan.admin.po.ProvinceCityDetailData;
import com.anrong.wulan.admin.service.ProvinceCityDetailDataService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;
import com.anrong.wulan.core.util.Page;
@Service
public class ProvinceCityDetailDataServiceImpl extends
		GenericServiceImpl<ProvinceCityDetailData, Long> implements ProvinceCityDetailDataService {

    @Resource
    private ProvinceCityDetailDataMapper provinceCityDetailDataMapper;
	

	@Override
	public GenericDao<ProvinceCityDetailData, Long> getDao() {
		return null;
	}


	@Override
	public Page<ProvinceCityDetailData> getProvinceCityData(Integer p,
			Map<String, Object> params) {
		int totalsize = provinceCityDetailDataMapper.getProvinceCityDataCount(params).size();
		 Page<ProvinceCityDetailData> page = new Page<>(p,6,totalsize);
		 params.put("size",6);
		 params.put("start",page.getStart());
		 
		 List<ProvinceCityDetailData> list = provinceCityDetailDataMapper.getProvinceCityData(params);
	        page.setItems(list);
		
		return page;
	}

}
