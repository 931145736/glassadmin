package com.xjt.dao.master;

import com.xjt.dto.AssetpurchaseReqDto;
import com.xjt.entity.Assetpurchasedetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AssetpurchasedetailDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Assetpurchasedetail record);

    int insertSelective(Assetpurchasedetail record);

    Assetpurchasedetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Assetpurchasedetail record);

    int updateByPrimaryKey(Assetpurchasedetail record);

    int insertDetailsBatch(@Param("details") List<Assetpurchasedetail> details);

    List<Assetpurchasedetail> queryPurchaseAssetInfo(AssetpurchaseReqDto reqDto);
}