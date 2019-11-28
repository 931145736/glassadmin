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

import java.math.BigDecimal;
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

 
    public static void main(String[] args) throws ParseException {
       /* GoodsReqDto goodsReqDto = new GoodsReqDto();
        goodsReqDto.setGoodsno("abc01");
        goodsReqDto.setGoodsname("珍视明滴眼液");
        goodsReqDto.setGoodsmanuno("cj001");
        List<GoodscolorKey> goodscolorKeys = new ArrayList<>();
        GoodscolorKey goodscolorKey = new GoodscolorKey();
        goodscolorKey.setColorid("1");
        goodscolorKeys.add(goodscolorKey);
        goodscolorKey = new GoodscolorKey();
        goodscolorKey.setColorid("2");
        goodscolorKeys.add(goodscolorKey);
        List<Goodsscale> goodsscales = new ArrayList<>();
        Goodsscale goodsscale = new Goodsscale();
        goodsscale.setUnitprice(new BigDecimal(20.3));
        goodsscale.setThickness(new BigDecimal(22));
        goodsscale.setWholesaleprice(new BigDecimal(28));
        goodsscales.add(goodsscale);
        goodsReqDto.setGoodscolorKeys(goodscolorKeys);
        goodsReqDto.setGoodsscales(goodsscales);
        logger.info("货品信息"+JSONObject.toJSONString(goodsReqDto));*/
        List<String> list = new ArrayList<>();
        list.add("沉默王二");
        list.add("一个文章真特么有趣的程序员");

        for (String str : list) {
            if (str.equals("沉默王二")) {
                list.remove(str);
            }
        }




        System.out.println(list);

    }
}
