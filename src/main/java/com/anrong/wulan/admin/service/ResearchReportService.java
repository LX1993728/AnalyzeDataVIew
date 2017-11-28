package com.anrong.wulan.admin.service;

import java.util.List;

import com.anrong.wulan.admin.po.ResearchReport;
import com.anrong.wulan.core.generic.GenericService;

public interface ResearchReportService extends GenericService<ResearchReport, Long> {
	
	/*根据时间查询研报*/
	List<ResearchReport> queryByDate();
}
