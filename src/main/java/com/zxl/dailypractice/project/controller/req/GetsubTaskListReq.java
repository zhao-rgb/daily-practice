package com.zxl.dailypractice.project.controller.req;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author: zhaoxl
 * @date: 2022/11/17
 * @desc:
 **/
@Getter
@Setter
@ToString
public class GetsubTaskListReq{
    private String taskid;
    private String accessnum;
    private String executestatus;

    private String step;
    private int pageNum;
    private int pageSize;
}
