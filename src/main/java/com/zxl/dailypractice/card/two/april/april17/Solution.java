package com.zxl.dailypractice.card.two.april.april17;

import java.util.*;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/4/17
 * @Version 1.0
 **/
//最常见的单词       https://leetcode-cn.com/problems/most-common-word/
public class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        Map<String,Integer> cache = new HashMap<>();
        String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split("\\s+");
        for(String str : words){
            if (!bannedSet.contains(str)){
                cache.put(str,cache.getOrDefault(str,0) + 1);
            }
        }
        return Collections.max(cache.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String a = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] b = {"hit"};
        String s = solution.mostCommonWord(a, b);
        System.out.println(s);
    }
}
