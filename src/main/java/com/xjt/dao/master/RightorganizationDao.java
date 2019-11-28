package com.xjt.dao.master;

import com.xjt.entity.Rightorganization;

public interface RightorganizationDao {
    int deleteByPrimaryKey(String id);

    int insert(Rightorganization record);

    int insertSelective(Rightorganization record);

    Rightorganization selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Rightorganization record);

    int updateByPrimaryKey(Rightorganization record);
}