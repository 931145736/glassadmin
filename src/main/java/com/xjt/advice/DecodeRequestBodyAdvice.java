package com.xjt.advice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.xjt.annotation.SecurityParameter;
import com.xjt.entity.ParamEntity;
import com.xjt.utils.AesEncryptUtil;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * @author monkey
 * @desc 请求数据解密
 * @date 2018/10/29 20:17
 */
@ControllerAdvice(basePackages = "com.xjt.controlle")
public class DecodeRequestBodyAdvice implements RequestBodyAdvice {
 
      private static final Logger log = LoggerFactory.getLogger(DecodeRequestBodyAdvice.class);

    @Value("${aes.key}")
    private String key;
    @Value("${aes.iv}")
    private String iv;

    @Override
    public boolean supports(MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        //这里设置成false 它就不会再走这个类了
        return methodParameter.getMethod().isAnnotationPresent(SecurityParameter.class);
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        try {
            log.info("开始对接受值进行解密操作");
            // 定义是否解密
            boolean encode = false;
            //获取注解配置的包含和去除字段
            SecurityParameter serializedField = methodParameter.getMethodAnnotation(SecurityParameter.class);
            //入参是否需要解密
            encode = serializedField.inDecode();
            log.info("对方法method :【" + methodParameter.getMethod().getName() + "】数据进行解密!");
            // 获取 json 字符串
          //  String bodyStr = IOUtils.toString(httpInputMessage.getBody(), "UTF-8");
            MyHttpInputMessage mim  = new MyHttpInputMessage(httpInputMessage, encode);

            return mim;
        } catch (IOException e) {
            e.printStackTrace();
            log.error("对方法method :【" + methodParameter.getMethod().getName() + "】数据进行解密出现异常：" + e.getMessage());
            throw new RuntimeException("对方法method :【" + methodParameter.getMethod().getName() + "】数据进行解密出现异常：" + e.getMessage());
        }
    }

    @Override
    public Object afterBodyRead(Object o, HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        return o;
    }

    @Override
    public Object handleEmptyBody(Object o, HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        return o;
    }


    //这里实现了HttpInputMessage 封装一个自己的HttpInputMessage
    class MyHttpInputMessage implements HttpInputMessage {
        HttpHeaders headers;
        InputStream body;

        public MyHttpInputMessage(HttpInputMessage httpInputMessage, boolean encode) throws IOException {
            this.headers = httpInputMessage.getHeaders();
            // 解密操作
            this.body = decryptBody(httpInputMessage.getBody(), encode);
        }

        @Override
        public InputStream getBody() {
            return body;
        }

        @Override
        public HttpHeaders getHeaders() {
            return headers;
        }
    }

    /**
     * 对流进行解密操作
     *
     * @param in
     * @return
     */
    public InputStream decryptBody(InputStream in, Boolean encode) throws IOException {
        try {

            // 获取 json 字符串
            String bodyStr = IOUtils.toString(in, "UTF-8");
            if (StringUtils.isEmpty(bodyStr)) {
                throw new RuntimeException("无任何参数异常!");
            }
            log.info("bodyStr"+bodyStr);

            ParamEntity paramEntity = JSONObject.parseObject(bodyStr,ParamEntity.class);
            // 获取 inputData 加密串
           String inputData = paramEntity.getInputData();
            // 验证是否为空
           if (StringUtils.isEmpty(inputData)) {
                throw new RuntimeException("参数【" + inputData + "】缺失");
            } else {

               // 是否解密
               if (!encode) {
                   log.info("没有解密标识不进行解密!");
                   return IOUtils.toInputStream(bodyStr, "UTF-8");
               }

               // 开始解密
               log.info("对加密串开始解密操作!");
               try {
              /*  JSONObject jsonObject = JSONObject.parseObject(bodyStr);
                for(String str:jsonObject.keySet()){
                    String value = AesEncryptUtil.desEncrypt(jsonObject.get(str).toString(),key,iv);
                  //  jsonObject.remove(str);
                    jsonObject.put(str,value);
                }*/
                   String decryptBody = null;

                   decryptBody = AesEncryptUtil.desEncrypt(inputData, key, iv);
                   log.info("解密后的数据"+decryptBody);

                   log.info("操作结束!");
                   return IOUtils.toInputStream(decryptBody, "UTF-8");
               } catch (Exception e) {
                   e.printStackTrace();
                   throw new RuntimeException("RSA解密异常：" + e.getMessage());
               }
           }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("获取参数【】异常：" + e.getMessage());
        }
    }
}


