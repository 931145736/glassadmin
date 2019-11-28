package com.xjt.business.impl;

import com.xjt.business.DeleteOrderBusinessService;
import com.xjt.dao.master.DeleteOrderDao;
import com.xjt.entity.DeleteOrderEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ClassNameDeleteOrderBusinessServiceImpl
 * @Description
 * @Author
 * @Date2019/11/13 14:48
 * @Version V1.0
 **/
@Service
public class DeleteOrderBusinessServiceImpl implements DeleteOrderBusinessService {

    @Resource
    private DeleteOrderDao deleteOrderDao;

    /***
    *@Description 删除订单  
    * * @param entity
    *@Return void
    *@Author Administrator
    *@Date 2019/11/15
    *@Time 
    */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteOrder(DeleteOrderEntity entity) {

        deleteOrderDao.deleteOrder(entity);
        Integer code = entity.getResultValue();
        if(code !=1){
            throw new RuntimeException("删除订单异常");
        }
    }
}
