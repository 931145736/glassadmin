package com.xjt.dao.master;

import com.xjt.entity.Dictcolor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DictcolorDao {

    int deleteByPrimaryKey(int colorid);

    int insert(Dictcolor record);

    int insertSelective(Dictcolor record);

    Dictcolor selectByPrimaryKey(int colorid);

    int updateByPrimaryKeySelective(Dictcolor record);

    int updateByPrimaryKey(Dictcolor record);

    /**
     * 批量添加颜色
     * @param colors
     * @return
     */
    int insertColorBatch(@Param("colors") List<String> colors);

    /**
     * 查看颜色列表
     * @return
     */
    List<Dictcolor> queryColorList();

    int deleteColorBatch(@Param("colors") List<String> colors);

}