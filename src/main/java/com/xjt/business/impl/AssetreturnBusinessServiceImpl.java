package com.xjt.business.impl;

import com.xjt.business.AssetreturnBusinessService;
import com.xjt.dao.master.AssetinfoDao;
import com.xjt.dao.master.AssetreturnDao;
import com.xjt.dao.master.AssetreturndetailDao;
import com.xjt.dto.AssetreturnReqDto;
import com.xjt.entity.Assetinfo;
import com.xjt.entity.Assetreturn;
import com.xjt.entity.Assetreturndetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassNameAssetreturnBusinessServiceImpl
 * @Description
 * @Author
 * @Date2019/11/18 17:27
 * @Version V1.0
 **/
@Service
public class AssetreturnBusinessServiceImpl implements AssetreturnBusinessService {
    private Logger logger = LoggerFactory.getLogger(AssetreturnBusinessServiceImpl.class);

    @Resource
    private AssetreturnDao assetreturnDao;
    @Resource
    private AssetreturndetailDao assetreturndetailDao;
    @Resource
    private AssetinfoDao assetinfoDao;

    /**
    *@Description 添加归还记录事务
    * * @param reqDto
    *@Return void
    *@Author Administrator
    *@Date 2019/11/18
    *@Time
    */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addAssetReturn(AssetreturnReqDto reqDto) {
        Assetreturn assetreturn = new Assetreturn();
        BeanUtils.copyProperties(reqDto,assetreturn);
        assetreturn.setReturnDate(new Date());
        int num1 = assetreturnDao.insert(assetreturn);
        if(num1 !=1){
            throw new RuntimeException("添加归还记录异常");
        }
        List<Assetreturndetail> details = reqDto.getAssetreturndetails();
        String returnId = reqDto.getReturnId();
        for(Assetreturndetail detail:details){
            detail.setAssetReturnId(returnId);
        }
        int num2 = assetreturndetailDao.insertReturnDetails(details);
        if(num2 !=details.size()){
            throw new RuntimeException("添加归还物资详情异常");
        }
        logger.info("添加物资归还成功");


    }

    /**
    *@Description 审核物资归还
    * * @param reqDto
    *@Return void
    *@Author Administrator
    *@Date 2019/11/20
    *@Time
    */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void checkAssetReturn(AssetreturnReqDto reqDto) {
        Assetreturn assetreturn = new Assetreturn();
        BeanUtils.copyProperties(reqDto,assetreturn);
        assetreturn.setIsAudit(1);
        assetreturn.setAuditTime(new Date());
        int num1 = assetreturnDao.updateByPrimaryKeySelective(assetreturn);
        if(num1 !=1){
            throw new RuntimeException("审核物资归还异常");
        }
        //归还的物资入库
        String returnId = reqDto.getReturnId();
        List<Assetreturndetail> details = assetreturndetailDao.queryReturnAsset(returnId);
        List<Assetinfo> assetinfos = new ArrayList<>();
        for(Assetreturndetail detail:details){
            assetinfos.add(new Assetinfo(detail.getAssetReturnMaterials(),-detail.getAssetReturnCount()));
        }
        int num2 = assetinfoDao.updateAssetCount(assetinfos);
        if(num2 <1){
            throw new RuntimeException("归还物资入库异常");
        }



    }
}
