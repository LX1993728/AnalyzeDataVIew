package com.anrong.wulan.admin.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.NewUserCarrierMapper;
import com.anrong.wulan.admin.po.NewUserCarrier;
import com.anrong.wulan.admin.service.NewUserCarrierService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;
import com.anrong.wulan.core.util.Page;

@Service
public class NewUserCarrierServiceImpl extends
		GenericServiceImpl<NewUserCarrier, Long> implements
		NewUserCarrierService {

	@Resource
	private NewUserCarrierMapper newUserCarrierMapper;

	@Override
	public GenericDao<NewUserCarrier, Long> getDao() {
		return newUserCarrierMapper;
	}

	@Override
	public List<NewUserCarrier> selectRecord(Map<String, Object> params) {
		return newUserCarrierMapper.selectRecord(params);
	}

	@Override
	public Page<NewUserCarrier> queryDetail (Integer p,Map<String, Object> params){
		int totalsize = newUserCarrierMapper.queryCount(params).size();
		Page<NewUserCarrier> page = new Page<>(p,6,totalsize);
//		Page<NewUserCarrier> page = new Page<>(p,6,10);
		 params.put("size",6);
		 params.put("start",page.getStart());
		 List<NewUserCarrier> List = newUserCarrierMapper.queryDetail(params);
	     page.setItems(List);
		
		return page;
		
	}

}
