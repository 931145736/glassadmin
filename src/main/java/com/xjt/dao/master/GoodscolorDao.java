package com.xjt.dao.master;

import com.xjt.entity.GoodscolorKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodscolorDao {
    int deleteByPrimaryKey(GoodscolorKey key);

    int insert(GoodscolorKey record);

    int insertSelective(GoodscolorKey record);

    int insertGoodsColorBatch(@Param("goodscolorKeys") List<GoodscolorKey> goodscolorKeys);
}