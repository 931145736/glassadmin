package com.xjt.dao.master;

import com.xjt.entity.Boxdetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoxdetailDao {
    int deleteByPrimaryKey(Integer aid);

    int insert(Boxdetail record);

    int insertSelective(Boxdetail record);

    Boxdetail selectByPrimaryKey(Integer aid);

    int updateByPrimaryKeySelective(Boxdetail record);

    int updateByPrimaryKey(Boxdetail record);

    int insertBoxDetailBatch(@Param("boxdetails") List<Boxdetail> boxdetails);
}