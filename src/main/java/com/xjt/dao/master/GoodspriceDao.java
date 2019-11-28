package com.xjt.dao.master;

import com.xjt.entity.Goodsprice;

public interface GoodspriceDao {
    int deleteByPrimaryKey(String idx);

    int insert(Goodsprice record);

    int insertSelective(Goodsprice record);

    Goodsprice selectByPrimaryKey(String idx);

    int updateByPrimaryKeySelective(Goodsprice record);

    int updateByPrimaryKey(Goodsprice record);
}