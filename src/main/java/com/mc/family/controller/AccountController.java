package com.mc.family.controller;

import com.mc.family.dto.AccountQueryReqDto;
import com.mc.family.dto.AccountReqDto;
import com.mc.family.model.AccountInfo;
import com.mc.family.service.AccountService;
import com.mc.family.vo.BaseVo;
import com.mc.family.vo.PageVo;
import com.mc.family.vo.SelectVo;
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
        AccountQueryReqDto reqDto = input(request, AccountQueryReqDto.class);
        // step2: 根据用户ID分页查询用户下账户列表
        PageVo pageVo = accountService.queryAccountListPageByUserId(reqDto);
        // step3: 结束, 返回结果
        commOutput(response, pageVo);
    }

    /**
     * @description 关联账户下拉列表查询服务接口
     * @param request 请求参数
     * @param response 返回参数
     * @throws java.lang.Exception
     * @author ChenglongChu
     * @create 2018/1/30 15:19
    **/
    @RequestMapping(value="/listRel", method = RequestMethod.POST)
    public void queryAccountListRelByUserId(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // step1: 处理请求参数, 查询条件userId
        BaseVo reqDto = input(request, BaseVo.class);
        // step2: 根据用户ID查询用户下账户列表
        SelectVo selectVo = accountService.queryAccountListRelByUserId(reqDto);
        // step3: 结束, 返回结果
        output(response, selectVo);
    }

    /**
     * @description 根据账户ID查询生活账户信息
     * @param request 请求参数
     * @param response 返回参数
     * @throws java.lang.Exception
     * @author ChenglongChu
     * @create 2018/1/31 15:02
    **/
    @RequestMapping(value="/single", method = RequestMethod.POST)
    public void queryAccountSingleByAccountId(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // step1: 处理请求参数, 查询条件userId
        BaseVo reqDto = input(request, BaseVo.class);
        // step2: 根据用户ID查询生活账户信息
        AccountInfo accountInfo = accountService.queryAccountSingleByAccountId(reqDto.getUserId());
        // step3: 结束, 返回结果
        output(response, accountInfo);
    }

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
     * @description 账户修改服务接口
     * @param request 请求参数
     * @param response 返回参数
     * @throws java.lang.Exception
     * @author ChenglongChu
     * @create 2018/1/31 9:54
     **/
    @RequestMapping(value="/update", method = RequestMethod.POST)
    public void updateAccount(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // step1: 处理请求参数, 查询条件userId
        BaseVo reqDto = input(request, BaseVo.class);
        // step2: 根据用户ID删除生活账户
//        accountService.updateAccount(reqDto);
        // step3: 结束, 返回结果
        output(response, null);
    }

    /**
     * @description 账户删除服务接口
     * @param request 请求参数
     * @param response 返回参数
     * @throws java.lang.Exception
     * @author ChenglongChu
     * @create 2018/1/31 9:54
     **/
    @RequestMapping(value="/delete", method = RequestMethod.POST)
    public void deleteAccount(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // step1: 处理请求参数, 查询条件userId
        BaseVo reqDto = input(request, BaseVo.class);
        // step2: 根据用户ID删除生活账户
//        accountService.deleteAccount(reqDto);
        // step3: 结束, 返回结果
        output(response, null);
    }

}
