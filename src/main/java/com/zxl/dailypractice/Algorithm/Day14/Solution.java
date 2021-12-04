package com.zxl.dailypractice.Algorithm.Day14;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2021/11/29
 * @Version 1.0
 **/
public class Solution {
    // 颠倒二进制位   https://leetcode-cn.com/problems/reverse-bits/solution/
    public int reverseBits(int n){
        return Integer.reverse(n);
    }

    //只出现一次的数字    https://leetcode-cn.com/problems/single-number/solution/zhi-chu-xian-yi-ci-de-shu-zi-by-leetcode-solution/
    public int singleNumber(int[] nums){
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 10011100;
        System.out.println(n);
        int i = solution.reverseBits(n);
        System.out.println(i);

        int[] num = {1,1,2,3,4,2,3};
        int i1 = solution.singleNumber(num);
        System.out.println(i1);
    }
}
