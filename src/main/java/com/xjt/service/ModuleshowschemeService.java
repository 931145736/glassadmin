package com.xjt.service;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.ModuleshowschemeReqDto;

public interface ModuleshowschemeService {


    /**
    *@Description 添加方案 
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/6
    *@Time 
    */
    BaseResDto insertModuleScheme(ModuleshowschemeReqDto reqDto);
    
    /***
    *@Description 查看方案下的模块 
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/6
    *@Time 
    */
    BaseResDto queryModuleScheme(ModuleshowschemeReqDto reqDto);

    
}
