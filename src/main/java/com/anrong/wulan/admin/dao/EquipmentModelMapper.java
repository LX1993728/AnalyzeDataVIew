package com.anrong.wulan.admin.dao;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.EquipmentModel;
import com.anrong.wulan.core.generic.GenericDao;

public interface EquipmentModelMapper extends GenericDao<EquipmentModel, Long> {
	List<EquipmentModel> queryVendorDetailCount(Map<String, Object> params);
	List<EquipmentModel> queryVendorDetail(Map<String, Object> params);
}
