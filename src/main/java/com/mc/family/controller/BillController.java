package com.mc.family.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ChenglongChu
 * @description 账单相关服务接口
 * @create 2018/01/19 11:20
 * @since v0.3
 */
@Controller
@RequestMapping("/bill")
public class BillController extends BaseController {
    /**
     * @description 账单新增服务接口
     * @param request 请求参数
     * @param response 返回参数
     * @throws java.lang.Exception
     * @author ChenglongChu
     * @create 2018/1/17 17:00
     **/
    @RequestMapping(value="/insert", method = RequestMethod.POST)
    public void addBill(HttpServletRequest request, HttpServletResponse response) throws Exception {

    }

    @RequestMapping(value="/listPage", method = RequestMethod.POST)
    public void queryBillListPageByUserId(HttpServletRequest request, HttpServletResponse response) throws Exception {

    }


    @RequestMapping(value="/list", method = RequestMethod.POST)
    public void queryBillListByUserId(HttpServletRequest request, HttpServletResponse response) throws Exception {

    }

}
