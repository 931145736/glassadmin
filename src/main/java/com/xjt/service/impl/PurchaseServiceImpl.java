package com.xjt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xjt.business.PurchaseBusinessService;
import com.xjt.dao.master.PurchaseDao;
import com.xjt.dto.BaseResDto;
import com.xjt.dto.PurchaseReqDto;
import com.xjt.dto.PurchasedetailReqDto;
import com.xjt.dto.PurchasegoodsReqDto;
import com.xjt.entity.OrderEntity;
import com.xjt.entity.Purchase;
import com.xjt.entity.Purchasedetail;
import com.xjt.entity.Purchasegoods;
import com.xjt.enums.ResultCode;
import com.xjt.service.PurchaseService;
import com.xjt.utils.DateUtil;
import com.xjt.utils.STRUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassNamePurchaseServiceImpl
 * @Description
 * @Author
 * @Date2019/11/7 9:15
 * @Version V1.0
 **/
@Service
public class PurchaseServiceImpl implements PurchaseService {

    private Logger logger = LoggerFactory.getLogger(PurchaseServiceImpl.class);
    @Resource
    private PurchaseBusinessService businessService;
    @Resource
    private PurchaseDao purchaseDao;


    /***
    *@Description 添加采购单 采购单主表 采购的货品表 货品的明细表
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/7
    *@Time
    */
    @Override
    public BaseResDto addPurchaseOrder(PurchaseReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        if(!checkParams(reqDto,baseResDto)){
            return baseResDto;
        }
        try{
            Purchase purchase = new Purchase();
            List<Purchasegoods> purchasegoodsList = new ArrayList<>();
            List<Purchasedetail> purchasedetails = new ArrayList<>();
            //采购单主体信息
            BeanUtils.copyProperties(reqDto,purchase);
            String purchaseId = STRUtils.createUUID();
            Date nowDate = new Date();
            purchase.setPurchaseId(purchaseId);
            purchase.setInputDate(nowDate);
            purchase.setPosted(0);//默认未审核
            purchase.setJizhang(0);//默认未记账
            purchase.setPurchDate(DateUtil.getDate(reqDto.getPurchDateStr(),"yyyy-MM-dd"));
            //采购单对应的货品信息
            List<PurchasegoodsReqDto> purchasegoods = reqDto.getPurchasegoodsList();
            for(PurchasegoodsReqDto reqDto1:purchasegoods){
                Purchasegoods goods = new Purchasegoods();
                Date deliverDate = DateUtil.getDate(reqDto1.getDeliverDateStr(),"yyyy-MM-dd");
                BeanUtils.copyProperties(reqDto1,goods);
                String goodsId = STRUtils.createUUID();
                goods.setPurchaseId(purchaseId);
                goods.setPurchasegoodsid(goodsId);
                goods.setDeliverDate(deliverDate);
                purchasegoodsList.add(goods);
                //货品对应的明细信息
                List<PurchasedetailReqDto> purchasedetailReqDtos = reqDto1.getPurchasedetailList();
                if(purchasedetailReqDtos!=null&&purchasedetailReqDtos.size()>0){
                    for(PurchasedetailReqDto detailDto:purchasedetailReqDtos){
                        Purchasedetail purchasedetail = new Purchasedetail();
                        BeanUtils.copyProperties(detailDto,purchasedetail);
                        purchasedetail.setPurchasegoodsid(goodsId);
                        purchasedetails.add(purchasedetail);
                    }
                }
            }


            businessService.addPurchaseOrder(purchase,purchasegoodsList,purchasedetails);
        }catch (Exception e){
            baseResDto.setResultMessage("添加采购单异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("添加采购单异常",e);
        }
        return baseResDto;
    }

    /***
    *@Description 审核采购订单  posted 0 未审核 1 审核
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/7
    *@Time
    */
    @Override
    public BaseResDto checkPurchaseOrder(PurchaseReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        if(STRUtils.isEmpty(reqDto.getPurchaseId())){
            baseResDto.setResultMessage("订单号为空");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        try{
            reqDto.setPosteddate(new Date());//审核日期
            int num = purchaseDao.checkPurchaseOrder(reqDto);
            if(num !=1){
                baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
                baseResDto.setResultMessage("审核异常");
                return baseResDto;
            }

        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("审核采购订单异常");
            logger.error("审核采购订单异常",e);
        }
        return baseResDto;
    }

    /***
    *@Description 获取采购订单列表
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/12
    *@Time
    */
    @Override
    public BaseResDto PurchaseOrderLisy(OrderEntity reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        Integer pageNo = reqDto.getPageNo();
        Integer pageSize = reqDto.getPageSize();
        if(pageNo==null||pageSize==null){
            baseResDto.setResultMessage("pageNo or pageSize is null");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        try{
            PageHelper.startPage(pageNo,pageSize);
            if(STRUtils.isEmpty(reqDto.getStartTime())||reqDto.getStartTime().equals("0-0-0 0:0:0")||reqDto.getStartTime().equals("0")){
                reqDto.setStartTime(null);
            }
            if(STRUtils.isEmpty(reqDto.getStartTime())||reqDto.getEndTime().equals("0-0-0 0:0:0")||reqDto.getEndTime().equals("0")){
                reqDto.setEndTime(null);
            }
            List<OrderEntity> purchases = purchaseDao.queryPurchaseList(reqDto);
            if(purchases==null||purchases.size()==0){
                baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
                baseResDto.setResultMessage("no data");
                return baseResDto;
            }else{
                PageInfo<OrderEntity> pageInfo = new PageInfo<>(purchases);
                baseResDto.setData(pageInfo);
            }
        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("获取采购订单列表异常");
            logger.error("获取采购订单列表异常",e);
        }
        return baseResDto;
    }

    /***
    *@Description 查看采购订单详情
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/12
    *@Time
    */
    @Override
    public BaseResDto queryOrderDetail(PurchaseReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        if(STRUtils.isEmpty(reqDto.getPurchaseId())){
            baseResDto.setResultMessage("purchaseId is null");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        try{
            List<OrderEntity> purchase = purchaseDao.selectByPrimaryKey(reqDto.getPurchaseId());
            baseResDto.setData(purchase);

        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("查看订单详情异常");
            logger.error("查看订单详情异常",e);
        }
        return baseResDto;
    }

    /***
    *@Description 删除采购订单
    * * @param purchaseId
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/13
    *@Time
    */
    @Override
    public BaseResDto deletePurchaseOrder(String purchaseId) {
        BaseResDto baseResDto = new BaseResDto();
        if(STRUtils.isEmpty(purchaseId)){
            baseResDto.setResultMessage("purchaseId is null");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        try{
            businessService.deletePurchaseOrder(purchaseId);

        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("删除采购订单异常");
            logger.error("删除采购订单异常",e);
        }
        return baseResDto;
    }

    /***
    *@Description 采购单参数验证
    * * @param reqDto
 * @param resDto
    *@Return boolean
    *@Author Administrator
    *@Date 2019/11/7
    *@Time
    */
    private boolean checkParams(PurchaseReqDto reqDto,BaseResDto resDto){
        boolean flag = true;
        if(STRUtils.isEmpty(reqDto.getSupplyNo())){
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            resDto.setResultMessage("供应商编号不能为空");
            flag = false;
        }
        if(reqDto.getPurchasegoodsList()==null||reqDto.getPurchasegoodsList().size()==0){
            resDto.setResultMessage("货品不能为空");
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            flag = false;
        }



        return flag;
    }
}
