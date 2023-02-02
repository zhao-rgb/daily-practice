package com.zxl.dailypractice.card.three.february.february1;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author: zhaoxl
 * @date: 2022/11/3
 * @desc:
 **/
public class IcutWSReq implements Serializable {
    private static final long serialVersionUID = 6772220160528191342L;
    private String orderId;
    private String city;
    private String classify;
    private String neName;
    private List<CoverList> coverList;
    private Date startTime;
    private Date endTime;
    private String opDetails;
    private String cutType;
    private String opType;
    private String opTitle;

    private String taskid;
    private String description;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getNeName() {
        return neName;
    }

    public void setNeName(String neName) {
        this.neName = neName;
    }

    public List<CoverList> getCoverList() {
        return coverList;
    }

    public void setCoverList(List<CoverList> coverList) {
        this.coverList = coverList;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getOpDetails() {
        return opDetails;
    }

    public void setOpDetails(String opDetails) {
        this.opDetails = opDetails;
    }

    public String getCutType() {
        return cutType;
    }

    public void setCutType(String cutType) {
        this.cutType = cutType;
    }

    public String getOpType() {
        return opType;
    }

    public void setOpType(String opType) {
        this.opType = opType;
    }

    public String getOpTitle() {
        return opTitle;
    }

    public void setOpTitle(String opTitle) {
        this.opTitle = opTitle;
    }

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "IcutWSReq{" +
                "orderId='" + orderId + '\'' +
                ", city='" + city + '\'' +
                ", classify='" + classify + '\'' +
                ", neName='" + neName + '\'' +
                ", coverList=" + coverList +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", opDetails='" + opDetails + '\'' +
                ", cutType='" + cutType + '\'' +
                ", opType='" + opType + '\'' +
                ", opTitle='" + opTitle + '\'' +
                ", taskid='" + taskid + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
