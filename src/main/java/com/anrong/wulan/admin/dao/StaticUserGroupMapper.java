package com.anrong.wulan.admin.dao;

import com.anrong.wulan.admin.po.StaticUserGroup;
import com.anrong.wulan.admin.po.StaticUserGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StaticUserGroupMapper {
    int countByExample(StaticUserGroupExample example);

    int deleteByExample(StaticUserGroupExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StaticUserGroup record);

    int insertSelective(StaticUserGroup record);

    List<StaticUserGroup> selectByExample(StaticUserGroupExample example);

    StaticUserGroup selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StaticUserGroup record, @Param("example") StaticUserGroupExample example);

    int updateByExample(@Param("record") StaticUserGroup record, @Param("example") StaticUserGroupExample example);

    int updateByPrimaryKeySelective(StaticUserGroup record);

    int updateByPrimaryKey(StaticUserGroup record);
}