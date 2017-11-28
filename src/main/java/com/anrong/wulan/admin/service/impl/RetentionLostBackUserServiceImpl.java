package com.anrong.wulan.admin.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.RetentionLostBackDetailMapper;
import com.anrong.wulan.admin.po.RetentionLostBackUser;
import com.anrong.wulan.admin.service.RetentionLostBackUserService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;
import com.anrong.wulan.core.util.Page;
@Service
public class RetentionLostBackUserServiceImpl extends
GenericServiceImpl<RetentionLostBackUser, Long> implements RetentionLostBackUserService{

	@Resource
	private RetentionLostBackDetailMapper userDetail;
	@Override
	public Page<RetentionLostBackUser> queryUserDetailCount(Integer p,
			Map<String, Object> params) {
		int totalsize = userDetail.queryDetailCount(params).size();
		 Page<RetentionLostBackUser> page = new Page<>(p,6,totalsize);
		 params.put("size",6);
		 params.put("start",page.getStart());
		 
		 List<RetentionLostBackUser> list = userDetail.queryDetail(params);
	        page.setItems(list);
		return page;
	}

	@Override
	public GenericDao<RetentionLostBackUser, Long> getDao() {
		return null;
	}

}
