package com.xjt.business;

import com.xjt.entity.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface GoodsBusinessService {

    void insertGoods(Goods goods, List<Goodspicturemgt> goodspicturemgts,List<GoodscolorKey> goodscolorKeys, List<Goodsscale> goodsscales);
}
