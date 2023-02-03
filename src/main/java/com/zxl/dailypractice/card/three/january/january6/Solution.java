package com.zxl.dailypractice.card.three.january.january6;

import com.alibaba.fastjson.JSONObject;

import java.util.Iterator;

/**
 * @author: zhaoxl
 * @date: 2023/1/6
 * @desc:
 **/
public class Solution {
    public static void main(String[] args) {
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("orderId", "orderId");
//        jsonObject.put("endTime", "endTime");
//        String busiParams = JSON.toJSONString(jsonObject);
//        System.out.println(busiParams);
        String a = "{\n" +
                "    \"resultId\": \"0001\",\n" +
                "    \"resultData\": {\n" +
                "        \"display ip routing-table vpn-instance MCN-PI0 221.238.230.201\\ndisplay ip routing-table vpn-instance MCN-PI0 221.238.230.145\\n\": \"display ip routing-table vpn-instance MCN-PI0 221.238.230.201\\r\\nRoute Flags: R - relay, D - download to fib, T - to vpn-instance, B - black hole route\\r\\n------------------------------------------------------------------------------\\r\\nRouting Table : MCN-PI0\\r\\nSummary Count : 1\\r\\n\\r\\nDestination/Mask    Proto   Pre  Cost        Flags NextHop         Interface\\r\\n\\r\\n221.238.230.201/32  Direct  0    0             D   127.0.0.1       Eth-Trunk11.1283\\t\\t\\t\\r\\n<TJ-DL-XSW2-B-6.STN.CX600-X8A>display ip routing-table vpn-instance MCN-PI0 221.238.230.145\\r\\nRoute Flags: R - relay, D - download to fib, T - to vpn-instance, B - black hole route\\r\\n------------------------------------------------------------------------------\\r\\nRouting Table : MCN-PI0\\r\\nSummary Count : 1\\r\\n\\r\\nDestination/Mask    Proto   Pre  Cost        Flags NextHop         Interface\\r\\n\\r\\n221.238.230.145/32  Direct  0    0             D   127.0.0.1       Eth-Trunk11.1283\\t\\t\\t\\r\\n<TJ-DL-XSW2-B-6.STN.CX600-X8A>\\r\\n<TJ-DL-XSW2-B-6.STN.CX600-X8A>\"\n" +
                "    },\n" +
                "    \"resultDesc\": \"{\\\"display ip routing-table vpn-instance MCN-PI0 221.238.230.201\\\\ndisplay ip routing-table vpn-instance MCN-PI0 221.238.230.145\\\\n\\\":\\\"display ip routing-table vpn-instance MCN-PI0 221.238.230.201\\\\r\\\\nRoute Flags: R - relay, D - download to fib, T - to vpn-instance, B - black hole route\\\\r\\\\n------------------------------------------------------------------------------\\\\r\\\\nRouting Table : MCN-PI0\\\\r\\\\nSummary Count : 1\\\\r\\\\n\\\\r\\\\nDestination/Mask    Proto   Pre  Cost        Flags NextHop         Interface\\\\r\\\\n\\\\r\\\\n221.238.230.201/32  Direct  0    0             D   127.0.0.1       Eth-Trunk11.1283\\\\t\\\\t\\\\t\\\\r\\\\n<TJ-DL-XSW2-B-6.STN.CX600-X8A>display ip routing-table vpn-instance MCN-PI0 221.238.230.145\\\\r\\\\nRoute Flags: R - relay, D - download to fib, T - to vpn-instance, B - black hole route\\\\r\\\\n------------------------------------------------------------------------------\\\\r\\\\nRouting Table : MCN-PI0\\\\r\\\\nSummary Count : 1\\\\r\\\\n\\\\r\\\\nDestination/Mask    Proto   Pre  Cost        Flags NextHop         Interface\\\\r\\\\n\\\\r\\\\n221.238.230.145/32  Direct  0    0             D   127.0.0.1       Eth-Trunk11.1283\\\\t\\\\t\\\\t\\\\r\\\\n<TJ-DL-XSW2-B-6.STN.CX600-X8A>\\\\r\\\\n<TJ-DL-XSW2-B-6.STN.CX600-X8A>\\\"}\"\n" +
                "}";
        JSONObject jsonObject = JSONObject.parseObject(a);
        System.out.println(jsonObject);
        String result = "";
        JSONObject resultData = jsonObject.getJSONObject("resultData");
        System.out.println(resultData);
        Iterator<String> iterator = resultData.keySet().iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            result += resultData.getString(key)+"\r\n";
        }
        System.out.println(result);
        System.out.println("***************************");
        String result1 = "";
        String resultDesc = jsonObject.getString("resultDesc");
        System.out.println("resultDesc为:" + resultDesc);
        boolean isjson = isjson(resultDesc);
        if (isjson) {
            JSONObject jsonObject1 = JSONObject.parseObject(resultDesc);
            Iterator<String> iterator1 = jsonObject1.keySet().iterator();
            while (iterator1.hasNext()){
                String key = iterator1.next();
                System.out.println(key);
                result1 += jsonObject1.getString(key)+"\r\n";
            }
            System.out.println(result1);
        } else {
            System.out.println("不是json：" + resultDesc);
        }


        //test
        String b = "{\n" +
                "\t\"resultId\": \"系统错误\"\n" +
                "}";
    }

    static boolean isjson(String str) {
        try {
            JSONObject.parseObject(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
