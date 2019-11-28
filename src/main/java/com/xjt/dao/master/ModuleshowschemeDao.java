package com.xjt.dao.master;

import com.xjt.entity.Moduleshowscheme;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ModuleshowschemeDao {
    int deleteByPrimaryKey(String schemeid);

    /***
    *@Description 添加方案信息
    * * @param record
    *@Return int
    *@Author Administrator
    *@Date 2019/11/6
    *@Time 
    */
    int insert(Moduleshowscheme record);

    int insertSelective(Moduleshowscheme record);

    Moduleshowscheme selectByPrimaryKey(String schemeid);

    int updateByPrimaryKeySelective(Moduleshowscheme record);

    int updateByPrimaryKey(Moduleshowscheme record);
}