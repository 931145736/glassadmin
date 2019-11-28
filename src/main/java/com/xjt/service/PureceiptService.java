package com.xjt.service;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.PureceiptReqDto;
import com.xjt.entity.OrderEntity;

import javax.servlet.http.HttpSession;

public interface PureceiptService {

    /***
    *@Description 添加仓库验收单
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/7
    *@Time
    */
    BaseResDto insertPureceiptOrder(PureceiptReqDto reqDto, HttpSession session);

    /***
    *@Description 审核厂家到货单 
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/12
    *@Time 
    */
    BaseResDto checkPureceiptOrder (PureceiptReqDto reqDto);
    
    /***
    *@Description 查看到货单列表 
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/12
    *@Time 
    */
    BaseResDto queryPureceiptOrderList(OrderEntity reqDto);
    
    /***
    *@Description 查看到货单详情 
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/12
    *@Time 
    */
    BaseResDto queryPureceiptDetail(PureceiptReqDto reqDto);
}
