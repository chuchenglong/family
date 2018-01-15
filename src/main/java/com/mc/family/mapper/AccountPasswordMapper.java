package com.mc.family.mapper;

import com.mc.family.model.AccountPassword;
import java.util.List;

public interface AccountPasswordMapper {
    int deleteByPrimaryKey(Integer passwordId);

    int insert(AccountPassword record);

    AccountPassword selectByPrimaryKey(Integer passwordId);

    List<AccountPassword> selectAll();

    int updateByPrimaryKey(AccountPassword record);
}