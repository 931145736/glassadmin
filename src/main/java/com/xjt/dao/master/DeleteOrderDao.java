package com.xjt.dao.master;

import com.xjt.entity.DeleteOrderEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeleteOrderDao {

    /***
    *@Description 删除订单
    * * @param entity
    *@Return int
    *@Author Administrator
    *@Date 2019/11/13
    *@Time
    */
    int deleteOrder(DeleteOrderEntity entity);
}
