package com.anrong.wulan.admin.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.CoreEventMapper;
import com.anrong.wulan.admin.po.CoreEvent;
import com.anrong.wulan.admin.service.CoreEventService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;
import com.anrong.wulan.core.util.Page;

@Service
public class CoreEventServiceImpl extends GenericServiceImpl<CoreEvent, Long>
		implements CoreEventService  {
	@Resource
	private CoreEventMapper coreEventMapper;

	@Override
	public Page<CoreEvent> queryNode(Integer p, Map<String, Object> params) {
		int totalsize = coreEventMapper.queryNodeCount(params).size();
		 Page<CoreEvent> page = new Page<>(p,6,totalsize);
		 params.put("size",6);
		 params.put("start",page.getStart());
		 List<CoreEvent> list = coreEventMapper.queryNode(params);
	     page.setItems(list);
		return page;
	}

	@Override
	public GenericDao<CoreEvent, Long> getDao() {
		return null;
	}

	@Override
	public List<CoreEvent> queryEventId(Map<String, Object> params) {
		return coreEventMapper.queryEventId(params);
	}

	@Override
	public List<CoreEvent> queryEcharts(Map<String, Object> params) {
		return coreEventMapper.queryCharts(params);
	}

	@Override
	public List<CoreEvent> queryPathCharts(Map<String, Object> params) {
		return coreEventMapper.queryPathCharts(params);
	}

	/*核心事件查询*/
	@Override
	public List<CoreEvent> coreEventByParam(Map<String, Object> params) {
		
		return coreEventMapper.coreEventByParam(params);
	}

	@Override
	public Page<CoreEvent> queryCoreEvent(Integer p, Map<String, Object> params) {
		//params中目前不需传值，预留传值，后期需要传入用户 id，和appId
		int totalsize = coreEventMapper.eventManagerCount(params).size();
		 Page<CoreEvent> page = new Page<>(p,10,totalsize);
		 params.put("size",10);
		 params.put("start",page.getStart());
		 List<CoreEvent> list = coreEventMapper.eventManagerDetail(params);
	     page.setItems(list);
		return page;
	}

	/*更改事件状态*/
	@Override
	public int updateEvent(CoreEvent coreEvent) {
		List<CoreEvent> CoreEvents = queryById(coreEvent.getEventId());
		if(CoreEvents !=null ){
			coreEvent=CoreEvents.get(0);
			if(coreEvent.getType()==null){
				coreEvent.setType("core");
			}else{
				coreEvent.setType(null);
			}
		}
		return coreEventMapper.updateCoreEvent(coreEvent);
	}

	/*根据事件ID查询*/
	@Override
	public List<CoreEvent> queryById(Integer eventId) {
		return coreEventMapper.queryById(eventId);
	}

	/*删除事件*/
	@Override
	public int deleteEvent(Integer eventId) {
		return coreEventMapper.deleteEvent(eventId);
	}

}
