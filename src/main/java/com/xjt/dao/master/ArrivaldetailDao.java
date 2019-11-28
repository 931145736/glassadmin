package com.xjt.dao.master;

import com.xjt.entity.Arrivaldetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArrivaldetailDao {
    int deleteByPrimaryKey(Integer autoid);

    int insert(Arrivaldetail record);

    int insertSelective(Arrivaldetail record);

    Arrivaldetail selectByPrimaryKey(Integer autoid);

    int updateByPrimaryKeySelective(Arrivaldetail record);

    int updateByPrimaryKey(Arrivaldetail record);

    /***
    *@Description 批量添加通知单货品明细
    * * @param arrivaldetails
    *@Return int
    *@Author Administrator
    *@Date 2019/11/7
    *@Time
    */
    int insertArrivalDetailBatch(@Param("arrivaldetails") List<Arrivaldetail> arrivaldetails);
}