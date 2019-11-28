package com.xjt.business.impl;

import com.xjt.business.PurchaseBusinessService;
import com.xjt.dao.master.PurchaseDao;
import com.xjt.dao.master.PurchasedetailDao;
import com.xjt.dao.master.PurchasegoodsDao;
import com.xjt.entity.Purchase;
import com.xjt.entity.Purchasedetail;
import com.xjt.entity.Purchasegoods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassNamePurchaseBusinessServiceImpl
 * @Description
 * @Author
 * @Date2019/11/7 9:47
 * @Version V1.0
 **/
@Service
public class PurchaseBusinessServiceImpl implements PurchaseBusinessService {

    @Resource
    private PurchaseDao purchaseDao;
    @Resource
    private PurchasegoodsDao purchasegoodsDao;

    @Resource
    private PurchasedetailDao purchasedetailDao;
    private Logger logger = LoggerFactory.getLogger(PurchaseBusinessServiceImpl.class);


    /***
    *@Description 添加采购单 采购货品单 货品明细单
    * * @param purchase
 * @param purchasegoods
 * @param purchasedetails
    *@Return void
    *@Author Administrator
    *@Date 2019/11/7
    *@Time
    */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addPurchaseOrder(Purchase purchase, List<Purchasegoods> purchasegoods, List<Purchasedetail> purchasedetails) {

        int num1 = purchaseDao.insert(purchase);
        if(num1 !=1){
            throw new RuntimeException("添加采购单主体信息异常");
        }
        int num2 = purchasegoodsDao.insertGoodsBatch(purchasegoods);
        if(num2 != purchasegoods.size()){
            throw new RuntimeException("添加采购的货品异常");
        }
        int num3 = purchasedetailDao.insertGoodsDetailBatch(purchasedetails);
        if(num3 != purchasedetails.size()){
            throw new RuntimeException("添加货品的明细异常");
        }
        logger.info("添加采购单成功");

    }

    /**
    *@Description 删除采购订单
    * * @param purchaseId
    *@Return void
    *@Author Administrator
    *@Date 2019/11/13
    *@Time
    */

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deletePurchaseOrder(String purchaseId) {
        //删除采购订单主表
        int num1 = purchaseDao.deletePurchaseOrder(purchaseId);
        if(num1 != 1){
            throw new RuntimeException("删除采购单主表异常");
        }
        //查看货品id
        List<String> goodsIds = purchasegoodsDao.getPurchaseGoodsId(purchaseId);
        if(goodsIds!=null&&goodsIds.size()>0){
            //删除采购货品表
            int num2 = purchasegoodsDao.deleteGoods(purchaseId);
            if(num2 != goodsIds.size()){
                throw new RuntimeException("删除货品异常");
            }
            //删除货品详情表
            int num3 = purchasedetailDao.deleteGoodsDetail(goodsIds);
            if(num3<goodsIds.size()){
                throw new RuntimeException("删除货品详情异常");
            }

        }


    }
}
