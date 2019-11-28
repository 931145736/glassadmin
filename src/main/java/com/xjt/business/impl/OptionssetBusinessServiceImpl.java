package com.xjt.business.impl;

import com.xjt.business.OptionssetBusinessService;
import com.xjt.dao.master.OptionscombolistDao;
import com.xjt.dao.master.OptionssetDao;
import com.xjt.entity.Optionscombolist;
import com.xjt.entity.Optionsset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassNameOptionssetBusinessServiceImpl
 * @Description
 * @Author
 * @Date2019/11/8 15:32
 * @Version V1.0
 **/
@Service
public class OptionssetBusinessServiceImpl implements OptionssetBusinessService {
    @Resource
    private OptionssetDao optionssetDao;
    @Resource
    private OptionscombolistDao optionscombolistDao;

    private Logger logger = LoggerFactory.getLogger(OptionssetBusinessServiceImpl.class);


    /***
    *@Description 添加全局配置 
    * * @param optionsset
 * @param optionscombolists
    *@Return void
    *@Author Administrator
    *@Date 2019/11/8
    *@Time 
    */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertGlobalOptionSet(Optionsset optionsset, List<Optionscombolist> optionscombolists) {
       int num1 = optionssetDao.insert(optionsset);

       if(num1 != 1){
           throw new RuntimeException("添加配置信息异常");
       }
       int num2 = optionscombolistDao.insertListBatch(optionscombolists);
       if(num2 != optionscombolists.size()){
           throw new RuntimeException("添加备选参数值异常");
       }
       logger.info("添加全局配置成功");
    }

    /***
    *@Description 批量添加全局配置 
    * * @param optionssets
 * @param optionscombolists
    *@Return void
    *@Author Administrator
    *@Date 2019/11/8
    *@Time 
    */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void batchInsertOptionSet(List<Optionsset> optionssets, List<Optionscombolist> optionscombolists) {
        int num1 = optionssetDao.insertBatchOptionset(optionssets);
        if(num1 != optionssets.size()){
            throw new RuntimeException("添加全局配置异常");
        }
        int num2 = optionscombolistDao.insertListBatch(optionscombolists);
        if(num2 != optionscombolists.size()){
            throw new RuntimeException("添加备选参数值异常");
        }

    }
}
