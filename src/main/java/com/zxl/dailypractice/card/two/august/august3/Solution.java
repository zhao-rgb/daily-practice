package com.zxl.dailypractice.card.two.august.august3;

import java.util.Arrays;

/**
 * @author: zhaoxl
 * @date: 2022/8/3
 * @desc:
 **/
//有序队列    https://leetcode.cn/problems/orderly-queue/
public class Solution {
    public String orderlyQueue(String s, int k) {
        if(k == 1){
            StringBuilder sb = new StringBuilder(s);
            for (int i = 1; i < s.length(); i++) {
                sb.append(sb.charAt(0)).deleteCharAt(0);
                if (sb.toString().compareTo(s) < 0){
                    s = sb.toString();
                }
            }
            return s;
        }else {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String cba = solution.orderlyQueue("cba", 1);
        System.out.println(cba);
    }
}
