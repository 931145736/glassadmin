package com.xjt.business.impl;

import com.xjt.business.CustomerBusinessService;
import com.xjt.dao.master.CustomerDao;
import com.xjt.dao.master.CustomeraccountsDao;
import com.xjt.dao.master.CustomerbrandDao;
import com.xjt.dao.master.CustomergroupDao;
import com.xjt.dto.CustomerReqDto;
import com.xjt.entity.Customer;
import com.xjt.entity.CustomeraccountsKey;
import com.xjt.utils.STRUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @ClassNameCustomerBusinessServiceImpl
 * @Description
 * @Author
 * @Date2019/11/6 9:43
 * @Version V1.0
 **/
@Service
public class CustomerBusinessServiceImpl implements CustomerBusinessService {

    @Resource
    private CustomerDao customerDao;
    @Resource
    private CustomerbrandDao customerbrandDao;
    @Resource
    private CustomeraccountsDao customeraccountsDao;
    @Resource
    private CustomergroupDao customergroupDao;

    /**
    *@Description  增加渠道信息
    * * @param customer
    *@Return void
    *@Author Administrator
    *@Date 2019/11/6
    *@Time
    */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertCustomer(CustomerReqDto reqDto) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(reqDto,customer);
        String customerId = STRUtils.createUUID();
        Date nowDate = new Date();
        customer.setCustomerId(customerId);
        customer.setInputDate(nowDate);
        //添加渠道信息
        int num = customerDao.insert(customer);
        if (num !=1){
            throw new RuntimeException("添加渠道信息异常");
        }
        //添加渠道品牌信息
        List<String> brandNames = reqDto.getBrandNames();
        if(brandNames!=null&&brandNames.size()>0){
            int num2 =customerbrandDao.insertCustomerBrandBatch(customerId,brandNames);
            if(num2 != brandNames.size()){
                throw new RuntimeException("添加渠道品牌异常");
            }
        }
        //添加渠道开户行信息
        if(!STRUtils.isEmpty(reqDto.getAccountId())){
            CustomeraccountsKey account = new CustomeraccountsKey();
            account.setCustomerId(customerId);
            account.setId(reqDto.getAccountId());
            int num3 = customeraccountsDao.insert(account);
            if(num3!=1){
                throw new RuntimeException("添加渠道开户行信息异常");
            }
        }



    }
}
