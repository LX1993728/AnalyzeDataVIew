package com.anrong.wulan.admin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.ReportMenuMapper;
import com.anrong.wulan.admin.po.ReportMenu;
import com.anrong.wulan.admin.service.ReportMenuService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;

@Service
public class ReportMenuServiceImpl extends GenericServiceImpl<ReportMenu, Long> implements ReportMenuService {

	@Resource
	private ReportMenuMapper reportMenuMapper;
	
	@Override
	public GenericDao<ReportMenu, Long> getDao() {
		return reportMenuMapper;
	}

	@Override
	public List<ReportMenu> queryReportMenu() {
		return reportMenuMapper.queryReportMenu();
	}
}
