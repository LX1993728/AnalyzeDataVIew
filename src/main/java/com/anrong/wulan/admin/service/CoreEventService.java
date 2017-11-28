package com.anrong.wulan.admin.service;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.CoreEvent;
import com.anrong.wulan.core.generic.GenericService;
import com.anrong.wulan.core.util.Page;

public interface CoreEventService extends GenericService<CoreEvent, Long> {
	
	Page<CoreEvent> queryNode(Integer p,Map<String, Object> params);
	
	List<CoreEvent> queryEventId(Map<String, Object> params);
	
	List<CoreEvent> queryEcharts(Map<String, Object> params);
	
	List<CoreEvent> queryPathCharts(Map<String, Object> params);
	
	/*核心事件查询*/
	List<CoreEvent> coreEventByParam(Map<String, Object> params);
	
	Page<CoreEvent> queryCoreEvent(Integer p,Map<String, Object> params);
	
	/*根据事件ID查询*/
	List<CoreEvent> queryById(Integer eventId);
	
	 /*更改事件状态*/
	int updateEvent(CoreEvent coreEvent);

	/*删除事件*/
	int deleteEvent(Integer eventId);
}
