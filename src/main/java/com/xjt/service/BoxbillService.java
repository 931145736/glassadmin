package com.xjt.service;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.BoxbillReqDto;

public interface BoxbillService {

    /***
    *@Description 添加箱子
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/7
    *@Time
    */
    BaseResDto insertBoxBill(BoxbillReqDto reqDto);
}
