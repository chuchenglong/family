package com.mc.family.controller;

import com.mc.family.service.PublishService;
import com.mc.family.vo.SelectVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ChenglongChu
 * @description 公共相关服务接口
 * @create 2018/01/26 16:21
 * @since v0.4
 */
@Controller
@RequestMapping("/publish")
public class PublishController extends BaseController {
    @Autowired
    private PublishService publishService;

    @RequestMapping(value="/data", method = RequestMethod.POST)
    public void querySelectorDatasByParentCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
        SelectVo selectVo = input(request, SelectVo.class);
        selectVo = publishService.querySelectorDatasByParentCode(selectVo.getCode());
        output(response, selectVo);
    }
}
