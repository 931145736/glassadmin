package com.xjt.controlle;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.OptionssetReqDto;
import com.xjt.service.OptionssetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassNameOptionssetController
 * @Description
 * @Author
 * @Date2019/11/8 16:01
 * @Version V1.0
 **/
@RestController
@RequestMapping("/optionset")
@Api(tags = "全局参数接口")
public class OptionssetController {

    @Autowired
    private OptionssetService optionssetService;

    @PostMapping("/insertOptionSet")
    @ApiOperation("添加单个参数配置")
    public BaseResDto insertOptionSet(OptionssetReqDto reqDto){
        return optionssetService.insertGlobalOptionSet(reqDto);
    }

    @PostMapping("/insertOptionSetBatch")
    @ApiOperation("批量添加参数配置")
    public BaseResDto insertOptionSetBatch(@RequestBody List<OptionssetReqDto> reqDtoList){
        return optionssetService.batchInsertOptionSet(reqDtoList);
    }
}
