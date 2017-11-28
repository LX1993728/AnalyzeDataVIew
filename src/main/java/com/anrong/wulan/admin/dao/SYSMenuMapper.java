package com.anrong.wulan.admin.dao;

import com.anrong.wulan.admin.po.SYSMenu;
import com.anrong.wulan.admin.po.SYSMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SYSMenuMapper {
    int countByExample(SYSMenuExample example);

    int deleteByExample(SYSMenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SYSMenu record);

    int insertSelective(SYSMenu record);

    List<SYSMenu> selectByExample(SYSMenuExample example);

    SYSMenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SYSMenu record, @Param("example") SYSMenuExample example);

    int updateByExample(@Param("record") SYSMenu record, @Param("example") SYSMenuExample example);

    int updateByPrimaryKeySelective(SYSMenu record);

    int updateByPrimaryKey(SYSMenu record);

	List<String> getAllMenuNames();
}