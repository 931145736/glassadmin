package com.xjt.dao.master;

import com.xjt.dto.ArrivalReqDto;
import com.xjt.entity.Arrival;
import com.xjt.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArrivalDao {
    int deleteByPrimaryKey(String arrivalid);

    int insert(Arrival record);

    int insertSelective(Arrival record);

    List<OrderEntity> selectByPrimaryKey(String arrivalid);

    int updateByPrimaryKeySelective(Arrival record);

    int updateByPrimaryKey(Arrival record);
    
    /***
    *@Description 审核到货通知单
    * * @param reqDto
    *@Return int
    *@Author Administrator
    *@Date 2019/11/7
    *@Time 
    */
    int checkArrivalOrder(ArrivalReqDto reqDto);

    /***
    *@Description 查看到货通知单列表
    * * @param reqDto
    *@Return java.util.List<com.xjt.entity.Arrival>
    *@Author Administrator
    *@Date 2019/11/12
    *@Time
    */
    List<OrderEntity> queryArrivalOrderList(OrderEntity reqDto);
}