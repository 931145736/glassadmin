package com.xjt.controlle;

import com.xjt.annotation.UserLog;
import com.xjt.dto.AssetreceiveReqDto;
import com.xjt.dto.BaseResDto;
import com.xjt.entity.Assetreceive;
import com.xjt.entity.Master;
import com.xjt.service.AssetreceiveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassNameAssetreceiveController
 * @Description
 * @Author
 * @Date2019/11/18 11:28
 * @Version V1.0
 **/
@RestController
@RequestMapping("/assetreceive")
@Api(tags = "物资领用单接口")
public class AssetreceiveController {

    @Autowired
    private AssetreceiveService assetreceiveService;

    /***
    *@Description 添加物资领用单
    * * @param reqDtos
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/18
    *@Time
    */
    @UserLog("添加物资领用单")
    @PostMapping("/insertAssetReceive")
    @ApiOperation("添加物资领用单接口")
    public BaseResDto insertAssetReceive(@RequestBody AssetreceiveReqDto reqDto, HttpServletRequest request){
        Master master = (Master) request.getAttribute("currentUser");
        reqDto.setReceivePerson(master.getId());
        return assetreceiveService.insertAssetReceive(reqDto);
    }

    @UserLog("查看物资领用单列表")
    @PostMapping("/queryReceiveList")
    @ApiOperation("查看物资领用单列表")
    public BaseResDto queryReceiveList(AssetreceiveReqDto reqDto){
        return assetreceiveService.queryAssetReceiveList(reqDto);
    }

    @UserLog("查看领用单物资信息")
    @PostMapping("/queryReceiveAssetInfo")
    @ApiOperation("查看领用单物资信息")
    public BaseResDto queryReceiveAssetInfo(AssetreceiveReqDto reqDto){
        return assetreceiveService.queryReceiveAssetInfo(reqDto);
    }

    @UserLog("审核领用单")
    @PostMapping("/checkAssetReceive")
    @ApiOperation("审核领用单")
    public BaseResDto checkAssetReceive(AssetreceiveReqDto reqDto, HttpServletRequest request){
        Master master = (Master) request.getAttribute("currentUser");
        reqDto.setAuditPerson(master.getId());
        return assetreceiveService.checkAssetReceive(reqDto);
    }





}
