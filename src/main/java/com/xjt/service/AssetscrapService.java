package com.xjt.service;

import com.xjt.dto.AssetscrapReqDto;
import com.xjt.dto.BaseResDto;

public interface AssetscrapService {


    /***
    *@Description 物资报废
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/18
    *@Time
    */
    BaseResDto assetScrap(AssetscrapReqDto reqDto);

    /***
    *@Description 审核报废的物资
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/18
    *@Time
    */
    BaseResDto checkAssetScrap(AssetscrapReqDto reqDto);
}
