package com.xjt.service.impl;

import com.xjt.business.BoxbillBusinessService;
import com.xjt.dto.BaseResDto;
import com.xjt.dto.BoxbillReqDto;
import com.xjt.dto.BoxdetailReqDto;
import com.xjt.entity.Boxbill;
import com.xjt.entity.Boxdetail;
import com.xjt.enums.ResultCode;
import com.xjt.service.BoxbillService;
import com.xjt.utils.STRUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import sun.swing.BakedArrayList;

import javax.annotation.Resource;
import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassNameBoxbillServiceImpl
 * @Description
 * @Author
 * @Date2019/11/7 11:43
 * @Version V1.0
 **/
@Service
public class BoxbillServiceImpl implements BoxbillService {

    private Logger logger = LoggerFactory.getLogger(BoxbillServiceImpl.class);
    @Resource
    private BoxbillBusinessService businessService;


    /***
    *@Description 根据货单添加箱子信息
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/7
    *@Time
    */
    @Override
    public BaseResDto insertBoxBill(BoxbillReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        if(STRUtils.isEmpty(reqDto.getAccbillno())){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("单号不能为空");
            return baseResDto;
        }
        if(reqDto.getBoxdetails()==null||reqDto.getBoxdetails().size()==0){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("需要数据明细");
            return baseResDto;
        }
        try{
            Boxbill boxbill = new Boxbill();
            List<Boxdetail> boxdetails = new ArrayList<>();
            BeanUtils.copyProperties(reqDto,boxbill);
            String boxId = STRUtils.createUUID();
            boxbill.setBoxno(boxId);
            //箱子数据明细
            List<BoxdetailReqDto> boxdetailReqDtos = reqDto.getBoxdetails();
            for(BoxdetailReqDto detail:boxdetailReqDtos){
                Boxdetail boxdetail = new Boxdetail();
                BeanUtils.copyProperties(detail,boxdetail);
                boxdetail.setBoxno(boxId);
                boxdetails.add(boxdetail);
            }
            businessService.insertBoxBill(boxbill,boxdetails);

        }catch (Exception e){
            baseResDto.setResultMessage("录入箱子数据异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("录入箱子数据异常",e);

        }
        return baseResDto;
    }
}
