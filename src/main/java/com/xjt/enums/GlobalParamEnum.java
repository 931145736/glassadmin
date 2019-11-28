package com.xjt.enums;



public enum GlobalParamEnum {

    WAREHOUSE_ACCEPTANCE_PROCESS_ONE(1),//采购-通知-到货
    WAREHOUSE_ACCEPTANCE_PROCESS_TWO(2);//采购——到货


     GlobalParamEnum(Integer value){
        this.value = value;
    }
    private Integer value;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
