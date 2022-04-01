package com.zxl.dailypractice.card.april.april1;

import java.util.*;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/4/1
 * @Version 1.0
 **/
//二倍数对数组      https://leetcode-cn.com/problems/array-of-doubled-pairs/
public class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int x : arr){
            cnt.put(x,cnt.getOrDefault(x,0) + 1);
        }
        if (cnt.getOrDefault(0,0) % 2 != 0){
            return false;
        }

        List<Integer> vals = new ArrayList<>();
        for (int x : cnt.keySet()){
            vals.add(x);
        }
        Collections.sort(vals,(a,b) -> Math.abs(a) - Math.abs(b));
        for (int x : vals) {
            if (cnt.getOrDefault(2*x,0) < cnt.get(x)){
                return false;
            }
            cnt.put(2*x,cnt.getOrDefault(2*x,0) - cnt.get(x));
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3,1,3,6};
        boolean b = solution.canReorderDoubled(arr);
        System.out.println(b);
    }
}
