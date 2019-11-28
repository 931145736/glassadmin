package com.xjt.controlle;

import com.xjt.annotation.UserLog;
import com.xjt.dto.BaseResDto;
import com.xjt.dto.ChanneloptionsReqDto;
import com.xjt.service.ChanneloptionsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassNameChanneloptionsController
 * @Description
 * @Author
 * @Date2019/11/5 10:02
 * @Version V1.0
 **/
@RestController
@Api(tags = "渠道参数接口")
@RequestMapping("/channeloption")
public class ChanneloptionsController {

    @Autowired
    private ChanneloptionsService channeloptionsService;

    @UserLog("增加渠道参数")
    @PostMapping("/insertChannelOption")
    @ApiOperation("增加渠道参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cname",value = "参数名",required = true),
            @ApiImplicitParam(name = "cdata",value = "参数值",required = true),
            @ApiImplicitParam(name = "optionType",value = "参数类型",required = true),
            @ApiImplicitParam(name = "channelId",value = "渠道id",required = true)
    })
    public BaseResDto insertChannelOption(ChanneloptionsReqDto reqDto){
        return channeloptionsService.insertChannelOption(reqDto);
    }

}
