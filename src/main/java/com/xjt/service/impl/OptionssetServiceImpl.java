package com.xjt.service.impl;

import com.xjt.business.OptionssetBusinessService;
import com.xjt.dto.BaseResDto;
import com.xjt.dto.OptionssetReqDto;
import com.xjt.entity.Optionscombolist;
import com.xjt.entity.Optionsset;
import com.xjt.enums.ResultCode;
import com.xjt.service.OptionssetService;
import com.xjt.utils.PrimaryKeyWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassNameOptionssetServiceImpl
 * @Description
 * @Author
 * @Date2019/11/8 15:04
 * @Version V1.0
 **/
@Service
public class OptionssetServiceImpl implements OptionssetService {

    private Logger logger = LoggerFactory.getLogger(OptionssetServiceImpl.class);

    @Resource
    private OptionssetBusinessService businessService;
    @Resource
    private PrimaryKeyWorker primaryKeyWorker;


    /***
    *@Description 添加全局参数配置
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/8
    *@Time
    */
    @Override
    public BaseResDto insertGlobalOptionSet(OptionssetReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        try{
            Optionsset optionsset = new Optionsset();
            BeanUtils.copyProperties(reqDto,optionsset);
            optionsset.setId(primaryKeyWorker.getPrimaryKey("0"));
            String cName = optionsset.getName();
            List<String> alternatives = reqDto.getAlternatives();
            List<Optionscombolist> optionscombolists = new ArrayList<>();
            int i=1;
            for(String a:alternatives){
                Optionscombolist obj = new Optionscombolist();
                obj.setCname(cName);
                obj.setListcaption(a);
                obj.setListindex(i);
                i++;
                optionscombolists.add(obj);
            }
            businessService.insertGlobalOptionSet(optionsset,optionscombolists);
        }catch (Exception e){
            baseResDto.setResultMessage("添加全局参数配置异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("添加全局参数配置异常",e);

        }
        return baseResDto;
    }

    /***
    *@Description 批量添加全局参数配置
    * * @param reqDtos
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/8
    *@Time
    */
    @Override
    public BaseResDto batchInsertOptionSet(List<OptionssetReqDto> reqDtos) {
        BaseResDto baseResDto = new BaseResDto();
        //参数校验
        try{
            List<Optionsset> optionssets = new ArrayList<>();
            List<Optionscombolist> optionscombolists = new ArrayList<>();
            for(OptionssetReqDto reqDto:reqDtos){
                Optionsset optionsset = new Optionsset();
                BeanUtils.copyProperties(reqDto,optionsset);
                optionsset.setId(primaryKeyWorker.getPrimaryKey("0"));
                String cName = reqDto.getName();
                List<String> alternatives = reqDto.getAlternatives();
                int index = 1;
                for(String alterNative:alternatives){
                    Optionscombolist optionscombolist = new Optionscombolist();
                    optionscombolist.setCname(cName);
                    optionscombolist.setListcaption(alterNative);
                    optionscombolist.setListindex(index);
                    optionscombolists.add(optionscombolist);
                }
                optionssets.add(optionsset);
            }
            businessService.batchInsertOptionSet(optionssets,optionscombolists);


        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("批量添加全局参数配置异常");
            logger.error("批量添加全局参数配置异常",e);
        }
        return baseResDto;
    }

    /***
    *@Description 参数校验
    * * @param reqDto
 * @param resDto
    *@Return boolean
    *@Author Administrator
    *@Date 2019/11/8
    *@Time
    */
    private boolean checkParams(OptionssetReqDto reqDto,BaseResDto resDto){
        boolean flag = true;




        return flag;
    }
}
