package com.zxl.dailypractice.card.one.december.December26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2021/12/26
 * @Version 1.0
 **/
// Bigram 分词   https://leetcode-cn.com/problems/occurrences-after-bigram/
public class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String[] ss = text.split(" ");
        int n = ss.length;
        List<String> list = new ArrayList<>();
        for (int i = 0; i + 2 < n ; i++) {
            if (ss[i].equals(first) && ss[i+1].equals(second)){
                list.add(ss[i+2]);
            }
        }
        //将List转为数组的一个非常方便的方法toArray
        return list.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String text = "we will we will rock you";
        String[] ocurrences = solution.findOcurrences(text, "we", "will");
        System.out.println(Arrays.toString(ocurrences));

    }
}
