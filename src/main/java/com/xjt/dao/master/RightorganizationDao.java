package com.xjt.dao.master;

import com.xjt.entity.Rightorganization;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RightorganizationDao {
    int deleteByPrimaryKey(String id);

    int insert(Rightorganization record);

    int insertSelective(Rightorganization record);

    Rightorganization selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Rightorganization record);

    int updateByPrimaryKey(Rightorganization record);

    List<Rightorganization> queryListByIds(@Param("ids") List<String> ids);
}