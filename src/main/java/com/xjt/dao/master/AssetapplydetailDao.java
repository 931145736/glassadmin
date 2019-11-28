package com.xjt.dao.master;

import com.xjt.entity.Assetapply;
import com.xjt.entity.Assetapplydetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AssetapplydetailDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Assetapplydetail record);

    int insertSelective(Assetapplydetail record);

    Assetapplydetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Assetapplydetail record);

    int updateByPrimaryKey(Assetapplydetail record);

    int insertMaterialsBatch(@Param("details") List<Assetapplydetail> details);

    List<Assetapplydetail> queryDetails(String applyId);


}