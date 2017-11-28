package com.anrong.wulan.admin.dao;

import java.util.Date;
import java.util.List;

import com.anrong.wulan.admin.po.AnalyzePDetail;
import com.anrong.wulan.admin.vo.ANALYPageDetailVO;
import com.anrong.wulan.admin.vo.ANALYPageInOutVO;

/**
 * 页面分析DAO
 * @author liuxun
 *
 */
public interface ANALYPageDetailMapper {

	List<ANALYPageInOutVO> getInOrOutDetailOfPage(String name, int i, Date beginDate, Date endDate);

	List<AnalyzePDetail> getPageDetailsByCriteria(ANALYPageDetailVO analyPageDetailVO);

	Long getPageDetailsCountByCriteria(ANALYPageDetailVO analyPageDetailVO);

}
