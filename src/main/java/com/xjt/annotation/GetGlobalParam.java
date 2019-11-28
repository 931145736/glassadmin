package com.xjt.annotation;

import java.lang.annotation.*;

/***
*@Description 获取全局参数
* * @param null
*@Return
*@Author Administrator
*@Date 2019/11/8
*@Time
*/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface GetGlobalParam {

    String value() default "";
}
