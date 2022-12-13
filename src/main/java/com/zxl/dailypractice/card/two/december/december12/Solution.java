package com.zxl.dailypractice.card.two.december.december12;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author: zhaoxl
 * @date: 2022/12/9
 * @desc:
 **/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String h = "[{\"CODE\": \"red\",\"VALUE\": true},{\"CODE\": \"blue\",\"VALUE\": true},{\"CODE\": \"hello\",\"VALUE\": true}]";
        JSONArray hh = JSONArray.parseArray(h);
        JSONArray objects = solution.addDataToParaArr(hh);
        System.out.println(objects);
        for (int i = 0; i < objects.size(); i++) {
            JSONObject jsonObject = objects.getJSONObject(i);
            System.out.println(jsonObject);
        }
    }

    private JSONArray addDataToParaArr(JSONArray paraArr){
        JSONArray paraArrFormat = null;

        paraArrFormat = paraArr;

        return paraArrFormat;
    }
}
