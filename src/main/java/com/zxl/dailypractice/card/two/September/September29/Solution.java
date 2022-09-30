package com.zxl.dailypractice.card.two.September.September29;

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
                "\t\t\"fileContent\":\"w2w2w2\"},\"tip\": \"成功\"\n" +
                "}";
        String fileContent = a.substring(a.indexOf("fileContent", 1),
                        a.indexOf("\"},\"tip\"", 1))
                .replaceAll("fileContent\":\"", "");
        System.out.println(fileContent);
//        JSONObject getcurdevcfgfile = JSON.parseObject(a);
//        System.out.println(getcurdevcfgfile);
//        String fileContent =getcurdevcfgfile.getJSONObject("data").getString("fileContent");
//        System.out.println(fileContent);
    }
}
