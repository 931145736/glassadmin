package com.xjt.dao.master;

import com.xjt.entity.Assetreturn;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AssetreturnDao {
    int deleteByPrimaryKey(String returnId);

    int insert(Assetreturn record);

    int insertSelective(Assetreturn record);

    Assetreturn selectByPrimaryKey(String returnId);

    int updateByPrimaryKeySelective(Assetreturn record);

    int updateByPrimaryKey(Assetreturn record);
}