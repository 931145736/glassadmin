package com.xjt.service.impl;

import com.github.pagehelper.PageHelper;
import com.xjt.business.AssetinfoBusinessService;
import com.xjt.dao.master.AssetinfoDao;
import com.xjt.dto.AssetinfoReqDto;
import com.xjt.dto.BaseResDto;
import com.xjt.entity.Assetinfo;
import com.xjt.entity.Master;
import com.xjt.enums.ResultCode;
import com.xjt.service.AssetinfoService;
import com.xjt.utils.STRUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @ClassNameAssetinfoServiceImpl
 * @Description
 * @Author
 * @Date2019/11/15 16:19
 * @Version V1.0
 **/
@Service
public class AssetinfoServiceImpl implements AssetinfoService {

    private Logger logger = LoggerFactory.getLogger(AssetinfoServiceImpl.class);
    @Resource
    private AssetinfoDao assetinfoDao;
    @Resource
    private AssetinfoBusinessService businessService;


    /**
    *@Description 查看物资列表
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/15
    *@Time
    */
    @Override
    public BaseResDto queryAssetList(AssetinfoReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        try{

            List<Assetinfo> assetinfos = assetinfoDao.queryAssetList();
            if(assetinfos==null||assetinfos.size()==0){
                baseResDto.setResultMessage("no data");
                baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
                return baseResDto;
            }
            baseResDto.setData(assetinfos);



        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("查看物资列表异常");
            logger.error("查看物资列表异常",e);

        }
        return baseResDto;
    }

    /***
    *@Description 添加物资信息
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/15
    *@Time
    */
    @Override
    public BaseResDto addAssetinfo(List<AssetinfoReqDto> reqDtos, Master master) {
        BaseResDto baseResDto = new BaseResDto();
        try{
            for(AssetinfoReqDto reqDto:reqDtos){
                reqDto.setInputPerson(master.getId());
                reqDto.setInputDate(new Date());
                reqDto.setAssetId(STRUtils.createUUID());
            }
            businessService.insetrAssetinfoBatch(reqDtos);


        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("添加物资信息异常");
            logger.error("添加物资信息异常",e);
        }
        return baseResDto;
    }
}
