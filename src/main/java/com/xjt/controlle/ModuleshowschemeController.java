package com.xjt.controlle;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.ModuleshowschemeReqDto;
import com.xjt.service.ModuleshowschemeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassNameModuleshowschemeController
 * @Description
 * @Author
 * @Date2019/11/6 15:01
 * @Version V1.0
 **/
@RestController
@Api(tags = "方案相关接口")
@RequestMapping("/showscheme")
public class ModuleshowschemeController {

    @Autowired
    private ModuleshowschemeService service;

    @PostMapping("/insertModulescheme")
    @ApiOperation("添加方案")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "schemename",value = "方案名称",required = true),
            @ApiImplicitParam(name = "moduleid",value = "模块名称",required = true),
            @ApiImplicitParam(name = "orderindex",value = "排序字段",required = true)
    })
    public BaseResDto insertModulescheme(ModuleshowschemeReqDto reqDto){
        return service.insertModuleScheme(reqDto);
    }
}
