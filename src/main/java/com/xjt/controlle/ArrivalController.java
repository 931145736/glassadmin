package com.xjt.controlle;

import com.xjt.annotation.SecurityParameter;
import com.xjt.annotation.UserLog;
import com.xjt.dto.ArrivalReqDto;
import com.xjt.dto.BaseResDto;
import com.xjt.entity.Master;
import com.xjt.entity.OrderEntity;
import com.xjt.service.ArrivalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassNameArrivalController
 * @Description
 * @Author
 * @Date2019/11/7 11:22
 * @Version V1.0
 **/
@RestController
@Api(tags = "到货通知单相关接口")
@RequestMapping("/arrival")
public class ArrivalController {

    @Autowired
    private ArrivalService arrivalService;
    @SecurityParameter(outEncode = false)
    @UserLog("添加到货通知单") //记录用户日志操作
    @PostMapping("/insertArrivalOrder")
    @ApiOperation("添加到货通知单")
    public BaseResDto insertArrivalOrder(@RequestBody ArrivalReqDto reqDto){
        return arrivalService.insertArrivalOrder(reqDto);
    }
    @UserLog("审核到货通知单")
    @SecurityParameter(outEncode = false)
    @PostMapping("/checkArrivalOrder")
    @ApiOperation("审核到货通知单 posted 0 未审核 1 审核")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "arrivalid",value = "通知单id",required = true)

    })
    public BaseResDto checkArrivalOrder(@RequestBody ArrivalReqDto reqDto,HttpServletRequest request){
        Master master =(Master)request.getAttribute("currentUser");
        reqDto.setPostuser(master.getId());
        reqDto.setPosted(1);
        return arrivalService.checkArrivalOrder(reqDto);
    }

    @UserLog("查看到货通知单列表")
    @SecurityParameter(outEncode = false)
    @PostMapping("/queryArrivalOrderList")
    @ApiOperation("查看到货通知单列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo",value = "分页参数，第几页",required = true)
    })
    public BaseResDto queryArrivalOrderList(@RequestBody OrderEntity reqDto){

        return arrivalService.queryArrivalOrderList(reqDto);
    }

    @SecurityParameter(outEncode = false)
    @UserLog("查看到货通知单详情")
    @PostMapping("/queryArrivalDetail")
    @ApiOperation("查看到货通知单详情")
    @ApiImplicitParam(name = "arrivalid",value = "通知单id",required = true)
    public BaseResDto queryArrivalDetail(@RequestBody ArrivalReqDto reqDto){
        return arrivalService.queryArrivalOrderDetail(reqDto);
    }
}
