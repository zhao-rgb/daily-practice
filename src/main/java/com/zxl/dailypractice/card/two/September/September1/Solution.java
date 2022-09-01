package com.zxl.dailypractice.card.two.September.September1;

import java.util.Arrays;

/**
 * @author: zhaoxl
 * @date: 2022/9/1
 * @desc:
 **/
//商品折扣后的最终价格      https://leetcode.cn/problems/final-prices-with-a-special-discount-in-a-shop/
public class Solution {
    public int[] finalPrices(int[] prices) {
        int[] ints = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int discount = 0;
            for (int j = i+1; j < prices.length; j++) {
                if (prices[j] <= prices[i]){
                    discount = prices[j];
                    break;
                }
            }
            ints[i] = prices[i] - discount;
        }
        return ints;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {8,4,6,2,3};
        int[] ints = solution.finalPrices(a);
        System.out.println(Arrays.toString(ints));
    }
}
