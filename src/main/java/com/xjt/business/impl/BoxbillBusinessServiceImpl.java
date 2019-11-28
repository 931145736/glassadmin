package com.xjt.business.impl;

import com.xjt.business.BoxbillBusinessService;
import com.xjt.dao.master.BoxbillDao;
import com.xjt.dao.master.BoxdetailDao;
import com.xjt.entity.Boxbill;
import com.xjt.entity.Boxdetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassNameBoxbillBusinessServiceImpl
 * @Description
 * @Author
 * @Date2019/11/7 14:00
 * @Version V1.0
 **/
@Service
public class BoxbillBusinessServiceImpl implements BoxbillBusinessService {


    private Logger logger = LoggerFactory.getLogger(BoxbillBusinessServiceImpl.class);
    @Resource
    private BoxbillDao boxbillDao;

    @Resource
    private BoxdetailDao boxdetailDao;

    /***
    *@Description 添加箱数统计
    * * @param boxbill
 * @param boxdetails
    *@Return void
    *@Author Administrator
    *@Date 2019/11/7
    *@Time
    */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertBoxBill(Boxbill boxbill, List<Boxdetail> boxdetails) {
        int num1 = boxbillDao.insert(boxbill);
        if(num1 != 1){
            throw new RuntimeException("添加箱数统计主表异常");
        }
        int num2 = boxdetailDao.insertBoxDetailBatch(boxdetails);
        if(num2 != boxdetails.size()){
            throw new RuntimeException("添加箱明细表异常");
        }
        logger.info("添加箱数统计成功");
    }
}
