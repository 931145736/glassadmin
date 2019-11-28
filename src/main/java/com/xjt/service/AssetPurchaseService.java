package com.xjt.service;

import com.xjt.dto.AssetpurchaseReqDto;
import com.xjt.dto.BaseResDto;

public interface AssetPurchaseService {

    BaseResDto insertAssetPurchase(AssetpurchaseReqDto reqDto);
    
    /**
    *@Description 审核物资采购单 
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/20
    *@Time 
    */
    BaseResDto checkAssetPurchase(AssetpurchaseReqDto reqDto);
    
    /**
    *@Description 查看物资采购单列表
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/20
    *@Time 
    */
    BaseResDto queryAssetPurchaseList(AssetpurchaseReqDto reqDto);

    /***
    *@Description 查看采购的货品
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/20
    *@Time 
    */
    BaseResDto queryPurchaseAssetInfo(AssetpurchaseReqDto reqDto);
}
