package com.xjt.handler;

import com.alibaba.fastjson.JSONObject;
import com.xjt.entity.Master;
import com.xjt.enums.ResultCode;
import com.xjt.utils.RedisUtil;
import com.xjt.utils.STRUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Component
public class UserLoginHandler extends HandlerInterceptorAdapter {

    @Autowired
    private RedisUtil redisUtil;

    @Value("${login.validity.time}")
    private Long loginValidityTime;
    private Logger logger = LoggerFactory.getLogger(UserLoginHandler.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json; charset=utf-8");
        Map<String,Object>  map = new HashMap<>();
        String token = request.getHeader("token");
        if(STRUtils.isEmpty(token)){
            PrintWriter writer = response.getWriter();
            map.put("code",ResultCode.RESULT_CODE_EXCEPTION.getCode());
            map.put("message","没有请求头信息");
            writer.print(JSONObject.toJSONString(map));
            return false;
        }
        //根据token获取用户信息 如果已失效 请求重新登录 移除map集合里的当前用户 否则 把当前用户存入请求域，更新失效时间
        if(!STRUtils.isEmpty(token)){
            Master master = (Master) redisUtil.get(token);
            if(master==null){
                PrintWriter writer = response.getWriter();
                map.put("code",ResultCode.RESULT_CODE_EXCEPTION);
                map.put("message","已超时，请重新登录");
                writer.write(JSONObject.toJSONString(map));
                return false;
            }else{
                redisUtil.set(token,master,loginValidityTime);
                request.setAttribute("currentUser",master);
                logger.info("用户信息存入request成功");
                return true;

            }

        }else {
            PrintWriter writer = response.getWriter();
            map.put("code",ResultCode.RESULT_CODE_EXCEPTION);
            map.put("message","请登陆后查看");
            writer.write(JSONObject.toJSONString(map));
            return false;
        }









    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
       super.postHandle(request,response,handler,modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
       super.afterCompletion(request,response,handler,ex);

    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }
}
