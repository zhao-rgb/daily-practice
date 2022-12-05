package com.zxl.dailypractice.card.two.december.december2;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhaoxl
 * @date: 2022/12/2
 * @desc:
 **/
public class Solution {
    public static void main(String[] args) {
        List<String> groupList = new ArrayList<String>();
        groupList.add("k_ALARMTYPEID");
        groupList.add("k_ALARMTYPEDESC");
        JSONObject aggs = getGroupByJson(groupList);
        System.out.println(aggs);
        System.out.println(aggs.keySet());
    }

    public static JSONObject getGroupByJson(List<String> groupList){
        JSONObject aggs = new JSONObject();
        aggs.put("group_by_",new JSONObject());
        aggs.getJSONObject("group_by_").put("composite", new JSONObject());
        aggs.getJSONObject("group_by_").getJSONObject("composite").put("sources", new JSONArray());
        for (String key:groupList) {
            JSONObject groupJson = new JSONObject();
            groupJson.put(key.replaceAll(".keyword", ""), new JSONObject());
            groupJson.getJSONObject(key.replaceAll(".keyword", "")).put("terms", new JSONObject());
            groupJson.getJSONObject(key.replaceAll(".keyword", "")).getJSONObject("terms").put("field", key);
            aggs.getJSONObject("group_by_").getJSONObject("composite").getJSONArray("sources").add(groupJson);
        }
        return aggs;
    }
}
