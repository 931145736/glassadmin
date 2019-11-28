package com.xjt.dao.master;

import com.xjt.entity.Purchasedetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PurchasedetailDao {
    int deleteByPrimaryKey(Integer autoid);

    int insert(Purchasedetail record);

    int insertSelective(Purchasedetail record);

    Purchasedetail selectByPrimaryKey(Integer autoid);

    int updateByPrimaryKeySelective(Purchasedetail record);

    int updateByPrimaryKey(Purchasedetail record);

    /***
    *@Description 批量添加货品明细
    * * @param purchasedetails
    *@Return int
    *@Author Administrator
    *@Date 2019/11/7
    *@Time
    */
    int insertGoodsDetailBatch(@Param("purchasedetails") List<Purchasedetail> purchasedetails);

    int deleteGoodsDetail(@Param("purchaseGoodsId") List<String> purchaseGoodsId);


}