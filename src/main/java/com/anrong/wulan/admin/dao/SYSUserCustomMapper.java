package com.anrong.wulan.admin.dao;

import java.util.List;

import com.anrong.wulan.admin.po.User;
import com.anrong.wulan.admin.vo.SYSUserVO;
/**
 * 系统用户的管理维护-业务逻辑
 * @author liuxun
 *
 */
public interface SYSUserCustomMapper {
	//获取符合条件的用户记录总数量
	Integer findUserCountByCriteria(SYSUserVO sysUserVO);
	// 获取符合条件的 用户记录数据
	List<User> findUserListByCriteria(SYSUserVO sysUserVO);
	// 根据用户名查询存在的数量
	Long getCountByUserName(String userName);
}
