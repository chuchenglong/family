package com.mc.family.mapper;

import com.mc.family.model.DataInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DataInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DataInfo record);

    DataInfo selectByPrimaryKey(Integer id);

    List<DataInfo> selectAll();

    int updateByPrimaryKey(DataInfo record);

    List<DataInfo> selectDatasByParentCode(@Param("code") String code);
}