package com.xjt.dao.master;

import com.xjt.dto.PurchaseReqDto;
import com.xjt.entity.DeleteOrderEntity;
import com.xjt.entity.OrderEntity;
import com.xjt.entity.Purchase;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface PurchaseDao {
    int deleteByPrimaryKey(String purchaseId);

    int insert(Purchase record);

    int insertSelective(Purchase record);

    List<OrderEntity> selectByPrimaryKey(String purchaseId);

    int updateByPrimaryKeySelective(Purchase record);

    int updateByPrimaryKey(Purchase record);

    /***
    *@Description 审核采购订单
    * * @param reqDto
    *@Return int
    *@Author Administrator
    *@Date 2019/11/7
    *@Time
    */
    int checkPurchaseOrder(PurchaseReqDto reqDto);

    /***
    *@Description 更改记账状态
    * * @param reqDto
    *@Return int
    *@Author Administrator
    *@Date 2019/11/7
    *@Time
    */
    int PurchaseOrderCharge(PurchaseReqDto reqDto);

    /***
    *@Description 查看采购订单列表
    * * @param
    *@Return java.util.List<com.xjt.entity.Purchase>
    *@Author Administrator
    *@Date 2019/11/12
    *@Time
    */
    List<OrderEntity> queryPurchaseList(OrderEntity entity);

    int deletePurchaseOrder(String purchaseId);

    int deleteOrder (DeleteOrderEntity entity);
}