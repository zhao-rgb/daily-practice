package com.zxl.dailypractice.card.two.october.october17;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhaoxl
 * @date: 2022/10/14
 * @desc:
 **/
//水果成篮         https://leetcode.cn/problems/fruit-into-baskets/
public class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        Map<Integer, Integer> cnt = new HashMap<>();
        int left = 0,ans = 0;
        for (int right = 0; right < n; right++) {
            cnt.put(fruits[right],cnt.getOrDefault(fruits[right],0) + 1);
            while (cnt.size() > 2){
                cnt.put(fruits[left],cnt.get(fruits[left]) - 1);
                if (cnt.get(fruits[left]) == 0){
                    cnt.remove(fruits[left]);
                }
                left++;
            }
            ans = Math.max(ans,right - left + 1);
        }
        return ans;
    }
}
