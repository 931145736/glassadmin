package com.xjt.service.impl;

import com.xjt.dao.master.UimoduleDao;
import com.xjt.dto.BaseResDto;
import com.xjt.dto.UimoduleReqDto;
import com.xjt.entity.Uimodule;
import com.xjt.enums.ResultCode;
import com.xjt.service.UimoduleService;
import com.xjt.utils.STRUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassNameUimoduleServiceImpl
 * @Description
 * @Author
 * @Date2019/11/8 16:18
 * @Version V1.0
 **/
@Service
public class UimoduleServiceImpl implements UimoduleService {

    private Logger logger = LoggerFactory.getLogger(UimoduleServiceImpl.class);
    @Resource
    private UimoduleDao uimoduleDao;

    /***
    *@Description 添加菜单
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/8
    *@Time
    */
    @Override
    public BaseResDto insertUimodule(UimoduleReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();

        try{




        }catch (Exception e){
            baseResDto.setResultMessage("添加菜单异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("添加菜单异常",e);

        }
        return baseResDto;
    }

    /***
    *@Description 查看一级菜单列表
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/8
    *@Time
    */
    @Override
    public BaseResDto queryOneMenu(UimoduleReqDto reqDto) {
        BaseResDto resDto = new BaseResDto();
      /*  List<String> ids = reqDto.getIds();
        if(ids==null||ids.size()==0){
            resDto.setResultMessage("没有权限查看");
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return resDto;
        }*/
        try{
            List<Uimodule> uimodules = uimoduleDao.queryOneList(reqDto);
            List<String> parentIds = uimodules.stream().map(Uimodule::getId).collect(Collectors.toList());
            reqDto.setParentIds(parentIds);
            List<Uimodule> childrenModules = uimoduleDao.queryChildrenList(reqDto);
            Map<String,List<Uimodule>> map = childrenModules.stream().collect(Collectors.groupingBy(Uimodule::getParentid));
            Integer pIndex = 1;

            for(Uimodule e:uimodules){
                e.setIndex(String.valueOf(pIndex));
                List<Uimodule> children = map.get(e.getId());
                if(children!=null&&children.size()>0){
                    Integer index = 1;
                    for(Uimodule c:children){
                        c.setIndex(String.valueOf(pIndex)+"-"+String.valueOf(index));
                        index ++;
                    }
                }
                e.setChildrdenModules(children);
                pIndex++;
            }

            resDto.setData(uimodules);
        }catch (Exception e){
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            resDto.setResultMessage("查看一级菜单列表异常");
            logger.error("查看一级菜单列表异常",e);
        }
        return resDto;
    }

    /***
    *@Description 查看子集菜单列表
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/8
    *@Time
    */
    @Override
    public BaseResDto queryChildrenMenu(UimoduleReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        if(STRUtils.isEmpty(reqDto.getParentid())){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("parentid is null");
            return baseResDto;
        }
        List<String> ids = reqDto.getIds();
        if(ids==null||ids.size()==0){
            baseResDto.setResultMessage("没有权限查看");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        try{
            List<Uimodule> uimodules = uimoduleDao.queryChildrenList(reqDto);
            if(uimodules==null||uimodules.size()==0){
                baseResDto.setResultCode(ResultCode.RESULT_CODE_NODATA.getCode());
                baseResDto.setResultMessage("暂无权限 请联系管理员");
                return baseResDto;
            }
            baseResDto.setData(uimodules);

        }catch (Exception e){
            baseResDto.setResultMessage("查看菜单子集异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("查看菜单子集异常",e);
        }

        return baseResDto;
    }
}
