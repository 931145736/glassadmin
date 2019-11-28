package com.xjt.controlle;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.ChanneloptionssetReqDto;
import com.xjt.service.ChanneloptionssetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassNameChanneloptionssetController
 * @Description
 * @Author
 * @Date2019/11/5 9:37
 * @Version V1.0
 **/
@RestController
@Api(tags = "参数设置接口")
@RequestMapping("/channelset")
public class ChanneloptionssetController {

    @Autowired
    private ChanneloptionssetService service;

    @PostMapping("/insertOptionSet")
    @ApiOperation("添加参数设置")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cname",value = "参数名称",required = true),
            @ApiImplicitParam(name = "optionType",value = "参数类型",required = true)
    })
    public BaseResDto insertOptionSet(ChanneloptionssetReqDto reqDto){
        return service.insertChannelSet(reqDto);
    }

}
