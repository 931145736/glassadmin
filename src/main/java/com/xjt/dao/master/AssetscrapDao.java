package com.xjt.dao.master;

import com.xjt.entity.Assetscrap;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AssetscrapDao {
    int deleteByPrimaryKey(String scrapId);

    int insert(Assetscrap record);

    int insertSelective(Assetscrap record);

    Assetscrap selectByPrimaryKey(String scrapId);

    int updateByPrimaryKeySelective(Assetscrap record);

    int updateByPrimaryKey(Assetscrap record);
}