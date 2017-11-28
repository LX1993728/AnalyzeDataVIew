package com.anrong.wulan.admin.dao;

import com.anrong.wulan.admin.po.StaticLabel;
import com.anrong.wulan.admin.po.StaticLabelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StaticLabelMapper {
    int countByExample(StaticLabelExample example);

    int deleteByExample(StaticLabelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StaticLabel record);

    int insertSelective(StaticLabel record);

    List<StaticLabel> selectByExample(StaticLabelExample example);

    StaticLabel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StaticLabel record, @Param("example") StaticLabelExample example);

    int updateByExample(@Param("record") StaticLabel record, @Param("example") StaticLabelExample example);

    int updateByPrimaryKeySelective(StaticLabel record);

    int updateByPrimaryKey(StaticLabel record);
}