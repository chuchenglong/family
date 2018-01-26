package com.mc.family.mapper;

import com.mc.family.dto.AccountReqDto;
import com.mc.family.model.AccountInfo;

import java.util.List;

public interface AccountInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AccountInfo record);

    AccountInfo selectByPrimaryKey(Integer id);

    List<AccountInfo> selectAll();

    int updateByPrimaryKey(AccountInfo record);

    List<AccountInfo> selectAccountListPageByUserId(AccountReqDto reqDto);

    int selectAccountListPageCountByUserId(AccountReqDto reqDto);
}