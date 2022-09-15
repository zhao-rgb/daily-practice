package com.zxl.dailypractice.card.two.September.September14;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * @author: zhaoxl
 * @date: 2022/9/14
 * @desc:
 **/
//删除某些元素后的数组均值    https://leetcode.cn/problems/mean-of-array-after-removing-some-elements/
public class Solution {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int removeCount = (int) (n * 0.05);
        int sum = 0;
        for (int i = removeCount; i < n - removeCount; i++) {
            sum += arr[i];
        }
        return sum / (n * 0.9);
    }

    public static void main(String[] args) {
        String paradef = "{\"interface\":{\"type\":\"string\",\"description\":\"互联接口\",\"required\":true,\"value\":\"$11\"},\"aggreInterface\":{\"type\":\"string\",\"description\":\"聚合接口\",\"required\":true,\"value\":\"11\"}}";
//        String paradef = "{\"port\":{\"type\":\"string\",\"description\":\"端口名称\",\"required\":true,\"value\":\"11\"}}";
        System.out.println(paradef);
        JSONObject jsonObject = JSONObject.parseObject(paradef);

        String body = "";
        for (String key : jsonObject.keySet()) {

            JSONObject childObject = jsonObject.getJSONObject(key);
            String value = childObject.getString("value");
            if (value.contains("$")){
                value = value.substring(1);
                System.out.println(value);
            }
//            System.out.println(childObject.getString("value"));
            body += "\"" + key + "\"" + ":\"" + dealNullStr(value) + "\",";

        }
        body = body.substring(0, body.length() - 1);   //去掉末尾的逗号,

        System.out.println(body);
    }

    private static String dealNullStr(String str) {
        return StringUtils.isBlank(str) ? "" : str;
    }
}
