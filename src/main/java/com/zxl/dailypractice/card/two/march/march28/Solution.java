package com.zxl.dailypractice.card.two.march.march28;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/3/28
 * @Version 1.0
 **/
//交替位二进制数     https://leetcode-cn.com/problems/binary-number-with-alternating-bits/
public class Solution {
    public boolean hasAlternatingBits(int n) {
        int prev = 2;
        while(n!=0){
            int cur = n%2;
            if (cur == prev){
                return false;
            }
            prev = cur;
            n/=2;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean b = solution.hasAlternatingBits(11);
        System.out.println(b);
    }
}
