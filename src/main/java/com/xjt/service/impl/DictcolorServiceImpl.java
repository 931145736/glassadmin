package com.xjt.service.impl;

import com.xjt.dao.master.DictcolorDao;
import com.xjt.dto.BaseResDto;
import com.xjt.entity.Dictcolor;
import com.xjt.enums.ResultCode;
import com.xjt.service.DictcolorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DictcolorServiceImpl implements DictcolorService {

    @Resource
    private DictcolorDao dictcolorDao;

    private Logger logger = LoggerFactory.getLogger(DictcolorServiceImpl.class);

    /**
     * 查看颜色列表
     * @return
     */
    @Override
    public BaseResDto queryColorList() {
        BaseResDto baseResDto = new BaseResDto();
        try{
            List<Dictcolor> dictcolors = dictcolorDao.queryColorList();
            if(dictcolors==null||dictcolors.size()==0){
                baseResDto.setResultMessage("no data");
                baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
                return baseResDto;
            }
            baseResDto.setData(dictcolors);

        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("查看颜色列表异常");
            logger.error("查看颜色列表异常",e);

        }
        return baseResDto;
    }
}
