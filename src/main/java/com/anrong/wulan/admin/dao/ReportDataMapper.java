package com.anrong.wulan.admin.dao;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.ReportData;
import com.anrong.wulan.core.generic.GenericDao;

public interface ReportDataMapper extends GenericDao<ReportData, Long> {

	/*保存研报数据*/
	int save(ReportData reportData);
	
	/*查询所有研报数据*/
	List<ReportData> queryReportData();

	/*跟新研报数据*/
	int update(ReportData reportData);

	/*查询总数*/
	List<ReportData> reportDataCount(Map<String, Object> params);

	/*分页查询*/
	List<ReportData> queryReportDataByParams(Map<String, Object> params);
}
