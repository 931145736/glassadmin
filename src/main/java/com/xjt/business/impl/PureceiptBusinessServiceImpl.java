package com.xjt.business.impl;

import com.alibaba.fastjson.JSONObject;
import com.xjt.business.PureceiptBusinessService;
import com.xjt.dao.master.*;
import com.xjt.entity.*;
import org.hibernate.annotations.Target;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassNamePureceiptBusinessServiceImpl
 * @Description
 * @Author
 * @Date2019/11/7 16:20
 * @Version V1.0
 **/
@Service
public class PureceiptBusinessServiceImpl implements PureceiptBusinessService {
    @Resource
    private PureceiptDao pureceiptDao;
    @Resource
    private PureceiptgoodsDao pureceiptgoodsDao;
    @Resource
    private PureceiptdetailDao pureceiptdetailDao;
    @Resource
    private StockbatchDao stockbatchDao;
    @Resource
    private StockbatchdetailDao stockbatchdetailDao;

    private Logger logger = LoggerFactory.getLogger(PureceiptBusinessServiceImpl.class);


    /**
    *@Description 添加仓库验货单/厂家到货单
    * * @param pureceipt
 * @param pureceiptgoods
 * @param pureceiptdetails
    *@Return void
    *@Author Administrator
    *@Date 2019/11/7
    *@Time
    */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertPureceiptOrder(Pureceipt pureceipt, List<Pureceiptgoods> pureceiptgoods, List<Pureceiptdetail> pureceiptdetails) {

        int num1 = pureceiptDao.insert(pureceipt);
        if(num1 !=1){
            throw new RuntimeException("添加到货单异常");
        }
        int num2 = pureceiptgoodsDao.insertPureceiptGoodsBatch(pureceiptgoods);
        if(num2 != pureceiptgoods.size()){
            throw new RuntimeException("添加到货单货品表异常");
        }
        int num3 = pureceiptdetailDao.insertPureceiptDetailsBatch(pureceiptdetails);
        if(num3 != pureceiptdetails.size()){
            throw new RuntimeException("添加到货单明细表异常");
        }
        logger.info("添加到货单成功");
    }

    /***
    *@Description 审核厂家到货单
    * * @param pureceiptId
 * @param stockbatches
 * @param stockbatchdetails
    *@Return void
    *@Author Administrator
    *@Date 2019/11/11
    *@Time
    */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void checkPureceiptOrder(Pureceipt pureceipt, List<Stockbatch> stockbatches, List<Stockbatchdetail> stockbatchdetails) {

        //更新到货单审核状态
        logger.info("更新实体"+JSONObject.toJSONString(pureceipt));
        int num1 = pureceiptDao.updateStatus(pureceipt);
        logger.info("审核货单"+num1);
        if(num1 != 1){
            throw new RuntimeException("更新到货单审核状态异常");
        }
        //入库操作
        int num2 = stockbatchDao.insertStockBatch(stockbatches);
        if(num2 != stockbatches.size()){
            throw new RuntimeException("入库记录异常");
        }
        int num3 = stockbatchdetailDao.insertStockDetailBatch(stockbatchdetails);
        if(num3 != stockbatchdetails.size()){
            throw new RuntimeException("入库明细异常");
        }
        logger.info("审核成功");
    }
}
