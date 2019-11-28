package com.xjt.business.impl;

import com.xjt.business.AssetApplyBusinessService;
import com.xjt.dao.master.AssetapplyDao;
import com.xjt.dao.master.AssetapplydetailDao;
import com.xjt.dto.AssetapplyReqDto;
import com.xjt.entity.Assetapply;
import com.xjt.entity.Assetapplydetail;
import com.xjt.enums.ExceptionEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @ClassNameAssetApplyBusinessServiceImpl
 * @Description
 * @Author
 * @Date2019/11/18 9:00
 * @Version V1.0
 **/
@Service
public class AssetApplyBusinessServiceImpl implements AssetApplyBusinessService {

    private Logger logger = LoggerFactory.getLogger(AssetApplyBusinessServiceImpl.class);
    @Resource
    private AssetapplyDao assetapplyDao;
    @Resource
    private AssetapplydetailDao detailDao;

    /***
    *@Description 批量添加物资申请表
    * * @param reqDtos
    *@Return void
    *@Author Administrator
    *@Date 2019/11/18
    *@Time
    */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertAssetApplyBatch(AssetapplyReqDto reqDto) {
        Assetapply assetapply = new Assetapply();
        BeanUtils.copyProperties(reqDto,assetapply);
        int num1 = assetapplyDao.insert(assetapply);
        if(num1 != 1){
            throw new RuntimeException("添加物资申请异常");
        }
        List<Assetapplydetail> details = reqDto.getAssetapplydetails();
        for(Assetapplydetail detail:details){
            detail.setAssetApplyId(reqDto.getApplyId());
        }
        int num2 = detailDao.insertMaterialsBatch(details);
        if(num2 != details.size()){
            throw new RuntimeException("添加物资申请表异常");
        }

        logger.info("添加物资申请表成功");

    }

    /**
    *@Description 审核物资申领单
    * * @param reqDto
    *@Return void
    *@Author Administrator
    *@Date 2019/11/22
    *@Time
    */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void checkAssetApply(AssetapplyReqDto reqDto) {
        //String applyId = reqDto.getApplyId();
        //申请的物资详情
       // List<Assetapplydetail> details = detailDao.queryDetails(applyId);
        Assetapply assetapply = new Assetapply();
        BeanUtils.copyProperties(reqDto,assetapply);
        assetapply.setIsAudit(1);
        assetapply.setAuditTime(new Date());
        int num =assetapplyDao.updateByPrimaryKeySelective(assetapply);
        if(num !=1){
            throw new RuntimeException("审核物资申领单异常");
        }


    }
}
