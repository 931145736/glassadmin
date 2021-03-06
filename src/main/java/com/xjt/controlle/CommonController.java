package com.xjt.controlle;

import com.alibaba.fastjson.JSONObject;
import com.xjt.annotation.SecurityParameter;
import com.xjt.dto.BaseResDto;
import com.xjt.dto.CommonReqDto;
import com.xjt.service.CommonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "单字段表相关操作接口")
@RequestMapping("/common")
public class CommonController {

    @Autowired
    private CommonService commonService;

    private Logger logger = LoggerFactory.getLogger(CommonController.class);

    /**
     * 批量添加数据
     * @param reqDto
     * @return
     */
    @RequestMapping("/insertDatasBatch")
    public BaseResDto insertDatasBatch(CommonReqDto reqDto){
        return commonService.insertDatasBatch(reqDto);
    }

    /**
     * 批量删除数据
     * @param reqDto
     * @return
     */
    @RequestMapping("/deleteDatasBatch")
    public BaseResDto deleteDatasBatch(CommonReqDto reqDto){
        return commonService.deleteDatasBatch(reqDto);
    }

    /**
     * 查看所有数据
     */
    @SecurityParameter(outEncode = false)
    @RequestMapping("/queryAllDatas")
    public BaseResDto queryAllDatas(@RequestBody CommonReqDto reqDto){
        return commonService.queryAllData(reqDto);
    }

    /**
    *@Description 查看下拉列表 requestType: 1 供应商；2 公司； 3 组织机构
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/12/2
    *@Time
    */

    @SecurityParameter(outEncode = false)
    @PostMapping("/selectOptionList")
    @ApiOperation("查看下拉列表")
    @ApiImplicitParam(name = "requestType",value = "1 供应商；2 公司； 3 组织机构; 4 开户行信息；5 品牌信息 ",required = true)
    public BaseResDto selectOptionList(@RequestBody CommonReqDto reqDto){
        return commonService.SelectOptionList(reqDto);
    }


    @SecurityParameter(outEncode = false)
    @PostMapping("/openOrClosedTarget")
    public BaseResDto openOrClosedTarget(@RequestBody CommonReqDto reqDto){
        logger.info("参数"+JSONObject.toJSONString(reqDto));
        return commonService.openOrClosedTarget(reqDto);
    }


}
