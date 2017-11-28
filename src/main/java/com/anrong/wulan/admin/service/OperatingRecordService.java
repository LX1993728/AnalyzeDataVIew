package com.anrong.wulan.admin.service;

import java.util.List;
import java.util.Map;
import com.anrong.wulan.admin.po.OperatingRecord;
import com.anrong.wulan.core.generic.GenericService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface OperatingRecordService extends GenericService<OperatingRecord, Long> {
	 List<OperatingRecord> queryOperatingRecord(Map<String, Object> params,PageBounds pageBounds);
	 List<OperatingRecord> queryOperatingRecordByExcep(Map<String, Object> params,PageBounds pageBounds);
}
