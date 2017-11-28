package com.anrong.wulan.admin.dao;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.CoreEvent;
import com.anrong.wulan.core.generic.GenericDao;
public interface CoreEventMapper extends GenericDao<CoreEvent, Long>{
	List<CoreEvent> queryNodeCount(Map<String, Object> params);
	List<CoreEvent> queryNode(Map<String, Object> params);
	List<CoreEvent> queryEventId(Map<String, Object> params);
	List<CoreEvent> queryCharts(Map<String, Object> params);
	List<CoreEvent> queryPathCharts(Map<String, Object> params);
	
	/*核心事件查询*/
	List<CoreEvent> coreEventByParam(Map<String, Object> params);
	
	List<CoreEvent> eventManagerCount(Map<String, Object> params);
	List<CoreEvent> eventManagerDetail(Map<String, Object> params);
	
	/*更改事件状态*/
	int updateCoreEvent(CoreEvent coreEvent);
	/*根据事件Id查询事件*/
	List<CoreEvent> queryById(Integer eventId);
	/*根据事件Id删除事件*/
	int deleteEvent(Integer eventId);
}
