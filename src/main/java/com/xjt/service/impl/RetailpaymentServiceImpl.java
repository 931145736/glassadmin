package com.xjt.service.impl;

import com.xjt.business.RetailpaymentBusinessSer;
import com.xjt.dto.BaseResDto;
import com.xjt.dto.RetailpaymentReqDto;
import com.xjt.entity.Retailpayment;
import com.xjt.enums.ResultCode;
import com.xjt.service.RetailpaymentService;
import com.xjt.utils.STRUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassNameRetailpaymentServiceImpl
 * @Description
 * @Author
 * @Date2019/11/5 9:07
 * @Version V1.0
 **/
@Service
public class RetailpaymentServiceImpl implements RetailpaymentService {

    @Resource
    private RetailpaymentBusinessSer businessSer;

    private Logger logger = LoggerFactory.getLogger(RetailpaymentServiceImpl.class);


    /**
    *@Description 添加支付说明
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/5
    *@Time
    */
    @Override
    public BaseResDto insertPayMent(RetailpaymentReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        if(STRUtils.isEmpty(reqDto.getPaymentname())){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("支付说明 paymentname is null");
            return baseResDto;
        }
        try{
            Retailpayment retailpayment = new Retailpayment();
            BeanUtils.copyProperties(reqDto,retailpayment);
            retailpayment.setPaymentid(STRUtils.createUUID());
            businessSer.insertPayMent(retailpayment);

        }catch (Exception e){
            baseResDto.setResultMessage("添加支付说明异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("添加支付说明异常",e);
        }
        return baseResDto;
    }
}
