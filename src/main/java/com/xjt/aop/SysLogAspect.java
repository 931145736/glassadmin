package com.xjt.aop;

import com.xjt.annotation.UserLog;
import com.xjt.dao.master.SysuserlogDao;
import com.xjt.entity.Master;
import com.xjt.entity.Sysuserlog;
import com.xjt.utils.IpUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 系统日志：切面处理类
 */
@Aspect
@Component
public class SysLogAspect {
 
    @Resource
    private SysuserlogDao sysuserlogDao;

    private Logger logger = LoggerFactory.getLogger(SysLogAspect.class);
 
    //定义切点 @Pointcut
    //在注解的位置切入代码
    @Pointcut("@annotation( com.xjt.annotation.UserLog)")
    public void logPoinCut() {
    }
 
    //切面 配置通知
    @Transactional(rollbackFor = Exception.class)
    @AfterReturning("logPoinCut()")
    public void saveSysLog(JoinPoint joinPoint) {
        System.out.println("切面。。。。。");
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        Master master = (Master) request.getAttribute("currentUser");

 
        //请求的参数
     /*   Object[] args = joinPoint.getArgs();
        Object[] arguments  = new Object[args.length];
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof ServletRequest || args[i] instanceof ServletResponse || args[i] instanceof MultipartFile) {
                //ServletRequest不能序列化，从入参里排除，否则报异常：java.lang.IllegalStateException: It is illegal to call this method if the current request is not in asynchronous mode (i.e. isAsyncStarted() returns false)
                //ServletResponse不能序列化 从入参里排除，否则报异常：java.lang.IllegalStateException: getOutputStream() has already been called for this response
                continue;
            }
            arguments[i] = args[i];
        }
        String paramter = "";
        if (arguments.length>0) {
            try {
                paramter = JSONObject.toJSONString(arguments);
                //将参数所在的数组转换成json
                sysLog.setLogParams(paramter);
            } catch (Exception e) {
                paramter = arguments.toString();
            }
        }
*/
     //获取用户名
        if(master!=null){
            //保存日志
            Sysuserlog sysLog = new Sysuserlog();

            //从切面织入点处通过反射机制获取织入点处的方法
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            //获取切入点所在的方法
            Method method = signature.getMethod();

            //获取操作
            UserLog userLog = method.getAnnotation(UserLog.class);
            if (userLog != null) {
                String value = userLog.value();
                sysLog.setLogOperatiion(value);//保存获取的操作
            }


            //获取请求的类名
            String className = joinPoint.getTarget().getClass().getName();
            //获取请求的方法名
            String methodName = method.getName();
            sysLog.setLogMethod(className + "." + methodName);
            sysLog.setLogDate(new Date());
            //获取用户ip地址
            sysLog.setLogUserIp(IpUtils.getIpAddr(request));
            sysLog.setLogUser(master.getTrueName());
            sysLog.setLogUserName(master.getName());
            //获取请求的接口路径
            String url = request.getRequestURI();
            sysLog.setLogUrl(url);
            //调用service保存SysLog实体类到数据库
            sysLog.setDeleteFlag(1);
            int num =sysuserlogDao.insert(sysLog);
            if(num !=1){
                throw new RuntimeException("添加用户操作日志异常");
            }
            logger.info("存入用户操作成功");
        }

 

    }
 
}