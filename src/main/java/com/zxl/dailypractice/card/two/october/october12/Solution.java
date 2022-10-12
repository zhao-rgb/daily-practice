package com.zxl.dailypractice.card.two.october.october12;


import com.zxl.dailypractice.collection.ArrayList.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: zhaoxl
 * @date: 2022/10/11
 * @desc:
 **/
public class Solution {
    public static void main(String[] args) {
        Student zxl = new Student("1", "zxl");
        Student zxl2 = new Student("2", "zxl2");
        Student zxl3 = new Student("3", "zxl3");
        Student zxl4 = new Student("4", "zxl4");
        List<Student> list = new ArrayList<>();
        list.add(zxl);
        list.add(zxl2);
        list.add(zxl3);
        list.add(zxl4);
        List<Student> collect = list.stream().filter(p -> "2".equals(p.id)).collect(Collectors.toList());
        System.out.println(collect);
        List<Student> collect1 = list.stream().parallel().collect(Collectors.toList());
        System.out.println(collect1);
    }
}
