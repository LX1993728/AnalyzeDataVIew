package com.anrong.wulan.admin.service;

import java.util.Map;

import com.anrong.wulan.admin.po.StartFrequency;
import com.anrong.wulan.core.generic.GenericService;
import com.anrong.wulan.core.util.Page;

public interface StartFrequencyService extends
GenericService<StartFrequency, Long>{
	Page<StartFrequency> queryStartDetail(Integer p,Map<String, Object> params);
}
