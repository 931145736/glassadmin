package com.xjt.service;

import com.xjt.dto.AssetapplyReqDto;
import com.xjt.dto.BaseResDto;

import java.util.List;

public interface AssetApplyService {


    /***
    *@Description 批量添加物资申请表
    * * @param
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/18
    *@Time
    */
    BaseResDto insertAssetApply(AssetapplyReqDto reqDto);

    /***
    *@Description 查看物资申请列表
    * * @param
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/18
    *@Time
    */
    BaseResDto queryAssetApplyList(AssetapplyReqDto reqDto);
    
    /**
    *@Description 查看物资申领表详情 
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/18
    *@Time 
    */
    BaseResDto queryApplyDetails(AssetapplyReqDto reqDto);

    /***
    *@Description 审核物资申领表
    * * @param
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/18
    *@Time
    */
    BaseResDto checkAssetApply(AssetapplyReqDto reqDto);
}
