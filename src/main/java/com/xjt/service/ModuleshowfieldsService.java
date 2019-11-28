package com.xjt.service;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.ModuleshowfieldsReqDto;
import com.xjt.entity.Moduleshowfields;

public interface ModuleshowfieldsService {


    /**
    *@Description 增加模块 
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/6
    *@Time 
    */
    BaseResDto insertModule(ModuleshowfieldsReqDto reqDto);
    
    /**
    *@Description 查看模块下字段列表
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/6
    *@Time 
    */
    BaseResDto queryModuleListByModuleName(ModuleshowfieldsReqDto reqDto);

    /***
    *@Description 批量删除模块下的字段
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/6
    *@Time
    */
    BaseResDto deleteFieldsFromModule(ModuleshowfieldsReqDto reqDto);
}
