package com.xjt.business.impl;

import com.xjt.business.ChanneloptionssetBusSer;
import com.xjt.dao.master.ChanneloptionssetDao;
import com.xjt.entity.Channeloptionsset;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ClassNameChanneloptionssetBusSerImpl
 * @Description
 * @Author
 * @Date2019/11/5 9:25
 * @Version V1.0
 **/
@Service
public class ChanneloptionssetBusSerImpl implements ChanneloptionssetBusSer {

    @Resource
    private ChanneloptionssetDao setDao;


    /**
    *@Description 添加渠道参数设置
    * * @param set
    *@Return void
    *@Author Administrator
    *@Date 2019/11/5
    *@Time
    */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertChannelSet(Channeloptionsset set) {

        int num = setDao.insert(set);
        if(num !=1){
            throw new RuntimeException("添加渠道参数设置异常");
        }
    }
}
