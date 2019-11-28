package com.xjt.controlle;

import com.xjt.annotation.UserLog;
import com.xjt.dto.AssetinfoReqDto;
import com.xjt.dto.BaseResDto;
import com.xjt.entity.Master;
import com.xjt.service.AssetinfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @ClassNameAssetinfoController
 * @Description
 * @Author
 * @Date2019/11/15 16:25
 * @Version V1.0
 **/
@RestController
@Api(tags = "物资信息接口")
@RequestMapping("/assetinfo")
public class AssetinfoController {

    @Autowired
    private AssetinfoService assetinfoService;
    @UserLog("查看物资列表")
    @PostMapping("/queryAssetinfoList")
    @ApiOperation("查看物资列表，id和名称，规格")
    public BaseResDto queryAssetinfoList(AssetinfoReqDto reqDto){
        return assetinfoService.queryAssetList(reqDto);
    }

    @UserLog("批量添加物资信息")
    @PostMapping("/addAssetinfoBatch")
    @ApiOperation("批量添加物资信息")
    public BaseResDto addAssetinfoBatch(@RequestBody List<AssetinfoReqDto> reqDtos, HttpServletRequest request){
        Master master = (Master) request.getAttribute("currentUser");

        return assetinfoService.addAssetinfo(reqDtos,master);
    }
}
