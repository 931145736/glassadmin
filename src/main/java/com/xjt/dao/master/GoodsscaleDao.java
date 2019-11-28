package com.xjt.dao.master;

import com.xjt.entity.Goodsscale;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsscaleDao {
    int deleteByPrimaryKey(Goodsscale key);

    int insert(Goodsscale record);

    int insertSelective(Goodsscale record);

    Goodsscale selectByPrimaryKey(Goodsscale key);

    int updateByPrimaryKeySelective(Goodsscale record);

    int updateByPrimaryKey(Goodsscale record);

    int insertGoodDetail(@Param("goodsscales") List<Goodsscale> goodsscales);
}