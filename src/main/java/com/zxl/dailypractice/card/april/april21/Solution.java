package com.zxl.dailypractice.card.april.april21;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/4/21
 * @Version 1.0
 **/
//山羊拉丁文      https://leetcode-cn.com/problems/goat-latin/
public class Solution {
    public String toGoatLatin(String sentence) {
        String[] strs = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        String vowel = "aeiouAEIOU";
        for (int i = 0; i < strs.length; i++) {
            sb.append(vowel.indexOf(strs[i].charAt(0)) == -1 ? strs[i].substring(1) + strs[i].charAt(0) +
                    "ma" : strs[i] +"ma");
            sb.append("a".repeat(i + 1));
            sb.append(' ');
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "I speak Goat Latin";
        String s1 = solution.toGoatLatin(s);
        System.out.println(s1);
    }
}
