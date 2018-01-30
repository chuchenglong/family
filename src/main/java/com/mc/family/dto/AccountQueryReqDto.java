package com.mc.family.dto;

import com.mc.family.vo.PageVo;

import java.util.List;

/**
 * @author ChenglongChu
 * @description 日常账户查询请求DTO, 便于理解服务接口报文和接收请求输入
 * 所有DTO要集成BaseVo模型来序列化
 * 涉及的接口服务为:
 * AccountController.queryAccountListPageByUserId
 * @create 2018/01/30 15:00
 * @since v0.4
 */
public class AccountQueryReqDto extends PageVo {
    private String username;

    private List<String> companyList;

    private List<String> classifyList;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<String> companyList) {
        this.companyList = companyList;
    }

    public List<String> getClassifyList() {
        return classifyList;
    }

    public void setClassifyList(List<String> classifyList) {
        this.classifyList = classifyList;
    }
}
