package com.xjt.dao.master;

import com.xjt.entity.Channeloptionsset;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChanneloptionssetDao {
    int deleteByPrimaryKey(String primaryid);

    /**
    *@Description 添加渠道参数设置
    * * @param record
    *@Return int
    *@Author Administrator
    *@Date 2019/11/5
    *@Time
    */
    int insert(Channeloptionsset record);

    int insertSelective(Channeloptionsset record);

    Channeloptionsset selectByPrimaryKey(String primaryid);

    int updateByPrimaryKeySelective(Channeloptionsset record);

    int updateByPrimaryKey(Channeloptionsset record);
}