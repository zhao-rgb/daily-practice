package com.zxl.dailypractice.lambda;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author zhao
 * @className LambdaWays
 * @Description TODO
 * @Date 2021/12/1
 * @Version 1.0
 **/
//Lambda相关的方法介绍    https://www.lanqiao.cn/courses/1230/learning/?id=9471
public class LambdaWays {
    public static void main(String[] args) {
        //forEach
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);

        //map
        List<Integer> numbers = Arrays.asList(2,3,3,2,5,2,7);
        //get list of unique squares
        List<Integer> squaresList = numbers.stream().map(i->i*i).distinct().collect(Collectors.toList());
        System.out.println(squaresList);

        //filter
        List<String> strings = Arrays.asList("efg", "", "abc", "bc", "ghij","", "lmn");
        //get count of empty string
        long count = strings.stream().filter(string -> string.isEmpty()).count();

        //limit
        random.ints().limit(10).forEach(System.out::println);

        //sorted
        random.ints().limit(10).sorted().forEach(System.out::println);

        //并行处理
        long count1 = strings.parallelStream().filter(String::isEmpty).count();
        System.out.println(count1);

        //Collector
        List<String> filtered = strings.stream().filter(string ->!string.isEmpty()).collect(Collectors.toList());
        System.out.println("Filtered List: " + filtered);
        String mergedString = strings.stream().filter(string ->!string.isEmpty()).collect(Collectors.joining(","));
        System.out.println("Merged String: " + mergedString);

        //Stream 处理完成后使用 Collector 来统计数据。
        IntSummaryStatistics stats = numbers.stream().mapToInt((x)->x).summaryStatistics();
        System.out.println("Highest number in List : " + stats.getMax());
        System.out.println("Lowest number in List : " + stats.getMin());
        System.out.println("Sum of all numbers : " + stats.getSum());
        System.out.println("Average of all numbers : " + stats.getAverage());
    }
}
