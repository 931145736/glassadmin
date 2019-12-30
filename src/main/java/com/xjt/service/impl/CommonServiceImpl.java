package com.xjt.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.xjt.business.CommonBusinessService;
import com.xjt.dao.master.CommonDao;
import com.xjt.dao.other.CommonSqlDao;
import com.xjt.dto.BaseResDto;
import com.xjt.dto.CommonReqDto;
import com.xjt.entity.CommonData;
import com.xjt.entity.SelectListPojo;
import com.xjt.enums.ResultCode;
import com.xjt.service.CommonService;
import com.xjt.utils.STRUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommonServiceImpl implements CommonService {

    @Resource
    private CommonBusinessService businessService;
    @Resource
    private CommonDao commonDao;
    @Resource
    private CommonSqlDao commonSqlDao;
    @Value("${selectOptionList}")
    private String selectOptionList;
    @Value("${openOrClosedTarget}")
    private String openOrClosedTarget;
    @Value("${dictRequestList}")
    private String dictRequestList;

    private Logger logger = LoggerFactory.getLogger(CommonServiceImpl.class);

    /**
     * 批量添加数据
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto insertDatasBatch(CommonReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        String tableName = reqDto.getTableName();
        List<String> values = reqDto.getValues();
        Integer db = reqDto.getDb();
        if(STRUtils.isEmpty(tableName)||values==null||db==null){
            baseResDto.setResultMessage("参数错误");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        try{
            businessService.insertBatch(tableName,values,db);
            }catch (Exception e){
            baseResDto.setResultMessage("批量添加数据异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("批量添加数据异常",e);

        }
        return baseResDto;
    }

    /**
     * 批量删除数据
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto deleteDatasBatch(CommonReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        String tableName = reqDto.getTableName();
        List<String> values = reqDto.getValues();
        Integer db = reqDto.getDb();
        String colName = reqDto.getColName();
        if(STRUtils.isEmpty(tableName)||STRUtils.isEmpty(colName)||values==null||db==null){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("参数错误");
            return baseResDto;
        }
        try{
            businessService.deleteBatch(tableName,colName,values,db);
        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("批量删除数据异常");
            logger.error("批量删除数据异常",e);
        }
        return baseResDto;
    }

    /**
     * 查看数据
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto queryAllData(CommonReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        Integer requestType = reqDto.getRequestType();
        if(requestType==null){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("exception");
            return baseResDto;
        }
        try{
            reqDto =addParams(requestType,reqDto,dictRequestList);
            List<CommonData> commonDatas = commonDao.queryAllDatas(reqDto);

            if(commonDatas.size()==0){
                baseResDto.setResultCode(ResultCode.RESULT_CODE_NODATA.getCode());
                baseResDto.setResultMessage("no data");
                return baseResDto;
            }
            baseResDto.setData(commonDatas);
        }catch (Exception e){
            baseResDto.setResultMessage("查看数据异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("查看数据异常",e);
        }
        return baseResDto;
    }

    /**
    *@Description 查看下拉参数
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/12/2
    *@Time
    */

    @Override
    public BaseResDto SelectOptionList(CommonReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        Integer requestType = reqDto.getRequestType();
        if(requestType==null){
            baseResDto.setResultMessage("exception");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        try{
            String id = reqDto.getColId();
            reqDto = addParams(requestType,reqDto,selectOptionList);
            if(requestType==7){
                reqDto.setFilterCol("业务员");
            }
            reqDto.setObjId(id);

            List<SelectListPojo> selectListPojos = commonDao.selectOptionList(reqDto);
            logger.info("数据库对象"+JSONObject.toJSONString(selectListPojos));
            baseResDto.setData(selectListPojos);


        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("查看下拉参数异常");
            logger.error("查看下拉参数异常",e);
        }
        return baseResDto;
    }


    @Override
    public BaseResDto openOrClosedTarget(CommonReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        Integer requestType = reqDto.getRequestType();
        if(requestType==null){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("exception");
            return baseResDto;
        }
        try{
            if(reqDto.getShutout()==0){
                reqDto.setShutout(1);
            }else if(reqDto.getShutout()==1){
                reqDto.setShutout(0);
            }
            Integer shutout = reqDto.getShutout();
            String id = reqDto.getValue();
            reqDto = addParams(requestType,reqDto,openOrClosedTarget);
            reqDto.setShutout(shutout);
            reqDto.setValue(id);
            commonDao.openOrCloseTarget(reqDto);


        }catch (Exception e){
            baseResDto.setResultMessage("停启用异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("停启用异常", e);

        }
        return baseResDto;
    }


    private CommonReqDto addParams(Integer requestType,CommonReqDto reqDto, String json){
        JSONObject object = JSONObject.parseObject(json);
        reqDto = JSONObject.parseObject(JSONObject.toJSONString(object.get(requestType)),CommonReqDto.class);
        return reqDto;
    }
}
