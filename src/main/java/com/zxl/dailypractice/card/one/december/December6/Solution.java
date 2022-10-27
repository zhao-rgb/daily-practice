package com.zxl.dailypractice.card.one.december.December6;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2021/12/5
 * @Version 1.0
 **/
//截断句子        https://leetcode-cn.com/problems/truncate-sentence/
public class Solution {
    public String truncateSentence(String s, int k) {
        StringBuilder ans = new StringBuilder();
        for (char c : s.toCharArray()){
            if(c==' '){
                k--;
                if(k==0){
                    break;
                }
            }
            ans.append(c);
        }
        return ans.toString();
    }

    public String truncateSentence1(String s, int k) {
        int n = s.length();
        int end = 0,count=0;
        for (int i = 1; i <= n; i++) {
            if(i==n||s.charAt(i)==' '){
                count++;
                if(count==k){
                    end = i;
                    break;
                }
            }
        }
        return s.substring(0,end);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "What is the solution to this problem";
        String s1 = solution.truncateSentence1(s, 4);
        System.out.println(s1);
    }
}
