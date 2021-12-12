package com.zxl.dailypractice.card.December.December1;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2021/12/1
 * @Version 1.0
 **/
//连续字符   https://leetcode-cn.com/problems/consecutive-characters/solution/lian-xu-zi-fu-by-leetcode-solution-lctm/
public class Solution {
    public int maxPower(String s){
        int ans = 1,cnt = 1;
        for (int i = 1; i < s.length(); i++) {
         if(s.charAt(i) == s.charAt(i-1)) {
             cnt++;
             ans = Math.max(ans,cnt);
         } else {
             cnt = 1;
         }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "leetcode";
        int i = solution.maxPower(s);
        System.out.println(i);
    }
}
