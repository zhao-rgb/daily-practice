package com.zxl.dailypractice.card.two.october.october27;

/**
 * @author: zhaoxl
 * @date: 2022/10/27
 * @desc:
 **/
//数组元素积的符号   https://leetcode.cn/problems/sign-of-the-product-of-an-array/
public class Solution {
    public int arraySign(int[] nums) {
        int sign = 1;
        for (int num : nums){
            if (num == 0){
                return 0;
            }
            if (num < 0){
                sign = -sign;
            }
        }
        return sign;
    }
}
