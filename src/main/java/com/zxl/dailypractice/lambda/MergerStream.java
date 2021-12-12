package com.zxl.dailypractice.lambda;

import java.util.stream.Stream;

/**
 * @author zhao
 * @className MergerStream
 * @Description TODO
 * @Date 2021/12/2
 * @Version 1.0
 **/
//合并流     https://www.lanqiao.cn/courses/1230/learning/?id=9471
public class MergerStream {
    public static void main(String[] args) {
        Stream<Integer> stream1 = Stream.of(1,2,3);
        Stream<Integer> stream2 = Stream.of(4,5,6);
        Stream<Integer> stream3 = Stream.of(7,8,9);
        Stream<Integer> mergerStream = Stream.of(stream1,stream2,stream3).flatMap((i)->i);
        mergerStream.forEach(System.out::println);
    }
}
