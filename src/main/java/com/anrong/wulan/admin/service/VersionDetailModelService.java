package com.anrong.wulan.admin.service;

import java.util.Map;
import com.anrong.wulan.admin.po.VersionDetailModel;
import com.anrong.wulan.core.generic.GenericService;
import com.anrong.wulan.core.util.Page;

public interface VersionDetailModelService extends GenericService<VersionDetailModel, Long> {
	
	Page<VersionDetailModel> queryVersionDetail(Integer p,Map<String, Object> params);

}
