package com.zxl.dailypractice.card.march.march31;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/3/31
 * @Version 1.0
 **/
//自除数    https://leetcode-cn.com/problems/self-dividing-numbers/
public class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividing(i)){
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean isSelfDividing(int num){
        int temp = num;
        while (temp > 0){
            int digit = temp%10;
            if (digit == 0 || num%digit != 0){
                return false;
            }
            temp /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> list = solution.selfDividingNumbers(1, 22);
        System.out.println(list);
    }
}
