package com.zxl.dailypractice.card.april.april18;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/4/18
 * @Version 1.0
 **/
//字典序排数     https://leetcode-cn.com/problems/lexicographical-numbers/
public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ret = new ArrayList<>();
        int number = 1;
        for (int i = 0; i < n; i++) {
            ret.add(number);
            if (number*10<=n){
                number *= 10;
            } else {
                while (number%10==9||number+1>n){
                    number /= 10;
                }
                number++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> list = solution.lexicalOrder(12);
        System.out.println(list);
    }
}
