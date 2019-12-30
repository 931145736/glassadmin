package com.xjt.controlle;

import com.xjt.annotation.SecurityParameter;
import com.xjt.annotation.UserLog;
import com.xjt.dto.BaseResDto;
import com.xjt.entity.DeleteOrderEntity;
import com.xjt.service.DeleteOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassNameDeleteOrderController
 * @Description
 * @Author
 * @Date2019/11/13 14:30
 * @Version V1.0
 **/
@RestController
@Api(tags = "删除订单")
@RequestMapping("/delete")
public class DeleteOrderController {

    @Autowired
    private DeleteOrderService deleteOrderService;

    @UserLog("删除订单")
    @SecurityParameter(outEncode = false)
    @PostMapping("/deleteOrder")
    @ApiOperation("删除订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId", value = "订单id", required = true),
            @ApiImplicitParam(name = "requestType", value = "请求类型:1 采购单，2 通知单，3 来货单", required = true)
    })

    public BaseResDto deleteOrder(@RequestBody DeleteOrderEntity entity){
        return deleteOrderService.deleteOrder(entity);
    }
}
