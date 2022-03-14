package com.zxl.dailypractice.card.march.march14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/3/14
 * @Version 1.0
 **/
//两个列表的最小索引总和    https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists/
public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int n = list1.length,m = list2.length;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(list1[i],i);
        }
        List<String> ans = new ArrayList<>();
        int min = 3000;
        for (int i = 0; i < m; i++) {
            String s = list2[i];
            if (!map.containsKey(s)){
                continue;
            }
            if (i + map.get(s) < min){
                ans.clear();
                min = i + map.get(s);
                ans.add(s);
            } else if (i + map.get(s) ==  min){
                ans.add(s);
            }
        }
        return ans.toArray(new String[ans.size()]);
    }

    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        Solution solution = new Solution();
        String[] restaurant = solution.findRestaurant(list1, list2);
        for (String s : restaurant) {
            System.out.println(s);
        }
    }
}
