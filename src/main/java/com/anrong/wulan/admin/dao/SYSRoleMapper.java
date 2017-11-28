package com.anrong.wulan.admin.dao;

import com.anrong.wulan.admin.po.SYSRole;
import com.anrong.wulan.admin.po.SYSRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SYSRoleMapper {
    int countByExample(SYSRoleExample example);

    int deleteByExample(SYSRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SYSRole record);

    int insertSelective(SYSRole record);

    List<SYSRole> selectByExample(SYSRoleExample example);

    SYSRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SYSRole record, @Param("example") SYSRoleExample example);

    int updateByExample(@Param("record") SYSRole record, @Param("example") SYSRoleExample example);

    int updateByPrimaryKeySelective(SYSRole record);

    int updateByPrimaryKey(SYSRole record);
}