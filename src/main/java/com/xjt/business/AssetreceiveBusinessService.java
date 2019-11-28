package com.xjt.business;

import com.xjt.dto.AssetreceiveReqDto;
import com.xjt.entity.Assetreceive;

import java.util.List;

public interface AssetreceiveBusinessService {

    void insertAssetReceive(AssetreceiveReqDto reqDto);

    void checkAssetReceive(Assetreceive reqDto);
}
