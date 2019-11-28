package com.xjt.service.impl;

import com.xjt.business.ChanneloptionssetBusSer;
import com.xjt.dao.master.ChanneloptionssetDao;
import com.xjt.dto.BaseResDto;
import com.xjt.dto.ChanneloptionssetReqDto;
import com.xjt.entity.Channeloptionsset;
import com.xjt.enums.ResultCode;
import com.xjt.service.ChanneloptionssetService;
import com.xjt.utils.STRUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassNameChanneloptionssetServiceImpl
 * @Description
 * @Author
 * @Date2019/11/5 9:29
 * @Version V1.0
 **/
@Service
public class ChanneloptionssetServiceImpl implements ChanneloptionssetService {

    private Logger logger = LoggerFactory.getLogger(ChanneloptionssetServiceImpl.class);

    @Resource
    private ChanneloptionssetBusSer busSer;
    
    @Resource
    private ChanneloptionssetDao setDao;

    /**
    *@Description 增加参数设置
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/5
    *@Time 
    */
    @Override
    public BaseResDto insertChannelSet(ChanneloptionssetReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        String optionName = reqDto.getCname();
        String optionType = reqDto.getOptiontype();
        if(STRUtils.isEmpty(optionName)){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("参数名 optionName is null");
            return baseResDto;
        }
        if(STRUtils.isEmpty(optionType)){
            baseResDto.setResultMessage("参数类型 optionType is null");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        try{
            Channeloptionsset set = new Channeloptionsset();
            BeanUtils.copyProperties(reqDto,set);
            set.setPrimaryid(STRUtils.createUUID());
            busSer.insertChannelSet(set);

        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("添加参数设置异常");
            logger.error("添加参数设置异常",e);
        }
        return baseResDto;
    }
}
