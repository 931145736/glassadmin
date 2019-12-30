package com.xjt.controlle;

import com.alibaba.fastjson.JSONObject;
import com.xjt.dto.BaseResDto;
import com.xjt.dto.GoodsReqDto;
import com.xjt.entity.GoodscolorKey;
import com.xjt.entity.Goodsscale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassNameTest
 * @Description
 * @Author
 * @Date2019/11/4 14:46
 * @Version V1.0
 **/
@RestController
public class Test {
    public static Logger logger = LoggerFactory.getLogger(Test.class);



    @RequestMapping("/testOne")
    public BaseResDto testOne(){
        BaseResDto resDto = new BaseResDto();
        Map<String,Object> map = new HashMap<>();
        map.put("name","小花");
        map.put("age",19);
        resDto.setData(map);
        return resDto;

    }
    @RequestMapping("/testTwo")
    public BaseResDto testTwo(){
        BaseResDto resDto = new BaseResDto();
        return resDto;
    }

 

}
