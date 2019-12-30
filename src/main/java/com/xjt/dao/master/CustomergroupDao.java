package com.xjt.dao.master;

import com.xjt.entity.CustomergroupKey;
import org.apache.ibatis.annotations.Param;

public interface CustomergroupDao {
    int deleteByPrimaryKey(CustomergroupKey key);

    int insert(CustomergroupKey record);

    int insertSelective(CustomergroupKey record);

    int deleteCustomer(@Param("customerId") String customerId, @Param("deleteFlag") Integer deleteFlag);
}