package com.anrong.wulan.admin.dao;

import java.util.List;
import java.util.Map;
import com.anrong.wulan.admin.po.ProvinceCityDetailData;
import com.anrong.wulan.core.generic.GenericDao;

public interface ProvinceCityDetailDataMapper extends GenericDao<ProvinceCityDetailData, Long> {
	List<ProvinceCityDetailData> getProvinceCityData(Map<String, Object> params);
	List<ProvinceCityDetailData> getProvinceCityDataCount(Map<String, Object> params);
}
