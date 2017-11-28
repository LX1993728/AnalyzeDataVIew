package com.anrong.wulan.admin.dao;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.ExceptionAnalysis;
import com.anrong.wulan.admin.po.SysExceptionHour;
import com.anrong.wulan.core.generic.GenericDao;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

/**
 * 程序异常记录
 * @author ZYJ
 **/
public interface ExceptionAnalysisMapper extends
		GenericDao<ExceptionAnalysis, Long> {
	
	ExceptionAnalysis getTodayExceptionSummary(Map<String, Object> params,
			PageBounds pageBounds);

	ExceptionAnalysis getYestodayExceptionSummary(Map<String, Object> params,
			PageBounds pageBounds);

	ExceptionAnalysis getLastWeekExceptionSummary(Map<String, Object> params,
			PageBounds pageBounds);

	ExceptionAnalysis getLastMonthExceptionSummary(Map<String, Object> params,
			PageBounds pageBounds);

	ExceptionAnalysis getBusinessExceptionSummary(Map<String, Object> params,
			PageBounds pageBounds);

	ExceptionAnalysis getExceptionSummary(Map<String, Object> params,
			PageBounds pageBounds);

	List<ExceptionAnalysis> getSystemExceptionByDate(Map<String, Object> params);

	List<ExceptionAnalysis> getSystemExceptionDetail(
			Map<String, Object> params, PageBounds pageBounds);

	List<ExceptionAnalysis> getApplicationExceptionByDate(
			Map<String, Object> params);

	List<ExceptionAnalysis> getApplicationExceptionDetail(
			Map<String, Object> params, PageBounds pageBounds);

	List<SysExceptionHour> queryTop10SysException(Map<String, Object> params);
}
