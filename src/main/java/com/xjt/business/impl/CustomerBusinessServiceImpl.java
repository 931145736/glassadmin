package com.xjt.business.impl;

import com.xjt.business.CustomerBusinessService;
import com.xjt.dao.master.*;
import com.xjt.dto.CustomerReqDto;
import com.xjt.entity.Customer;
import com.xjt.entity.CustomeraccountsKey;
import com.xjt.entity.Dictbankaccounts;
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
    @Resource
    private DictbankaccountsDao dictbankaccountsDao;

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
        customer.setCompanyId(reqDto.getCompanyid());
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
        insertCustomerAccount(reqDto,customerId);

    }

    private void insertCustomerAccount(CustomerReqDto reqDto,String customerId){
        if(!STRUtils.isEmpty(reqDto.getAccounts())){
            String accountId = STRUtils.createUUID();
            Dictbankaccounts dictbankaccounts = new Dictbankaccounts();
            dictbankaccounts.setAccounts(reqDto.getAccounts());
            dictbankaccounts.setAccountsname(reqDto.getAccountsName());
            dictbankaccounts.setBank(reqDto.getBank());
            dictbankaccounts.setBankaddr(reqDto.getBankaddr());
            dictbankaccounts.setBanktel(reqDto.getBanktel());
            dictbankaccounts.setCmemo(reqDto.getCmemo());
            dictbankaccounts.setTel(reqDto.getTel());
            dictbankaccounts.setBanknumber(reqDto.getBanknumber());
            dictbankaccounts.setId(accountId);
            int num4 =dictbankaccountsDao.insert(dictbankaccounts);
            if(num4!=1){
                throw new RuntimeException("添加开户行信息异常");
            }
            //添加渠道开户行信息
            CustomeraccountsKey account = new CustomeraccountsKey();
            account.setCustomerId(customerId);
            account.setId(accountId);
            int num3 = customeraccountsDao.insert(account);
            if(num3!=1){
                throw new RuntimeException("添加渠道开户行信息异常");
            }
        }
    }

    /**
    *@Description 删除渠道
    * * @param reqDto
    *@Return void
    *@Author Administrator
    *@Date 2019/12/19
    *@Time
    */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteCustomer(CustomerReqDto reqDto) {
        String customerId = reqDto.getCustomerId();
        Integer deleteFlag = reqDto.getDeleteFlag();

        customerDao.deleteCustomer(customerId,deleteFlag);
        customerbrandDao.deleteCustomer(customerId);
        customeraccountsDao.deleteCustomer(customerId);
        customergroupDao.deleteCustomer(customerId,deleteFlag);


    }

    /***
    *@Description 更新渠道
    * * @param reqDto
    *@Return void
    *@Author Administrator
    *@Date 2019/12/20
    *@Time
    */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateCustomer(CustomerReqDto reqDto) {
        String customerId = reqDto.getCustomerId();
        //更新渠道主体信息
        Customer customer = new Customer();
        BeanUtils.copyProperties(reqDto,customer);
        Date nowDate = new Date();
        customer.setInputDate(nowDate);
        customer.setCompanyId(reqDto.getCompanyid());
        int num1 = customerDao.updateByPrimaryKeySelective(customer);
        if(num1 !=1){
            throw new RuntimeException("更新渠道信息异常");
        }
        //更新渠道对应品牌(删除旧的 添加新的)
        List<String> customerBrands = reqDto.getBrandNames();
        if(customerBrands!=null&&customerBrands.size()>0){
            customerbrandDao.deleteCustomer(customerId);
            int num2 =customerbrandDao.insertCustomerBrandBatch(customerId,customerBrands);
            if(num2 != customerBrands.size()){
                throw new RuntimeException("更新渠道品牌异常");
            }
        }
        //更新渠道账户
        if(!STRUtils.isEmpty(reqDto.getAccounts())){
            customeraccountsDao.deleteCustomer(customerId);
            insertCustomerAccount(reqDto,customerId);
        }



    }
}
