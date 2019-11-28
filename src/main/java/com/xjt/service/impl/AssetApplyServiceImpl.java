package com.xjt.service.impl;

import com.xjt.business.AssetApplyBusinessService;
import com.xjt.dao.master.AssetapplyDao;
import com.xjt.dao.master.AssetapplydetailDao;
import com.xjt.dto.AssetapplyReqDto;
import com.xjt.dto.BaseResDto;
import com.xjt.entity.Assetapply;
import com.xjt.entity.Assetapplydetail;
import com.xjt.enums.ResultCode;
import com.xjt.service.AssetApplyService;
import com.xjt.utils.STRUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @ClassNameAssetApplyServiceImpl
 * @Description
 * @Author
 * @Date2019/11/18 8:56
 * @Version V1.0
 **/
@Service
public class AssetApplyServiceImpl implements AssetApplyService {

    private Logger logger = LoggerFactory.getLogger(AssetApplyServiceImpl.class);
    @Resource
    private AssetApplyBusinessService businessService;
    @Resource
    private AssetapplyDao assetapplyDao;
    @Resource
    private AssetapplydetailDao assetapplydetailDao;

    /**
    *@Description 批量添加物资申请表
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/18
    *@Time
    */
    @Override
    public BaseResDto insertAssetApply(AssetapplyReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        if(!checkParams(reqDto,baseResDto)){
            return baseResDto;
        }
        try{
            reqDto.setApplyId(STRUtils.createUUID());
            reqDto.setApplyDate(new Date());
            businessService.insertAssetApplyBatch(reqDto);

        }catch (Exception e){
            baseResDto.setResultMessage("批量添加物资申请表异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("批量添加物资申请表异常",e);
        }
        return baseResDto;
    }

    /**
    *@Description 查看物资申请表列表
    * * @param
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/18
    *@Time
    */
    @Override
    public BaseResDto queryAssetApplyList(AssetapplyReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        try{
            List<Assetapply> assetapplies = assetapplyDao.assetApplyList(reqDto);
            baseResDto.setData(assetapplies);

        }catch (Exception e){
            baseResDto.setResultMessage("查看物资申请表列表异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("查看物资申请表列表异常",e);
        }

        return baseResDto;
    }

    /**
    *@Description 查看物资申领表详情
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/18
    *@Time
    */
    @Override
    public BaseResDto queryApplyDetails(AssetapplyReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        if(STRUtils.isEmpty(reqDto.getApplyId())){
            baseResDto.setResultMessage("申领表id applyId is null");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        try{
            List<Assetapply> assetapplies = assetapplyDao.queryApplyDetail(reqDto.getApplyId());
            if (assetapplies==null||assetapplies.size()==0){
                baseResDto.setResultCode(ResultCode.RESULT_CODE_NODATA.getCode());
                baseResDto.setResultMessage("no data");
                return baseResDto;
            }
            baseResDto.setData(assetapplies);


        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("查看物资申领表详情异常");
            logger.error("查看物资申领表详情异常",e);
        }
        return baseResDto;
    }

    /***
    *@Description 审核物资申领单
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/18
    *@Time
    */
    @Override
    public BaseResDto checkAssetApply(AssetapplyReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        String applyId = reqDto.getApplyId();
        if(STRUtils.isEmpty(applyId)){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("applyId is null");
            return baseResDto;
        }
        try{
            businessService.checkAssetApply(reqDto);


        }catch (Exception e){
            baseResDto.setResultMessage("审核申请表异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("审核申请表异常",e);
        }
        return baseResDto;
    }

    private boolean checkParams(AssetapplyReqDto reqDto,BaseResDto resDto){
        boolean flag = true;
        if(STRUtils.isEmpty(reqDto.getApplyPerson())){
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            resDto.setResultMessage("申请人不能为空");
            flag = false;
        }
        if(reqDto.getApplyType()==null){
            resDto.setResultMessage("申请者类型不能为空");
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            flag = false;
        }
        List<Assetapplydetail> details = reqDto.getAssetapplydetails();
        if(details==null||details.size()==0){
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            resDto.setResultMessage("需要添加申领的物资信息");
            flag = false;
        }else{
            for(Assetapplydetail detail:details){
                if(STRUtils.isEmpty(detail.getAssetApplyMaterials())||detail.getAssetApplyCount()==null){
                    resDto.setResultMessage("请添加需要的物资名称和数量");
                    resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
                    flag = false;
                }
            }
        }


        return flag;
    }


}
