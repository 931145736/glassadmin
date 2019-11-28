package com.xjt.business;

import com.xjt.dto.AssetapplyReqDto;

import java.util.List;

public interface AssetApplyBusinessService {

    void insertAssetApplyBatch(AssetapplyReqDto reqDto);

    void checkAssetApply(AssetapplyReqDto reqDto);
}
