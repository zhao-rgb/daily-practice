package com.zxl.dailypractice.project.controller.req;

import java.util.List;

/**
 * @author: zhaoxl
 * @date: 2022/12/13
 * @desc:
 **/
public class UpdateAlarmSubscribeRuleReq {
    private String operType;
    private String ruleId;
    private String ruleName;
    private String ruleDesc;
    private Integer ruleStatus;
    private String ruleType;
    private String activeTemplId;
    private String clearTemplId;
    private String modTemplId;
    private List<UpdateAlarmSubscribeRuleFilterReq> filterList;

    public String getModTemplId() {
        return modTemplId;
    }

    public void setModTemplId(String modTemplId) {
        this.modTemplId = modTemplId;
    }

    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
        this.operType = operType;
    }

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleDesc() {
        return ruleDesc;
    }

    public void setRuleDesc(String ruleDesc) {
        this.ruleDesc = ruleDesc;
    }

    public Integer getRuleStatus() {
        return ruleStatus;
    }

    public void setRuleStatus(Integer ruleStatus) {
        this.ruleStatus = ruleStatus;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public String getActiveTemplId() {
        return activeTemplId;
    }

    public void setActiveTemplId(String activeTemplId) {
        this.activeTemplId = activeTemplId;
    }

    public String getClearTemplId() {
        return clearTemplId;
    }

    public void setClearTemplId(String clearTemplId) {
        this.clearTemplId = clearTemplId;
    }



    public List<UpdateAlarmSubscribeRuleFilterReq> getFilterList() {
        return filterList;
    }

    public void setFilterList(List<UpdateAlarmSubscribeRuleFilterReq> filterList) {
        this.filterList = filterList;
    }
}
