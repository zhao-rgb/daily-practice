package com.zxl.dailypractice.card.two.november.november18;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: zhaoxl
 * @date: 2022/11/18
 * @desc:
 **/
public class Solution {

    public static final String DIA_PRE_CFG_CHECK_WITH_PASSWORD = "{" +
            "     <BODY>" +
            "   ," +
            "     \"DeviceIP\": \"<DeviceIP>\"," +
            " }";

    public static void main(String[] args) throws IllegalAccessException {
//        GetsubTaskListReq getsubTaskListReq1 = new GetsubTaskListReq();
//        getsubTaskListReq1.setAccessnum("12s2");
//        Field[] fields = getsubTaskListReq1.getClass().getDeclaredFields();
//        for (Field field : fields) {
//            field.setAccessible(true);
//            //获取字段名称
//            String name = field.getName();
//            System.out.println(name);
//            Object value = null;
//            value = field.get(getsubTaskListReq1);
//            System.out.println(value);
//        }
//        System.out.println(new GetsubTaskListReq().toString());
//        //todo

        String jsonParam = DIA_PRE_CFG_CHECK_WITH_PASSWORD
                .replace("<BODY>", getCfgdeployBodyz())
                .replace("<DeviceIP>", "s2ksk2");
        System.out.println(jsonParam);

        //todo
    }


    private static String getCfgdeployBodyz() {
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
        return body;
    }

    private static String dealNullStr(String str) {
        return StringUtils.isBlank(str) ? "" : str;
    }

}
