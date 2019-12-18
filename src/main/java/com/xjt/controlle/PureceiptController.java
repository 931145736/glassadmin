package com.xjt.controlle;

import com.xjt.annotation.GetGlobalParam;
import com.xjt.annotation.SecurityParameter;
import com.xjt.annotation.UserLog;
import com.xjt.dto.BaseResDto;
import com.xjt.dto.PureceiptReqDto;
import com.xjt.entity.Master;
import com.xjt.entity.OrderEntity;
import com.xjt.service.PureceiptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @ClassNamePureceiptController
 * @Description
 * @Author
 * @Date2019/11/7 16:30
 * @Version V1.0
 **/
@RestController
@Api(tags = "厂家到货单相关接口")
@RequestMapping("/pureceipt")
public class PureceiptController {
    @Autowired
    private PureceiptService pureceiptService;
    /***
    *@Description 添加厂家到货单
    * * @param reqDto
 * @param session
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/7
    *@Time
    */
    @UserLog("添加厂家到货单")
    @SecurityParameter(outEncode = false)
    @GetGlobalParam
    @PostMapping("/insertPureceiptOrder")
    @ApiOperation("添加厂家到货单")
    public BaseResDto insertPureceiptOrder(@RequestBody PureceiptReqDto reqDto, HttpSession session){
        return pureceiptService.insertPureceiptOrder(reqDto,session);
    }


    @UserLog("审核厂家到货单")
    @SecurityParameter(outEncode = false)
    @PostMapping("/checkPureceiptOrder")
    @ApiOperation("审核厂家到货单")
    @ApiImplicitParam(name = "pureceiptid",value = "到货单id",required = true)
    public BaseResDto checkPureceiptOrder(@RequestBody PureceiptReqDto reqDto, HttpServletRequest request){
        Master master =(Master)request.getAttribute("currentUser");
        reqDto.setPostuser(master.getId());
        reqDto.setPosted(1);
        return pureceiptService.checkPureceiptOrder(reqDto);
    }
    @UserLog("查看厂家到货单列表")
    @SecurityParameter(outEncode = false)
    @PostMapping("/queryPureceiptOrderList")
    @ApiOperation("查看厂家到货单列表")
    @ApiImplicitParam(name = "pageNo",value = "分页参数，第几页",required = true)
    public BaseResDto queryPureceiptOrderList(@RequestBody OrderEntity reqDto){

        return pureceiptService.queryPureceiptOrderList(reqDto);
    }

    @UserLog("查看到货单详情")
    @SecurityParameter(outEncode = false)
    @PostMapping("/queryPureceiptDetail")
    @ApiOperation("查看到货单详情")
    @ApiImplicitParam(name = "pureceiptid",value = "到货单id",required = true)
    public BaseResDto queryPureceiptDetail(@RequestBody PureceiptReqDto reqDto){
        return pureceiptService.queryPureceiptDetail(reqDto);
    }
}
