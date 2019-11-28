package com.xjt.dao.master;

import com.xjt.dto.PureceiptReqDto;
import com.xjt.entity.OrderEntity;
import com.xjt.entity.Pureceipt;
import com.xjt.fileupload.common.OrderBy;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PureceiptDao {
    int deleteByPrimaryKey(String pureceiptid);

    int insert(Pureceipt record);

    int insertSelective(Pureceipt record);

    List<OrderEntity> selectByPrimaryKey(String pureceiptid);

    int updateByPrimaryKeySelective(Pureceipt record);

    int updateByPrimaryKey(Pureceipt record);

    //更新单据审核状态
    int updateStatus(Pureceipt pureceipt);
    /***
    *@Description 查看到货单列表 
    * * @param reqDto
    *@Return java.util.List<com.xjt.entity.OrderEntity>
    *@Author Administrator
    *@Date 2019/11/12
    *@Time 
    */

    List<OrderEntity> queryPureceiptOrderList(OrderEntity reqDto);
}