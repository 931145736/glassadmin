package com.xjt.dto;

import java.util.Date;
import java.util.List;

/**
 * 装箱单
 * 
 * @author wcyong
 * 
 * @date 2019-11-07
 */
public class BoxbillReqDto extends BaseReqDto  {
    /**
     * 箱号  装箱单
     */
    private String boxno;

    /**
     * 单据类型
     */
    private String accbilltype;

    /**
     * 单据编号
     */
    private String accbillno;
    /**
     * 日期
     */
    private Date inputDate;

    private List<BoxdetailReqDto> boxdetails;

    public String getBoxno() {
        return boxno;
    }

    public void setBoxno(String boxno) {
        this.boxno = boxno;
    }

    public String getAccbilltype() {
        return accbilltype;
    }

    public void setAccbilltype(String accbilltype) {
        this.accbilltype = accbilltype;
    }

    public String getAccbillno() {
        return accbillno;
    }

    public void setAccbillno(String accbillno) {
        this.accbillno = accbillno;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public List<BoxdetailReqDto> getBoxdetails() {
        return boxdetails;
    }

    public void setBoxdetails(List<BoxdetailReqDto> boxdetails) {
        this.boxdetails = boxdetails;
    }
}