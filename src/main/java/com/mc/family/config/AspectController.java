package com.mc.family.config;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author ChenglongChu
 * @description controller层切面
 * @create 2017/12/13 16:42
 * @since v0.1
 */
@Aspect
@Component
public class AspectController {
    /**
     * @description controller层切点入口
     * @author ChenglongChu
     * @create 2017/12/14 15:13
    **/
    @Pointcut("execution(* com.mc.family.controller.*Controller*.*(..))")
    public void controllerAspect() {
    }

    /**
     * @description controller层接入前执行
     * @param joinPoint 过程参数
     * @author ChenglongChu
     * @create 2017/12/14 15:13
    **/
    @Before("controllerAspect()")
    public void before(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("controller " + methodName + " start----------");
    }

    /**
     * @description controller层环绕进行中执行
     * @param pjp 过程参数
     * @throws java.lang.Throwable
     * @author ChenglongChu
     * @create 2017/12/14 15:13
     **/
    @Around("controllerAspect()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        try {
            pjp.proceed();
        } catch (Throwable ex) {
            ManagerLog.error(ex, "Controller AOP异常捕获统一处理, 打印错误内容 : ", ex.getMessage());
            // 统一处理异常
            Object[] objects = pjp.getArgs();
            HttpServletResponse response = (HttpServletResponse)objects[1];
            // to json string
            String json = JSONObject.toJSONStringWithDateFormat(ManagerResult.newFailed(ex.getLocalizedMessage(),ex), ConstantComm.DATE_FORMAT_ONE);
            // output response
            PrintWriter out = response.getWriter();
            out.print(json);
            out.flush();
            out.close();
        }
    }

    /**
     * @description controller层完成后执行
     * @param joinPoint 过程参数
     * @author ChenglongChu
     * @create 2017/12/14 15:13
     **/
    @After("controllerAspect()")
    public void after(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("controller " + methodName + " end----------");
    }

    /**
     * @description controller层完成后返回时执行
     * @param joinPoint 过程参数
     * @param returnVal 返回参数
     * @author ChenglongChu
     * @create 2017/12/14 15:13
     **/
    @AfterReturning(pointcut = "controllerAspect()", returning = "returnVal")
    public void afterReturning(JoinPoint joinPoint, Object returnVal) {
//        System.out.println("afterReturning executed, return result is " + returnVal);
    }

    /**
     * @description controller层抛出异常时执行
     * @param joinPoint 过程参数
     * @param error 异常信息
     * @author ChenglongChu
     * @create 2017/12/14 15:13
     **/
    @AfterThrowing(pointcut = "controllerAspect()", throwing = "error")
    public void afterThrowing(JoinPoint joinPoint, Throwable error) {
//        System.out.println("error:" + error.getMessage());
    }
}
