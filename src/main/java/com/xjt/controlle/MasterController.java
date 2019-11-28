package com.xjt.controlle;

import com.alibaba.fastjson.JSONObject;
import com.xjt.annotation.SecurityParameter;
import com.xjt.annotation.UserLog;
import com.xjt.dto.BaseResDto;
import com.xjt.dto.MasterReqDto;
import com.xjt.entity.Master;
import com.xjt.service.MasterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;

@RestController
@Api(tags = "用户管理相关接口")
@RequestMapping("/master")
public class MasterController  {

    @Autowired
    private MasterService masterService;

    private Logger logger = LoggerFactory.getLogger(MasterController.class);

    /**
     * 添加用户信息
     * @param reqDto
     * @return
     */


    @UserLog("添加用户")
    @SecurityParameter(outEncode = false)
    @ApiOperation("添加用户信息")
    @PostMapping("/insertMaster")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "用户名",required = true),
            @ApiImplicitParam(name = "password",value = "用户密码",required = true),
            @ApiImplicitParam(name = "dept",value = "用户部门",required = true)
    })
    public BaseResDto insertMaster(@RequestBody MasterReqDto reqDto, HttpServletRequest request){
        Master master =(Master)request.getAttribute("currentUser");
        reqDto.setMasterId(master.getId());
        reqDto.setMasterName(master.getTrueName());
        return masterService.insertMaster(reqDto);
    }

    /**
     * 更新用户有效状态值（逻辑删除用户）
     * @param reqDto
     * @return
     */
    @UserLog("删除用户")
    @SecurityParameter(outEncode = false)
    @PostMapping("/updateDeleteFlagMaster")
    @ApiOperation("更新用户有效状态值（逻辑删除用户）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "用户id",required = true),

    })
    public BaseResDto updateDeleteFlag(@RequestBody MasterReqDto reqDto){
        return masterService.deleteMaster(reqDto);
    }

    /**
     * 更新用户
     * @param reqDto
     * @return
     */
    @UserLog("更新用户")
    @SecurityParameter(outEncode = false)
    @PostMapping("/updateMaster")
    @ApiOperation("更新用户")
    @ApiImplicitParam(name = "id",value = "用户id",required = true)
    public BaseResDto updateMaster(@RequestBody MasterReqDto reqDto){
        return masterService.updateMaster(reqDto);
    }

    /**
     * 查看用户列表
     * @param reqDto
     * @return
     */
    @UserLog("查看用户列表")
    @SecurityParameter(outEncode = false)
    @PostMapping("/queryMasterList")
    @ApiOperation("分页查看用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo",value = "分页参数，第几页",required = true),
            @ApiImplicitParam(name = "pageSize",value = "分页参数，每页请求几条",required = true)
    })
    public BaseResDto queryMasterList(@RequestBody MasterReqDto reqDto){
        logger.info("参数信息"+JSONObject.toJSONString(reqDto));
        return masterService.queryMasterList(reqDto);
    }

    /**
     * 查看单个用户信息
     * @param
     * @return
     */
    @UserLog("查看用户详情")
    @SecurityParameter(outEncode = false)
    @PostMapping("/queryMasterInfo")
    @ApiOperation("查看单个用户信息")
    @ApiImplicitParam(name = "userId",value = "用户id",required = true)
    public BaseResDto queryMasterInfo(@RequestBody MasterReqDto reqDto ){


        return masterService.queryMasterInfo(reqDto.getUserId());
    }


}
