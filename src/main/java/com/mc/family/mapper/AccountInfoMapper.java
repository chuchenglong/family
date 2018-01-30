package com.mc.family.mapper;

import com.mc.family.dto.AccountQueryReqDto;
import com.mc.family.dto.AccountQueryResDto;
import com.mc.family.model.AccountInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AccountInfo record);

    AccountInfo selectByPrimaryKey(Integer id);

    List<AccountInfo> selectAll();

    int updateByPrimaryKey(AccountInfo record);

    List<AccountQueryResDto> selectAccountListPageByUserId(AccountQueryReqDto reqDto);

    int selectAccountListPageCountByUserId(AccountQueryReqDto reqDto);

    List<AccountInfo> selectAccountListRelByUserId(@Param("userId") Integer userId);
}