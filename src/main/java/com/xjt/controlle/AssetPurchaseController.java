package com.xjt.controlle;

import com.xjt.annotation.UserLog;
import com.xjt.dto.AssetpurchaseReqDto;
import com.xjt.dto.BaseResDto;
import com.xjt.entity.Master;
import com.xjt.service.AssetPurchaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassNameAssetPurchaseController
 * @Description
 * @Author
 * @Date2019/11/20 10:42
 * @Version V1.0
 **/
@RestController
@Api(tags = "物资采购单接口")
@RequestMapping("/AssetPurchase")
public class AssetPurchaseController {
    @Autowired
    private AssetPurchaseService purchaseService;

    @UserLog("添加物资采购单")
    @PostMapping("/insertAssetPurchase")
    @ApiOperation("添加物资采购单")
    public BaseResDto insertAssetPurchase(@RequestBody AssetpurchaseReqDto reqDto, HttpServletRequest request){
        Master master = (Master) request.getAttribute("currentUser");
        reqDto.setPurchasePerson(master.getId());
        return purchaseService.insertAssetPurchase(reqDto);
    }

    @UserLog("审核物资采购单")
    @PostMapping("/checkAssetPurchase")
    @ApiOperation("审核物资采购单接口")
    public BaseResDto checkAssetPurchase(AssetpurchaseReqDto reqDto,HttpServletRequest request){
        Master master = (Master) request.getAttribute("currentUser");
        reqDto.setAuditPerson(master.getId());
        return purchaseService.checkAssetPurchase(reqDto);
    }

    @UserLog("查看物资采购单列表")
    @PostMapping("/queryAssetPurchaseList")
    @ApiOperation("查看物资采购单列表")
    public BaseResDto queryAssetPurchaseList(AssetpurchaseReqDto reqDto){
        return purchaseService.queryAssetPurchaseList(reqDto);
    }

    @UserLog("查看采购的物资详情")
    @PostMapping("/queryPurchaseAssetInfo")
    @ApiOperation("查看采购的物资详情")
    public BaseResDto queryPurchaseAssetInfo(AssetpurchaseReqDto reqDto){
        return purchaseService.queryPurchaseAssetInfo(reqDto);
    }
}
