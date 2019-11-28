package com.xjt.dao.master;

import com.xjt.entity.Channeloptions;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChanneloptionsDao {


    int deleteByPrimaryKey(Channeloptions key);

    /***
    *@Description 增加参数
    * * @param record
    *@Return int
    *@Author Administrator
    *@Date 2019/11/5
    *@Time 
    */
    int insert(Channeloptions record);

    int insertSelective(Channeloptions record);

    Channeloptions selectByPrimaryKey(Channeloptions key);

    int updateByPrimaryKeySelective(Channeloptions record);

    int updateByPrimaryKey(Channeloptions record);
}