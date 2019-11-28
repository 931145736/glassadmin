package com.xjt.controlle;

import com.xjt.annotation.UserLog;
import com.xjt.dto.AssetreturnReqDto;
import com.xjt.dto.BaseResDto;
import com.xjt.entity.Master;
import com.xjt.service.AssetreturnService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassNameAssetreturnController
 * @Description
 * @Author
 * @Date2019/11/18 17:57
 * @Version V1.0
 **/
@RestController
@Api(tags = "物资归还")
@RequestMapping("/assetreturn")
public class AssetreturnController {

    @Autowired
    private AssetreturnService assetreturnService;

    @UserLog("添加归还信息")
    @PostMapping("/insedrtReturnAsset")
    @ApiOperation("添加归还信息")
    public BaseResDto insedrtReturnAsset(@RequestBody AssetreturnReqDto reqDto, HttpServletRequest request){
        Master master = (Master) request.getAttribute("currentUser");
        reqDto.setReturnPerson(master.getId());
        return assetreturnService.addAssetReturn(reqDto);
    }

    @UserLog("审核归还的物资")
    @PostMapping("/checkReturnAsset")
    @ApiOperation("审核归还的物资")
    public BaseResDto checkReturnAsset(AssetreturnReqDto reqDto,HttpServletRequest request){
        Master master = (Master) request.getAttribute("currentUser");
        reqDto.setAuditPerson(master.getId());
        return assetreturnService.checkAssetReturn(reqDto);
    }
}
