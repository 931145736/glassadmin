package com.xjt.dao.master;

import com.xjt.entity.Purchasegoods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PurchasegoodsDao {
    int deleteByPrimaryKey(String purchasegoodsid);

    int insert(Purchasegoods record);

    int insertSelective(Purchasegoods record);

    Purchasegoods selectByPrimaryKey(String purchasegoodsid);

    int updateByPrimaryKeySelective(Purchasegoods record);

    int updateByPrimaryKey(Purchasegoods record);

    /***
    *@Description 批量添加采购的货品
    * * @param purchasegoods
    *@Return int
    *@Author Administrator
    *@Date 2019/11/7
    *@Time
    */
    int insertGoodsBatch(@Param("purchasegoods") List<Purchasegoods> purchasegoods);

    int deleteGoods(String purchaseId);

    List<String> getPurchaseGoodsId(String purchaseId);
}