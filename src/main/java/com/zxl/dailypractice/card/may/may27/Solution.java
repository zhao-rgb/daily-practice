package com.zxl.dailypractice.card.may.may27;

/**
 * @author zhao
 * @className Soution
 * @Description TODO
 * @Date 2022/5/27
 * @Version 1.0
 **/
//单词距离    https://leetcode.cn/problems/find-closest-lcci/
public class Solution {
    public int findClosest(String[] words, String word1, String word2) {
        int n = words.length,ans = n;
        for (int i = 0,p=-1,q=-1; i < n; i++) {
            String t = words[i];
            if (t.equals(word1)){
                p = i;
            }
            if (t.equals(word2)){
                q = i;
            }
            if (p!=-1 && q!=-1){
                ans = Math.min(ans,Math.abs(p-q));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] a ={"I","am","a","student","from","a","university","in","a","city"};
        String b = "a",c="student";
        int closest = solution.findClosest(a, b, c);
        System.out.println(closest);
    }
}
