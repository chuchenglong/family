package com.mc.family.mapper;

import com.mc.family.model.AccountInfo;
import java.util.List;

public interface AccountInfoMapper {
    int deleteByPrimaryKey(Integer accountId);

    int insert(AccountInfo record);

    AccountInfo selectByPrimaryKey(Integer accountId);

    List<AccountInfo> selectAll();

    int updateByPrimaryKey(AccountInfo record);

    List<AccountInfo> selectAccountListPageByUserId(AccountInfo accountInfo);

    int selectAccountListPageCountByUserId(AccountInfo accountInfo);
}