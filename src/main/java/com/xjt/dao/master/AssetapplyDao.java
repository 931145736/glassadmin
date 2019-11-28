package com.xjt.dao.master;

import com.xjt.dto.AssetapplyReqDto;
import com.xjt.entity.Assetapply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AssetapplyDao {
    int deleteByPrimaryKey(String applyId);

    int insert(Assetapply record);

    int insertSelective(Assetapply record);

    Assetapply selectByPrimaryKey(String applyId);

    int updateByPrimaryKeySelective(Assetapply record);

    int updateByPrimaryKey(Assetapply record);


    /**
    *@Description 查看物资申请表列表
    * * @param
    *@Return java.util.List<com.xjt.entity.Assetapply>
    *@Author Administrator
    *@Date 2019/11/18
    *@Time
    */
    List<Assetapply> assetApplyList(AssetapplyReqDto reqDto);
    /**
    *@Description 查看物资申领表详情
    * * @param applyId
    *@Return com.xjt.entity.Assetapply
    *@Author Administrator
    *@Date 2019/11/18
    *@Time
    */
    List<Assetapply> queryApplyDetail(String applyId);

    int checkApply(AssetapplyReqDto reqDto);
}