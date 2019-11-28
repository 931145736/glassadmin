package com.xjt.business.impl;

import com.xjt.business.ChanneloptionsBusinessSer;
import com.xjt.dao.master.ChanneloptionsDao;
import com.xjt.entity.Channeloptions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ClassNameChanneloptionsBusinessSerImpl
 * @Description
 * @Author
 * @Date2019/11/5 9:50
 * @Version V1.0
 **/
@Service
public class ChanneloptionsBusinessSerImpl implements ChanneloptionsBusinessSer {

    @Resource
    private ChanneloptionsDao channeloptionsDao;

    /**
    *@Description 增加参数
    * * @param channeloptions
    *@Return void
    *@Author Administrator
    *@Date 2019/11/5
    *@Time
    */
    @Transactional (rollbackFor = Exception.class)
    @Override
    public void insertChanneloption(Channeloptions channeloptions) {
        int num = channeloptionsDao.insert(channeloptions);
        if(num != 1){
            throw new RuntimeException("增加参数异常");
        }
    }
}
