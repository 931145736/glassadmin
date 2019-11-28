package com.xjt.dao.master;

import com.xjt.entity.Optionscombolist;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OptionscombolistDao {
    int deleteByPrimaryKey(Optionscombolist key);

    int insert(Optionscombolist record);

    int insertSelective(Optionscombolist record);

    Optionscombolist selectByPrimaryKey(Optionscombolist key);

    int updateByPrimaryKeySelective(Optionscombolist record);

    int updateByPrimaryKey(Optionscombolist record);

    int insertListBatch(@Param("optionscombolists") List<Optionscombolist> optionscombolists);
}