package com.xjt.controlle;

import com.alibaba.fastjson.JSONObject;
import com.xjt.annotation.SecurityParameter;
import com.xjt.annotation.UserLog;
import com.xjt.dto.BaseResDto;
import com.xjt.dto.CustomerReqDto;
import com.xjt.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassNameCustomerController
 * @Description
 * @Author
 * @Date2019/11/6 10:00
 * @Version V1.0
 **/
@RestController
@Api(tags = "渠道信息接口")
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    private Logger logger = LoggerFactory.getLogger(CustomerController.class);

    /***
    *@Description 添加渠道信息
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/6
    *@Time
    */
    @UserLog("添加渠道")
    @SecurityParameter(outEncode = false)
    @PostMapping("/insertCustomer")
    @ApiOperation("添加渠道信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "customerNa",value = "渠道名称",required = true),
            @ApiImplicitParam(name = "abbrev",value = "渠道简称",required = true),
            @ApiImplicitParam(name = "fictitiousperson",value = "企业法人",required = true)
    })
    public BaseResDto insertCustomer(@RequestBody CustomerReqDto reqDto){
        logger.info("参数信息"+JSONObject.toJSONString(reqDto));
        return customerService.insertCustomer(reqDto);
    }

    @UserLog("查看渠道详情")
    @SecurityParameter(outEncode = false)
    @PostMapping("/queryCustomerInfo")
    @ApiOperation("查看渠道详情")
    @ApiImplicitParam(name = "customerId",value = "渠道id",required = true)
    public BaseResDto queryCustomerInfo(@RequestBody CustomerReqDto reqDto){
        return customerService.queryCustomerInfo(reqDto);
    }


    /***
    *@Description 查看渠道列表
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/12/13
    *@Time
    */
    @UserLog("查看渠道列表")
    @PostMapping("/queryCustomerList")
    @SecurityParameter(outEncode = false)
    public BaseResDto queryCustomerList(@RequestBody CustomerReqDto reqDto){
        return customerService.queryCustomerList(reqDto);
    }
}
