package com.anrong.wulan.admin.dao;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.ChannelPromotion;
import com.anrong.wulan.core.generic.GenericDao;

public interface ChannelPromotionMapper extends GenericDao<ChannelPromotion,Long>{
	List<ChannelPromotion> queryUserCount(Map<String, Object> params);

	/*研报_渠道*/
	List<ChannelPromotion> reportChannel(Map<String, Object> params);
}
