package com.zxl.dailypractice.card.may.may12;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/5/12
 * @Version 1.0
 **/
//删列造序  https://leetcode.cn/problems/delete-columns-to-make-sorted/
public class Solution {
    public int minDeletionSize(String[] strs) {
        int row = strs.length;
        int col = strs[0].length();
        int ans = 0;
        for (int j = 0; j < col; ++j) {
            for (int i = 1; i < row; ++i) {
                if (strs[i - 1].charAt(j) > strs[i].charAt(j)) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] a = {"cba","daf","ghi"};
        int i = solution.minDeletionSize(a);
        System.out.println(i);
    }
}
