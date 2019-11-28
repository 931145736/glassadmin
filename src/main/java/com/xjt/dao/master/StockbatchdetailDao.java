package com.xjt.dao.master;

import com.xjt.entity.Stockbatchdetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StockbatchdetailDao {
    int deleteByPrimaryKey(Integer aid);

    int insert(Stockbatchdetail record);

    int insertSelective(Stockbatchdetail record);

    Stockbatchdetail selectByPrimaryKey(Integer aid);

    int updateByPrimaryKeySelective(Stockbatchdetail record);

    int updateByPrimaryKey(Stockbatchdetail record);

    int insertStockDetailBatch(@Param("stockbatchdetails") List<Stockbatchdetail> stockbatchdetails);
}