package com.zxl.dailypractice.sort;

import java.util.Arrays;

/**
 * @author zhao
 * @className SelectSort
 * @Description TODO
 * @Date 2021/11/23
 * @Version 1.0
 **/
//选择排序
public class SelectSort {
    public int[] Select(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            //默认第一个最小
            int min = i;
            //通过与后面的数据进行比较得出，最小值和下标
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            if(min!=i){
                //然后将最小值与本次循环，开始值交换
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] a = {5,2,3,4,1,6};
        SelectSort selectSort = new SelectSort();
        int[] select = selectSort.Select(a);
        System.out.println(Arrays.toString(select));
    }
}
