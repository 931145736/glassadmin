package com.xjt.business.impl;

import com.xjt.business.ArrivalBusinessService;
import com.xjt.dao.master.ArrivalDao;
import com.xjt.dao.master.ArrivaldetailDao;
import com.xjt.dao.master.ArrivalgoodsDao;
import com.xjt.entity.Arrival;
import com.xjt.entity.Arrivaldetail;
import com.xjt.entity.Arrivalgoods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassNameArrivalBusinessServiceImpl
 * @Description
 * @Author
 * @Date2019/11/7 11:14
 * @Version V1.0
 **/
@Service
public class ArrivalBusinessServiceImpl implements ArrivalBusinessService {
    @Resource
    private ArrivalDao arrivalDao;
    @Resource
    private ArrivalgoodsDao arrivalgoodsDao;
    @Resource
    private ArrivaldetailDao arrivaldetailDao;

    private Logger logger = LoggerFactory.getLogger(ArrivalBusinessServiceImpl.class);

    /***
    *@Description 添加到货通知单  货品信息 货品明细
    * * @param arrival
 * @param arrivalgoods
 * @param arrivaldetails
    *@Return void
    *@Author Administrator
    *@Date 2019/11/7
    *@Time
    */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertArrivalOrder(Arrival arrival, List<Arrivalgoods> arrivalgoods, List<Arrivaldetail> arrivaldetails) {

        int num1 = arrivalDao.insert(arrival);
        if(num1 !=1){
            throw new RuntimeException("添加到货通知单信息异常");
        }
        int num2 = arrivalgoodsDao.insertArrivalGoods(arrivalgoods);
        if(num2 != arrivalgoods.size()){
            throw new RuntimeException("添加到货通知单货品异常");
        }
        int num3 = arrivaldetailDao.insertArrivalDetailBatch(arrivaldetails);
        if(num3 != arrivaldetails.size()){
            throw new RuntimeException("添加到货通知到货品明细异常");
        }
        logger.info("添加到货通知单异常");

    }
}
