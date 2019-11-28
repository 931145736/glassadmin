package com.xjt.service;

import com.xjt.dto.AssetinfoReqDto;
import com.xjt.dto.BaseResDto;
import com.xjt.entity.Master;

import java.util.List;

public interface AssetinfoService {

    /***
    *@Description 查看物资信息列表 
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/15
    *@Time 
    */
    BaseResDto queryAssetList(AssetinfoReqDto reqDto);
    
    /***
    *@Description 添加物资信息  
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/15
    *@Time 
    */
    BaseResDto addAssetinfo(List<AssetinfoReqDto> reqDtos, Master master);
    
}
