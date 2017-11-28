package com.anrong.wulan.admin.service;

import java.util.Date;
import java.util.List;

import com.anrong.wulan.admin.po.AnalyzePDetail;
import com.anrong.wulan.admin.po.AnalyzePage;
import com.anrong.wulan.admin.vo.ANALYPageDetailVO;
import com.anrong.wulan.admin.vo.ANALYPageInOutVO;
import com.anrong.wulan.admin.vo.ANALYPageVO;
import com.anrong.wulan.core.util.Page;

public interface ANALYPageService {
	
	// 根据时间查询 并进行数据汇总封装
	Page<AnalyzePage> getPagesByCriteria(ANALYPageVO analyPageVO);

	// 查询某页面在一段时间的流入和流入大致情况
	List<ANALYPageInOutVO> getInOrOutDetailOfPage(String name, int i, Date beginDate, Date endDate);

	// 查询具体的流入流出详情
	Page<AnalyzePDetail> getPageDetailsByCriteria(ANALYPageDetailVO analyPageDetailVO);


}
