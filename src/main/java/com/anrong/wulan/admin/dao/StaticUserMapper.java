package com.anrong.wulan.admin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.anrong.wulan.admin.po.StaticUser;
import com.anrong.wulan.admin.po.StaticUserExample;

public interface StaticUserMapper {
	int countByExample(StaticUserExample example);

	int deleteByExample(StaticUserExample example);

	int deleteByPrimaryKey(Long id);

	int insert(StaticUser record);

	int insertSelective(StaticUser record);

	List<StaticUser> selectByExample(StaticUserExample example);

	StaticUser selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") StaticUser record,
			@Param("example") StaticUserExample example);

	int updateByExample(@Param("record") StaticUser record,
			@Param("example") StaticUserExample example);

	int updateByPrimaryKeySelective(StaticUser record);

	int updateByPrimaryKey(StaticUser record);
}