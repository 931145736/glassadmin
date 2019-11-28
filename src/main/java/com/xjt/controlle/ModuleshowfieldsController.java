package com.xjt.controlle;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.ModuleshowfieldsReqDto;
import com.xjt.service.ModuleshowfieldsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassNameModuleshowfieldsController
 * @Description
 * @Author
 * @Date2019/11/6 15:45
 * @Version V1.0
 **/
@RestController
@Api(tags = "模块相关接口")
@RequestMapping("modulefields")
public class ModuleshowfieldsController {

    @Autowired
    private ModuleshowfieldsService service;

    @PostMapping("/insertModuleshowFields")
    @ApiOperation("增加模块接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "filedNames",value = "字段名",required = true),
            @ApiImplicitParam(name = "orderindex",value = "排序字段",required = true)
    })
    public BaseResDto insertModuleshowFields(ModuleshowfieldsReqDto reqDto){
        return service.insertModule(reqDto);
    }


    @PostMapping("/queryModuleListByModuleName")
    @ApiOperation("查看模块下的字段列表")
    @ApiImplicitParam(name = "moduleid",value = "模块名称",required = true)
    public BaseResDto queryModuleListByModuleName(ModuleshowfieldsReqDto reqDto){
        return service.queryModuleListByModuleName(reqDto);
    }

    @PostMapping("/deleteFieldsFromModule")
    @ApiOperation("批量删除模块下的字段")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "moduleid",value = "模块名称",required = true),
            @ApiImplicitParam(name = "fieldIds",value = "选择的字段",required = true)
    })
    public BaseResDto deleteFieldsFromModule(ModuleshowfieldsReqDto reqDto){
        return service.deleteFieldsFromModule(reqDto);
    }
}
