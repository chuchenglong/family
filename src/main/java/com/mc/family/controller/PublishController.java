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

    /**
     * @description 根据code查询下拉框数据服务接口
     * @param request 请求参数
     * @param response 返回参数
     * @throws java.lang.Exception
     * @author ChenglongChu
     * @create 2018/1/30 18:08
    **/
    @RequestMapping(value="/data", method = RequestMethod.POST)
    public void querySelectorDatasByParentCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // step1: 开始, 获取输入参数
        SelectVo selectVo = input(request, SelectVo.class);
        // step2: 根据父节点code查询数据内容
        selectVo = publishService.querySelectorDatasByParentCode(selectVo.getCode());
        // step3: 结束, 返回结果
        output(response, selectVo);
    }
}
