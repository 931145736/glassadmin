package com.xjt.business;

import com.xjt.dto.AssetreturnReqDto;

public interface AssetreturnBusinessService {

    void addAssetReturn(AssetreturnReqDto reqDto);

    void checkAssetReturn(AssetreturnReqDto reqDto);
}
