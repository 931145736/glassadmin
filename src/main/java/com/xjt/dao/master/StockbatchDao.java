package com.xjt.dao.master;

import com.xjt.annotation.MenuPower;
import com.xjt.entity.Stockbatch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StockbatchDao {
    int deleteByPrimaryKey(String stockcode);

    int insert(Stockbatch record);

    int insertSelective(Stockbatch record);

    Stockbatch selectByPrimaryKey(String stockcode);

    int updateByPrimaryKeySelective(Stockbatch record);

    int updateByPrimaryKey(Stockbatch record);

    int insertStockBatch(@Param("stockbatchList") List<Stockbatch> stockbatchList);
}