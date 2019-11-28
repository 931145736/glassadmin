package com.xjt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xjt.business.ArrivalBusinessService;
import com.xjt.dao.master.ArrivalDao;
import com.xjt.dto.ArrivalReqDto;
import com.xjt.dto.ArrivaldetailReqDto;
import com.xjt.dto.ArrivalgoodsReqDto;
import com.xjt.dto.BaseResDto;
import com.xjt.entity.Arrival;
import com.xjt.entity.Arrivaldetail;
import com.xjt.entity.Arrivalgoods;
import com.xjt.entity.OrderEntity;
import com.xjt.enums.ResultCode;
import com.xjt.service.ArrivalService;
import com.xjt.utils.DateUtil;
import com.xjt.utils.STRUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassNameArrivalServiceImpl
 * @Description
 * @Author
 * @Date2019/11/7 10:59
 * @Version V1.0
 **/
@Service
public class ArrivalServiceImpl implements ArrivalService {

    private Logger logger = LoggerFactory.getLogger(ArrivalServiceImpl.class);

    @Resource
    private ArrivalBusinessService businessService;
    @Resource
    private ArrivalDao arrivalDao;

    /***
    *@Description 添加到货通知单 货品  货品明细
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/7
    *@Time
    */
    @Override
    public BaseResDto insertArrivalOrder(ArrivalReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        if(!checkParams(reqDto,baseResDto)){
            return baseResDto;
        }
        try{
            Arrival arrival = new Arrival();
            List<Arrivalgoods> arrivalgoods = new ArrayList<>();
            List<Arrivaldetail> arrivaldetails = new ArrayList<>();
            //到货通知单主体
            BeanUtils.copyProperties(reqDto,arrival);
            String arrivalId = STRUtils.createUUID();
            arrival.setArrivalid(arrivalId);
            arrival.setInputDate(DateUtil.getDate(reqDto.getInputDateStr(),"yyyy-MM-dd"));
            arrival.setPosted(0);
            arrival.setFlag(0);
            //货品信息
            List<ArrivalgoodsReqDto> arrivalgoodsReqDtos = reqDto.getArrivalgoodsList();
            for(ArrivalgoodsReqDto goods:arrivalgoodsReqDtos){
                Arrivalgoods arrivalgoods1 = new Arrivalgoods();
                BeanUtils.copyProperties(goods,arrivalgoods1);
                arrivalgoods1.setManudate(DateUtil.getDate(goods.getManudateStr(),"yyyy-MM-dd"));//生产日期
                if(!STRUtils.isEmpty(goods.getSterilizedateStr())){
                    arrivalgoods1.setSterilizedate(DateUtil.getDate(goods.getSterilizedateStr(),"yyyy-MM-dd"));//灭菌日期
                }
                arrivalgoods1.setArrivalid(arrivalId);
                String arrivalGoodsId = STRUtils.createUUID();
                arrivalgoods1.setArrivalgoodsid(arrivalGoodsId);
                arrivalgoods.add(arrivalgoods1);
                //货品对应的明细信息
                List<ArrivaldetailReqDto> arrivaldetailReqDtos = goods.getArrivaldetailReqDtoList();
                for(ArrivaldetailReqDto detail:arrivaldetailReqDtos){
                    Arrivaldetail arrivaldetail = new Arrivaldetail();
                    BeanUtils.copyProperties(detail,arrivaldetail);
                    arrivaldetail.setArrivalgoodsid(arrivalGoodsId);
                   arrivaldetails.add(arrivaldetail);
                }
            }

            businessService.insertArrivalOrder(arrival,arrivalgoods,arrivaldetails);
        }catch (Exception e){
            baseResDto.setResultMessage("添加到货通知单异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("添加到货通知单异常",e);
        }
        return baseResDto;
    }

    @Override
    public BaseResDto checkArrivalOrder(ArrivalReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        if(STRUtils.isEmpty(reqDto.getArrivalid())){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("通知单id不能为空");
            return baseResDto;
        }
        try{
            reqDto.setPosteddate(new Date());//审核日期
            int num =  arrivalDao.checkArrivalOrder(reqDto);
            if(num !=1){
                baseResDto.setResultMessage("审核通知单异常");
                baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
                return baseResDto;
            }




        }catch (Exception e){
            baseResDto.setResultMessage("审核到货通知单异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("审核到货通知单异常",e);
        }
        return baseResDto;
    }

    /***
    *@Description 查看到货通知单列表
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/12
    *@Time
    */
    @Override
    public BaseResDto queryArrivalOrderList(OrderEntity reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        Integer pageNo = reqDto.getPageNo();
        if(pageNo==null){
            baseResDto.setResultMessage("pageNo is null");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        Integer pageSize = 20;
        try{

            PageHelper.startPage(pageNo,pageSize);
            if(STRUtils.isEmpty(reqDto.getStartTime())||reqDto.getStartTime().equals("0-0-0 0:0:0")||reqDto.getStartTime().equals("0")){
                reqDto.setStartTime(null);
            }
            if(STRUtils.isEmpty(reqDto.getStartTime())||reqDto.getEndTime().equals("0-0-0 0:0:0")||reqDto.getEndTime().equals("0")){
                reqDto.setEndTime(null);
            }
            List<OrderEntity> arrivals = arrivalDao.queryArrivalOrderList(reqDto);
            if(arrivals==null||arrivals.size()==0){
                baseResDto.setResultMessage("no data");
                baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
                return baseResDto;
            }
            PageInfo<OrderEntity> pageInfo = new PageInfo<>(arrivals);
            baseResDto.setData(pageInfo);



        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("查看到货通知单列表异常");
            logger.error("查看到货通知单列表异常",e);
        }
        return baseResDto;
    }

    /***
    *@Description 查看到货通知单详情
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/12
    *@Time
    */
    @Override
    public BaseResDto queryArrivalOrderDetail(ArrivalReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        if(STRUtils.isEmpty(reqDto.getArrivalid())){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("arrivalid is null");
            return baseResDto;
        }
        try{
            List<OrderEntity> arrival = arrivalDao.selectByPrimaryKey(reqDto.getArrivalid());
            baseResDto.setData(arrival);

        }catch (Exception e){
            baseResDto.setResultMessage("查看到货通知单详情异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("查看到货通知单详情异常",e);
        }
        return baseResDto;
    }

    /***
    *@Description 添加参数验证
    * * @param reqDto
 * @param resDto
    *@Return boolean
    *@Author Administrator
    *@Date 2019/11/7
    *@Time
    */
    private boolean checkParams(ArrivalReqDto reqDto,BaseResDto resDto){
        boolean flag = true;
        if(reqDto.getArrivalgoodsList()==null||reqDto.getArrivalgoodsList().size()==0){
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            resDto.setResultMessage("货品不能为空");
            flag = false;
        }


        return flag;
    }
}
