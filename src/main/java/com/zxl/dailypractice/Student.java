package com.zxl.dailypractice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhao
 * @className Student
 * @Description TODO
 * @Date 2021/11/17
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String id;
    private String name;
    private String gender;
    private String age;
    private String zy;
    private String score;
}
