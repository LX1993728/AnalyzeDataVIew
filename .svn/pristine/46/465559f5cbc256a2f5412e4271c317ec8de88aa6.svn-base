package com.anrong.wulan.admin.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.ChannelPromotionMapper;
import com.anrong.wulan.admin.po.ChannelPromotion;
import com.anrong.wulan.admin.service.ChannelPromotionService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;
@Service
public class ChannelPromotionServiceImpl extends GenericServiceImpl<ChannelPromotion, Long>
		implements ChannelPromotionService {
	
	@Resource
	private ChannelPromotionMapper channelPromotionMapper;
	@Override
	public GenericDao<ChannelPromotion, Long> getDao() {
		return null;
	}

	@Override
	public List<ChannelPromotion> queryUserCount(Map<String, Object> params) {
		return channelPromotionMapper.queryUserCount(params);
	}

	/*研报_渠道*/
	@Override
	public List<ChannelPromotion> reportChannel(Map<String, Object> params) {
		return channelPromotionMapper.reportChannel(params);
	}

}
