package com.xjt.service.impl;

import com.sun.org.apache.regexp.internal.RE;
import com.xjt.business.AssetscrapBusinessService;
import com.xjt.dao.master.AssetscrapDao;
import com.xjt.dto.AssetscrapReqDto;
import com.xjt.dto.BaseResDto;
import com.xjt.entity.Assetscrap;
import com.xjt.enums.ResultCode;
import com.xjt.service.AssetscrapService;
import com.xjt.utils.STRUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.print.DocFlavor;
import java.util.Date;

/**
 * @ClassNameAssetscrapServiceImpl
 * @Description
 * @Author
 * @Date2019/11/18 16:53
 * @Version V1.0
 **/
@Service
public class AssetscrapServiceImpl implements AssetscrapService {

    private Logger logger = LoggerFactory.getLogger(AssetscrapServiceImpl.class);

    @Resource
    private AssetscrapDao assetscrapDao;
    @Resource
    private AssetscrapBusinessService businessService;

    /**
    *@Description 物资报废
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/18
    *@Time
    */
    @Override
    public BaseResDto assetScrap(AssetscrapReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        if(!checkParam(reqDto,baseResDto)){
            return baseResDto;
        }
        try{
            Assetscrap assetscrap = new Assetscrap();
            BeanUtils.copyProperties(reqDto,assetscrap);
            assetscrap.setScrapDate(new Date());
            assetscrap.setScrapId(STRUtils.createUUID());
            int num =assetscrapDao.insert(assetscrap);
            if(num !=1){
                baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
                baseResDto.setResultMessage("添加报废信息异常");
                return baseResDto;
            }
        }catch (Exception e){
            baseResDto.setResultMessage("添加报废物资信息异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("添加报废物资信息异常",e);
        }
        return baseResDto;
    }

    /**
    *@Description 审核报废的物资
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/18
    *@Time
    */
    @Override
    public BaseResDto checkAssetScrap(AssetscrapReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        String scrapId = reqDto.getScrapId();
        if(STRUtils.isEmpty(scrapId)){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("scrapId is null");
            return baseResDto;
        }
        try{
            Assetscrap assetscrap = assetscrapDao.selectByPrimaryKey(scrapId);
            assetscrap.setAuditTime(new Date());
            assetscrap.setIsAudit(1);
            assetscrap.setAuditPerson(reqDto.getAuditPerson());
            businessService.checkAssetscrap(assetscrap);

        }catch (Exception e){
            baseResDto.setResultMessage("审核报废的物资异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("审核报废的物资异常",e);
        }
        return baseResDto;
    }

    private boolean checkParam(AssetscrapReqDto reqDto,BaseResDto resDto){
        boolean flag = true;
        if(STRUtils.isEmpty(reqDto.getScrapAsset())){
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            resDto.setResultMessage("报废的物资id不能为空");
            flag = false;
        }
        if(reqDto.getScrapType()==null){
            resDto.setResultMessage("请选择报废机构类型");
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            flag = false;
        }
        if(reqDto.getScrapType()==3&&STRUtils.isEmpty(reqDto.getScrapPerson())){
            resDto.setResultMessage("报废人的信息为空");
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            flag = false;
        }
        return flag;
    }
}
