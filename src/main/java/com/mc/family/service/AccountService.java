package com.mc.family.service;

import com.mc.family.config.ConstantComm;
import com.mc.family.dto.AccountQueryReqDto;
import com.mc.family.dto.AccountQueryResDto;
import com.mc.family.dto.AccountReqDto;
import com.mc.family.mapper.AccountInfoMapper;
import com.mc.family.mapper.PasswordInfoMapper;
import com.mc.family.model.AccountInfo;
import com.mc.family.model.PasswordInfo;
import com.mc.family.vo.BaseVo;
import com.mc.family.vo.PageVo;
import com.mc.family.vo.SelectVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

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
    @Autowired
    private PasswordInfoMapper passwordInfoMapper;

    /**
     * @description 新增生活账户
     * @param reqDto 添加的生活账户信息
     * @throws java.lang.Exception
     * @author ChenglongChu
     * @create 2018/1/26 14:52
    **/
    public void addAccount(AccountReqDto reqDto) throws Exception {
        // 保持新建内所有时间是一致的，必须先new时间，再做set
        Date nowDate = new Date();
        // 添加生活账户信息
        AccountInfo accountInfo = new AccountInfo();
        BeanUtils.copyProperties(reqDto, accountInfo);
        accountInfo.setCreator(reqDto.getUserId().toString());
        accountInfo.setCreateTime(nowDate);
        accountInfo.setUpdater(reqDto.getUserId().toString());
        accountInfo.setLastModifyTime(nowDate);
        accountInfoMapper.insert(accountInfo);

        // 添加登录密码信息
        if (!StringUtils.isEmpty(reqDto.getLoginPassword())) {
            PasswordInfo passwordInfo = new PasswordInfo();
            passwordInfo.setRelId(accountInfo.getId());
            passwordInfo.setRelType(ConstantComm.OTHER);
            passwordInfo.setPasswordType(ConstantComm.PASSWORD_TYPE.LOGIN.getKey());
            passwordInfo.setPassword(reqDto.getLoginPassword());
            passwordInfo.setCreator(reqDto.getUserId().toString());
            passwordInfo.setCreateTime(nowDate);
            passwordInfo.setUpdater(reqDto.getUserId().toString());
            passwordInfo.setLastModifyTime(nowDate);
            passwordInfoMapper.insert(passwordInfo);
        }

        // 添加查询密码信息
        if (!StringUtils.isEmpty(reqDto.getQueryPassword())) {
            PasswordInfo passwordInfo = new PasswordInfo();
            passwordInfo.setRelId(accountInfo.getId());
            passwordInfo.setRelType(ConstantComm.OTHER);
            passwordInfo.setPasswordType(ConstantComm.PASSWORD_TYPE.QUERY.getKey());
            passwordInfo.setPassword(reqDto.getQueryPassword());
            passwordInfo.setCreator(reqDto.getUserId().toString());
            passwordInfo.setCreateTime(nowDate);
            passwordInfo.setUpdater(reqDto.getUserId().toString());
            passwordInfo.setLastModifyTime(nowDate);
            passwordInfoMapper.insert(passwordInfo);
        }

        // 添加交易密码信息
        if (!StringUtils.isEmpty(reqDto.getDealPassword())) {
            PasswordInfo passwordInfo = new PasswordInfo();
            passwordInfo.setRelId(accountInfo.getId());
            passwordInfo.setRelType(ConstantComm.OTHER);
            passwordInfo.setPasswordType(ConstantComm.PASSWORD_TYPE.DEAL.getKey());
            passwordInfo.setPassword(reqDto.getDealPassword());
            passwordInfo.setCreator(reqDto.getUserId().toString());
            passwordInfo.setCreateTime(nowDate);
            passwordInfo.setUpdater(reqDto.getUserId().toString());
            passwordInfo.setLastModifyTime(nowDate);
            passwordInfoMapper.insert(passwordInfo);
        }
    }

    /**
     * @description 根据用户ID分页查询生活账户信息
     * @param reqDto 查询条件
     * @return PageVo 查询结果
     * @throws java.lang.Exception
     * @author ChenglongChu
     * @create 2018/1/30 18:27
    **/
    public PageVo queryAccountListPageByUserId(AccountQueryReqDto reqDto) throws Exception {
        // 查询条件数据
        List<AccountQueryResDto> list =  accountInfoMapper.selectAccountListPageByUserId(reqDto);
        // 查询条件总数
        int total = accountInfoMapper.selectAccountListPageCountByUserId(reqDto);
        // 将结果数据放入分页模型
        PageVo pageVo = new PageVo();
        pageVo.setTotal(total);
        pageVo.setRows(list);
        return pageVo;
    }

    /**
     * @description 查询用户下关联账户列表信息
     * @param reqDto 查询条件
     * @return SelectVo 查询结果
     * @throws java.lang.Exception
     * @author ChenglongChu
     * @create 2018/1/30 18:29
    **/
    public SelectVo queryAccountListRelByUserId(BaseVo reqDto) throws Exception {
        List<AccountInfo> accountInfos =  accountInfoMapper.selectAccountListRelByUserId(reqDto.getUserId());
        List<Map<String, String>> selects = new ArrayList<>();
        for (AccountInfo accountInfo : accountInfos) {
            Map<String, String> select = new HashMap<>();
            select.put(ConstantComm.STRING_KEY, accountInfo.getId().toString());
            select.put(ConstantComm.STRING_VALUE, accountInfo.getUsername());
            selects.add(select);
        }
        SelectVo selectVo = new SelectVo();
        selectVo.setSelects(selects);
        return selectVo;
    }
}
