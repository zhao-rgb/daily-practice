package com.zxl.dailypractice.project.controller.req;

public class CreateAlarmAttrReq {
    //键
    private String attributeCode;
    //值
    private String attributeValue;

    public String getAttributeCode() {
        return attributeCode;
    }

    public void setAttributeCode(String attributeCode) {
        this.attributeCode = attributeCode;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }
}
