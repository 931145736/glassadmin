package com.xjt.aop;

import com.xjt.entity.GlobalParam;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassNameGlobalParamAop
 * @Description
 * @Author
 * @Date2019/11/7 14:45
 * @Version V1.0
 **/
@Component
@Aspect
public class GlobalParamAop {


    @Pointcut("@annotation(com.xjt.annotation.GetGlobalParam)")
    public void pointcut(){

    }

    /***
    *@Description 获取全局参数配置
    * * @param pjp
    *@Return java.lang.Object
    *@Author Administrator
    *@Date 2019/11/7
    *@Time
    */
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response =attributes.getResponse();
        HttpSession session = request.getSession();
        //模拟全局参数配置
       /* 仓库验收流程配置
         1 采购单 -通知单 - 验收单
         2 通知单 - 验收单
        */
        GlobalParam globalParam = new GlobalParam();
        globalParam.setValue(1);

        session.setAttribute("globalParam",globalParam);
        return pjp.proceed();
    }

}
