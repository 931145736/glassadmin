package com.xjt.dao.master;

import com.xjt.entity.Supplyaddress;

public interface SupplyaddressDao {
    int deleteByPrimaryKey(Supplyaddress key);

    int insert(Supplyaddress record);

    int insertSelective(Supplyaddress record);

    Supplyaddress selectByPrimaryKey(Supplyaddress key);

    int updateByPrimaryKeySelective(Supplyaddress record);

    int updateByPrimaryKey(Supplyaddress record);
}