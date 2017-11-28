package com.anrong.wulan.admin.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.NewStartDetailDataMapper;
import com.anrong.wulan.admin.po.BootstrapPage;
import com.anrong.wulan.admin.po.NewStartDetailData;
import com.anrong.wulan.admin.service.NewStartDetailDataService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;
@Service
public class NewStartDetailDataServiceImpl extends
		GenericServiceImpl<NewStartDetailData, Long> implements NewStartDetailDataService {

    @Resource
    private NewStartDetailDataMapper newStartDetailDataMapper;
	
//	@Override
//	public List<NewStartDetailData> queryDetailDataByPage(
//			Map<String, Object> params, PageBounds pageBounds) {
//		return newStartDetailDataMapper.queryDetailDataByPage(params, pageBounds);
//	}

	@Override
	public GenericDao<NewStartDetailData, Long> getDao() {
		return null;
	}

	@Override
	/*public Page<NewStartDetailData> queryUserDetailCount(Integer p,*/
	public BootstrapPage<NewStartDetailData> queryUserDetailCount(Integer s,Integer n,
			Map<String, Object> params) {

		int totalsize = newStartDetailDataMapper.queryDetailDatas(params).size();
		 BootstrapPage<NewStartDetailData> page = new BootstrapPage<>(totalsize,n,s);
/*		 Page<NewStartDetailData> page = new Page<>(p,6,totalsize);
*/		 params.put("size",s);
		 params.put("start",page.getStart());
		 
		 List<NewStartDetailData> list = newStartDetailDataMapper.queryDetailDataByPage(params);
	       // page.setItems(list);
		 page.setRows(list);
		
		return page;
	}

}
