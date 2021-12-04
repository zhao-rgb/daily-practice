package com.zxl.dailypractice.sort;

import java.util.Arrays;

/**
 * @author zhao
 * @className BubbleSort
 * @Description TODO
 * @Date 2021/11/23
 * @Version 1.0
 **/
//冒泡排序
public class BubbleSort {

    public int[] Bubble(int[] arr){
        for(int i =0;i<arr.length;i++){
            //外层循环，遍历次数
            for (int j = 0; j < arr.length-i-1; j++) {
                //内层循环，升序（如果前一个值比后一个值大，则交换）
                //内层循环一次，获取一个最大值
                if(arr[j]>arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] a = {5,2,3,4,1,6};
        BubbleSort bubbleSort = new BubbleSort();
        int[] bubble = bubbleSort.Bubble(a);
        System.out.println(Arrays.toString(bubble));
    }
}
