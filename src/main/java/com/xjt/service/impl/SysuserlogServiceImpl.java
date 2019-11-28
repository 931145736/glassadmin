package com.xjt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xjt.dao.master.SysuserlogDao;
import com.xjt.dto.BaseResDto;
import com.xjt.dto.SysuserlogReqDto;
import com.xjt.entity.Sysuserlog;
import com.xjt.enums.ResultCode;
import com.xjt.exception.MyException;
import com.xjt.service.SysuserlogService;
import com.xjt.utils.STRUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassNameSysuserlogServiceImpl
 * @Description
 * @Author
 * @Date2019/11/21 10:03
 * @Version V1.0
 **/
@Service
public class SysuserlogServiceImpl implements SysuserlogService {

    private Logger logger = LoggerFactory.getLogger(SysuserlogServiceImpl.class);
    @Resource
    private SysuserlogDao sysuserlogDao;

    /***
    *@Description 查看日志列表
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/21
    *@Time
    */
    @Override
    public BaseResDto queryUserLogList(SysuserlogReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        Integer pageNo = reqDto.getPageNo();
        Integer pageSize = 20;
        if(pageNo==null){
            baseResDto.setResultMessage("pageNo is null");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        try{
            if(STRUtils.isEmpty(reqDto.getStartTime())||reqDto.getStartTime().equals("0-0-0 0:0:0")||reqDto.getStartTime().equals("0")){
                reqDto.setStartTime(null);
            }
            if(STRUtils.isEmpty(reqDto.getStartTime())||reqDto.getEndTime().equals("0-0-0 0:0:0")||reqDto.getEndTime().equals("0")){
                reqDto.setEndTime(null);
            }
            PageHelper.startPage(pageNo,pageSize);
            List<Sysuserlog> sysuserlogs = sysuserlogDao.queryUserLogList(reqDto);
            PageInfo<Sysuserlog> pageInfo = new PageInfo<>(sysuserlogs);
            baseResDto.setData(pageInfo);
            }catch (Exception e){
            baseResDto.setResultMessage("查看日志列表异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("查看日志列表异常",e);
        }
        return baseResDto;
    }

    /**
    *@Description  删除用户日志
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/21
    *@Time 
    */
    @Override
    public BaseResDto deleteUserLog(SysuserlogReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        Integer logId = reqDto.getLogId();
        if(logId==null){
           // throw MyException.le(2001,"参数缺失");
            baseResDto.setResultMessage("logId is null");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        try{

            int num = sysuserlogDao.deleteSysUserLog(logId);

            if(num !=1){
                throw MyException.le(1001,"删除日志异常");
            }
        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("删除用户操作日志异常");
            logger.error("删除用户操作日志异常",e);

        }

        return baseResDto;
    }
}
