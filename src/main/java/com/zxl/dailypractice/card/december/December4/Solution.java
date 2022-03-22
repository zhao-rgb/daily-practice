package com.zxl.dailypractice.card.december.December4;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2021/12/3
 * @Version 1.0
 **/
//赎金信  https://leetcode-cn.com/problems/ransom-note/
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()){
            return false;
        }
        int[] cnt = new int[26];
        for (char c : magazine.toCharArray()){
            cnt[c-'a']++;
        }
        for (char c : ransomNote.toCharArray()){
            cnt[c-'a']--;
            if (cnt[c-'a'] < 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String ransomNote = "aa";
        String magazine = "aab";
        boolean b = solution.canConstruct(ransomNote, magazine);
        System.out.println(b);
    }
}
