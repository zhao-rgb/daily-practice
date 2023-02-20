package com.zxl.dailypractice.card.three.february.february16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: zhaoxl
 * @date: 2023/2/16
 * @desc:
 **/
public class Solution {
    public static void main(String[] args) {
        List<String> titleList = new ArrayList<>();
        titleList.add("节点");
        titleList.add("设备名称");
        titleList.add("设备IP");
        titleList.add("健康指数:hello,zxl");
        System.out.println(Arrays.toString(titleList.toArray(new String[titleList.size()])));
        System.out.println("hello");
    }
}
