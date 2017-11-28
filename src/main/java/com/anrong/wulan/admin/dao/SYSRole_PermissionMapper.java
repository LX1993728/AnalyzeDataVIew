package com.anrong.wulan.admin.dao;

import com.anrong.wulan.admin.po.SYSRole_Permission;
import com.anrong.wulan.admin.po.SYSRole_PermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SYSRole_PermissionMapper {
    int countByExample(SYSRole_PermissionExample example);

    int deleteByExample(SYSRole_PermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SYSRole_Permission record);

    int insertSelective(SYSRole_Permission record);

    List<SYSRole_Permission> selectByExample(SYSRole_PermissionExample example);

    SYSRole_Permission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SYSRole_Permission record, @Param("example") SYSRole_PermissionExample example);

    int updateByExample(@Param("record") SYSRole_Permission record, @Param("example") SYSRole_PermissionExample example);

    int updateByPrimaryKeySelective(SYSRole_Permission record);

    int updateByPrimaryKey(SYSRole_Permission record);
}