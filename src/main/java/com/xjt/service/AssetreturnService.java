package com.xjt.service;

import com.xjt.dto.AssetreturnReqDto;
import com.xjt.dto.BaseResDto;

public interface AssetreturnService {

    BaseResDto addAssetReturn(AssetreturnReqDto reqDto);

    /***
    *@Description 审核物资归还
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/20
    *@Time 
    */
    BaseResDto checkAssetReturn(AssetreturnReqDto reqDto);
}
