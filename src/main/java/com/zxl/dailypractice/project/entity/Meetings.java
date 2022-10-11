package com.zxl.dailypractice.project.entity;

import lombok.*;

import java.util.Date;


/**
 * @author: zhaoxl
 * @date: 2022/10/10
 * @desc:
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Meetings {
    private Integer id;
    private String people;
    private String subject;
    private String context;
    private Date time;
    private String remark;
}
