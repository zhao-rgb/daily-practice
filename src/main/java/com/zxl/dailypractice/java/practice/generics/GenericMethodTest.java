package com.zxl.dailypractice.java.practice.generics;

/**
 * @author zhao
 * @className GenericMethodTest
 * @Description TODO
 * @Date 2022/3/10
 * @Version 1.0
 **/
// 泛型   https://www.twle.cn/l/yufei/java/java-basic-generics.html
public class GenericMethodTest {
    public static<E> void printArray( E[] inputArray){
        for (E element : inputArray){
            System.out.print(element);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 创建不同类型数组： Integer, Double 和 Character
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

        System.out.println( "整型数组元素为:" );
        printArray( intArray  ); // 传递一个整型数组

        System.out.println( "\n双精度型数组元素为:" );
        printArray( doubleArray ); // 传递一个双精度型数组

        System.out.println( "\n字符型数组元素为:" );
        printArray( charArray ); // 传递一个字符型数组
    }
}
