package com.xjt.controlle;

import com.alibaba.fastjson.JSONObject;
import com.xjt.annotation.SecurityParameter;
import com.xjt.annotation.UserLog;
import com.xjt.dto.BaseResDto;
import com.xjt.dto.PurchaseReqDto;
import com.xjt.entity.Master;
import com.xjt.entity.OrderEntity;
import com.xjt.service.PurchaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassNamePurchaseController
 * @Description
 * @Author
 * @Date2019/11/7 10:06
 * @Version V1.0
 **/
@RestController
@Api(tags = "采购单相关接口")
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    private Logger logger = LoggerFactory.getLogger(PurchaseController.class);

    @UserLog("添加采购单")
    @SecurityParameter(outEncode = false)
    @PostMapping("/insertPurchase")
    @ApiOperation("添加采购单")
    public BaseResDto insertPurchase(@RequestBody PurchaseReqDto reqDto, HttpServletRequest request){
        logger.info("接收的参数"+JSONObject.toJSONString(reqDto));
        Master master = (Master) request.getAttribute("currentUser");
        reqDto.setOperator(master.getId());
        return purchaseService.addPurchaseOrder(reqDto);
    }

    @UserLog("审核采购订单")
    @SecurityParameter(outEncode = false)
    @PostMapping("/checkPurchaseOrder")
    @ApiOperation("审核采购订单 posted 0 未审核 1 审核")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "purchaseId",value = "订单号",required = true),
            @ApiImplicitParam(name = "posted",value = "是否审核 0 否 1 是",required = true)
    })
    public BaseResDto checkPurchaseOrder(@RequestBody PurchaseReqDto reqDto, HttpServletRequest request){
        Master master =(Master)request.getAttribute("currentUser");
        reqDto.setPostuser(master.getId());
        reqDto.setPosted(1);
        return purchaseService.checkPurchaseOrder(reqDto);
    }

    @UserLog("查看采购订单列表")
    @SecurityParameter(outEncode = false)
    @PostMapping("/queryPurchaseOrderList")
    @ApiOperation("查看采购订单列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo",value ="分页参数 第几页",required = true)

    })
    public BaseResDto queryPurchaseOrderList(@RequestBody OrderEntity reqDto){
        reqDto.setPageSize(20);
        return purchaseService.PurchaseOrderLisy(reqDto);
    }

    @UserLog("查看订单详情")
    @SecurityParameter(outEncode = false)
    @PostMapping("/queryOrderDetail")
    @ApiOperation("查看订单详情")
    @ApiImplicitParam(name = "purchaseId",value = "订单id",required = true)
    public BaseResDto queryOrderDetail(@RequestBody PurchaseReqDto reqDto){
        return purchaseService.queryOrderDetail(reqDto);
    }


    @SecurityParameter(outEncode = false)
    @UserLog("删除采购订单")
    @PostMapping("/deletePurchaseOrder")
    @ApiOperation("删除采购订单")
    @ApiImplicitParam(name = "purchaseId",value = "采购单id",required = true)
    public BaseResDto deletePurchaseOrder(String purchaseId){
        return purchaseService.deletePurchaseOrder(purchaseId);
    }
}
