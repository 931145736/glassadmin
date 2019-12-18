package com.xjt.service;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.WarehouseReqDto;


public interface WarehouseService {

    /**
     * 增加仓库
     * @param reqDto
     * @return
     */
    BaseResDto insertWareHouse(WarehouseReqDto reqDto);

    /**
     * 查看仓库列表
     * @param reqDto
     * @return
     */
    BaseResDto queryWarehouseList(WarehouseReqDto reqDto);

    /**
     * 查看仓库详情
     * @param reqDto
     * @return
     */
    BaseResDto queryHouseInfo(WarehouseReqDto reqDto);
    /***
    *@Description 更新仓库信息
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/12/10
    *@Time
    */
    BaseResDto updateWarehouseInfo(WarehouseReqDto reqDto);

    BaseResDto openOrCloseWare(WarehouseReqDto reqDto);

    BaseResDto deleteWareHouse(WarehouseReqDto reqDto);
}
