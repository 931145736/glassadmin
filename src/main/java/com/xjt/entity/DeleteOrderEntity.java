package com.xjt.entity;

/**
 * @ClassNameDeleteOrderEntity
 * @Description
 * @Author
 * @Date2019/11/13 11:38
 * @Version V1.0
 **/
public class DeleteOrderEntity {

    private String orderId;
    private String orderMaster;
    private String orderGoods;
    private String orderDetail;
    private String columnMaster;
    private String columnGoods;
    private Integer resultValue;

    private Integer requestType;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderMaster() {
        return orderMaster;
    }

    public void setOrderMaster(String orderMaster) {
        this.orderMaster = orderMaster;
    }

    public String getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(String orderGoods) {
        this.orderGoods = orderGoods;
    }

    public String getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(String orderDetail) {
        this.orderDetail = orderDetail;
    }

    public String getColumnMaster() {
        return columnMaster;
    }

    public void setColumnMaster(String columnMaster) {
        this.columnMaster = columnMaster;
    }

    public String getColumnGoods() {
        return columnGoods;
    }

    public void setColumnGoods(String columnGoods) {
        this.columnGoods = columnGoods;
    }

    public Integer getResultValue() {
        return resultValue;
    }

    public void setResultValue(Integer resultValue) {
        this.resultValue = resultValue;
    }

    public Integer getRequestType() {
        return requestType;
    }

    public void setRequestType(Integer requestType) {
        this.requestType = requestType;
    }
}
