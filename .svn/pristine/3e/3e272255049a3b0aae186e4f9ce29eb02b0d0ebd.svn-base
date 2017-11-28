package com.anrong.wulan.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.StaticUserMapper;
import com.anrong.wulan.admin.po.StaticUser;
import com.anrong.wulan.admin.po.StaticUserExample;
import com.anrong.wulan.admin.po.StaticUserExample.Criteria;
import com.anrong.wulan.admin.service.UserPortraitService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;

@Service
public class UserPortraitServiceImpl extends
		GenericServiceImpl<StaticUser, Long> implements UserPortraitService {

	@Autowired
	private StaticUserMapper staticUserMapper;


	public List<StaticUser> queryUserPortrait(Map<String, Object> params) {
		StaticUserExample example = new StaticUserExample();
		Criteria criteria = example.createCriteria();
		if (params.keySet().contains("sex")) {
			criteria.andSexEqualTo((Integer) params.get("sex"));
		}
		if (params.keySet().contains("beginAge")
				&& params.keySet().contains("endAge")) {
			criteria.andAgeBetween((Integer) params.get("beginAge"),
					(Integer) params.get("endAge"));
		}
		if (params.keySet().contains("province")) {
			criteria.andProvinceEqualTo((String) params.get("province"));
		}

		List<StaticUser> users = staticUserMapper.selectByExample(example);
		return users;
	}

	@Override
	public GenericDao<StaticUser, Long> getDao() {
		return null;
	}

}
