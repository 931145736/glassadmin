package com.xjt.config;

import com.xjt.handler.UserLoginHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *   拦截器配置
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    

    /***
    *@Description 设置跳过拦截器 
    * * @param registry
    *@Return void
    *@Author Administrator
    *@Date 2019/11/8
    *@Time 
    */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(getUserLoginHandler()).addPathPatterns("/**")
        .excludePathPatterns("/userLogin","/encode","/index","/login","/**/*.css", "/**/*.js", "/**/*.png", "/**/*.jpg", "/**/*.jpeg", "/*.html", "/**/*.html","/swagger-resources/**");

    }

    @Bean
    public UserLoginHandler getUserLoginHandler(){
        return new UserLoginHandler();
    }
}