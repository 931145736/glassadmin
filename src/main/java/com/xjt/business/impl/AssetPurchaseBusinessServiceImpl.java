package com.xjt.business.impl;

import com.xjt.business.AssetPurchaseBusinessService;
import com.xjt.dao.master.AssetpurchaseDao;
import com.xjt.dao.master.AssetpurchasedetailDao;
import com.xjt.dto.AssetpurchaseReqDto;
import com.xjt.entity.Assetpurchase;
import com.xjt.entity.Assetpurchasedetail;
import com.xjt.entity.Assetreceivedetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassNameAssetPurchaseBusinessServiceImpl
 * @Description
 * @Author
 * @Date2019/11/20 10:09
 * @Version V1.0
 **/
@Service
public class AssetPurchaseBusinessServiceImpl implements AssetPurchaseBusinessService {

    private Logger logger = LoggerFactory.getLogger(AssetPurchaseBusinessServiceImpl.class);
    @Resource
    private AssetpurchaseDao assetpurchaseDao;
    @Resource
    private AssetpurchasedetailDao assetpurchasedetailDao;

    /**
    *@Description 添加采购订单
    * * @param reqDto
    *@Return void
    *@Author Administrator
    *@Date 2019/11/20
    *@Time
    */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertAssetPurchase(AssetpurchaseReqDto reqDto) {
        Assetpurchase assetpurchase = new Assetpurchase();
        BeanUtils.copyProperties(reqDto,assetpurchase);
        String purchaseId = assetpurchase.getPurchaseId();

        int num1 = assetpurchaseDao.insert(assetpurchase);
        if(num1 !=1){
            throw new RuntimeException("添加采购订单信息异常");
        }
        List<Assetpurchasedetail> details = reqDto.getDetails();
        for(Assetpurchasedetail detail:details){
            detail.setAssetPurchaseId(purchaseId);
        }
        int num2 = assetpurchasedetailDao.insertDetailsBatch(details);
        if(num2 != details.size()){
            throw new RuntimeException("添加采购物资异常");
        }

    }
}
