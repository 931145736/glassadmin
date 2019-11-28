package com.xjt.business.impl;

import com.xjt.business.RetailpaymentBusinessSer;
import com.xjt.dao.master.RetailpaymentDao;
import com.xjt.entity.Retailpayment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ClassNameRetailpaymentBusinessSerImpl
 * @Description
 * @Author
 * @Date2019/11/5 9:02
 * @Version V1.0
 **/
@Service
public class RetailpaymentBusinessSerImpl implements RetailpaymentBusinessSer {

    @Resource
    private RetailpaymentDao retailpaymentDao;

    /**
    *@Description  添加支付説明
    * * @param retailpayment
    *@Return void
    *@Author Administrator
    *@Date 2019/11/5
    *@Time
    */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertPayMent(Retailpayment retailpayment) {

        int num = retailpaymentDao.insert(retailpayment);

        if(num !=1){
            throw new RuntimeException("添加支付説明异常");
        }
    }
}
