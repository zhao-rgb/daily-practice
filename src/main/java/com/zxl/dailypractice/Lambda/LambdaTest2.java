package com.zxl.dailypractice.Lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhao
 * @className LambdaTest2
 * @Description TODO
 * @Date 2021/12/1
 * @Version 1.0
 **/
//方法引用  https://www.lanqiao.cn/courses/1230/learning/?id=9471
public class LambdaTest2 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Peter");
        names.add("Linda");
        names.add("Smith");
        names.add("Zack");
        names.add("Bob");

        //     通过System.out::println引用了输出的方法
        names.forEach(System.out::println);
    }
}
