package com.zxl.dailypractice.card.two.october.october8;

import com.alibaba.fastjson.JSONObject;

/**
 * @author: zhaoxl
 * @date: 2022/10/8
 * @desc:
 **/
//最大升序子数组和           https://leetcode.cn/problems/maximum-ascending-subarray-sum/
public class Solution {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length, ans = nums[0];
        for (int i = 1, cur = nums[0]; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                cur += nums[i];
            } else {
                cur = nums[i];
            }
            ans = Math.max(ans, cur);
        }
        return ans;
    }

    public static void main(String[] args) {
        //es查询
        JSONObject jsonObject = new JSONObject();
        getfluxesjson(jsonObject,"resid2");
        System.out.println(jsonObject.toJSONString());
    }

    private static void getfluxesjson(JSONObject jsonObject, String resid) {
        jsonObject.put("query", new JSONObject());
        jsonObject.getJSONObject("query").put("term", new JSONObject());
        jsonObject.getJSONObject("query").getJSONObject("term").put("k_portgrp", resid);
        jsonObject.put("aggs", new JSONObject());
    }
}
