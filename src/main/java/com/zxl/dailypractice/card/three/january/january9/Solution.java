package com.zxl.dailypractice.card.three.january.january9;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author: zhaoxl
 * @date: 2023/1/9
 * @desc:
 **/
public class Solution {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("orderId", "orderId");
        jsonObject.put("endTime", "endTime");
        String busiParams = JSON.toJSONString(jsonObject);
        System.out.println(busiParams);
    }
}
