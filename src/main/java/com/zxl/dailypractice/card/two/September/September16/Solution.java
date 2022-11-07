package com.zxl.dailypractice.card.two.September.September16;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: zhaoxl
 * @date: 2022/9/14
 * @desc:
 **/
//string转成json
public class Solution {
    public static void main(String[] args) {
        String paradef = "{\"interface\":{\"type\":\"string\",\"description\":\"互联接口\",\"required\":true,\"value\":\"$11\"},\"aggreInterface\":{\"type\":\"string\",\"description\":\"聚合接口\",\"required\":true,\"value\":\"11\"}}";
//        String paradef = "{\"port\":{\"type\":\"string\",\"description\":\"端口名称\",\"required\":true,\"value\":\"11\"}}";
        System.out.println(paradef);
        JSONObject jsonObject = JSONObject.parseObject(paradef);
        System.out.println(jsonObject);
        String body = "";
        for (String key : jsonObject.keySet()) {
            JSONObject childObject = jsonObject.getJSONObject(key);
            String value = childObject.getString("value");
            if (value.contains("$")){
                value = value.substring(1);
                System.out.println(value);
            }
            body += "\"" + key + "\"" + ":\"" + dealNullStr(value) + "\",";
        }
        body = body.substring(0, body.length() - 1);   //去掉末尾的逗号,
        System.out.println(body);
    }

    private static String dealNullStr(String str) {
        return StringUtils.isBlank(str) ? "" : str;
    }
}
