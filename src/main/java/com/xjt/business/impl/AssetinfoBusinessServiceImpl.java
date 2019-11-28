package com.xjt.business.impl;

import com.xjt.business.AssetinfoBusinessService;
import com.xjt.dao.master.AssetinfoDao;
import com.xjt.dto.AssetinfoReqDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassNameAssetinfoBusinessServiceImpl
 * @Description
 * @Author
 * @Date2019/11/15 16:38
 * @Version V1.0
 **/
@Service
public class AssetinfoBusinessServiceImpl implements AssetinfoBusinessService {

    private Logger logger = LoggerFactory.getLogger(AssetinfoBusinessServiceImpl.class);

    @Resource
    private AssetinfoDao assetinfoDao;
    
    /**
    *@Description 批量添加物资库存信息 
    * * @param reqDtos
    *@Return void
    *@Author Administrator
    *@Date 2019/11/15
    *@Time 
    */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insetrAssetinfoBatch(List<AssetinfoReqDto> reqDtos) {
        int num = assetinfoDao.insertAssetinfoBatch(reqDtos);
        if(num != reqDtos.size()){
            throw new RuntimeException("批量添加库存物资异常");
        }
        logger.info("批量添加物资成功");
        
    }
}
