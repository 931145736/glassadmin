package com.xjt.service.impl;

import com.xjt.business.ModuleshowfieldsBusService;
import com.xjt.dao.master.ModuleshowfieldsDao;
import com.xjt.dto.BaseResDto;
import com.xjt.dto.FieldReqDto;
import com.xjt.dto.ModuleshowfieldsReqDto;
import com.xjt.entity.Moduleshowfields;
import com.xjt.enums.ResultCode;
import com.xjt.service.ModuleshowfieldsService;
import com.xjt.utils.STRUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassNameModuleshowfieldsServiceImpl
 * @Description
 * @Author
 * @Date2019/11/6 14:38
 * @Version V1.0
 **/
@Service
public class ModuleshowfieldsServiceImpl implements ModuleshowfieldsService {

    @Resource
    private ModuleshowfieldsDao dao;
    @Resource
    private ModuleshowfieldsBusService busService;
    private Logger logger = LoggerFactory.getLogger(ModuleshowfieldsServiceImpl.class);

    /***
    *@Description 添加模块信息
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/6
    *@Time
    */
    @Override
    public BaseResDto insertModule(ModuleshowfieldsReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        if(!checkParam(reqDto,baseResDto)){
            return  baseResDto;
        }

        try{
            List<String> fieldNames = reqDto.getFiledNames();
            List<Moduleshowfields> moduleshowfieldsList = new ArrayList<>();
            String moduleId = STRUtils.createUUID();
            for(String fileName:fieldNames){
                Moduleshowfields moduleshowfields = new Moduleshowfields();
                moduleshowfields.setFieldid(STRUtils.createUUID());
                moduleshowfields.setFieldname(fileName);
                moduleshowfields.setModuleid(moduleId);
                moduleshowfields.setOrderindex(reqDto.getOrderindex());
                moduleshowfieldsList.add(moduleshowfields);
            }
           busService.insertModuleFields(moduleshowfieldsList);
            }catch (Exception e){
            baseResDto.setResultMessage("添加模块信息异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("添加模块信息异常",e);
        }
        return baseResDto;
    }

    /***
    *@Description 查看模块下字段列表
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/6
    *@Time
    */
    @Override
    public BaseResDto queryModuleListByModuleName(ModuleshowfieldsReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        String module = reqDto.getModuleid();
        if(STRUtils.isEmpty(module)){
            baseResDto.setResultMessage("模块名称 moduleid is null");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        try{
            List<Moduleshowfields> moduleshowfields = dao.queryModuleFieldsList(module);
            if(moduleshowfields==null||moduleshowfields.size()==0){
                baseResDto.setResultCode(ResultCode.RESULT_CODE_NODATA.getCode());
                baseResDto.setResultMessage("no data");
                return baseResDto;
            }
            baseResDto.setData(moduleshowfields);


        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("查看模块列表异常");
            logger.error("查看模块列表异常",e);
        }
        return baseResDto;
    }

    /***
    *@Description 批量删除模块下的字段
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/6
    *@Time
    */
    @Override
    public BaseResDto deleteFieldsFromModule(ModuleshowfieldsReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        if(STRUtils.isEmpty(reqDto.getModuleid())){
            baseResDto.setResultMessage("模块名称 moduleid is null");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        List<String> fieldIds = reqDto.getFieldids();
        if(fieldIds==null||fieldIds.size()==0){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("Please choose one fieldid at least");
            return baseResDto;
        }
        try{
          busService.deleteFieldsByModuleName(reqDto);
          }catch (Exception e){
            baseResDto.setResultMessage("删除模块下的字段异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("删除模块下的字段异常",e);
        }
        return baseResDto;
    }

    private  boolean checkParam(ModuleshowfieldsReqDto reqDto,BaseResDto resDto){
        boolean flag = true;
       if(reqDto.getFiledNames()==null||reqDto.getFiledNames().size()==0){
           resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
           resDto.setResultMessage("请至少添加一个字段");
           flag = false;
       }
        if(reqDto.getOrderindex()==null){
            resDto.setResultMessage("排序字段 orderindex is null" );
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            flag = false;
        }
        return  flag;
    }
}
