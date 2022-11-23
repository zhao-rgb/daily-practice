package com.zxl.dailypractice.card.two.november.november18;

import com.zxl.dailypractice.project.controller.req.GetsubTaskListReq;

import java.lang.reflect.Field;

/**
 * @author: zhaoxl
 * @date: 2022/11/18
 * @desc:
 **/
public class Solution {

    public static void main(String[] args) throws IllegalAccessException {
        GetsubTaskListReq getsubTaskListReq1 = new GetsubTaskListReq();
        getsubTaskListReq1.setAccessnum("12s2");
        Field[] fields = getsubTaskListReq1.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            //获取字段名称
            String name = field.getName();
            System.out.println(name);
            Object value = null;
            value = field.get(getsubTaskListReq1);
            System.out.println(value);
        }
        System.out.println(new GetsubTaskListReq().toString());
    }

}
