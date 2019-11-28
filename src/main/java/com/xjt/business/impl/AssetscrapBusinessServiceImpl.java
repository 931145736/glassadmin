package com.xjt.business.impl;

import com.xjt.business.AssetscrapBusinessService;
import com.xjt.dao.master.AssetinfoDao;
import com.xjt.dao.master.AssetscrapDao;
import com.xjt.entity.Assetinfo;
import com.xjt.entity.Assetscrap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassNameAssetscrapBusinessServiceImpl
 * @Description
 * @Author
 * @Date2019/11/18 17:11
 * @Version V1.0
 **/
@Service
public class AssetscrapBusinessServiceImpl implements AssetscrapBusinessService {

    private Logger logger = LoggerFactory.getLogger(AssetscrapBusinessServiceImpl.class);

    @Resource
    private AssetscrapDao assetscrapDao;
    @Resource
    private AssetinfoDao assetinfoDao;


    /**
    *@Description 审核报废物资
    * * @param assetscrap
    *@Return void
    *@Author Administrator
    *@Date 2019/11/18
    *@Time
    */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void checkAssetscrap(Assetscrap assetscrap) {
        int num1 = assetscrapDao.updateByPrimaryKeySelective(assetscrap);
        if(num1 !=1){
            throw new RuntimeException("审核报废物资异常");
        }
        if(assetscrap.getScrapType()==1){
            //如果是仓库报废，减去对应库存
            List<Assetinfo> assetinfos = new ArrayList<>();
            assetinfos.add(new Assetinfo(assetscrap.getScrapAsset(),assetscrap.getScrapCount()));
            int num2 =assetinfoDao.updateAssetCount(assetinfos);
            if(num2 != assetinfos.size()){
                throw new RuntimeException("更新对应库存异常");
            }

        }

    }
}
