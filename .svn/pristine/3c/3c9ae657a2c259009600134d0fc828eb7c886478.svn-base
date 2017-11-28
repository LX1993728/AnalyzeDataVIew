package com.anrong.wulan.admin.dao;

import com.anrong.wulan.admin.po.StaticUserEvent;
import com.anrong.wulan.admin.po.StaticUserEventExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StaticUserEventMapper {
    int countByExample(StaticUserEventExample example);

    int deleteByExample(StaticUserEventExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StaticUserEvent record);

    int insertSelective(StaticUserEvent record);

    List<StaticUserEvent> selectByExample(StaticUserEventExample example);

    StaticUserEvent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StaticUserEvent record, @Param("example") StaticUserEventExample example);

    int updateByExample(@Param("record") StaticUserEvent record, @Param("example") StaticUserEventExample example);

    int updateByPrimaryKeySelective(StaticUserEvent record);

    int updateByPrimaryKey(StaticUserEvent record);
}