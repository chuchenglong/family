package com.mc.family.dto;

import com.mc.family.vo.BaseVo;

/**
 * @author ChenglongChu
 * @description 登录请求DTO, 便于理解服务接口报文和接收请求输入
 * 所有DTO要集成BaseVo模型来序列化
 * 涉及的接口服务为:
 * LoginController.checkLogin
 * LoginController.queryMainInfoByUserId
 * @create 2018/01/24 18:26
 * @since v0.4
 */
public class LoginReqDto extends BaseVo {
    // 登录用户名/手机号/邮箱
    private String username;
    // 登录密码
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
