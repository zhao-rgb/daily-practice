package com.zxl.dailypractice.card.april.april24;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/4/24
 * @Version 1.0
 **/
//二进制间距    https://leetcode-cn.com/problems/binary-gap/
public class Solution {
    public int binaryGap(int n) {
        String binStr = Integer.toBinaryString(n);
        int lastOneIdx = n, max = 0;
        for (int i = 0; i < binStr.length(); i++) {
            if (binStr.charAt(i) == '1') {
                max = Math.max(max, i - lastOneIdx);
                lastOneIdx = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.binaryGap(22);
        System.out.println(i);
    }
}
