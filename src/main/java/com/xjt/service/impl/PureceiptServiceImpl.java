package com.xjt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.regexp.internal.RE;
import com.xjt.business.PureceiptBusinessService;
import com.xjt.dao.master.PureceiptDao;
import com.xjt.dao.master.PureceiptdetailDao;
import com.xjt.dto.BaseResDto;
import com.xjt.dto.PureceiptReqDto;
import com.xjt.dto.PureceiptdetailReqDto;
import com.xjt.dto.PureceiptgoodsReqDto;
import com.xjt.entity.*;
import com.xjt.enums.GlobalParamEnum;
import com.xjt.enums.ResultCode;
import com.xjt.service.PureceiptService;
import com.xjt.utils.DateUtil;
import com.xjt.utils.PrimaryKeyWorker;
import com.xjt.utils.STRUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.connection.SortParameters;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassNamePureceiptServiceImpl
 * @Description
 * @Author
 * @Date2019/11/7 15:02
 * @Version V1.0
 **/
@Service
public class PureceiptServiceImpl implements PureceiptService {

    private Logger logger = LoggerFactory.getLogger(PureceiptServiceImpl.class);

    @Resource
    private PureceiptBusinessService businessService;
    @Resource
    private PureceiptdetailDao pureceiptdetailDao;
    @Resource
    private PrimaryKeyWorker keyWorker;
    @Resource
    private PureceiptDao pureceiptDao;


