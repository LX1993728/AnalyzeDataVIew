package com.anrong.wulan.admin.dao;

import com.anrong.wulan.admin.po.SYSPermission;
import com.anrong.wulan.admin.po.SYSPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SYSPermissionMapper {
    int countByExample(SYSPermissionExample example);

    int deleteByExample(SYSPermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SYSPermission record);

    int insertSelective(SYSPermission record);

    List<SYSPermission> selectByExample(SYSPermissionExample example);

    SYSPermission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SYSPermission record, @Param("example") SYSPermissionExample example);

    int updateByExample(@Param("record") SYSPermission record, @Param("example") SYSPermissionExample example);

    int updateByPrimaryKeySelective(SYSPermission record);

    int updateByPrimaryKey(SYSPermission record);

    // 获取所有的资源编码
	List<String> getAllCodes();
}