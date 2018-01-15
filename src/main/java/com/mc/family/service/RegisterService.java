package com.mc.family.service;

import com.mc.family.config.ConstantComm;
import com.mc.family.config.ConstantTips;
import com.mc.family.mapper.UserInfoMapper;
import com.mc.family.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * @author ChenglongChu
 * @description 注册相关原子服务实现
 * @create 2017/12/13 17:30
 * @since v0.1
 */
@Service
public class RegisterService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * @description 新增用户
     * @param userInfo 待添加的用户信息
     * @throws java.lang.Exception
     * @author ChenglongChu
     * @create 2017/12/13 18:10
    **/
    public void addUser(UserInfo userInfo) throws Exception {
        // 保持新建和修改时间是一致的，必须先new时间，再做set
        Date nowDate = new Date();
        userInfo.setCreateTime(nowDate);
        userInfo.setLastModifyTime(nowDate);
        // 普通注册用户设置为默认角色
        userInfo.setRoleId(ConstantComm.DEFAULT_ROLE);
        userInfoMapper.insert(userInfo);
    }

    /**
     * @description 检查用户的合规性
     * 前台检查是为了用户的体验更友好，但前台传入数据默认是不可靠的，后台检查是为了数据的安全性
     * 1) 检查输入字段的合法性
     * 2) 检查用户是否已存在
     * @param userInfo 待检查的用户信息
     * @throws java.lang.Exception
     * @author ChenglongChu
     * @create 2017/12/13 18:10
    **/
    public void checkBeforeAddUser(UserInfo userInfo) throws Exception {
        // step1: 检查输入字段
        if (null == userInfo) {
            throw new Exception(ConstantTips.INVALID_DATA);
        }
        if (StringUtils.isEmpty(userInfo.getUsername())) {
            throw new Exception(ConstantTips.NONE_USERNAME);
        }
        if (StringUtils.isEmpty(userInfo.getEmail())) {
            throw new Exception(ConstantTips.NONE_EMAIL);
        }
        if (StringUtils.isEmpty(userInfo.getPhone())) {
            throw new Exception(ConstantTips.NONE_PHONE);
        }

        // step2: 检查用户是否已存在，包括用户名/邮箱/手机号
        UserInfo user = userInfoMapper.selectUserByContent(userInfo);
        if (null != user) {
            throw new Exception(ConstantTips.USER_EXISTS);
        }
    }
}
