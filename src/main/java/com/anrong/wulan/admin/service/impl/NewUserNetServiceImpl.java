package com.anrong.wulan.admin.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.NewUserNetMapper;
import com.anrong.wulan.admin.po.NewUserNet;
import com.anrong.wulan.admin.service.NewUserNetService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;
import com.anrong.wulan.core.util.Page;

@Service
public class NewUserNetServiceImpl extends GenericServiceImpl<NewUserNet, Long>
		implements NewUserNetService {

	@Resource
	private NewUserNetMapper newUserNetMapper;

	@Override
	public GenericDao<NewUserNet, Long> getDao() {
		return newUserNetMapper;
	}

	public List<NewUserNet> queryNetNewUser(Map<String, Object> params) {
		return newUserNetMapper.queryNetNewUser(params);
	}

	@Override
	public Page<NewUserNet> queryDetail(Integer p,Map<String, Object> params){
		int totalsize = newUserNetMapper.queryCount(params).size();
		 Page<NewUserNet> page = new Page<>(p,6,totalsize);
		 params.put("size",6);
		 params.put("start",page.getStart());
		 List<NewUserNet> List = newUserNetMapper.queryDetail(params);
	        page.setItems(List);
		
		return page;
		
		
	}
}
