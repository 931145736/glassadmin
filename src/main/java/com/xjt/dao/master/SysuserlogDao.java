package com.xjt.dao.master;

import com.xjt.dto.SysuserlogReqDto;
import com.xjt.entity.Sysuserlog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysuserlogDao {

    int deleteByPrimaryKey(Integer logId);

    int insert(Sysuserlog record);

    int insertSelective(Sysuserlog record);

    Sysuserlog selectByPrimaryKey(Integer logId);

    int updateByPrimaryKeySelective(Sysuserlog record);

    int updateByPrimaryKey(Sysuserlog record);

    List<Sysuserlog> queryUserLogList(SysuserlogReqDto reqDto);

    int deleteSysUserLog(Integer logId);
}