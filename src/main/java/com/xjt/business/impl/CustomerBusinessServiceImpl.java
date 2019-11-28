package com.xjt.business.impl;

import com.xjt.business.CustomerBusinessService;
import com.xjt.dao.master.CustomerDao;
import com.xjt.entity.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

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
    public void insertCustomer(Customer customer) {
        int num = customerDao.insert(customer);
        if (num !=1){
            throw new RuntimeException("添加渠道信息异常");
        }
    }
}
