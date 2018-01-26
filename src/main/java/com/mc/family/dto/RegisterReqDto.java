package com.mc.family.dto;

import com.mc.family.vo.BaseVo;

/**
 * @author ChenglongChu
 * @description 注册请求DTO, 便于理解服务接口报文和接收请求输入
 * 所有DTO要集成BaseVo模型来序列化
 * 涉及的接口服务为:
 * RegisterController.addRegister
 * @create 2018/01/25 14:22
 * @since v0.4
 */
public class RegisterReqDto extends BaseVo {
    // 用户名
    private String username;

    // 邮箱
    private String email;

    // 手机号
    private String phone;

    // 昵称
    private String alias;

    // 性别
    private String gender;

    // 个人头像
    private String photo;

    // 个人简介
    private String brief;

    // 登录密码
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
