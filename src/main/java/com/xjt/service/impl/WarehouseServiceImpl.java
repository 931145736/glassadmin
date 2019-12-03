package com.xjt.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.regexp.internal.RE;
import com.xjt.business.WarehouseBusinessService;
import com.xjt.dao.master.CompanyDao;
import com.xjt.dao.master.RightorganizationDao;
import com.xjt.dao.master.SupplyDao;
import com.xjt.dao.master.WarehouseDao;
import com.xjt.dto.BaseResDto;
import com.xjt.dto.WarehouseReqDto;
import com.xjt.entity.Company;
import com.xjt.entity.Rightorganization;
import com.xjt.entity.Supply;
import com.xjt.entity.Warehouse;
import com.xjt.enums.ResultCode;
import com.xjt.service.WarehouseService;
import com.xjt.utils.STRUtils;


import com.xjt.utils.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Resource
    private WarehouseBusinessService businessService;
    @Resource
    private WarehouseDao warehouseDao;
    @Resource
    private SupplyDao supplyDao;
    @Resource
    private CompanyDao companyDao;
    @Resource
    private RightorganizationDao rightorganizationDao;

    private Logger logger = LoggerFactory.getLogger(WarehouseServiceImpl.class);

    /**
     * 增加仓库
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto insertWareHouse(WarehouseReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        if(!checkParams(reqDto,baseResDto)){
            return baseResDto;
        }

        try{

            Warehouse warehouse = new Warehouse();
            BeanUtils.copyProperties(reqDto,warehouse);
            arrayToStr(reqDto,warehouse);
            warehouse.setWarehouseNo(STRUtils.createUUID());
            businessService.insertWarehouse(warehouse);

        }catch (Exception e){
            baseResDto.setResultMessage("增加仓库异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("增加仓库异常",e);
        }

        return baseResDto;
    }

    private void arrayToStr(WarehouseReqDto reqDto,Warehouse warehouse){
        List<String> list = null;
        if(reqDto.getSupplyNo()!=null&&!reqDto.getSupplyNo().toString().equals("")){
            list =(List<String>)reqDto.getSupplyNo();
            if(list!=null&&list.size()>0){
                String[] supplys = new String[list.size()];
                list.toArray(supplys);
                warehouse.setSupplyNo(StringUtils.join(supplys,","));
            }
        }
       if(reqDto.getCompanyId()!=null&&!reqDto.getCompanyId().toString().equals("")){
           list = (List<String>)reqDto.getCompanyId();
           if(list!=null&&list.size()>0){
               String[] companys = new String[list.size()];
               list.toArray(companys);
               warehouse.setCompanyId(StringUtils.join(companys,","));
           }
       }
        if(reqDto.getId()!=null&&!reqDto.getId().toString().equals("")){
            list = (List<String>)reqDto.getId();

            if(list!=null&&list.size()>0){
                String[] ids = new String[list.size()];
                list.toArray(ids);
                warehouse.setId(StringUtils.join(ids,","));
            }
        }


    }

    /**
     * 查看仓库列表
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto queryWarehouseList(WarehouseReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        Integer pageNo = reqDto.getPageNo();
        Integer pageSize = reqDto.getPageSize();
        if(pageNo==null){
            baseResDto.setResultMessage("pageNo is null");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }

        try{
            PageHelper.startPage(pageNo,pageSize);
            List<Warehouse> warehouses = warehouseDao.queryWarehouseList(reqDto);
            PageInfo<Warehouse> pageInfo = new PageInfo<>(warehouses);
            baseResDto.setData(pageInfo);


        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("查看仓库列表异常");
            logger.error("查看仓库列表异常",e);
        }
        return baseResDto;
    }

    /**
     * 查看仓库详情
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto queryHouseInfo(WarehouseReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        String wareNo = reqDto.getWarehouseNo();
        if(STRUtils.isEmpty(wareNo)){
            baseResDto.setResultMessage("warehouseNo is null");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        try{
            Warehouse warehouse = warehouseDao.selectByPrimaryKey(wareNo);
            getOtherInfo(warehouse);
            baseResDto.setData(warehouse);
        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("查看仓库详情异常");
            logger.error("查看仓库详情异常",e);
        }
        return baseResDto;
    }

    private void getOtherInfo(Warehouse warehouse){
        String supplyIds =warehouse.getSupplyNo();
        List<String> ids = new ArrayList<>();
        if(!STRUtils.isEmpty(supplyIds)){
           ids = Arrays.asList(supplyIds.split(","));
           List<Supply> supplies = supplyDao.querySupplyList(ids);
           warehouse.setSupplies(supplies);
        }
        String companyIds = warehouse.getCompanyId();
        if(!STRUtils.isEmpty(companyIds)){
            ids = Arrays.asList(companyIds.split(","));
            List<Company> companies = companyDao.queryCompanyListByIds(ids);
            warehouse.setCompanies(companies);
        }
        String organizationIds = warehouse.getId();
        if(!STRUtils.isEmpty(organizationIds)){
            ids = Arrays.asList(organizationIds.split(","));
            List<Rightorganization> rightorganizations = rightorganizationDao.queryListByIds(ids);
            warehouse.setRightorganizations(rightorganizations);
        }

    }

    private boolean checkParams(WarehouseReqDto reqDto,BaseResDto resDto){
        boolean flag = true;
        if(STRUtils.isEmpty(reqDto.getWarehouseNa())){
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            resDto.setResultMessage("仓库名称不能为空");
            flag = false;
        }
        if(STRUtils.isEmpty(reqDto.getAddress())){
            resDto.setResultMessage("仓库地址不能为空");
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            flag = false;
        }
        if(STRUtils.isEmpty(reqDto.getZipcode())){
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            resDto.setResultMessage("仓库电话不能为空");
            flag = false;
        }
        if(STRUtils.isEmpty(reqDto.getKeyman())){
            resDto.setResultMessage("仓库负责人不能为空");
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            flag = false;
        }
        if(reqDto.getTag()==null){
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            resDto.setResultMessage("tag is null");
            flag = false;
        }
        return flag;
    }
}
