package com.anrong.wulan.admin.service;

import java.util.Map;

import com.anrong.wulan.admin.po.NewLostFunnel;
import com.anrong.wulan.core.generic.GenericService;

public interface NewLostFunnelService extends GenericService<NewLostFunnel, Long> {

	NewLostFunnel selectNew(Map<String, Object> params);

}