    /**
    *@Description 添加仓库验收单
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/7
    *@Time
    */
    @Override
    public BaseResDto insertPureceiptOrder(PureceiptReqDto reqDto,HttpSession session) {
        BaseResDto baseResDto = new BaseResDto();
        if(!checkParam(reqDto,baseResDto,session)){
            return baseResDto;
        }
        try{
            Pureceipt pureceipt = new Pureceipt();
            List<Pureceiptgoods> pureceiptgoods = new ArrayList<>();
            List<Pureceiptdetail> pureceiptdetails = new ArrayList<>();
            //到货单主体信息
            BeanUtils.copyProperties(reqDto,pureceipt);
            String pureceiptId = STRUtils.createUUID();
            pureceipt.setPureceiptid(pureceiptId);
            pureceipt.setInputDate(new Date());
            pureceipt.setPosted(0);
            List<PureceiptgoodsReqDto> pureceiptgoodsReqDtos = reqDto.getPureceiptgoodsList();
            for(PureceiptgoodsReqDto goods:pureceiptgoodsReqDtos){
                Pureceiptgoods pureceiptgoods1 = new Pureceiptgoods();
                BeanUtils.copyProperties(goods,pureceiptgoods1);
                pureceiptgoods1.setPureceiptid(pureceiptId);
                String goodsId = STRUtils.createUUID();
                pureceiptgoods1.setPureceiptgoodsid(goodsId);
                pureceiptgoods1.setManudate(DateUtil.getDate(goods.getManudateStr(),"yyyy-MM-dd"));//生产日期
                if(!STRUtils.isEmpty(goods.getSterilizedateStr())){
                    pureceiptgoods1.setSterilizedate(DateUtil.getDate(goods.getSterilizedateStr(),"yyyy-MM-dd"));//灭菌日期
                }
                pureceiptgoods.add(pureceiptgoods1);
                List<PureceiptdetailReqDto> pureceiptdetailReqDtos = goods.getPureceiptdetailList();
                for(PureceiptdetailReqDto detail:pureceiptdetailReqDtos){
                    Pureceiptdetail pureceiptdetail = new Pureceiptdetail();
                    BeanUtils.copyProperties(detail,pureceiptdetail);
                    pureceiptdetail.setPureceiptgoodsid(goodsId);
                    pureceiptdetails.add(pureceiptdetail);
                }

            }

            businessService.insertPureceiptOrder(pureceipt,pureceiptgoods,pureceiptdetails);

        }catch (Exception e){
            baseResDto.setResultMessage("添加仓库验收单异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("添加仓库验收单异常",e);
        }
        return baseResDto;
    }

    /***
    *@Description 审核到货单
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/11
    *@Time
    */
    @Override
    public BaseResDto checkPureceiptOrder(PureceiptReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        if(STRUtils.isEmpty(reqDto.getPureceiptid())){
            baseResDto.setResultMessage("到货单id pureceiptid is null");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        try{
            //查询到货单货品数据
            List<Pureceiptdetail> pureceiptdetails = pureceiptdetailDao.queryGoodsInfo(reqDto.getPureceiptid());
            if(pureceiptdetails==null||pureceiptdetails.size()==0){
                baseResDto.setResultMessage("系统异常");
                baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
                return baseResDto;
            }

            Map<String,List<Pureceiptdetail>> map = pureceiptdetails.stream().collect(Collectors.groupingBy(e ->e.getWarehouseNo()+":"+e.getGoodsNo()+":"+e.getBatchnumber()+":"+e.getCountQuantity()));
            List<Stockbatch> stockbatches = new ArrayList<>();
            List<Stockbatchdetail> stockbatchdetails = new ArrayList<>();
            for(Map.Entry<String,List<Pureceiptdetail>> entry:map.entrySet()){
                String key = entry.getKey();
                List<String> keys = Arrays.asList(key.split(":"));
                Stockbatch stockbatch = new Stockbatch();
                String batchId = keyWorker.getPrimaryKey("2");
                stockbatch.setStockcode(batchId);
                stockbatch.setWarehouseNo(keys.get(0));
                stockbatch.setGoodsid(keys.get(1));
                stockbatch.setBatchnumber(keys.get(2));
                stockbatch.setQuantity(Integer.parseInt(keys.get(3)));
                stockbatches.add(stockbatch);
                List<Pureceiptdetail> list = entry.getValue();
                for(Pureceiptdetail e:list){
                    Stockbatchdetail detail = new Stockbatchdetail();
                    detail.setColorid(e.getColorid());
                    detail.setAstigmia(e.getAstigmia());
                    detail.setDioptre(e.getDioptre());
                    detail.setQuantity(e.getQuantity());
                    detail.setStockcode(batchId);
                    stockbatchdetails.add(detail);
                }
            }
            Pureceipt pureceipt = new Pureceipt();
            BeanUtils.copyProperties(reqDto,pureceipt);
            pureceipt.setPosteddate(new Date());
            businessService.checkPureceiptOrder(pureceipt,stockbatches,stockbatchdetails);
        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("审核到货单异常");
            logger.error("审核到货单异常",e);
        }
        return baseResDto;
    }

    /***
    *@Description 查看到货单列表
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/12
    *@Time
    */
    @Override
    public BaseResDto queryPureceiptOrderList(OrderEntity reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        Integer pageNo = reqDto.getPageNo();
        if(pageNo==null){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("pageNo is null");
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
            List<OrderEntity> pureceiptOrders = pureceiptDao.queryPureceiptOrderList(reqDto);
            if(pureceiptOrders==null||pureceiptOrders.size()==0){
                baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
                baseResDto.setResultMessage("no data");
                return baseResDto;
            }
            PageInfo<OrderEntity> pageInfo = new PageInfo<>(pureceiptOrders);
            baseResDto.setData(pageInfo);

        }catch (Exception e){
            baseResDto.setResultMessage("查看到货单列表异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("查看到货单列表异常",e);
        }
        return baseResDto;
    }

    /***
    *@Description 查看到货单详情
    * * @param reqDto
    *@Return com.xjt.dto.BaseResDto
    *@Author Administrator
    *@Date 2019/11/12
    *@Time
    */
    @Override
    public BaseResDto queryPureceiptDetail(PureceiptReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        String orderId = reqDto.getPureceiptid();
        if(STRUtils.isEmpty(orderId)){
            baseResDto.setResultMessage("pureceiptid is null");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        try{
            List<OrderEntity> orderEntity = pureceiptDao.selectByPrimaryKey(orderId);
            baseResDto.setData(orderEntity);

        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("查看到货单详情异常");
            logger.error("查看到货单详情异常",e);
        }
        return baseResDto;
    }

    /***
    *@Description 参数校验
    * * @param reqDto
 * @param resDto
 * @param session
    *@Return boolean
    *@Author Administrator
    *@Date 2019/11/7
    *@Time
    */
    private boolean checkParam(PureceiptReqDto reqDto, BaseResDto resDto, HttpSession session){
        boolean flag = true;
        GlobalParam globalParam = (GlobalParam) session.getAttribute("globalParam");
        if(STRUtils.isEmpty(reqDto.getWarehouseNo())){
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            resDto.setResultMessage("仓库不能为空");
            flag = false;
        }
        if(reqDto.getPureceiptgoodsList()==null||reqDto.getPureceiptgoodsList().size()==0){
            resDto.setResultMessage("货品信息不能为空");
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            flag = false;
        }
        if(reqDto.getType()==null){
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            resDto.setResultMessage("单据类型不能为空");
            flag = false;
        }
        //单据类型 单据类型1 = '厂家来货' 2 = '仓库调入' 3 = '仓库收退货'
        Short type = reqDto.getType();
        if(type==2){
            if(STRUtils.isEmpty(reqDto.getFmwarehouseNo())){
                resDto.setResultMessage("调出仓库不能为空");
                resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
                flag = false;
            }
        }
        if(type==3){
            if(STRUtils.isEmpty(reqDto.getCustomerId())){
                resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
                resDto.setResultMessage("调出渠道不能为空");
                flag = false;
            }
            if(STRUtils.isEmpty(reqDto.getReturntype())){
                resDto.setResultMessage("渠道退货类型不能为空");
                resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
                flag = false;
            }
        }
        //第一个采购流程  采购单-通知单-到货单
        if(globalParam.getValue()==GlobalParamEnum.WAREHOUSE_ACCEPTANCE_PROCESS_ONE.getValue()){
            if(STRUtils.isEmpty(reqDto.getPurchaseId())){
                resDto.setResultMessage("采购单单号不能为空");
                resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
                flag = false;
            }
            if(STRUtils.isEmpty(reqDto.getArrivalid())){
                resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
                resDto.setResultMessage("通知单单号不能为空");
                flag = false;
            }
        }



        return flag;
    }
}
