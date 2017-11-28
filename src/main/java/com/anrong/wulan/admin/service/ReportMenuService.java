package com.anrong.wulan.admin.service;

import java.util.List;

import com.anrong.wulan.admin.po.ReportMenu;
import com.anrong.wulan.core.generic.GenericService;

public interface ReportMenuService extends GenericService<ReportMenu, Long> {
	
	/*查询所有研报菜单*/
	List<ReportMenu> queryReportMenu();

}
