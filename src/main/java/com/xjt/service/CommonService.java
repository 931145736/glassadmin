package com.xjt.service;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.CommonReqDto;

public interface CommonService {

    BaseResDto insertDatasBatch(CommonReqDto reqDto);

    BaseResDto deleteDatasBatch(CommonReqDto reqDto);

    BaseResDto queryAllData(CommonReqDto reqDto);

    /**
    *@Description 查看下拉列表
    * * @param null
    *@Return
    *@Author Administrator
    *@Date 2019/12/2
    *@Time
    */
    BaseResDto SelectOptionList(CommonReqDto reqDto);
}
