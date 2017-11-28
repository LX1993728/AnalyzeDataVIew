package com.anrong.wulan.admin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.ResearchReportMapper;
import com.anrong.wulan.admin.po.ResearchReport;
import com.anrong.wulan.admin.service.ResearchReportService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;

@Service
public class ResearchReportServiceImpl extends
GenericServiceImpl<ResearchReport, Long> implements ResearchReportService
 {

	@Resource
	private ResearchReportMapper researchReportMapper;
	
	@Override
	public GenericDao<ResearchReport, Long> getDao() {
		return researchReportMapper;
	}
	
	
	/*根据时间查询研报*/
	public List<ResearchReport> queryByDate(){
		
		return researchReportMapper.queryByDate();
	} 

}
