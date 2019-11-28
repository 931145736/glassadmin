package com.xjt.controlle;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.BoxbillReqDto;
import com.xjt.service.BoxbillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassNameBoxbillController
 * @Description
 * @Author
 * @Date2019/11/7 14:19
 * @Version V1.0
 **/
@RestController
@Api(tags = "箱数统计接口")
@RequestMapping("/boxbill")
public class BoxbillController {

    @Autowired
    private BoxbillService boxbillService;

    @PostMapping("/insertBoxbill")
    @ApiOperation("添加箱数统计")
    public BaseResDto insertBoxbill(BoxbillReqDto reqDto){
        return boxbillService.insertBoxBill(reqDto);
    }
}
