package com.xjt.service.impl;

import com.xjt.business.AssetPurchaseBusinessService;
import com.xjt.dao.master.AssetpurchaseDao;
import com.xjt.dao.master.AssetpurchasedetailDao;
import com.xjt.dto.AssetpurchaseReqDto;
import com.xjt.dto.BaseResDto;
import com.xjt.entity.Assetpurchase;
import com.xjt.entity.Assetpurchasedetail;
import com.xjt.enums.ResultCode;
import com.xjt.service.AssetPurchaseService;
import com.xjt.utils.DateUtil;
import com.xjt.utils.STRUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @ClassNameAssetPurchaseServiceImpl
 * @Description
 * @Author
 * @Date2019/11/20 10:06
 * @Version V1.0
 **/
@Service
public class AssetPurchaseServiceImpl implements AssetPurchaseService {

    private Logger logger = LoggerFactory.getLogger(AssetPurchaseServiceImpl.class);
    @Resource
    private AssetPurchaseBusinessService businessService;
    @Resource
    private AssetpurchaseDao assetpurchaseDao;
    @Resource
    private AssetpurchasedetailDao assetpurchasedetailDao;

    /**
    *@Description 添加采购物资单
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/20
    *@Time
    */
    @Override
    public BaseResDto insertAssetPurchase(AssetpurchaseReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        if(!checkParams(reqDto,baseResDto)){
            return baseResDto;
        }

        try{
            reqDto.setPurchaseId(STRUtils.createUUID());
            reqDto.setPurchaseDate(DateUtil.getDate(reqDto.getPurchaseDateStr(),"yyyy-MM-dd"));
            businessService.insertAssetPurchase(reqDto);

        }catch (Exception e){
            baseResDto.setResultMessage("添加采购物资信息异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("添加采购物资信息异常",e);
        }
        return baseResDto;
    }

    /**
    *@Description 审核物资采购单
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/20
    *@Time
    */
    @Override
    public BaseResDto checkAssetPurchase(AssetpurchaseReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        if(STRUtils.isEmpty(reqDto.getPurchaseId())){
            baseResDto.setResultMessage("purchaseId is null");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        try{
            Assetpurchase assetpurchase = new Assetpurchase();
            BeanUtils.copyProperties(reqDto,assetpurchase);
            assetpurchase.setIsAudit(1);
            assetpurchase.setAuditTime(new Date());
            assetpurchaseDao.updateByPrimaryKeySelective(assetpurchase);
        }catch (Exception e){

            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("审核物资采购订单异常");
            logger.error("审核物资采购订单异常",e);
        }
        return baseResDto;
    }

    /**
    *@Description 查看物资采购单列表
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/20
    *@Time
    */
    @Override
    public BaseResDto queryAssetPurchaseList(AssetpurchaseReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        try{
            List<Assetpurchase> assetpurchases = assetpurchaseDao.queryAssetPurchaseList(reqDto);
            baseResDto.setData(assetpurchases);
        }catch (Exception e){
            baseResDto.setResultMessage("查看物资采购单列表异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("查看物资采购单列表异常");
        }
        return baseResDto;
    }

    /***
    *@Description 查看采购的物资清单
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/20
    *@Time 
    */
    @Override
    public BaseResDto queryPurchaseAssetInfo(AssetpurchaseReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        if(STRUtils.isEmpty(reqDto.getPurchaseId())){
            baseResDto.setResultMessage("purchaseId is null");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        try{
            List<Assetpurchasedetail> details = assetpurchasedetailDao.queryPurchaseAssetInfo(reqDto);
            baseResDto.setData(details);

        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("查看采购的物资清单异常");
            logger.error("查看采购的物资清单异常",e);
        }
        return baseResDto;
    }

    private boolean checkParams(AssetpurchaseReqDto reqDto,BaseResDto resDto){
        boolean flag = true;
        if(reqDto.getDetails()==null||reqDto.getDetails().size()==0){
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            resDto.setResultMessage("需要填写采购物资信息");
            flag = false;
        }else{
            for(Assetpurchasedetail detail:reqDto.getDetails()){
                if(STRUtils.isEmpty(detail.getAssetPurchaseMaterials())){
                    resDto.setResultMessage("物资id 不能为空");
                    resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
                    flag = false;
                }
                if(detail.getAssetPurchaseCount()==null){
                    resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
                    resDto.setResultMessage("需要填写物资数量");
                    flag = false;
                }
            }
        }

        return flag;
    }
}
