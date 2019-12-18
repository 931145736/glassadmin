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
import java.util.Map;
import java.util.stream.Collectors;

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
            getOtherInfos(warehouses);

            PageInfo<Warehouse> pageInfo = new PageInfo<>(warehouses);
            baseResDto.setData(pageInfo);


        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("查看仓库列表异常");
            logger.error("查看仓库列表异常",e);
        }
        return baseResDto;
    }

    private void getOtherInfos(List<Warehouse> warehouses){
        if(warehouses!=null&&warehouses.size()>0){
            for(Warehouse warehouse:warehouses){
                getOtherInfo(warehouse);
            }

        }
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

    @Override
    public BaseResDto updateWarehouseInfo(WarehouseReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        if(!checkParams(reqDto,baseResDto)){
            return baseResDto;
        }
        try{
            Warehouse warehouse = new Warehouse();
            BeanUtils.copyProperties(reqDto,warehouse);
            warehouseDao.updateByPrimaryKeySelective(warehouse);

        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("更新仓库信息异常");
            logger.error("更新仓库信息异常",e);
        }
        return baseResDto;
    }

    @Override
    public BaseResDto openOrCloseWare(WarehouseReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        logger.info("参数信息"+JSONObject.toJSONString(reqDto));
        if(StringUtils.isEmpty(reqDto.getWarehouseNo())){
            baseResDto.setResultMessage("仓库编号为空");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        if(reqDto.getShutout()==null){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("参数错误");
            return baseResDto;
        }
        try{
            if(reqDto.getShutout()==0){
                reqDto.setShutout(1);
            }else if(reqDto.getShutout()==1){
                reqDto.setShutout(0);
            }
            int num = warehouseDao.openOrStopWare(reqDto);
            if(num != 1){
                baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
                baseResDto.setResultMessage("停启用仓库异常");
            }

        }catch (Exception e){
            baseResDto.setResultMessage("停启用仓库异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("停启用仓库异常",e);
        }
        return baseResDto;
    }

    @Override
    public BaseResDto deleteWareHouse(WarehouseReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        if(StringUtils.isEmpty(reqDto.getWarehouseNo())){
            baseResDto.setResultMessage("warehouseNo is null");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        try{
            int num =warehouseDao.deleteWarehouse(reqDto);
            if(num !=1){
                baseResDto.setResultMessage("删除仓库异常");
                baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            }
        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("删除仓库异常");
            logger.error("删除仓库异常",e);
        }
        return baseResDto;
    }

    private void getOtherInfo(Warehouse warehouse){
        StringBuilder sbu = new StringBuilder();
        String supplyIds =warehouse.getSupplyNo();
        List<String> ids = new ArrayList<>();
        if(!STRUtils.isEmpty(supplyIds)){
           ids = Arrays.asList(supplyIds.split(","));
           List<Supply> supplies = supplyDao.querySupplyList(ids);
            if(supplies!=null&&supplies.size()>0){
                for(Supply s:supplies){
                    sbu.append(s.getSupplyNa()).append(",");
                }
                sbu.delete(sbu.length()-1,sbu.length());
                warehouse.setSupplyName(sbu.toString());
                sbu.delete(0,sbu.length());
            }
           //warehouse.setSupplies(supplies);
        }
        String companyIds = warehouse.getCompanyId();
        if(!STRUtils.isEmpty(companyIds)){
            ids = Arrays.asList(companyIds.split(","));
            List<Company> companies = companyDao.queryCompanyListByIds(ids);
            if(companies!=null&&companies.size()>0){
                for(Company c:companies){
                    sbu.append(c.getCompanyNa()).append(",");
                }
                sbu.delete(sbu.length()-1,sbu.length());
                warehouse.setCompanyName(sbu.toString());
                sbu.delete(0,sbu.length());
            }
            //warehouse.setCompanies(companies);
        }
        String organizationIds = warehouse.getId();
        if(!STRUtils.isEmpty(organizationIds)){
            ids = Arrays.asList(organizationIds.split(","));
            List<Rightorganization> rightorganizations = rightorganizationDao.queryListByIds(ids);
            if(rightorganizations!=null&&rightorganizations.size()>0){
                for(Rightorganization r:rightorganizations){
                    sbu.append(r.getOrganization()).append(",");
                }
                sbu.delete(sbu.length()-1,sbu.length());
                warehouse.setOrganizationName(sbu.toString());
                sbu.delete(0,sbu.length());
            }
            //warehouse.setRightorganizations(rightorganizations);
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
