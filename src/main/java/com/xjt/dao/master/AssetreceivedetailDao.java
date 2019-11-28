package com.xjt.dao.master;

import com.xjt.dto.AssetreceiveReqDto;
import com.xjt.entity.Assetreceivedetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AssetreceivedetailDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Assetreceivedetail record);

    int insertSelective(Assetreceivedetail record);

    Assetreceivedetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Assetreceivedetail record);

    int updateByPrimaryKey(Assetreceivedetail record);

    int insertReceiveDetail(@Param("assetreceivedetails") List<Assetreceivedetail> assetreceivedetails);

    List<Assetreceivedetail> queryByReceiveId(String receiveId);

    //查看领用的物资信息
    List<Assetreceivedetail> queryReceiveAssetInfo(AssetreceiveReqDto reqDto);



}