package com.xjt.controlle;

import com.xjt.annotation.SecurityParameter;
import com.xjt.annotation.UserLog;
import com.xjt.dto.BaseResDto;
import com.xjt.dto.WarehouseReqDto;
import com.xjt.service.WarehouseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags ="仓库相关接口" )
@RequestMapping("/warehouse")
public class WarehouseController {
    @Autowired
    private WarehouseService warehouseService;

    @UserLog("增加仓库")
    @SecurityParameter(outEncode = false)
    @PostMapping("/insertWareHouse")
    @ApiOperation("增加仓库接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "warehouseNa",value = "仓库名称",required = true),
            @ApiImplicitParam(name = "address",value = "仓库地址",required = true),
            @ApiImplicitParam(name = "zipcode",value = "仓库电话",required = true),
            @ApiImplicitParam(name = "keyman",value = "负责人",required = true),
            @ApiImplicitParam(name = "tag",value ="是否虚拟仓库 true or false",required = true)
    })
    public BaseResDto insertWareHouse(@RequestBody WarehouseReqDto reqDto){
        return warehouseService.insertWareHouse(reqDto);
    }

    @UserLog("查看仓库列表")
    @SecurityParameter(outEncode = false)
    @PostMapping("/queryWarehouseList")
    @ApiOperation("查看仓库列表 可以分页查看")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo",value = "分页参数 第几页"),
            @ApiImplicitParam(name = "pageSize",value = "分页参数 每页数据量")
    })
    public BaseResDto queryWarehouseList(@RequestBody WarehouseReqDto reqDto){

        return warehouseService.queryWarehouseList(reqDto);
    }

    @UserLog("查看仓库信息")
   @SecurityParameter(outEncode = false)
    @PostMapping("/queryWareInfo")
    @ApiOperation("查看仓库详细信息")
    @ApiImplicitParam(name = "warehouseNo",value = "仓库编号",required = true)
    public BaseResDto queryWareInfo( @RequestBody WarehouseReqDto reqDto){
        return warehouseService.queryHouseInfo(reqDto);
    }


    @UserLog("更新仓库")
    @SecurityParameter(outEncode = false)
    @PostMapping("/updateWareHouse")
    public BaseResDto updateWare(@RequestBody WarehouseReqDto reqDto){
        return warehouseService.updateWarehouseInfo(reqDto);

    }

    @UserLog("停启用仓库")
    @SecurityParameter(outEncode = false)
    @PostMapping("/openOrStopWare")
    public BaseResDto openOrStopWare(@RequestBody WarehouseReqDto reqDto){

        return warehouseService.openOrCloseWare(reqDto);
    }

    @UserLog("删除仓库")
    @SecurityParameter(outEncode = false)
    @PostMapping("/deleteWarehouse")
    public BaseResDto deleteWarehouse(@RequestBody  WarehouseReqDto reqDto){
        return warehouseService.deleteWareHouse(reqDto);
    }
}
