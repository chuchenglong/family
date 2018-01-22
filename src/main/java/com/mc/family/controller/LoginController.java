package com.mc.family.controller;

import com.mc.family.model.UserInfo;
import com.mc.family.service.LoginService;
import com.mc.family.vo.BaseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ChenglongChu
 * @description 登录相关服务接口
 * @create 2017/12/14 14:07
 * @since v0.1
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {
    @Autowired
    private LoginService loginService;
    /**
     * @description 登录服务接口
     * @param request 请求参数
     * @param response 返回参数
     * @throws java.lang.Exception
     * @author ChenglongChu
     * @create 2017/12/14 14:09
    **/
    @RequestMapping(value="/check", method = RequestMethod.POST)
    public void checkLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // step1: 开始, 获取输入参数
        UserInfo userInfo = input(request, UserInfo.class);
        // step2: 用户登录验证
        userInfo = loginService.checkLogin(userInfo);
        // step3: 结束, 返回结果
        output(response, userInfo);
    }

    /**
     * @description 根据用户ID查询用户信息服务接口
     * @param request 请求参数
     * @param response 返回参数
     * @throws java.lang.Exception
     * @author ChenglongChu
     * @create 2017/12/14 14:09
     **/
    @RequestMapping(value="/queryUserByUserId", method = RequestMethod.POST)
    public void queryUserByUserId(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // step1: 开始, 获取输入参数
        UserInfo userInfo = input(request, UserInfo.class);
        // step2: 查询用户信息
        userInfo = loginService.queryUserByUserId(userInfo.getUserId());
        // step3: 结束, 返回结果
        output(response, userInfo);
    }

}
