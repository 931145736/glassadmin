package com.xjt.dao.master;

import com.xjt.entity.Customerbrand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerbrandDao {
    int deleteByPrimaryKey(Customerbrand key);

    int insert(Customerbrand record);

    int insertSelective(Customerbrand record);

    Customerbrand selectByPrimaryKey(Customerbrand key);

    int updateByPrimaryKeySelective(Customerbrand record);

    int updateByPrimaryKey(Customerbrand record);

    List<Customerbrand> queryListByCId(@Param("customerIds") List<String> customerIds);

    //批量添加渠道品牌
    int insertCustomerBrandBatch(@Param("customerId") String customerId,@Param("brands") List<String> brands);

}