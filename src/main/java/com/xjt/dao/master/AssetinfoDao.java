package com.xjt.dao.master;

import com.xjt.dto.AssetinfoReqDto;
import com.xjt.entity.Assetinfo;
import com.xjt.entity.Assetreceivedetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AssetinfoDao {
    int deleteByPrimaryKey(String assetId);

    int insert(Assetinfo record);

    int insertSelective(Assetinfo record);

    Assetinfo selectByPrimaryKey(String assetId);

    int updateByPrimaryKeySelective(Assetinfo record);

    int updateByPrimaryKey(Assetinfo record);

    List<Assetinfo> queryAssetList();
    
    /***
    *@Description 批量添加物资信息
    * * @param reqDtos
    *@Return int
    *@Author Administrator
    *@Date 2019/11/15
    *@Time 
    */
    int insertAssetinfoBatch(@Param("reqDtos") List<AssetinfoReqDto> reqDtos);

    /***
    *@Description 根据物资id查看物资信息
    * * @param assetIds
    *@Return java.util.List<com.xjt.entity.Assetinfo>
    *@Author Administrator
    *@Date 2019/11/18
    *@Time
    */
    List<Assetinfo> queryByAssetId(@Param("assetIds") List<String> assetIds);

    int updateAssetCount(@Param("assetinfos")  List<Assetinfo> assetinfos);
}