package com.xjt.business.impl;

import com.xjt.business.ModuleshowfieldsBusService;
import com.xjt.dao.master.ModuleshowfieldsDao;
import com.xjt.dto.ModuleshowfieldsReqDto;
import com.xjt.entity.Moduleshowfields;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassNameModuleshowfieldsBusServiceImpl
 * @Description
 * @Author
 * @Date2019/11/6 16:25
 * @Version V1.0
 **/
@Service
public class ModuleshowfieldsBusServiceImpl implements ModuleshowfieldsBusService {

    @Resource
    private ModuleshowfieldsDao moduleshowfieldsDao;


    /***
    *@Description 批量添加模块下的字段
    * * @param moduleshowfields
    *@Return void
    *@Author Administrator
    *@Date 2019/11/6
    *@Time
    */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertModuleFields(List<Moduleshowfields> moduleshowfields) {
        int num = moduleshowfieldsDao.insertModuleBatch(moduleshowfields);
        if(num != moduleshowfields.size()){
            throw new RuntimeException("添加模块下的字段异常");
        }

    }

    /***
    *@Description 批量删除模块下的字段
    * * @param reqDto
    *@Return void
    *@Author Administrator
    *@Date 2019/11/6
    *@Time
    */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteFieldsByModuleName(ModuleshowfieldsReqDto reqDto) {
        int num = moduleshowfieldsDao.deleteFieldsByModule(reqDto);
        if(num != reqDto.getFieldids().size()){
            throw new RuntimeException("删除模块下的字段异常");
        }

    }
}
