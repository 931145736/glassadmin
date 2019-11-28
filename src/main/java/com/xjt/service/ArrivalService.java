package com.xjt.service;

import com.xjt.dto.ArrivalReqDto;
import com.xjt.dto.BaseResDto;
import com.xjt.entity.OrderEntity;

public interface ArrivalService {

    /***
    *@Description 添加到货通知单 
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/7
    *@Time 
    */
    BaseResDto insertArrivalOrder(ArrivalReqDto reqDto);
    
    /**
    *@Description 审核到货通知单 
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/7
    *@Time 
    */
    BaseResDto checkArrivalOrder(ArrivalReqDto reqDto);

    /***
    *@Description 查看到货通知单列表
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/12
    *@Time
    */
    BaseResDto queryArrivalOrderList(OrderEntity reqDto);
    
    /***
    *@Description 查看到货通知单详情 
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/12
    *@Time 
    */
    BaseResDto queryArrivalOrderDetail(ArrivalReqDto reqDto);
}
