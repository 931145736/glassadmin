package com.xjt.dao.master;

import com.xjt.dto.ModuleshowfieldsReqDto;
import com.xjt.entity.Moduleshowfields;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ModuleshowfieldsDao {
    int deleteByPrimaryKey(Moduleshowfields key);

    /**
    *@Description 添加模块 
    * * @param record
    *@Return int
    *@Author Administrator
    *@Date 2019/11/6
    *@Time 
    */
    int insert(Moduleshowfields record);

    int insertModuleBatch(@Param("moduleshowfields") List<Moduleshowfields> moduleshowfields);

    int insertSelective(Moduleshowfields record);

    Moduleshowfields selectByPrimaryKey(Moduleshowfields key);

    int updateByPrimaryKeySelective(Moduleshowfields record);

    int updateByPrimaryKey(Moduleshowfields record);


    List<Moduleshowfields> queryModuleFieldsList(String moduleId);

    int deleteFieldsByModule(ModuleshowfieldsReqDto reqDto);
}