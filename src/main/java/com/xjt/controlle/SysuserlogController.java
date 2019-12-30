package com.xjt.controlle;

import com.xjt.annotation.SecurityParameter;
import com.xjt.annotation.UserLog;
import com.xjt.dto.BaseResDto;
import com.xjt.dto.SysuserlogReqDto;
import com.xjt.service.SysuserlogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassNameSysuserlogController
 * @Description
 * @Author
 * @Date2019/11/21 10:08
 * @Version V1.0
 **/
@RestController
@Api(tags = "用户日志接口")
@RequestMapping("/userLog")
public class SysuserlogController {

    @Autowired
    private SysuserlogService sysuserlogService;

    @SecurityParameter(outEncode = false)
    @PostMapping("/querySysUserLog")
    @ApiOperation("查看用户操作日志接口")
    public BaseResDto querySysUserLog(@RequestBody SysuserlogReqDto reqDto){
        return sysuserlogService.queryUserLogList(reqDto);
    }


    @UserLog("删除用户日志")
    @PostMapping("/deleteUserLog")
    @ApiOperation("删除用户日志")
    public BaseResDto deleteUserLog(SysuserlogReqDto reqDto){
        return sysuserlogService.deleteUserLog(reqDto);
    }


}
