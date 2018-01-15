package com.mc.family.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author ChenglongChu
 * @description service层切面
 * @create 2017/12/13 16:45
 * @since v0.1
 */
@Aspect
@Component
public class AspectService {
    /**
     * @description service层切点入口
     * @author ChenglongChu
     * @create 2017/12/14 15:15
    **/
    @Pointcut("execution(* com.mc.family.service.*Service*.*(..))")
    public void serviceAspect() {
    }

    /**
     * @description service层接入前执行
     * @param joinPoint 过程参数
     * @author ChenglongChu
     * @create 2017/12/14 15:16
    **/
    @Before("serviceAspect()")
    public void before(JoinPoint joinPoint) {
//        String methodName = joinPoint.getSignature().getName();
//        System.out.println("service " + methodName + " start----------");
    }

    /**
     * @description service层完成后执行
     * @param joinPoint 过程参数
     * @author ChenglongChu
     * @create 2017/12/14 15:16
    **/
    @After("serviceAspect()")
    public void after(JoinPoint joinPoint) {
//        String methodName = joinPoint.getSignature().getName();
//        System.out.println("service " + methodName + " end----------");
    }

    /**
     * @description service层完成后返回时执行
     * @param joinPoint 过程参数
     * @param returnVal 返回参数
     * @author ChenglongChu
     * @create 2017/12/14 15:17
    **/
    @AfterReturning(pointcut = "serviceAspect()", returning = "returnVal")
    public void afterReturning(JoinPoint joinPoint, Object returnVal) {
//        System.out.println("afterReturning executed, return result is " + returnVal);
    }

    /**
     * @description service层抛出异常时执行
     * @param joinPoint 过程参数
     * @param error 异常信息
     * @author ChenglongChu
     * @create 2017/12/14 15:17
    **/
    @AfterThrowing(pointcut = "serviceAspect()", throwing = "error")
    public void afterThrowing(JoinPoint joinPoint, Throwable error) {
//        System.out.println("error:" + error.getMessage());
    }
}
