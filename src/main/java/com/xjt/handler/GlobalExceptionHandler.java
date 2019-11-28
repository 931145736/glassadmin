package com.xjt.handler;

import com.alibaba.fastjson.JSONObject;
import com.xjt.dto.BaseResDto;
import com.xjt.enums.ExceptionEnum;
import com.xjt.exception.MyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassNameGlobalExceptionHandler
 * @Description
 * @Author
 * @Date2019/11/21 15:06
 * @Version V1.0
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object logicExceptionHandler(HttpServletRequest request, Exception e, HttpServletResponse response) {
        //系统级异常，错误码固定为-1，提示语固定为系统繁忙，请稍后再试
        BaseResDto baseResDto = new BaseResDto(-1,e.getMessage(),false,ExceptionEnum.SYSTEM_EXCEPTION.getMsg());
        //如果是业务逻辑异常，返回具体的错误码与提示信息
        if (e instanceof MyException) {
            MyException logicException = (MyException) e;
            baseResDto.setResultCode(logicException.getCode());
            baseResDto.setResultMessage(logicException.getErrorMsg());
            baseResDto.setData(ExceptionEnum.CUSTOMER_EXCEPTION.getMsg());
        } else {
            //对系统级异常进行日志记录
            logger.error("系统异常:" + e.getMessage(), e);
        }
        return JSONObject.toJSON(baseResDto);
    }

}
