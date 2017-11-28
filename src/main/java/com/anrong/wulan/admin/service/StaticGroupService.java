package com.anrong.wulan.admin.service;
import com.anrong.wulan.admin.po.StaticGroup;
import com.anrong.wulan.admin.vo.StaticGroupVO;
import com.anrong.wulan.core.util.Page;

public interface StaticGroupService {

    // 根据条件查询群组
	Page<StaticGroup> getGroupsByCriteria(StaticGroupVO staticGroupVO);
	
	// 删除群组
	Boolean deleteGroup(Integer id);
	//新建群
	Boolean addGroupByGroupVO(StaticGroupVO staticGroupVO);
	//修改回显
	StaticGroup getGoupByID(Long id);
	//修改
	Boolean updateGroupByGroupVO(StaticGroupVO groupVO);
}
