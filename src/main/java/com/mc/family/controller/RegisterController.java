package com.mc.family.controller;

import com.mc.family.dto.RegisterReqDto;
import com.mc.family.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ChenglongChu
 * @description 注册相关服务接口
 * @create 2017/12/13 11:47
 * @since v0.1
 */
@Controller
@RequestMapping("/register")
public class RegisterController extends BaseController {
    @Autowired
    private RegisterService registerService;
    /**
     * @description 注册服务接口
     * @param request 请求参数
     * @param response 返回参数
     * @throws java.lang.Exception
     * @author ChenglongChu
     * @create 2017/12/13 14:03
    **/
    @RequestMapping(value="/insert", method = RequestMethod.POST)
    public void addRegister(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // step1: 开始, 获取输入参数
        RegisterReqDto reqDto = input(request, RegisterReqDto.class);
        // step2: 检查待添加用户用户信息是否合规
        registerService.checkBeforeAddUser(reqDto);
        // step3: 添加用户
        registerService.addUser(reqDto);
        // step4: 结束, 返回结果
        output(response, null);
    }
}

