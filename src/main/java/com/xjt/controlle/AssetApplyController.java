package com.xjt.controlle;

import com.xjt.annotation.UserLog;
import com.xjt.dto.AssetapplyReqDto;
import com.xjt.dto.BaseResDto;
import com.xjt.entity.Master;
import com.xjt.service.AssetApplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassNameAssetApplyController
 * @Description
 * @Author
 * @Date2019/11/18 9:16
 * @Version V1.0
 **/
@RestController
@RequestMapping("/assetApply")
@Api(tags = "物资申领表相关接口")
public class AssetApplyController {

    @Autowired
    private AssetApplyService assetApplyService;
    @UserLog("添加物资申领表")
    @PostMapping("/insertAssetApply")
    @ApiOperation("添加物资申领表")
    public BaseResDto insertAssetApply(@RequestBody AssetapplyReqDto  reqDto,HttpServletRequest request){
        Master master = (Master) request.getAttribute("currentUser");
        reqDto.setApplyPerson(master.getId());
        return assetApplyService.insertAssetApply(reqDto);
    }


    @PostMapping("/queryApplyList")
    @ApiOperation("查看物资申领表列表")
    public BaseResDto queryApplyList(AssetapplyReqDto reqDto)
    {
        return assetApplyService.queryAssetApplyList(reqDto);
    }



    @PostMapping("/queryApplyDetail")
    @ApiOperation("查看物资申领表详情")
    public BaseResDto queryApplyDetail(AssetapplyReqDto reqDto){
        return assetApplyService.queryApplyDetails(reqDto);
    }


    //暂缓
    @UserLog("审核物资申领表")
    @PostMapping("/checkApply")
    @ApiOperation("审核物资申领表")
    public BaseResDto checkApply(AssetapplyReqDto reqDto, HttpServletRequest request){
        Master master = (Master) request.getAttribute("currentUser");
        reqDto.setAuditPerson(master.getId());
        return assetApplyService.checkAssetApply(reqDto);
    }

}
