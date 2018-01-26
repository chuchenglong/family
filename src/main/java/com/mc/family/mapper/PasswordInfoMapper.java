package com.mc.family.mapper;

import com.mc.family.model.PasswordInfo;
import java.util.List;

public interface PasswordInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PasswordInfo record);

    PasswordInfo selectByPrimaryKey(Integer id);

    List<PasswordInfo> selectAll();

    int updateByPrimaryKey(PasswordInfo record);
}