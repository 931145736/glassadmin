package com.xjt.aop;

import com.alibaba.fastjson.JSONObject;
import com.xjt.annotation.ActionPower;
import com.xjt.dao.master.ActiongroupDao;
import com.xjt.entity.Datapermission;
import com.xjt.entity.Master;
import com.xjt.enums.ResultCode;
import com.xjt.utils.RedisUtil;
import com.xjt.utils.STRUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Aspect
//@Order() 控制执行顺序
@Component
public class ActionAop {

    private Logger logger = LoggerFactory.getLogger(QueryAopConfig.class);

    @Resource
    private ActiongroupDao actiongroupDao;
    @Resource
    private RedisUtil redisUtil;

    @Pointcut("@annotation(com.xjt.annotation.ActionPower)")
    public void addAdvice(){

    }

   /* @Before("@annotation(actionPower)")
    public void before(JoinPoint joinPoint,ActionPower actionPower){
        ProceedingJoinPoint pjp = (ProceedingJoinPoint)joinPoint;

        logger.info("方法执行前"+actionPower.value());
    }*/


   /***
   *@Description 获取用户的操作权限
   * * @param pjp
   *@Return java.lang.Object
   *@Author Administrator
   *@Date 2019/11/6
   *@Time
   */
    @Around("addAdvice()")

    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("进去切面");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response =attributes.getResponse();
        String token = request.getHeader("token");
        Master master = (Master) redisUtil.get(token);
        String userId = master.getId();
        logger.info("请求头信息"+userId);
        Map<String,Object> map = new HashMap<>();
        if(STRUtils.isEmpty(userId)){
            PrintWriter printWriter = response.getWriter();
            map.put("resultCode",ResultCode.RESULT_CODE_EXCEPTION.getCode());
            map.put("message","没有请求头信息");
            printWriter.write(JSONObject.toJSONString(map));
            return null ;
        }
        List<String> actionIds = actiongroupDao.queryActionsByUser(userId);
        if(actionIds==null||actionIds.size()==0){
            PrintWriter printWriter = response.getWriter();
            map.put("resultCode",ResultCode.RESULT_CODE_EXCEPTION.getCode());
            map.put("message","您没有权限查看");
            printWriter.write(JSONObject.toJSONString(map));
            return  null;
        }
        logger.info("可以查看的权限"+JSONObject.toJSONString(actionIds));
        HttpSession session =request.getSession();
        session.setAttribute("actionIds",actionIds);

        MethodSignature signature = (MethodSignature)pjp.getSignature();
        Method method = signature.getMethod();
        ActionPower actionPower = method.getAnnotation(ActionPower.class);
        logger.info("注解信息"+actionPower.value());

        return pjp.proceed();
    }

}
