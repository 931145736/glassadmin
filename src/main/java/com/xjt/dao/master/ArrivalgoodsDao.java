package com.xjt.dao.master;

import com.xjt.entity.Arrivalgoods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArrivalgoodsDao {
    int deleteByPrimaryKey(String arrivalgoodsid);

    int insert(Arrivalgoods record);

    int insertSelective(Arrivalgoods record);

    Arrivalgoods selectByPrimaryKey(String arrivalgoodsid);

    int updateByPrimaryKeySelective(Arrivalgoods record);

    int updateByPrimaryKey(Arrivalgoods record);

    /***
    *@Description 批量添加通知单货品
    * * @param arrivalgoods
    *@Return int
    *@Author Administrator
    *@Date 2019/11/7
    *@Time
    */
    int insertArrivalGoods(@Param("arrivalgoods") List<Arrivalgoods> arrivalgoods);
}