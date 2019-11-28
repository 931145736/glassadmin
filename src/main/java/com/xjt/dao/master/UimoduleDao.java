package com.xjt.dao.master;

import com.xjt.dto.UimoduleReqDto;
import com.xjt.entity.Uimodule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UimoduleDao {
    int deleteByPrimaryKey(String id);

    int insert(Uimodule record);

    int insertSelective(Uimodule record);

    Uimodule selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Uimodule record);

    int updateByPrimaryKey(Uimodule record);

    /***
    *@Description 查看一级菜单
    * * @param reqDto
    *@Return java.util.List<com.xjt.entity.Uimodule>
    *@Author Administrator
    *@Date 2019/11/8
    *@Time
    */
    List<Uimodule> queryOneList(UimoduleReqDto reqDto);

    /***
    *@Description 查看当前菜单的子集
    * * @param reqDto
    *@Return java.util.List<com.xjt.entity.Uimodule>
    *@Author Administrator
    *@Date 2019/11/8
    *@Time
    */
    List<Uimodule> queryChildrenList(UimoduleReqDto reqDto);
}