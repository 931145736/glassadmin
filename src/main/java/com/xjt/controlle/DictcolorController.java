package com.xjt.controlle;

import com.xjt.dto.BaseResDto;
import com.xjt.service.DictcolorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "颜色膜层相关接口")
@RequestMapping("/color")
public class DictcolorController {

    @Autowired
    private DictcolorService dictcolorService;

    @GetMapping("/queryColorList")
    @ApiOperation("查看颜色膜层列表")
    public BaseResDto queryColorList(){
        return dictcolorService.queryColorList();
    }
}
