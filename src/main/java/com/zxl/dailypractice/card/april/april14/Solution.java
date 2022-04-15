package com.zxl.dailypractice.card.april.april14;

import java.util.*;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/4/14
 * @Version 1.0
 **/
//最富有客户的资产总量      https://leetcode-cn.com/problems/richest-customer-wealth/
public class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for(int[] a : accounts){
            max = Math.max(max, Arrays.stream(a).sum());
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] b = {{1, 2, 3}, {2, 3, 4}};
        int i = solution.maximumWealth(b);
        System.out.println(i);

        //有一个字符串List，如下代码所示。续写代码，将words中的元素再按照字符拆分，合并成一个数组，然后字符去重，最终得到["h", "e", "l", "o", "w", "r", "d"]
        List<String> words = new ArrayList<>();
        words.add("hello");
        words.add("world");
        Set set = new LinkedHashSet();
        for (int a = 0; a < words.size(); a++) {
            String s = words.get(a);
            String[] split = s.split("");
            for (String ss : split) {
                set.add(ss);
            }
        }
        System.out.println(set);
    }
}
