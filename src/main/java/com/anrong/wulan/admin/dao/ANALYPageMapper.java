package com.anrong.wulan.admin.dao;

import java.util.List;

import com.anrong.wulan.admin.po.AnalyzePage;
import com.anrong.wulan.admin.vo.ANALYPageVO;

/**
 * 页面分析DAO
 * @author liuxun
 *
 */
public interface ANALYPageMapper {

	List<AnalyzePage> getPagesByCriteria(ANALYPageVO analyPageVO);
	Long getPagesCountByCriteria(ANALYPageVO analyPageVO);
}
