package com.xjt.dao.master;

import com.xjt.entity.CustomeraccountsKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomeraccountsDao {
    int deleteByPrimaryKey(CustomeraccountsKey key);

    int insert(CustomeraccountsKey record);

    int insertSelective(CustomeraccountsKey record);

    //查看渠道开户行信息
    List<CustomeraccountsKey> queryCustomerAccounts(@Param("customerIds") List<String> customerIds);
}