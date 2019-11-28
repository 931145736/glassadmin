package com.xjt.dao.master;

import com.xjt.entity.Assetreturndetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AssetreturndetailDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Assetreturndetail record);

    int insertSelective(Assetreturndetail record);

    Assetreturndetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Assetreturndetail record);

    int updateByPrimaryKey(Assetreturndetail record);

    int insertReturnDetails(@Param("details") List<Assetreturndetail> details);

    List<Assetreturndetail> queryReturnAsset(String returnId);
}