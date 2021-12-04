package com.zxl.dailypractice.Lambda;

import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * @author zhao
 * @className PredicateDemo
 * @Description TODO
 * @Date 2021/12/1
 * @Version 1.0
 **/
//Predicate 是 Java 提供的一个函数式接口      https://www.lanqiao.cn/courses/1230/learning/?id=9471
public class PredicateDemo {
    public static void main(String[] args) {
        //简单使用  判断a是否大于50
        Predicate<Integer> predicate = a->a>50;
        System.out.println(predicate.test(52));
        //如果只断言int类型，可以直接使用 IntPredicate
        IntPredicate intPredicate = a->a>50;
        // System.out.println(intPredicate.test(50));
        IntStream.of(10,11,44,59,46,55,99,88,50)
                //结合filter过滤数字 小于或等于50的数字被过滤
                .filter(intPredicate)
                .peek(System.out::println).count();
    }
}
