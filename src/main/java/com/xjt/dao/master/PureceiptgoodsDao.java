package com.xjt.dao.master;

import com.xjt.entity.Pureceiptgoods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PureceiptgoodsDao {
    int deleteByPrimaryKey(String pureceiptgoodsid);

    int insert(Pureceiptgoods record);

    int insertSelective(Pureceiptgoods record);

    Pureceiptgoods selectByPrimaryKey(String pureceiptgoodsid);

    int updateByPrimaryKeySelective(Pureceiptgoods record);

    int updateByPrimaryKey(Pureceiptgoods record);

    int insertPureceiptGoodsBatch(@Param("pureceiptgoods") List<Pureceiptgoods> pureceiptgoods);


}