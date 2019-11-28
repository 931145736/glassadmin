package com.xjt.dao.master;

import com.xjt.entity.Moduleshowschemefields;

public interface ModuleshowschemefieldsDao {
    int deleteByPrimaryKey(Moduleshowschemefields key);

    int insert(Moduleshowschemefields record);

    int insertSelective(Moduleshowschemefields record);

    Moduleshowschemefields selectByPrimaryKey(Moduleshowschemefields key);

    int updateByPrimaryKeySelective(Moduleshowschemefields record);

    int updateByPrimaryKey(Moduleshowschemefields record);
}