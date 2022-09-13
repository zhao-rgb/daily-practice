package com.zxl.dailypractice.card.two.September.September13;

/**
 * @author: zhaoxl
 * @date: 2022/9/13
 * @desc:
 **/
//最大交换       https://leetcode.cn/problems/maximum-swap/
public class Solution {
    public int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int n = chars.length;
        int maxNum = num;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                swap(chars,i,j);
                maxNum = Math.max(maxNum,Integer.parseInt(new String(chars)));
                swap(chars,i,j);
            }
        }
        return maxNum;
    }

    public void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }
}
