package com.anrong.wulan.admin.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.ReportDataMapper;
import com.anrong.wulan.admin.po.ReportData;
import com.anrong.wulan.admin.service.ReportDataService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;
import com.anrong.wulan.core.util.Page;
import com.google.common.collect.Maps;

@Service
public class ReportDataServiceImpl extends GenericServiceImpl<ReportData, Long> implements ReportDataService {

	@Resource
	private  ReportDataMapper  ReportDataMapper;
	
	@Override
	public GenericDao<ReportData, Long> getDao() {
		return ReportDataMapper;
	}

	@Override
	public List<ReportData> queryReportData() {
		return ReportDataMapper.queryReportData();
	}

	@Override
	public int save(ReportData reportData) {
		return ReportDataMapper.save(reportData);
		
	}

	@Override
	public int update(ReportData reportData) {
		return ReportDataMapper.update(reportData);
		
	}

	/*分页查询*/
	@Override
	public Page<ReportData> queryByPage(Integer p) {
		
		Map<String, Object> params = Maps.newHashMap();
		int pageSize = ReportDataMapper.queryReportData().size();
		Page<ReportData> page =  new Page<>(p,15,pageSize);
		params.put("size",15);
		params.put("start",page.getStart());
		List<ReportData> list = ReportDataMapper.queryReportDataByParams(params);
		page.setItems(list);
		
		return page;
	}

	@Override
	public List<ReportData> updateReportData() {
		// TODO Auto-generated method stub
		return null;
	}

}
