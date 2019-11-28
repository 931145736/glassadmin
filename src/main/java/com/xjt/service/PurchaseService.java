package com.xjt.service;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.PurchaseReqDto;
import com.xjt.entity.OrderEntity;

public interface PurchaseService {

    /***
    *@Description 添加采购订单
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/7
    *@Time
    */
    BaseResDto addPurchaseOrder(PurchaseReqDto reqDto);

    /***
    *@Description 审核采购订单
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/7
    *@Time
    */
    BaseResDto checkPurchaseOrder(PurchaseReqDto reqDto);
    
    /***
    *@Description 采购订单列表 
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/12
    *@Time 
    */
    BaseResDto PurchaseOrderLisy(OrderEntity reqDto);
    
    /***
    *@Description 查看采购订单详情 
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/12
    *@Time 
    */
    BaseResDto queryOrderDetail(PurchaseReqDto reqDto);
    
    /***
    *@Description ' 
    *删除采购订单
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/13
    *@Time 
    */
    BaseResDto deletePurchaseOrder(String purchaseId);

}
