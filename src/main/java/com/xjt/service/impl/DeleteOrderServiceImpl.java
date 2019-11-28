package com.xjt.service.impl;

import com.xjt.business.DeleteOrderBusinessService;
import com.xjt.dao.master.DeleteOrderDao;
import com.xjt.dto.BaseResDto;
import com.xjt.entity.DeleteOrderEntity;
import com.xjt.enums.ResultCode;
import com.xjt.service.DeleteOrderService;
import com.xjt.utils.STRUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ClassNameDeleteOrderServiceImpl
 * @Description
 * @Author
 * @Date2019/11/13 14:08
 * @Version V1.0
 **/
@Service
public class DeleteOrderServiceImpl implements DeleteOrderService {


    @Resource
    private DeleteOrderBusinessService businessService;
    private Logger logger = LoggerFactory.getLogger(DeleteOrderServiceImpl.class);

    /***
    *@Description 删除订单
    * * @param entity
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/13
    *@Time
    */

    @Override
    public BaseResDto deleteOrder(DeleteOrderEntity entity) {
        BaseResDto baseResDto = new BaseResDto();
        String orderId = entity.getOrderId();
        Integer type = entity.getRequestType();
        if(STRUtils.isEmpty(orderId)){
            baseResDto.setResultMessage("orderId is null");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return  baseResDto;
        }
        try{

            //删除采购订单
            if(type==1){
                entity.setOrderMaster("purchase");
                entity.setOrderGoods("purchasegoods");
                entity.setOrderDetail("purchasedetail");
                entity.setColumnMaster("Purchase_ID");
                entity.setColumnGoods("PurchaseGoodsID");
            }else if (type==2){
                //删除到货通知单
                entity.setOrderMaster("arrival");
                entity.setOrderGoods("arrivalgoods");
                entity.setOrderDetail("arrivaldetail");
                entity.setColumnMaster("ArrivalID");
                entity.setColumnGoods("ArrivalGoodsID");
            }else if(type==3){
                entity.setOrderMaster("pureceipt");
                entity.setOrderGoods("pureceiptgoods");
                entity.setOrderDetail("pureceiptdetail");
                entity.setColumnMaster("PureceiptID");
                entity.setColumnGoods("PureceiptGoodsID");
            }
           businessService.deleteOrder(entity);
            logger.info("返回值"+entity.getResultValue());

        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("删除订单异常");
            logger.error("删除订单异常",e);

        }
        return baseResDto;
    }
}
