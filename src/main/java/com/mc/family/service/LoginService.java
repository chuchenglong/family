package com.mc.family.service;

import com.mc.family.config.ConstantComm;
import com.mc.family.config.ConstantTips;
import com.mc.family.dto.LoginReqDto;
import com.mc.family.dto.LoginResDto;
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
     * @param reqDto 登录的用户信息
     * @throws java.lang.Exception
     * @author ChenglongChu
     * @create 2017/12/14 17:57
    **/
    public int checkLogin(LoginReqDto reqDto) throws Exception {
        // 检查传入数据为空
        if (null == reqDto) {
            throw new Exception(ConstantTips.INVALID_DATA);
        }
        // 检查传入用户名是否为空
        if (StringUtils.isEmpty(reqDto.getUsername())) {
            throw new Exception(ConstantTips.NONE_USERNAME);
        }
        // 检查传入登录密码是否为空
        if (StringUtils.isEmpty(reqDto.getPassword())) {
            throw new Exception(ConstantTips.NONE_LOGIN_PASSWORD);
        }
        // 通过登录信息获取用户信息, 登录信息可为用户名, 邮箱和手机号
        Integer userId = userInfoMapper.selectUserLoginByContent(reqDto);
        // 检查用户是否存在
        if (null == userId) {
            throw new Exception(ConstantTips.WRONG_USERNAME_OR_PASSWORD);
        }
        return userId;
    }

    /**
     * @description 获取主页面加载数据
     * @param userId 用户ID
     * @throws java.lang.Exception
     * @author ChenglongChu
     * @create 2018/1/26 14:23
    **/
    public LoginResDto queryMainInfoByUserId(Integer userId) throws Exception {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);
        // 若用户不存在, 则非法异常处理
        if (null == userInfo) {
            throw new Exception(ConstantTips.USER_QUERY_ERROR);
        }

        LoginResDto resDto = new LoginResDto();
        resDto.setUserId(userId);

        // 用户名称, 若有昵称, 则显示昵称
        if (StringUtils.isEmpty(userInfo.getAlias())) {
            resDto.setUsername(userInfo.getUsername());
        } else {
            resDto.setUsername(userInfo.getAlias());
        }

        // 用户简介, 若无简介, 则显示系统默认简介
        if (StringUtils.isEmpty(userInfo.getBrief())) {
            resDto.setBrief(ConstantComm.DEFAULT_BRIEF);
        } else {
            resDto.setBrief(userInfo.getBrief());
        }

        // 用户头像, 若无头像, 则显示系统默认头像
        if (StringUtils.isEmpty(userInfo.getPhoto())) {
            resDto.setPhoto(ConstantComm.DEFAULT_PHOTO);
        } else {
            resDto.setPhoto(userInfo.getPhoto());
        }
        return resDto;
    }
}
