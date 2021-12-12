package com.zxl.dailypractice.algorithm.Day13;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2021/11/29
 * @Version 1.0
 **/
public class Solution {
    //2 的幂     https://leetcode-cn.com/problems/power-of-two/solution/2de-mi-by-leetcode-solution-rny3/
    public boolean isPowerOfTwo(int n){
        if(n<1) {
            return false;
        }
        while (n!=1){
            if(n%2==1){
                return false;
            }
            n = n/2;
        }
        return true;
    }

    //位1的个数   https://leetcode-cn.com/problems/number-of-1-bits/comments/
    public int hammingWeight(int n) {
        String str = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='1'){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean powerOfTwo = solution.isPowerOfTwo(6);
        System.out.println(powerOfTwo);

        int i = solution.hammingWeight(00000000000000000000000000001011);
        System.out.println(i);
    }
}
