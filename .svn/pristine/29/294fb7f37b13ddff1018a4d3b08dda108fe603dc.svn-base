package com.anrong.wulan.admin.dao;

import com.anrong.wulan.admin.po.StaticGroup;
import com.anrong.wulan.admin.po.StaticGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StaticGroupMapper {
    int countByExample(StaticGroupExample example);

    int deleteByExample(StaticGroupExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StaticGroup record);

    int insertSelective(StaticGroup record);

    List<StaticGroup> selectByExample(StaticGroupExample example);

    StaticGroup selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StaticGroup record, @Param("example") StaticGroupExample example);

    int updateByExample(@Param("record") StaticGroup record, @Param("example") StaticGroupExample example);

    int updateByPrimaryKeySelective(StaticGroup record);

    int updateByPrimaryKey(StaticGroup record);
}