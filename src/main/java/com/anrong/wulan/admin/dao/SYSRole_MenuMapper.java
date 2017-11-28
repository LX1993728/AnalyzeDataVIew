package com.anrong.wulan.admin.dao;

import com.anrong.wulan.admin.po.SYSRole_Menu;
import com.anrong.wulan.admin.po.SYSRole_MenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SYSRole_MenuMapper {
    int countByExample(SYSRole_MenuExample example);

    int deleteByExample(SYSRole_MenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SYSRole_Menu record);

    int insertSelective(SYSRole_Menu record);

    List<SYSRole_Menu> selectByExample(SYSRole_MenuExample example);

    SYSRole_Menu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SYSRole_Menu record, @Param("example") SYSRole_MenuExample example);

    int updateByExample(@Param("record") SYSRole_Menu record, @Param("example") SYSRole_MenuExample example);

    int updateByPrimaryKeySelective(SYSRole_Menu record);

    int updateByPrimaryKey(SYSRole_Menu record);
}