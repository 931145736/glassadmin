package com.xjt.service;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.UimoduleReqDto;

public interface UimoduleService {

    /**
    *@Description 添加菜单
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/8
    *@Time
    */
    BaseResDto insertUimodule(UimoduleReqDto reqDto);

    /***
    *@Description 查看一级菜单 
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/8
    *@Time 
    */
    BaseResDto queryOneMenu(UimoduleReqDto reqDto);
    
    /***
    *@Description 查看当前菜单的子集 
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/8
    *@Time 
    */
    BaseResDto queryChildrenMenu(UimoduleReqDto reqDto);
}
