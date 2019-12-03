package com.xjt.controlle;

import com.xjt.annotation.MenuPower;
import com.xjt.annotation.UserLog;
import com.xjt.dto.BaseResDto;
import com.xjt.dto.UimoduleReqDto;
import com.xjt.service.UimoduleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassNameUimoduleController
 * @Description
 * @Author
 * @Date2019/11/8 16:41
 * @Version V1.0
 **/
@RestController
@Api(tags = "菜单相关接口")
@RequestMapping("/menu")
public class UimoduleController {

    @Autowired
    private UimoduleService uimoduleService;

    @UserLog("查看一级菜单")

    @PostMapping("/queryOneList")
    @ApiOperation("查看一级菜单列表")
    public BaseResDto queryOneList(UimoduleReqDto reqDto, HttpServletRequest request){
        List<String> ids = (List<String>)request.getAttribute("menuPower");
        reqDto.setIds(ids);
        return uimoduleService.queryOneMenu(reqDto);
    }

    @UserLog("查看子集菜单")
    @MenuPower
    @PostMapping("/queryChildrenList")
    @ApiOperation("查看子集菜单")
    @ApiImplicitParam(name = "parentid",value = "上级菜单id",required = true)
    public BaseResDto queryChildrenList(UimoduleReqDto reqDto,HttpSession session){
        List<String> ids = (List<String>)session.getAttribute("menuPower");
        reqDto.setIds(ids);
        return uimoduleService.queryChildrenMenu(reqDto);
    }

    @PostMapping("/insertUimodule")
    public BaseResDto insertUimodule(UimoduleReqDto reqDto){
        return uimoduleService.insertUimodule(reqDto);
    }
}
