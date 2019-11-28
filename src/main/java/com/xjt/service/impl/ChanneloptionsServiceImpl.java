package com.xjt.service.impl;

import com.xjt.business.ChanneloptionsBusinessSer;
import com.xjt.dto.BaseResDto;
import com.xjt.dto.ChanneloptionsReqDto;
import com.xjt.entity.Channeloptions;
import com.xjt.enums.ResultCode;
import com.xjt.service.ChanneloptionsService;
import com.xjt.utils.STRUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassNameChanneloptionsServiceImpl
 * @Description
 * @Author
 * @Date2019/11/5 9:54
 * @Version V1.0
 **/
@Service
public class ChanneloptionsServiceImpl implements ChanneloptionsService {

    @Resource
    private ChanneloptionsBusinessSer businessSer;

    private Logger logger = LoggerFactory.getLogger(ChanneloptionsServiceImpl.class);

    /**
    *@Description 添加参数
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/5
    *@Time
    */
    @Override
    public BaseResDto insertChannelOption(ChanneloptionsReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        if(STRUtils.isEmpty(reqDto.getOptiontype())){
            baseResDto.setResultMessage("参数类型 optiontype is null");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        if(STRUtils.isEmpty(reqDto.getCname())){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("参数名 cname is null");
            return baseResDto;
        }
        if(STRUtils.isEmpty(reqDto.getCdata())){
            baseResDto.setResultMessage("参数值 cdata is null");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        if(STRUtils.isEmpty(reqDto.getChannelId())){
            baseResDto.setResultMessage("渠道id channelId is null");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        try{
            Channeloptions channeloptions = new Channeloptions();
            BeanUtils.copyProperties(reqDto,channeloptions);
            businessSer.insertChanneloption(channeloptions);

        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("添加参数发生异常");
            logger.error("添加参数发生异常",e);
        }
        return baseResDto;
    }
}
