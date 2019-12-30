package com.xjt.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xjt.business.CustomerBusinessService;
import com.xjt.dao.master.CustomerDao;
import com.xjt.dao.master.CustomeraccountsDao;
import com.xjt.dao.master.CustomerbrandDao;
import com.xjt.dao.master.MasterDao;
import com.xjt.dto.BaseResDto;
import com.xjt.dto.CustomerReqDto;
import com.xjt.entity.Customer;
import com.xjt.entity.CustomeraccountsKey;
import com.xjt.entity.Customerbrand;
import com.xjt.entity.Master;
import com.xjt.enums.ResultCode;
import com.xjt.service.CustomerService;
import com.xjt.utils.DateUtil;
import com.xjt.utils.STRUtils;
import com.xjt.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

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
    @Resource
    private CustomerbrandDao customerbrandDao;
    @Resource
    private CustomeraccountsDao accountDao;
    @Resource
    private MasterDao masterDao;

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

            getBrands(reqDto);
            reqDto.setShutout(0);

            businessService.insertCustomer(reqDto);


        }catch (Exception e){
            baseResDto.setResultMessage("增加渠道信息异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("增加渠道信息异常",e);
        }
        return baseResDto;
    }

    private void getBrands(CustomerReqDto reqDto) throws ParseException {
        List<String> brands = null;
        if(reqDto.getBrands()!=null&&!reqDto.getBrands().toString().equals("")){
            brands = (List<String>)reqDto.getBrands();
            reqDto.setBrandNames(brands);
        }
        List<String> saleMans = null;
        if(reqDto.getSalemans()!=null&&!reqDto.getSalemans().toString().equals("")){
            saleMans = (List<String>) reqDto.getSalemans();
            if(saleMans!=null&&saleMans.size()>0){

                String[] mans = new String[saleMans.size()];
                saleMans.toArray(mans);
                logger.info("业务员"+JSONObject.toJSONString(mans));
                reqDto.setSaleman(StringUtils.join(mans,","));
            }
        }

        String openDate = reqDto.getPractisedatestr();
        String closedDate = reqDto.getShutoutdatestr();
        if(!StringUtils.isEmpty(openDate)&&!openDate.equals("0-0-0 0:0:0")){
            Date date = DateUtil.getDate(openDate,"yyyy-MM-dd");
            reqDto.setPractisedate(date);
        }
        if(!StringUtils.isEmpty(closedDate)&&!closedDate.equals("0-0-0 0:0:0")){
            Date date = DateUtil.getDate(closedDate,"yyyy-MM-dd");
            reqDto.setShutoutdate(date);
        }
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
            Customer customer1 =getOtherInfo(customer);
            baseResDto.setData(customer1);

        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("查看渠道详情异常");
            logger.error("查看渠道详情异常",e);
        }
        return baseResDto;
    }

    /***
    *@Description 查看渠道列表
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/12/12
    *@Time
    */
    @Override
    public BaseResDto queryCustomerList(CustomerReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        Integer pageNo = reqDto.getPageNo();
        if(pageNo==null){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("pageNo is null");
            return baseResDto;
        }
        Integer pageSize = reqDto.getPageSize();
        try{
            PageHelper.startPage(pageNo,pageSize);
            List<Customer> customers = customerDao.queryCustomerLists(reqDto);
            PageInfo<Customer> pageInfo = new PageInfo<>(customers);
            baseResDto.setData(pageInfo);
        }catch (Exception e){
            baseResDto.setResultMessage("查看渠道列表发生异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("查看渠道列表发生异常",e);
        }
        return baseResDto;
    }

    @Override
    public BaseResDto deleteCustomer(CustomerReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        String customerId = reqDto.getCustomerId();
        if(STRUtils.isEmpty(customerId)){
            baseResDto.setResultMessage("customerId is null");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        try{
            reqDto.setDeleteFlag(0);
            businessService.deleteCustomer(reqDto);

        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("删除渠道异常");
            logger.error("删除渠道异常",e);
        }
        return baseResDto;
    }

    /***
    *@Description 更新渠道信息
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/12/20
    *@Time
    */
    @Override
    public BaseResDto updateCustomer(CustomerReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        String customerId = reqDto.getCustomerId();
        if(STRUtils.isEmpty(customerId)){
            baseResDto.setResultMessage("customerId is null");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        try{
            getBrands(reqDto);
            businessService.updateCustomer(reqDto);

        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("更新渠道信息异常");
            logger.error("更新渠道信息异常");
        }
        return baseResDto;
    }

    private Customer getOtherInfo(Customer customer){
            //渠道品牌信息
            String customerId = customer.getCustomerId();
            List<Customerbrand> customerbrands = customerbrandDao.queryListByCId(customerId);
            if(customerbrands!=null&&customerbrands.size()>0){
                //渠道品牌
                List<String> brands = customerbrands.stream().map(Customerbrand::getBrandName).collect(Collectors.toList());
                String brandNames = listToString(brands);
                customer.setBrandNames(brandNames);
            }
            //渠道开户行信息
            List<CustomeraccountsKey> accounts = accountDao.queryCustomerAccounts(customerId);
            if(accounts!=null&&accounts.size()>0){
                CustomeraccountsKey key = accounts.get(0);
                customer.setAccountName(key.getAccountName());
                customer.setAccounts(key.getAccounts());
                customer.setBank(key.getBank());
                customer.setBankaddr(key.getBankaddr());
                customer.setBanknumber(key.getBanknumber());
                customer.setBanktel(key.getBanktel());
                customer.setTel(key.getTel());
                customer.setCmemo(key.getCmemo());
            }
            //业务员信息
            String saleMans = customer.getSaleman();
            if(!STRUtils.isEmpty(saleMans)){
                List<String> manIds = Arrays.asList(saleMans.split(","));
                List<Master> masters = masterDao.queryByIds(manIds);
                List<String> masterNames = masters.stream().map(Master::getTrueName).collect(Collectors.toList());
                String masterName = listToString(masterNames);
                customer.setSaleman(masterName);

            }


            return customer;
    }

    private String listToString(List<String> list){
        StringBuilder sbu = new StringBuilder();
        if(list!=null&&list.size()>0){

            for(String str:list){
                sbu.append(str).append(",");
            }
            sbu.delete(sbu.length()-1,sbu.length());
        }
        return sbu.toString();
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
