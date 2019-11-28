package com.xjt.dao.master;

import com.xjt.entity.Retailpayment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RetailpaymentDao {
    int deleteByPrimaryKey(Retailpayment key);

    /**
    *@Description 添加支付说明 
    * * @param record
    *@Return int
    *@Author Administrator
    *@Date 2019/11/5
    *@Time 
    */
    int insert(Retailpayment record);

    int insertSelective(Retailpayment record);

    Retailpayment selectByPrimaryKey(Retailpayment key);

    int updateByPrimaryKeySelective(Retailpayment record);

    int updateByPrimaryKey(Retailpayment record);
}