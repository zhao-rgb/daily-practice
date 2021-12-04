package com.zxl.dailypractice.Lambda;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author zhao
 * @className FlatMapTest
 * @Description TODO
 * @Date 2021/12/2
 * @Version 1.0
 **/
//FlatMap         https://www.lanqiao.cn/courses/1230/learning/?id=9471
public class FlatMapTest {
    public static void main(String[] args) {
        Stream<String> stringStream1 = Stream.of("shi yan", "shi yan lou","lou yan shi");
        Stream<String> stringStream2 = Stream.of("shi yan", "shi yan lou","lou yan shi");
        Stream<String[]> mapstream = stringStream1
        //map将一种类型的流 转换为另外一个类型的流  这里转换成了String[]流
        //这并不是我们想要的，我们想要的是Stream<String>,而不是Stream<String[]>
                .map(v->v.split(" "));
        Stream<String> flatMapStream = stringStream2
        //Arrays.stream将数组转换成了流 这里将分割后的String[]，转换成了Stream<String>，但是我们前面定义了三个字符串
        //所以这里将产生三个Stream<String>，flatMap用于将三个流合并成一个流
                .flatMap(v-> Arrays.stream(v.split(" ")));
        System.out.println("mapstream打印:");
        mapstream.peek(System.out::println).count();
        System.out.println("flatMapStream打印:");
        flatMapStream.peek(System.out::println).count();
    }
}
