package com.xjt.dao.master;

import com.xjt.dto.AssetpurchaseReqDto;
import com.xjt.entity.Assetpurchase;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AssetpurchaseDao {
    int deleteByPrimaryKey(String purchaseId);

    int insert(Assetpurchase record);

    int insertSelective(Assetpurchase record);

    Assetpurchase selectByPrimaryKey(String purchaseId);

    int updateByPrimaryKeySelective(Assetpurchase record);

    int updateByPrimaryKey(Assetpurchase record);

    List<Assetpurchase> queryAssetPurchaseList(AssetpurchaseReqDto reqDto);
}