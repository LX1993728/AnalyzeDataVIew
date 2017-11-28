package com.anrong.wulan.admin.dao;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.StartOs;
import com.anrong.wulan.core.generic.GenericDao;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface StartOsMapper extends GenericDao<StartOs, Long> {

	List<StartOs> queryVersionOs(Map<String, Object> params);

	StartOs queryNewUserCount(Map<String, Object> params);

	List<StartOs> queryAllVersionOs(Map<String, Object> params);

	List<StartOs> selectRecord(Map<String, Object> params);

	StartOs selectStartByVerOs(Map<String, Object> params);

	List<StartOs> queryStartTimeTotal(Map<String, Object> params);

	List<StartOs> selectRecordByPage(Map<String, Object> params,
			PageBounds pageBounds);
}
