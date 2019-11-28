package com.xjt.controlle;

import com.xjt.annotation.UserLog;
import com.xjt.dto.AssetscrapReqDto;
import com.xjt.dto.BaseResDto;
import com.xjt.service.AssetscrapService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassNameAssetscrapController
 * @Description
 * @Author
 * @Date2019/11/18 17:02
 * @Version V1.0
 **/
@RestController
@Api(tags = "物资报废接口")
@RequestMapping("/assetscrap")
public class AssetscrapController {

    @Autowired
    private AssetscrapService assetscrapService;

    @UserLog("添加物资报废")
    @PostMapping("/assetScrap")
    @ApiOperation("添加报废物资")
    public BaseResDto assetScrap(AssetscrapReqDto reqDto){
        return assetscrapService.assetScrap(reqDto);
    }

    @UserLog("审核报废物资")
    @PostMapping("/checkAssetScrap")
    @ApiOperation("审核报废物资")
    public BaseResDto checkAssetScrap(AssetscrapReqDto reqDto){
        return assetscrapService.checkAssetScrap(reqDto);
    }

}
