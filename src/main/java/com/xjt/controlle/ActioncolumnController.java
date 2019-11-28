package com.xjt.controlle;

import com.xjt.annotation.ActionPower;
import com.xjt.dto.ActioncolumnReqDto;
import com.xjt.dto.BaseResDto;
import com.xjt.service.ActioncolumnService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@Api(tags = "分栏相关接口")
@RequestMapping("/actioncloumn")
public class ActioncolumnController {

    @Autowired
    private ActioncolumnService actioncolumnService;

    /**
     * 添加分栏
     * @param reqDto
     * @return
     */
    @PostMapping("/insertSubfield")
    @ApiOperation("添加分栏")
    @ApiImplicitParam(name = "actionColumnName",value = "分栏名称",required = true)
    public BaseResDto insertSubfield(ActioncolumnReqDto reqDto){
        return actioncolumnService.insertSubfield(reqDto);
    }

    /**
     * 查看一级菜单
     */
    @ActionPower //菜单权限
    @GetMapping("/queryColumnList")
    @ApiOperation("查看分栏列表")
    public BaseResDto queryColumnList(HttpSession session){
        List<String> actionIds =(List<String>) session.getAttribute("actionIds");
        return actioncolumnService.queryColumnList(actionIds);
    }




}
