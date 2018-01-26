package com.mc.family.controller;

import com.mc.family.dto.LoginReqDto;
import com.mc.family.dto.LoginResDto;
import com.mc.family.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
        LoginReqDto reqDto = input(request, LoginReqDto.class);
        // step2: 用户登录验证
        int userId = loginService.checkLogin(reqDto);
        // step3: 结束, 返回结果
        output(response, userId);
    }

    /**
     * @description 主页面数据服务接口
     * 根据用户ID查询需要加载的主页面信息
     * @param request 请求参数
     * @param response 返回参数
     * @throws java.lang.Exception
     * @author ChenglongChu
     * @create 2017/12/14 14:09
     **/
    @RequestMapping(value="/main", method = RequestMethod.POST)
    public void queryMainInfoByUserId(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // step1: 开始, 获取输入参数, 即userId
        LoginReqDto reqDto = input(request, LoginReqDto.class);
        // step2: 查询用户信息
        LoginResDto resDto = loginService.queryMainInfoByUserId(reqDto.getUserId());
        // step3: 结束, 返回结果
        output(response, resDto);
    }

}
