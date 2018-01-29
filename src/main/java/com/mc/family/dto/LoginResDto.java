package com.mc.family.dto;

import com.mc.family.vo.BaseVo;

/**
 * @author ChenglongChu
 * @description 登录返回DTO, 便于理解服务接口报文和精简返回输出
 * 所有DTO要集成BaseVo模型来序列化
 * 涉及的接口服务为:
 * LoginController.queryMainInfoByUserId
 * @create 2018/01/24 18:29
 * @since v0.4
 */
public class LoginResDto extends BaseVo {
    // 用户昵称
    private String username;

    // 个人头像
    private String photo;

    // 个人简介
    private String brief;

    // 最后登录时间
    // 角色对应功能权限
    // 一些其他需要加载展示的用户信息

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
}
