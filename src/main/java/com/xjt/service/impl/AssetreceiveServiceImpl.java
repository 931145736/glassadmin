package com.xjt.service.impl;

import com.xjt.business.AssetreceiveBusinessService;
import com.xjt.dao.master.AssetreceiveDao;
import com.xjt.dao.master.AssetreceivedetailDao;
import com.xjt.dto.AssetreceiveReqDto;
import com.xjt.dto.BaseResDto;
import com.xjt.entity.Assetreceive;
import com.xjt.entity.Assetreceivedetail;
import com.xjt.entity.Assetreturndetail;
import com.xjt.enums.ResultCode;
import com.xjt.service.AssetreceiveService;
import com.xjt.utils.DateUtil;
import com.xjt.utils.STRUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.print.DocFlavor;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * @ClassNameAssetreceiveServiceImpl
 * @Description
 * @Author
 * @Date2019/11/18 11:11
 * @Version V1.0
 **/
@Service
public class AssetreceiveServiceImpl implements AssetreceiveService {

    private Logger logger = LoggerFactory.getLogger(AssetreceiveServiceImpl.class);
    @Resource
    private AssetreceiveDao assetreceiveDao;
    @Resource
    private AssetreceiveBusinessService businessService;
    @Resource
    private AssetreceivedetailDao assetreceivedetailDao;

    /***
    *@Description 添加物资领用单
    * * @param reqDtos
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/18
    *@Time
    */
    @Override
    public BaseResDto insertAssetReceive(AssetreceiveReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        if(!checkParams(reqDto,baseResDto)){
            return baseResDto;
        }
        try{
            reqDto.setReceiveId(STRUtils.createUUID());
            reqDto.setReceiveDate(new Date());
            businessService.insertAssetReceive(reqDto);

        }catch (Exception e){
            baseResDto.setResultMessage("添加领用表异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("添加领用表异常",e);
        }
        return baseResDto;
    }

    /***
    *@Description 审核物资领用单
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/18
    *@Time
    */
    @Override
    public BaseResDto checkAssetReceive(AssetreceiveReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        String receiveId = reqDto.getReceiveId();
        if(STRUtils.isEmpty(receiveId)){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("receiveId is null");
            return baseResDto;
        }
        try{
            Assetreceive assetreceive = new Assetreceive();
            BeanUtils.copyProperties(reqDto,assetreceive);
            assetreceive.setAuditTime(new Date());
            assetreceive.setIsAudit(1);
            businessService.checkAssetReceive(assetreceive);


        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("审核物资领用单异常");
            logger.error("审核物资领用单异常",e);
        }
        return baseResDto;
    }

    /***
    *@Description 查看物资领用单列表
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/18
    *@Time
    */
    @Override
    public BaseResDto queryAssetReceiveList(AssetreceiveReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        try{
            List<Assetreceive> assetreceives = assetreceiveDao.queryReceiveList(reqDto);
            baseResDto.setData(assetreceives);

        }catch (Exception e){
            baseResDto.setResultMessage("查看物资领用单列表异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("查看物资领用单列表异常",e);
        }
        return baseResDto;
    }

    /**
    *@Description 查看领用的物资信息
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/20
    *@Time
    */
    @Override
    public BaseResDto queryReceiveAssetInfo(AssetreceiveReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        if(STRUtils.isEmpty(reqDto.getReceiveId())){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("receiveId is null");
            return baseResDto;
        }
        try{
            List<Assetreceivedetail> details = assetreceivedetailDao.queryReceiveAssetInfo(reqDto);
            baseResDto.setData(details);

        }catch (Exception e){
            baseResDto.setResultMessage("查看领用的物资信息异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("查看领用的物资信息异常",e);
        }
        return baseResDto;
    }

    private boolean checkParams(AssetreceiveReqDto reqDto,BaseResDto resDto)  {
        boolean flag = true;
        if(STRUtils.isEmpty(reqDto.getReceivePerson())){
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            resDto.setResultMessage("领用人不能为空");
            flag = false;
        }
        List<Assetreceivedetail> details = reqDto.getDetails();
        if(details==null||details.size()==0){
            resDto.setResultMessage("请填写领用物资明细");
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            flag = false;

        }else{
            for(Assetreceivedetail detail:details){
                if(STRUtils.isEmpty(detail.getAssetReceiveMaterials())){
                    resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
                    resDto.setResultMessage("请选择领用的物资");
                    flag = false;
                }
                if(detail.getAssetReceiveCount()==null){
                    resDto.setResultMessage("请选择领用数量");
                    resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
                    flag = false;
                }
            }
        }


        return flag;
    }
}
