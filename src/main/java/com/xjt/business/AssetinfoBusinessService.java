package com.xjt.business;

import com.xjt.dto.AssetinfoReqDto;
import com.xjt.entity.Assetinfo;

import java.util.List;

public interface AssetinfoBusinessService {

    void insetrAssetinfoBatch(List<AssetinfoReqDto> reqDtos);
}
