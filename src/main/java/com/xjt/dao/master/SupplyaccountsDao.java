package com.xjt.dao.master;

import com.xjt.entity.Supplyaccounts;

public interface SupplyaccountsDao {
    int deleteByPrimaryKey(String id);

    int insert(Supplyaccounts record);

    int insertSelective(Supplyaccounts record);

    Supplyaccounts selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Supplyaccounts record);

    int updateByPrimaryKey(Supplyaccounts record);
}