package com.xjt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
/***
*@Description 跨域配置 https://www.cnblogs.com/cityspace/p/6858969.html
* * @param null
*@Return 
*@Author Administrator
*@Date 2019/11/8
*@Time 
*/
@Configuration
public class CorsConfig {
    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //  你需要跨域的地址  注意这里的 127.0.0.1 != localhost
        // * 表示对所有的地址都可以访问
        corsConfiguration.addAllowedOrigin("*");
        //  跨域的请求头
        corsConfiguration.addAllowedHeader("*"); // 2
        //  跨域的请求方法
        corsConfiguration.addAllowedMethod("*"); // 3
        //加上了这一句，大致意思是可以携带 cookie
        //最终的结果是可以 在跨域请求的时候获取同一个 session
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setMaxAge(1800L);//控制浏览器在半小时内（单位s）无需在请求时发送预检请求
        return corsConfiguration;
    }
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        //配置 可以访问的地址
        source.registerCorsConfiguration("/**", buildConfig()); // 4
        return new CorsFilter(source);
    }
}
