package com.zxl.dailypractice.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author zhao
 * @className FunctionTest
 * @Description TODO
 * @Date 2021/12/1
 * @Version 1.0
 **/
//使用这些函数式编程的接口      https://www.lanqiao.cn/courses/1230/learning/?id=9471
public class FunctionTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0,1,2,3,4,5,6,7,8,9);

        System.out.println("All of the numbers:");

        eval(list,n->true);

        System.out.println("Even numbers:");
        eval(list,n->n%2 == 0);

        System.out.println("Numbers that greater than  5:");
        eval(list, n -> n > 5 );
    }

    public static void eval(List<Integer> list,
                            Predicate<Integer> predicate){
        for (Integer n : list) {
            if (predicate.test(n)) {
                System.out.println(n);
            }
        }
    }
}
