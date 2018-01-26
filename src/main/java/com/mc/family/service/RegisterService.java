package com.mc.family.service;

import com.mc.family.config.ConstantComm;
import com.mc.family.config.ConstantTips;
import com.mc.family.dto.RegisterReqDto;
import com.mc.family.mapper.PasswordInfoMapper;
import com.mc.family.mapper.UserInfoMapper;
import com.mc.family.model.PasswordInfo;
import com.mc.family.model.UserInfo;
import org.springframework.beans.BeanUtils;
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
    @Autowired
    private PasswordInfoMapper passwordInfoMapper;

    /**
     * @description 检查用户的合规性
     * 前台检查是为了用户的体验更友好，但前台传入数据默认是不可靠的，后台检查是为了数据的安全性
     * 1. 检查输入字段的合法性
     *   1) input数据不能为空
     *   2) 用户名不能为空
     *   3) 邮箱不能为空
     *   4) 电话不能为空
     * 2. 检查用户是否已存在
     * @param reqDto 待检查的用户信息
     * @throws java.lang.Exception
     * @author ChenglongChu
     * @create 2017/12/13 18:10
     **/
    public void checkBeforeAddUser(RegisterReqDto reqDto) throws Exception {
        // 检查输入字段
        if (null == reqDto) {
            throw new Exception(ConstantTips.INVALID_DATA);
        }
        if (StringUtils.isEmpty(reqDto.getUsername())) {
            throw new Exception(ConstantTips.NONE_USERNAME);
        }
        if (StringUtils.isEmpty(reqDto.getEmail())) {
            throw new Exception(ConstantTips.NONE_EMAIL);
        }
        if (StringUtils.isEmpty(reqDto.getPhone())) {
            throw new Exception(ConstantTips.NONE_PHONE);
        }

        // 检查用户是否已存在，包括用户名/邮箱/手机号
        int count = userInfoMapper.selectUserCountByContent(reqDto);
        if (count > 0) {
            throw new Exception(ConstantTips.USER_EXISTS);
        }
    }

    /**
     * @description 新增用户
     * @param reqDto 待添加的用户信息
     * @throws java.lang.Exception
     * @author ChenglongChu
     * @create 2017/12/13 18:10
    **/
    public void addUser(RegisterReqDto reqDto) throws Exception {
        // 保持新建内所有时间是一致的，必须先new时间，再做set
        Date nowDate = new Date();
        // 保存用户基本信息
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(reqDto, userInfo);
        // 普通注册用户设置为默认角色
        userInfo.setRoleId(ConstantComm.DEFAULT_ROLE);
        // 注册用户后状态为正常
        userInfo.setStatus(ConstantComm.USER_STATUS.NORMAL.getKey());
        userInfo.setCreateTime(nowDate);
        userInfo.setLastModifyTime(nowDate);
        userInfoMapper.insert(userInfo);

        // 保存用户登录密码信息
        PasswordInfo passwordInfo = new PasswordInfo();
        passwordInfo.setRelId(userInfo.getId());
        passwordInfo.setRelType(ConstantComm.NATIVE);
        passwordInfo.setPasswordType(ConstantComm.PASSWORD_TYPE.LOGIN.getKey());
        passwordInfo.setPassword(reqDto.getPassword());
        passwordInfo.setCreator(reqDto.getUsername());
        passwordInfo.setCreateTime(nowDate);
        passwordInfo.setUpdater(reqDto.getUsername());
        passwordInfo.setLastModifyTime(nowDate);
        passwordInfoMapper.insert(passwordInfo);
    }


}
