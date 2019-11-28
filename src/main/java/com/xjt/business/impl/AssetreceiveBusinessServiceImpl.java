package com.xjt.business.impl;

import com.alibaba.fastjson.JSONObject;
import com.xjt.business.AssetreceiveBusinessService;
import com.xjt.dao.master.AssetinfoDao;
import com.xjt.dao.master.AssetreceiveDao;
import com.xjt.dao.master.AssetreceivedetailDao;
import com.xjt.dto.AssetreceiveReqDto;
import com.xjt.entity.Assetinfo;
import com.xjt.entity.Assetreceive;
import com.xjt.entity.Assetreceivedetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassNameAssetreceiveBusinessServiceImpl
 * @Description
 * @Author
 * @Date2019/11/18 11:13
 * @Version V1.0
 **/
@Service
public class AssetreceiveBusinessServiceImpl implements AssetreceiveBusinessService {
    
    @Resource
    private AssetreceiveDao assetreceiveDao;
    @Resource
    private AssetreceivedetailDao detailDao;
    @Resource
    private AssetinfoDao assetinfoDao;

    private Logger logger = LoggerFactory.getLogger(AssetreceiveBusinessServiceImpl.class);

    /**
    *@Description 添加领用表异常 
    * * @param reqDtos
    *@Return void
    *@Author Administrator
    *@Date 2019/11/18
    *@Time 
    */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertAssetReceive(AssetreceiveReqDto reqDto) {
        Assetreceive assetreceive = new Assetreceive();
        BeanUtils.copyProperties(reqDto,assetreceive);
        List<Assetreceivedetail> details = reqDto.getDetails();
        String receiveId = assetreceive.getReceiveId();
        for(Assetreceivedetail detail:details){
            detail.setAssetReceiveId(receiveId);
        }
        
        int num  = assetreceiveDao.insert(assetreceive);
        if(num != 1){
            throw new RuntimeException("添加领用表异常");
        }
        int num2 = detailDao.insertReceiveDetail(details);
        if(num2 != details.size()){
            throw new RuntimeException("添加领用货物明细异常");
        }
        
    }

    /***
    *@Description 审核物资领用
    * * @param reqDto
    *@Return void
    *@Author Administrator
    *@Date 2019/11/18
    *@Time
    */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void checkAssetReceive(Assetreceive reqDto) {
       //更新审核状态
        String receiveId = reqDto.getReceiveId();


        int num1 = assetreceiveDao.updateByPrimaryKeySelective(reqDto);
        logger.info("参数"+JSONObject.toJSONString(reqDto)+"num"+num1);
        if(num1 !=1){
            throw new RuntimeException("审核异常");
        }
        //要领用的物资
        List<Assetreceivedetail> details =detailDao.queryByReceiveId(receiveId);
        List<Assetinfo> assetinfos = new ArrayList<>();
        for(Assetreceivedetail detail:details){
            assetinfos.add(new Assetinfo(detail.getAssetReceiveMaterials(),detail.getAssetReceiveCount()));
        }
        logger.info("物资信息"+JSONObject.toJSONString(assetinfos));
        int num2 = assetinfoDao.updateAssetCount(assetinfos);
        if(num2 <1){
            throw new RuntimeException("更改库存物资数量异常");
        }




    }
}
