package com.xjt.business.impl;

import com.xjt.business.GoodsBusinessService;
import com.xjt.dao.master.*;
import com.xjt.entity.*;
import com.xjt.utils.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoodsBusinessServiceImpl implements GoodsBusinessService {


    @Resource
    private GoodsDao goodsDao;
    @Resource
    private GoodspicturemgtDao dao;

    @Resource
    private GoodscolorDao goodscolorDao;
    @Resource
    private GoodsscaleDao goodsscaleDao;



    /**
     * 增加货品信息
     * @param goods
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertGoods(Goods goods, List<Goodspicturemgt> goodspicturemgts,List<GoodscolorKey> goodscolorKeys, List<Goodsscale> goodsscales  ) {
        String goodsId = goods.getGoodsid();
        //增加货品主表
        int num = goodsDao.insert(goods);
        if(num !=1){
            throw new RuntimeException("增加货品信息异常");
        }
        //增加货品文件信息
        if(goodspicturemgts!=null&&goodspicturemgts.size()>0){
            int num2 = dao.insertGoodsPics(goodspicturemgts);
            if(num2 != goodspicturemgts.size()){
                List<String> paths = goodspicturemgts.stream().map(Goodspicturemgt::getFilepath).collect(Collectors.toList());
                for(String path:paths){
                    FileUtil.deleteFile(path);
                }
                throw new RuntimeException("批量添加货品文件信息异常");
            }
        }
        //增加货品颜色
        if(goodscolorKeys!=null&&goodscolorKeys.size()>0){
            int num3 = goodscolorDao.insertGoodsColorBatch(goodscolorKeys);
            if(num3 != goodscolorKeys.size()){
                throw new RuntimeException("批量添加货品颜色异常");
            }
        }
        //添加货品详细信息
        if(goodsscales!=null&&goodsscales.size()>0){
            int num4 = goodsscaleDao.insertGoodDetail(goodsscales);
            if(num4 != goodsscales.size()){
                throw new RuntimeException("批量添加货品价格信息异常");
            }
        }






    }
}
