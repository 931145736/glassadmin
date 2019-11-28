package com.xjt.service.impl;

import com.xjt.business.CustomerBusinessService;
import com.xjt.dao.master.CustomerDao;
import com.xjt.dto.BaseResDto;
import com.xjt.dto.CustomerReqDto;
import com.xjt.entity.Customer;
import com.xjt.enums.ResultCode;
import com.xjt.service.CustomerService;
import com.xjt.utils.STRUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @ClassNameCustomerServiceImpl
 * @Description
 * @Author
 * @Date2019/11/6 9:47
 * @Version V1.0
 **/
@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerBusinessService businessService;
    @Resource
    private CustomerDao customerDao;

    private Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    /***
    *@Description 添加渠道信息
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/6
    *@Time 
    */
    @Override
    public BaseResDto insertCustomer(CustomerReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        if(!checkParams(reqDto,baseResDto)){
            return baseResDto;
        }
        try{
            Customer customer = new Customer();
            BeanUtils.copyProperties(reqDto,customer);
            customer.setCustomerId(STRUtils.createUUID());
            customer.setInputDate(new Date());
            businessService.insertCustomer(customer);


        }catch (Exception e){
            baseResDto.setResultMessage("增加渠道信息异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("增加渠道信息异常",e);
        }
        return baseResDto;
    }

    /**
    *@Description 查看渠道详情
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/6
    *@Time
    */
    @Override
    public BaseResDto queryCustomerInfo(CustomerReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        String customerId = reqDto.getCustomerId();
        if(STRUtils.isEmpty(customerId)){
            baseResDto.setResultMessage("customerId is null");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        try{
            Customer customer = customerDao.selectByPrimaryKey(customerId);
            baseResDto.setData(customer);

        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("查看渠道详情异常");
            logger.error("查看渠道详情异常",e);
        }
        return baseResDto;
    }

    private boolean checkParams(CustomerReqDto reqDto,BaseResDto resDto){
        boolean flag = true;
        if(STRUtils.isEmpty(reqDto.getCustomerNa())){
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            resDto.setResultMessage("渠道名称 customerNa is null");
            flag = false;
        }
        if(STRUtils.isEmpty(reqDto.getAbbrev())){
            resDto.setResultMessage("渠道简称 abbrev is null");
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            flag = false;
        }
        if(STRUtils.isEmpty(reqDto.getFictitiousperson())){
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            resDto.setResultMessage(" 企业法人 fictitiousperson is null ");
            flag = false;
        }
        return  flag;
    }
}
