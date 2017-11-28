package com.anrong.wulan.admin.service.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.anrong.wulan.admin.dao.EquipmentModelMapper;
import com.anrong.wulan.admin.po.EquipmentModel;
import com.anrong.wulan.admin.service.EquipmentModelService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;
import com.anrong.wulan.core.util.Page;

@Service
public class EquipmentModelServiceImpl extends
		GenericServiceImpl<EquipmentModel, Long> implements
		EquipmentModelService {

	@Resource
	private EquipmentModelMapper equipmentModelMapper;

	@Override
	public GenericDao<EquipmentModel, Long> getDao() {
		return null;
	}

	@Override
	public Page<EquipmentModel> queryVendorDetail(Integer p,
			Map<String, Object> params) {
		int dataSize = equipmentModelMapper.queryVendorDetailCount(params).size();
		Page<EquipmentModel> page = new Page<>(p,6,dataSize);
		 params.put("size",6);
		 params.put("start",page.getStart());
		 
		 List<EquipmentModel> list = equipmentModelMapper.queryVendorDetail(params);
	        page.setItems(list);
		return page;
	}
	
}
