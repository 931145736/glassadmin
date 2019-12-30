package com.xjt.dao.master;

import com.xjt.dto.CustomerReqDto;
import com.xjt.entity.Customer;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CustomerDao {
    int deleteByPrimaryKey(String customerId);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(String customerId);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    List<Customer> queryCustomerByIds(@Param("customerIds") List<String> customerIds);

    List<Customer> queryCustomerLists(CustomerReqDto reqDto);

    int deleteCustomer(@Param("customerId") String customerId, @Param("deleteFlag") Integer deleteFlag);
}