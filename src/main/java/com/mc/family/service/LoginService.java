package com.mc.family.service;

import com.mc.family.config.ConstantTips;
import com.mc.family.mapper.UserInfoMapper;
import com.mc.family.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author ChenglongChu
 * @description 登录相关原子服务实现
 * @create 2017/12/14 14:09
 * @since v0.1
 */
@Service
public class LoginService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * @description 登录检查
     * @param userInfo 登录的用户信息
     * @throws java.lang.Exception
     * @author ChenglongChu
     * @create 2017/12/14 17:57
    **/
    public UserInfo checkLogin(UserInfo userInfo) throws Exception {
        // 检查传入数据为空
        if (null == userInfo) {
            throw new Exception(ConstantTips.INVALID_DATA);
        }
        // 检查传入用户名是否为空
        if (StringUtils.isEmpty(userInfo.getUsername())) {
            throw new Exception(ConstantTips.NONE_USERNAME);
        }
        // 检查传入登录密码是否为空
        if (StringUtils.isEmpty(userInfo.getLoginPassword())) {
            throw new Exception(ConstantTips.NONE_LOGIN_PASSWORD);
        }
        // 用户账户可为用户名、邮箱和手机号，将入参username分别放入email和phone中
        userInfo.setEmail(userInfo.getUsername());
        userInfo.setPhone(userInfo.getPhone());
        // 通过用户账户获取用户信息
        UserInfo user = userInfoMapper.selectUserByContent(userInfo);
        // 检查用户是否存在
        if (null == user) {
            throw new Exception(ConstantTips.USER_NOT_EXISTS);
        }
        // 检查用户登录密码是否正确
        if (!userInfo.getLoginPassword().equals(user.getLoginPassword())) {
            throw new Exception(ConstantTips.PASSWORD_WRONG);
        }
        return user;
    }

    public UserInfo queryUserByUserId(Integer userId) {
        return userInfoMapper.selectByPrimaryKey(userId);
    }
}
