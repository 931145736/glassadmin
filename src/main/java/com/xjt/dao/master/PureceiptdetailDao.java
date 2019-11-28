package com.xjt.dao.master;

import com.xjt.entity.Pureceiptdetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PureceiptdetailDao {
    int deleteByPrimaryKey(Integer autoid);

    int insert(Pureceiptdetail record);

    int insertSelective(Pureceiptdetail record);

    Pureceiptdetail selectByPrimaryKey(Integer autoid);

    int updateByPrimaryKeySelective(Pureceiptdetail record);

    int updateByPrimaryKey(Pureceiptdetail record);

    int insertPureceiptDetailsBatch(@Param("pureceiptdetails") List<Pureceiptdetail> pureceiptdetails);

    //查看到货单货品信息
    List<Pureceiptdetail> queryGoodsInfo(String pureceiptId);
}