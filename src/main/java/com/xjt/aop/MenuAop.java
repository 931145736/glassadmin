package com.xjt.aop;

import com.alibaba.fastjson.JSONObject;
import com.xjt.dao.master.ActiongroupDao;
import com.xjt.entity.Master;
import com.xjt.enums.ResultCode;
import com.xjt.utils.RedisUtil;
import com.xjt.utils.STRUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassNameMenuAop  用户菜单权限
 * @Description
 * @Author
 * @Date2019/11/8 17:03
 * @Version V1.0
 **/

@Aspect
@Component
public class MenuAop {

    private Logger logger = LoggerFactory.getLogger(MenuAop.class);
    @Resource
    private RedisUtil redisUtil;
    @Resource
    private ActiongroupDao actiongroupDao;

    @Pointcut("@annotation(com.xjt.annotation.MenuPower)")
    public void pointcut(){

    }

    @Around("pointcut()")
    public Object getMenuPower(ProceedingJoinPoint pjp) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response =attributes.getResponse();
        String token = request.getHeader("token");
        Master master = (Master) redisUtil.get(token);


        Map<String,Object> map = new HashMap<>();
        if(STRUtils.isEmpty(token)){
            PrintWriter printWriter = response.getWriter();
            map.put("resultCode",ResultCode.RESULT_CODE_EXCEPTION.getCode());
            map.put("message","没有请求头信息");
            printWriter.write(JSONObject.toJSONString(map));
            return null ;
        }
        //获取用户菜单权限
        String userId = master.getId();
        List<String> menuIds =actiongroupDao.queryActionsByUser(userId);
        logger.info("用户具有的菜单id"+JSONObject.toJSONString(menuIds));
        if(menuIds==null||menuIds.size()==0){
            PrintWriter printWriter = response.getWriter();
            map.put("resultCode",ResultCode.RESULT_CODE_EXCEPTION.getCode());
            map.put("message","暂无权限，请联系管理员");
            printWriter.write(JSONObject.toJSONString(map));
            return null ;
        }

        request.setAttribute("menuPower",menuIds);
        return pjp.proceed();

    }
}
