package com.xjt.annotation;

import java.lang.annotation.*;

/***
*@Description 获取用户菜单权限
* * @param null
*@Return
*@Author Administrator
*@Date 2019/11/8
*@Time
*/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ActionPower {

    String value() default "";
}
