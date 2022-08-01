package com.zxl.dailypractice.card.two.january.january25;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/1/25
 * @Version 1.0
 **/
//比赛中的配对次数    https://leetcode-cn.com/problems/count-of-matches-in-tournament/
public class Solution {
    public int numberOfMatches(int n) {
        int ans = 0;
        while (n > 1){
            if (n%2==0){
                ans+=n/2;
                n/=2;
            }else {
                ans += (n-1)/2;
                n = (n-1)/2+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.numberOfMatches(14);
        System.out.println(i);
    }
}
