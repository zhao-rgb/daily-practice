package com.zxl.dailypractice.card.two.September.September29;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author: zhaoxl
 * @date: 2022/9/28
 * @desc:
 **/
public class Solution {
    public static void main(String[] args) {
        String a = "{\n" +
                "\t\"msg\": \"\",\n" +
                "\t\"code\": \"0000\",\n" +
                "\t\"data\": {\n" +
                "\t\t\"fileContent\": \"ss2s22\"\n" +
                "\t},\n" +
                "\t\"tip\": \"成功\"\n" +
                "}";
        JSONObject getcurdevcfgfile = JSON.parseObject(a);
        System.out.println(getcurdevcfgfile);
        String fileContent =getcurdevcfgfile.getJSONObject("data").getString("fileContent");
        System.out.println(fileContent);
    }
}
