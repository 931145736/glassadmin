package com.xjt.dao.master;

import com.xjt.entity.Boxbill;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoxbillDao {
    int deleteByPrimaryKey(Boxbill key);

    int insert(Boxbill record);

    int insertSelective(Boxbill record);

    Boxbill selectByPrimaryKey(Boxbill key);

    int updateByPrimaryKeySelective(Boxbill record);

    int updateByPrimaryKey(Boxbill record);
}