package com.anrong.wulan.admin.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anrong.wulan.admin.dao.ANALYPageDetailMapper;
import com.anrong.wulan.admin.dao.ANALYPageMapper;
import com.anrong.wulan.admin.po.AnalyzePDetail;
import com.anrong.wulan.admin.po.AnalyzePage;
import com.anrong.wulan.admin.service.ANALYPageService;
import com.anrong.wulan.admin.vo.ANALYPageDetailVO;
import com.anrong.wulan.admin.vo.ANALYPageInOutVO;
import com.anrong.wulan.admin.vo.ANALYPageVO;
import com.anrong.wulan.core.util.Page;

@Service
@Transactional
public class ANALYPageServiceImpl implements ANALYPageService {
	
	@Autowired
	private ANALYPageMapper analyPageMapper;

	@Autowired
	private ANALYPageDetailMapper analyPageDetailMapper;
	
	@Override
	public Page<AnalyzePage> getPagesByCriteria(ANALYPageVO analyPageVO) {
		Integer offset = (analyPageVO.getP() - 1) * analyPageVO.getPageSize();
		analyPageVO.setOffset(offset);
		// 查询符合条件的总记录
		List<AnalyzePage> list = analyPageMapper.getPagesByCriteria(analyPageVO);
		//查询符合条件的总记录的数量
		Long count = analyPageMapper.getPagesCountByCriteria(analyPageVO);
		Page<AnalyzePage> page = new Page<>(analyPageVO.getP(), analyPageVO.getPageSize(), count.intValue());
		page.setItems(list);
		return page;
	}

	@Override
	public List<ANALYPageInOutVO> getInOrOutDetailOfPage(String name, int i, Date beginDate, Date endDate) {
		return analyPageDetailMapper.getInOrOutDetailOfPage(name,i,beginDate,endDate);
	}

	@Override
	public Page<AnalyzePDetail> getPageDetailsByCriteria(ANALYPageDetailVO analyPageDetailVO) {
		Integer offset = (analyPageDetailVO.getP() - 1) * analyPageDetailVO.getPageSize();
		analyPageDetailVO.setOffset(offset);
		// 查询符合条件的总记录
		List<AnalyzePDetail> list = analyPageDetailMapper.getPageDetailsByCriteria(analyPageDetailVO);
		//查询符合条件的总记录的数量
		Long count = analyPageDetailMapper.getPageDetailsCountByCriteria(analyPageDetailVO);
		Page<AnalyzePDetail> page = new Page<>(analyPageDetailVO.getP(), analyPageDetailVO.getPageSize(), count.intValue());
		page.setItems(list);
		return page;
	}


}
