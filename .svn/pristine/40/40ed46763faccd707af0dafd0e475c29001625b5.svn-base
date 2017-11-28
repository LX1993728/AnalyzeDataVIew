package com.anrong.wulan.admin.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.ModelInvokeMapper;
import com.anrong.wulan.admin.po.ModelInvoke;
import com.anrong.wulan.admin.service.ModelInvokeService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;
import com.anrong.wulan.core.util.Page;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

@Service
public class ModelInvokeServiceImpl extends
		GenericServiceImpl<ModelInvoke, Long> implements ModelInvokeService {
	
	@Resource
	private ModelInvokeMapper modelInvokeMapper;
	
	@Override
	public GenericDao<ModelInvoke, Long> getDao() {
		return modelInvokeMapper;
	}
	
	
	@Override
	public Page<ModelInvoke> queryDetail(Integer p,Map<String, Object> params){
		
		int totalsize = modelInvokeMapper.queryCount(params).size();
		 Page<ModelInvoke> page = new Page<>(p,6,totalsize);
		 params.put("size",6);
		 params.put("start",page.getStart());
		 
		 List<ModelInvoke> List = modelInvokeMapper.queryDetail(params);
	        page.setItems(List);
		
		return page;
	}
	

	@Override
	public List<ModelInvoke> queryTop10Model(Map<String, Object> params) {
		return modelInvokeMapper.queryTop10Model(params);
	}

	@Override
	public List<ModelInvoke> queryTop10ModelASC(Map<String, Object> params) {
		return modelInvokeMapper.queryTop10ModelASC(params);
	}
	
	@Override
	public List<ModelInvoke> selectRecord(Map<String, Object> params) {
		return modelInvokeMapper.selectRecordTop(params);
	}
	@Override
	public List<ModelInvoke> selectRecordUnder(Map<String, Object> params) {
		return modelInvokeMapper.selectRecordUnder(params);
	}
	
	@Override
	public List<ModelInvoke> selectRecordASC(Map<String, Object> params) {
		return modelInvokeMapper.selectRecordASC(params);
	}

	@Override
	public List<ModelInvoke> queryTop10ModelDetail(Map<String, Object> params,
			PageBounds pageBounds) {
		return modelInvokeMapper.queryTop10ModelDetail(params, pageBounds);
	}

	@Override
	public List<ModelInvoke> selectRecordByCustom(Map<String, Object> params) {
		return modelInvokeMapper.selectRecordByCustom(params);
	}

	@Override
	public List<ModelInvoke> queryTop10ModelDetailByCustom(
			Map<String, Object> params, PageBounds pageBounds) {
		return modelInvokeMapper.queryTop10ModelDetailByCustom(params,
				pageBounds);
	}

}
