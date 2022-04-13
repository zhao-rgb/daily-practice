package com.zxl.dailypractice.card.april.april13;

import java.util.*;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2022/4/13
 * @Version 1.0
 **/
//O(1) 时间插入、删除和获取随机元素       https://leetcode-cn.com/problems/insert-delete-getrandom-o1/
public class Solution {
    List<Integer> nums;
    Map<Integer, Integer> indices;
    Random random;

    public Solution() {
        nums = new ArrayList<>();
        indices = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (indices.containsKey(val)){
            return false;
        }
        int index = nums.size();
        nums.add(val);
        indices.put(val,index);
        return true;
    }

    public boolean remove(int val) {
        if (!indices.containsKey(val)){
            return false;
        }
        int index = indices.get(val);
        int last = nums.get(nums.size() - 1);
        nums.set(index,last);
        indices.put(last,index);
        nums.remove(nums.size() - 1);
        indices.remove(val);
        return true;
    }

    public int getRandom() {
        int i = random.nextInt(nums.size());
        return nums.get(i);
    }
}
