package com.xjt.entity;

/**
 * @ClassNameSelectListPojo
 * @Description 下拉列表选择项  只包括id name
 * @Author
 * @Date2019/12/2 17:01
 * @Version V1.0
 **/
public class SelectListPojo {

    private String label;

    private String value;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
