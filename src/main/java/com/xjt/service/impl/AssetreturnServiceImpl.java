package com.xjt.service.impl;

import com.xjt.business.AssetreturnBusinessService;
import com.xjt.dto.AssetreturnReqDto;
import com.xjt.dto.BaseResDto;
import com.xjt.entity.Assetreturn;
import com.xjt.entity.Assetreturndetail;
import com.xjt.enums.ResultCode;
import com.xjt.service.AssetreturnService;
import com.xjt.utils.STRUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassNameAssetreturnServiceImpl
 * @Description
 * @Author
 * @Date2019/11/18 17:24
 * @Version V1.0
 **/
@Service
public class AssetreturnServiceImpl implements AssetreturnService {

    private Logger logger = LoggerFactory.getLogger(AssetreturnServiceImpl.class);

    @Resource
    private AssetreturnBusinessService businessService;

    /***
    *@Description 添加物资归还
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/18
    *@Time
    */
    @Override
    public BaseResDto addAssetReturn(AssetreturnReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        if(!checkParam(reqDto,baseResDto)){
            return  baseResDto;
        }
        try{
            reqDto.setReturnId(STRUtils.createUUID());
            businessService.addAssetReturn(reqDto);


        }catch (Exception e){
            baseResDto.setResultMessage("添加物资归还记录异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("添加物资归还记录异常",e);
        }
        return baseResDto;
    }

    /**
    *@Description 审核物资归还表
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/20
    *@Time
    */
    @Override
    public BaseResDto checkAssetReturn(AssetreturnReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        if(STRUtils.isEmpty(reqDto.getReturnId())){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("returnId is null");
            return baseResDto;
        }
        try{
            businessService.checkAssetReturn(reqDto);

        }catch (Exception e){
            baseResDto.setResultMessage("审核物资归还表异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("审核物资归还表异常",e);
        }
        return baseResDto;
    }

    private boolean checkParam(AssetreturnReqDto reqDto,BaseResDto resDto){
        boolean flag = true;
        List<Assetreturndetail> details = reqDto.getAssetreturndetails();
        if(details==null||details.size()==0){
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            resDto.setResultMessage("请填写归还物资信息");
            flag = false;
        }else{
            for(Assetreturndetail detail:details){
                if(STRUtils.isEmpty(detail.getAssetReturnMaterials())){
                    resDto.setResultMessage("物资id is null");
                    resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
                    flag = false;
                }
                if(detail.getAssetReturnCount()==null){
                    resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
                    resDto.setResultMessage("请填写归还数量");
                }
            }
        }


        return flag;
    }
}
