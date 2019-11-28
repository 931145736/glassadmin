package com.xjt.service.impl;

import com.xjt.dao.master.ModuleshowschemeDao;
import com.xjt.dto.BaseResDto;
import com.xjt.dto.ModuleshowschemeReqDto;
import com.xjt.entity.Moduleshowscheme;
import com.xjt.enums.ResultCode;
import com.xjt.service.ModuleshowschemeService;
import com.xjt.utils.STRUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassNameModuleshowschemeServiceImpl
 * @Description
 * @Author
 * @Date2019/11/6 14:50
 * @Version V1.0
 **/
@Service
public class ModuleshowschemeServiceImpl implements ModuleshowschemeService {

    private Logger logger = LoggerFactory.getLogger(ModuleshowschemeServiceImpl.class);
    @Resource
    private ModuleshowschemeDao dao;

    /***
    *@Description 添加方案信息
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/6
    *@Time
    */
    @Override
    public BaseResDto insertModuleScheme(ModuleshowschemeReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        if(!checkParams(reqDto,baseResDto)){
            return baseResDto;
        }
        try{
            if(reqDto.getIssystem()==null){
                reqDto.setIssystem(0);
            }
            Moduleshowscheme moduleshowscheme = new Moduleshowscheme();
            BeanUtils.copyProperties(reqDto,moduleshowscheme);
            int num =dao.insert(moduleshowscheme);
            if(num !=1){
                baseResDto.setResultMessage("添加方案异常");
                baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            }
        }catch (Exception e){
            baseResDto.setResultMessage("添加方案信息异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("添加方案信息异常",e);
        }
        return baseResDto;
    }

    @Override
    public BaseResDto queryModuleScheme(ModuleshowschemeReqDto reqDto) {
        return null;
    }





    private boolean checkParams(ModuleshowschemeReqDto reqDto,BaseResDto resDto){
        boolean flag = true;
        if(STRUtils.isEmpty(reqDto.getSchemename())){
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            resDto.setResultMessage("方案名称 schemename is null");
            flag = false;
        }
        if(STRUtils.isEmpty(reqDto.getModuleid())){
            resDto.setResultMessage("模块名称 moduleid is null");
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            flag = false;
        }

        if(reqDto.getOrderindex()==null){
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            resDto.setResultMessage("排序 orderindex is null");
            flag = false;
        }
        return flag;
    }

}
