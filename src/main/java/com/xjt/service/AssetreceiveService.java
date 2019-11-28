package com.xjt.service;

import com.xjt.dto.AssetreceiveReqDto;
import com.xjt.dto.BaseResDto;

import java.util.List;

public interface AssetreceiveService {
    
    /***
    *@Description 添加物资领用表
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/18
    *@Time 
    */
    BaseResDto insertAssetReceive(AssetreceiveReqDto reqDto);

    /**
    *@Description 审核物资领用表
    * * @param
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/18
    *@Time
    */
    BaseResDto checkAssetReceive(AssetreceiveReqDto reqDto);
    
    /***
    *@Description 查看领用单列表 
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/18
    *@Time 
    */
    BaseResDto queryAssetReceiveList(AssetreceiveReqDto reqDto);
    
    /***
    *@Description 查看领用的物资信息 
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/20
    *@Time 
    */
    BaseResDto queryReceiveAssetInfo(AssetreceiveReqDto reqDto);
}
