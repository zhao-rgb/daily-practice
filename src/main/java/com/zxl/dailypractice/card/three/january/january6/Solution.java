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
        JSONObject resultData = jsonObject.getJSONObject("resultData");
        Iterator<String> iterator = resultData.keySet().iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            String value = resultData.getString(key);
            System.out.println(value);
        }
    }
}
