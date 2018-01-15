package com.mc.family.controller;

import com.alibaba.fastjson.JSONObject;
import com.mc.family.config.ConstantComm;
import com.mc.family.config.ManagerResult;
import com.mc.family.model.AccountInfo;
import com.mc.family.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ChenglongChu
 * @description 账户相关接口服务
 * @create 2017/12/22 15:01
 * @since v0.1
 */
@Controller
@RequestMapping("/account")
public class AccountController extends BaseController {
    @Autowired
    private AccountService accountService;

    /**
     * @description 账户列表查询接口
     * @param request 请求参数
     * @param response 返回参数
     * @throws java.lang.Exception
     * @author ChenglongChu
     * @create 2017/12/22 15:04
    **/
    @RequestMapping(value="/listWithPage", method = RequestMethod.POST)
    public void queryAccountListWithPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<AccountInfo> list = accountService.queryAccountListWithPage();
        output(response, list);
    }

    @RequestMapping(value="/aaa", method = RequestMethod.POST)
    public void aaa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("aaa","1111111");
        map.put("bbb","1111");
        map.put("ccc","111111");
        list.add(map);

        Map<String, String> map2 = new HashMap<>();
        map2.put("aaa","222222");
        map2.put("bbb","22222");
        map2.put("ccc","2222");
        list.add(map2);

        Map<String, String> map3 = new HashMap<>();
        map3.put("aaa","3333");
        map3.put("bbb","3333");
        map3.put("ccc","33333");
        list.add(map3);

        Map<String, String> map4 = new HashMap<>();
        map4.put("aaa","4444");
        map4.put("bbb","4444");
        map4.put("ccc", "44444");
        list.add(map4);

        Map<String, String> map5 = new HashMap<>();
        map5.put("aaa","5555");
        map5.put("bbb","555rqw5555e");
        map5.put("ccc", "5rq5555wer");
        list.add(map5);

        Map<String, String> map6 = new HashMap<>();
        map6.put("aaa","6qwer6666qw");
        map6.put("bbb","6r6q6666we");
        map6.put("ccc", "6rqw666er");
        list.add(map6);


        Map<String, String> map7 = new HashMap<>();
        map7.put("aaa","7777");
        map7.put("bbb","7rq77we");
        map7.put("ccc", "7rq7777wer");
        list.add(map7);

        Map<String, String> map8 = new HashMap<>();
        map8.put("aaa","8qwe888rqw");
        map8.put("bbb","8rq888we");
        map8.put("ccc", "8rq8888wer");
        list.add(map8);

        Map<String, String> map9 = new HashMap<>();
        map9.put("aaa","9qw999erqw");
        map9.put("bbb","9rqw999e");
        map9.put("ccc", "9rq999wer");
        list.add(map9);

        Map<String, Object> m = new HashMap<>();
        m.put("total",9);
        m.put("classes","strclass");
        m.put("rows",list);

        commOutput(response, m);
    }
}
