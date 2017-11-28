package com.anrong.wulan.admin.service.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.anrong.wulan.admin.dao.VersionDetailMapper;
import com.anrong.wulan.admin.po.VersionDetailModel;
import com.anrong.wulan.admin.service.VersionDetailModelService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;
import com.anrong.wulan.core.util.Page;

@Service
public class VersionDetailModelServiceImpl extends
		GenericServiceImpl<VersionDetailModel, Long> implements
		VersionDetailModelService {

	@Resource
	private VersionDetailMapper versionDetailMapper;

	@Override
	public Page<VersionDetailModel> queryVersionDetail(Integer p,
			Map<String, Object> params) {
		int versionSize = versionDetailMapper.queryVersionDetailCount(params).size();
		Page<VersionDetailModel> page = new Page<>(p,6,versionSize);
		params.put("size",6);
		params.put("start",page.getStart());
		List<VersionDetailModel> list = versionDetailMapper.queryVersionDetail(params);
        page.setItems(list);
		return page;
	}

	@Override
	public GenericDao<VersionDetailModel, Long> getDao() {
		return null;
	}

	
}
