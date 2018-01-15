package com.mc.family.service;

import com.mc.family.mapper.AccountInfoMapper;
import com.mc.family.model.AccountInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ChenglongChu
 * @description 账户相关原子服务实现
 * @create 2017/12/22 15:03
 * @since v0.1
 */
@Service
public class AccountService {
    @Autowired
    private AccountInfoMapper accountInfoMapper;
    public List<AccountInfo> queryAccountListWithPage() {
        return accountInfoMapper.selectAll();
    }
}
