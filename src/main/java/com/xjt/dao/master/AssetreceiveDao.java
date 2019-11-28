package com.xjt.dao.master;

import com.xjt.dto.AssetreceiveReqDto;
import com.xjt.entity.Assetreceive;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AssetreceiveDao {
    int deleteByPrimaryKey(String receiveId);

    int insert(Assetreceive record);

    int insertSelective(Assetreceive record);

    Assetreceive selectByPrimaryKey(String receiveId);

    int updateByPrimaryKeySelective(Assetreceive record);

    int updateByPrimaryKey(Assetreceive record);

    int insertAssetReceive(@Param("reqDtos") List<AssetreceiveReqDto> reqDtos);

    List<Assetreceive> queryReceiveList(AssetreceiveReqDto reqDto);


}