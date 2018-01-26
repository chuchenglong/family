package com.mc.family.controller;

import com.mc.family.dto.AccountReqDto;
import com.mc.family.service.AccountService;
import com.mc.family.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ChenglongChu
 * @description 账户相关服务接口
 * @create 2017/12/22 15:01
 * @since v0.1
 */
@Controller
@RequestMapping("/account")
public class AccountController extends BaseController {
    @Autowired
    private AccountService accountService;

    /**
     * @description 账户新增服务接口
     * @param request 请求参数
     * @param response 返回参数
     * @throws java.lang.Exception
     * @author ChenglongChu
     * @create 2018/1/17 17:00
     **/
    @RequestMapping(value="/insert", method = RequestMethod.POST)
    public void addAccount(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // step1: 处理请求参数, 添加内容
        AccountReqDto reqDto = input(request, AccountReqDto.class);
        // step2: 检查待添加账户信息, 待后续实现
//        accountService.checkBeforeAddAccount(accountInfo);
        // step3: 新增账户信息
        accountService.addAccount(reqDto);
        // step4: 结束, 返回结果
        output(response, null);
    }

    /**
     * @description 账户列表分页条件查询服务接口
     * @param request 请求参数
     * @param response 返回参数
     * @throws java.lang.Exception
     * @author ChenglongChu
     * @create 2017/12/22 15:04
    **/
    @RequestMapping(value="/listPage", method = RequestMethod.POST)
    public void queryAccountListPageByUserId(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // step1: 处理请求参数, 包括查询条件
        AccountReqDto reqDto = input(request, AccountReqDto.class);
        // step2: 根据用户ID分页查询用户下账户列表
        PageVo pageVo = accountService.queryAccountListPageByUserId(reqDto);
        // step3: 结束, 返回结果
        commOutput(response, pageVo);
    }



}
