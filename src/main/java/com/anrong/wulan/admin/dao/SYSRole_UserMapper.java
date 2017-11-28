package com.anrong.wulan.admin.dao;

import com.anrong.wulan.admin.po.SYSRole_User;
import com.anrong.wulan.admin.po.SYSRole_UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SYSRole_UserMapper {
    int countByExample(SYSRole_UserExample example);

    int deleteByExample(SYSRole_UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SYSRole_User record);

    int insertSelective(SYSRole_User record);

    List<SYSRole_User> selectByExample(SYSRole_UserExample example);

    SYSRole_User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SYSRole_User record, @Param("example") SYSRole_UserExample example);

    int updateByExample(@Param("record") SYSRole_User record, @Param("example") SYSRole_UserExample example);

    int updateByPrimaryKeySelective(SYSRole_User record);

    int updateByPrimaryKey(SYSRole_User record);
}