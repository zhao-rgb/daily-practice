package com.zxl.dailypractice.sort;

/**
 * @author zhao
 * @className QuickSort
 * @Description TODO
 * @Date 2022/3/29
 * @Version 1.0
 **/
//快速排序      https://pdai.tech/md/algorithm/alg-sort-x-fast.html
public class QuickSort {
    /*
     * 快速排序
     *
     * 参数说明:
     *     a -- 待排序的数组
     *     l -- 数组的左边界(例如，从起始位置开始排序，则l=0)
     *     r -- 数组的右边界(例如，排序截至到数组末尾，则r=a.length-1)
     */
    public static void quickSort(int[] a, int l, int r) {
        if(l < r){
            int i,j,x;
            i=l;
            j=r;
            x=a[i];
            while (i<j){
                while (i<j && a[j] > x){
                    j--; // 从右向左找第一个小于x的数
                }
                if (i<j){
                    a[i++] =a[j];
                }
                while (i<j && a[i] < x){
                    i++;  // 从左向右找第一个大于x的数
                }
                if (i < j){
                    a[j--] = a[i];
                }
            }
            a[i] = x;
            quickSort(a,l,i-1);
            quickSort(a,i+1,r);
        }
    }

    public static void main(String[] args) {
        int i;
        int[] a = {30,40,60,10,20,50};

        System.out.print("before sort:");
        for (i=0; i<a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        quickSort(a, 0, a.length-1);

        System.out.print("after  sort:");
        for (i=0; i<a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

}
