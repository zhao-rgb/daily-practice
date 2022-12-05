package com.zxl.dailypractice.project.constant;

import lombok.*;

/**
 * @author: zhaoxl
 * @date: 2022/12/2
 * @desc:
 **/
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public enum TestEnum {
    TASK_APPLY("TASK_APPLY", "任务申请"),
    TASK_BEFORE_APPROVE("TASK_BEFORE_APPROVE", "待审核");

    private String code;
    private String name;
}
