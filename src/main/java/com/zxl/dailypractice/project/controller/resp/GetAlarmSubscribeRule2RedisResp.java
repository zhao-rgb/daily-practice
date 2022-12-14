package com.zxl.dailypractice.project.controller.resp;

import com.alibaba.fastjson.JSONArray;

import java.util.List;
import java.util.Map;

/**
 * @author: zhaoxl
 * @date: 2022/12/13
 * @desc:
 **/
public class GetAlarmSubscribeRule2RedisResp {
    private String ruleId;
    private String ruleName;
    private String ruleDesc;
    private Integer ruleStatus;
    private String ruleType;
    private String ruleTypeDesc;
    private String activeTemplId;
    private String clearTemplId;
    private String modTemplId;
    private List<Map<String,Object>> filterList;
    private Map<String,Object> subParas;
    private String filterType;
    private String filterExpr;
    private String alarmType;
    private JSONArray activeTemplateDetail;
    private JSONArray clearTemplateDetail;

    public String getModTemplId() {
        return modTemplId;
    }

    public void setModTemplId(String modTemplId) {
        this.modTemplId = modTemplId;
    }

    public List<Map<String, Object>> getFilterList() {
        return filterList;
    }

    public void setFilterList(List<Map<String, Object>> filterList) {
        this.filterList = filterList;
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

    public String getRuleTypeDesc() {
        return ruleTypeDesc;
    }

    public void setRuleTypeDesc(String ruleTypeDesc) {
        this.ruleTypeDesc = ruleTypeDesc;
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

    public Map<String, Object> getSubParas() {
        return subParas;
    }

    public void setSubParas(Map<String, Object> subParas) {
        this.subParas = subParas;
    }

    public String getFilterType() {
        return filterType;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    public String getFilterExpr() {
        return filterExpr;
    }

    public void setFilterExpr(String filterExpr) {
        this.filterExpr = filterExpr;
    }

    public String getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(String alarmType) {
        this.alarmType = alarmType;
    }

    public JSONArray getActiveTemplateDetail() {
        return activeTemplateDetail;
    }

    public void setActiveTemplateDetail(JSONArray activeTemplateDetail) {
        this.activeTemplateDetail = activeTemplateDetail;
    }

    public JSONArray getClearTemplateDetail() {
        return clearTemplateDetail;
    }

    public void setClearTemplateDetail(JSONArray clearTemplateDetail) {
        this.clearTemplateDetail = clearTemplateDetail;
    }
}
