package com.mc.family.mapper;

import com.mc.family.dto.LoginReqDto;
import com.mc.family.dto.LoginResDto;
import com.mc.family.dto.RegisterReqDto;
import com.mc.family.model.UserInfo;
import java.util.List;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    List<UserInfo> selectAll();

    int updateByPrimaryKey(UserInfo record);

    // 根据用户名/手机号/邮箱, 检查用户登录信息, 返回用户的userId
    int selectUserLoginByContent(LoginReqDto reqDto);
    // 根据用户名/手机号/邮箱, 检查用户是否存在
    int selectUserCountByContent(RegisterReqDto reqDto);

}