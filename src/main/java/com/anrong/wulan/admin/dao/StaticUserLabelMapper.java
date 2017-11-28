package com.anrong.wulan.admin.dao;

import com.anrong.wulan.admin.po.StaticUserLabel;
import com.anrong.wulan.admin.po.StaticUserLabelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StaticUserLabelMapper {
    int countByExample(StaticUserLabelExample example);

    int deleteByExample(StaticUserLabelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StaticUserLabel record);

    int insertSelective(StaticUserLabel record);

    List<StaticUserLabel> selectByExample(StaticUserLabelExample example);

    StaticUserLabel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StaticUserLabel record, @Param("example") StaticUserLabelExample example);

    int updateByExample(@Param("record") StaticUserLabel record, @Param("example") StaticUserLabelExample example);

    int updateByPrimaryKeySelective(StaticUserLabel record);

    int updateByPrimaryKey(StaticUserLabel record);
}