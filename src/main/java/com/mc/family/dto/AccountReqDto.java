package com.mc.family.dto;

import com.mc.family.vo.BaseVo;
import com.mc.family.vo.PageVo;

/**
 * @author ChenglongChu
 * @description 日常账户管理请求DTO, 便于理解服务接口报文和接收请求输入
 * 所有DTO要集成BaseVo模型来序列化
 * 涉及的接口服务为:
 * AccountController.addAccount
 * @create 2018/01/25 14:47
 * @since v0.4
 */
public class AccountReqDto extends PageVo {
    private String username;

    private String phone;

    private String email;

    private String company;

    private String product;

    private String classify;

    private String alias;

    private String description;

    private Integer relId;

    private String loginPassword;

    private String queryPassword;

    private String dealPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRelId() {
        return relId;
    }

    public void setRelId(Integer relId) {
        this.relId = relId;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getQueryPassword() {
        return queryPassword;
    }

    public void setQueryPassword(String queryPassword) {
        this.queryPassword = queryPassword;
    }

    public String getDealPassword() {
        return dealPassword;
    }

    public void setDealPassword(String dealPassword) {
        this.dealPassword = dealPassword;
    }
}
