package com.xjt.dao.master;

import com.xjt.entity.CustomergroupKey;

public interface CustomergroupDao {
    int deleteByPrimaryKey(CustomergroupKey key);

    int insert(CustomergroupKey record);

    int insertSelective(CustomergroupKey record);
}