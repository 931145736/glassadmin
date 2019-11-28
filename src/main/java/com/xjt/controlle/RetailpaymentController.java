package com.xjt.controlle;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.RetailpaymentReqDto;
import com.xjt.service.RetailpaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassNameRetailpaymentController
 * @Description
 * @Author
 * @Date2019/11/5 9:14
 * @Version V1.0
 **/
@RestController
@Api(tags = "支付说明接口")
@RequestMapping("/payment")
public class RetailpaymentController {

    @Autowired
    private RetailpaymentService service;


    @PostMapping("/insertPayment")
    @ApiOperation("添加支付说明")
    @ApiImplicitParam(name = "paymentname",value = "支付说明",required = true)
    public BaseResDto insertPayment(RetailpaymentReqDto reqDto){
        return service.insertPayMent(reqDto);
    }
}
