package com.anrong.wulan.admin.service;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.StartUser;
import com.anrong.wulan.core.generic.GenericService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface StartDistributeService extends GenericService<StartUser, Long> {

	StartUser queryTop10StartDistribute(Map<String, Object> map);

	List<StartUser> listRetent(Map<String, Object> params);

	List<StartUser> listAllAvg(Map<String, Object> params);

	List<StartUser> queryStartDistribute(Map<String, Object> params, PageBounds pageBounds);
}
