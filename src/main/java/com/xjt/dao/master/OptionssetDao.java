package com.xjt.dao.master;

import com.xjt.entity.Optionsset;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OptionssetDao {
    int deleteByPrimaryKey(String id);

    int insert(Optionsset record);

    int insertSelective(Optionsset record);

    Optionsset selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Optionsset record);

    int updateByPrimaryKey(Optionsset record);

    int insertBatchOptionset(@Param("optionssets") List<Optionsset> optionssets);
}