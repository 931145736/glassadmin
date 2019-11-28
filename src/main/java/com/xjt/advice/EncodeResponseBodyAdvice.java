package com.xjt.advice;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.xjt.annotation.SecurityParameter;
import com.xjt.dto.BaseResDto;
import com.xjt.utils.AesEncryptUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author monkey
 * @desc 返回数据加密
 * @date 2018/10/25 20:17
 */
@ControllerAdvice(basePackages = "com.xjt.controlle")
public class EncodeResponseBodyAdvice implements ResponseBodyAdvice {
 
    private final static Logger log = LoggerFactory.getLogger(EncodeResponseBodyAdvice.class);
    @Value("${aes.key}")
    private String key;
    @Value("${aes.iv}")
    private String iv;



    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        //这里设置成false 它就不会再走这个类了
        return methodParameter.getMethod().isAnnotationPresent(SecurityParameter.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        try {
            log.info("开始对返回值进行加密操作!");
            // 定义是否解密
            boolean encode = false;
            //获取注解配置的包含和去除字段
            SecurityParameter serializedField = methodParameter.getMethodAnnotation(SecurityParameter.class);
            //入参是否需要解密
            encode = serializedField.outEncode();
            log.info("对方法method :【" + methodParameter.getMethod().getName() + "】数据进行加密!");
            return encryptedBody(body, encode);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("对方法method :【" + methodParameter.getMethod().getName() + "】数据进行加密出现异常：" + e.getMessage());
            throw new RuntimeException("对方法method :【" + methodParameter.getMethod().getName() + "】数据进行加密出现异常：" + e.getMessage());
        }
    }

    public Object encryptedBody(Object body, Boolean encode) throws IOException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String result = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(body);
            if (!encode) {
                log.info("没有加密表示不进行加密!");
                return body;
            }
            log.info("对字符串开始加密!");
            try {

                BaseResDto baseResDto =  JSONObject.parseObject(result,BaseResDto.class);
                log.info("返回数据"+baseResDto.getResultCode());
                String outputData = AesEncryptUtil.encrypt(result,key,iv);
                Map<String,String> map = new HashMap<String, String>();
                map.put("data",outputData);

                log.info("操作结束!");
                return JSONObject.toJSONString(map);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("对返回数据加密出现异常：" + e.getMessage());
            }

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("获取返回值出现异常:" + e.getMessage());
        }
    }
}


