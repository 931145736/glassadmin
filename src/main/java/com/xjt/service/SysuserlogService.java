package com.xjt.service;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.SysuserlogReqDto;

public interface SysuserlogService {

    /**
    *@Description 查看用户日志操作列表
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/21
    *@Time 
    */
    BaseResDto queryUserLogList(SysuserlogReqDto reqDto);

    /***
    *@Description 删除操作日志 
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/21
    *@Time 
    */
    BaseResDto deleteUserLog(SysuserlogReqDto reqDto);
}
