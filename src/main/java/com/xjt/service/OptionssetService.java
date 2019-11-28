package com.xjt.service;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.OptionssetReqDto;

import java.util.List;

public interface OptionssetService {

    /**
    *@Description 添加全局参数配置
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/8
    *@Time
    */
    BaseResDto insertGlobalOptionSet(OptionssetReqDto reqDto);
    
    /***
    *@Description 批量添加全局参数配置 
    * * @param reqDtos
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/8
    *@Time 
    */
    BaseResDto batchInsertOptionSet(List<OptionssetReqDto> reqDtos);
}
