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
                "\t\"resultId\": \"0001\",\n" +
                "\t\"resultData\": {\n" +
                "\t\t\"display current-configuration interface Eth-Trunk | section include Eth-Trunk11.1150\": \"display current-configuration interface Eth-Trunk | section include Eth-Trunk11.1150\\r\\nInfo: It will take a long time if the content you search is too much or the string you input is too long, you can press CTRL_C to break.\\r\\n<TJ-XQ-YLQ-B-3.STN.CX600-X8A>\",\n" +
                "\t\t\"display ip routing-table vpn-instance MCN-PI0 221.238.209.61\\n\": \"display ip routing-table vpn-instance MCN-PI0 221.238.209.61\\r\\nRoute Flags: R - relay, D - download to fib, T - to vpn-instance, B - black hole route\\r\\n------------------------------------------------------------------------------\\r\\nRouting Table : MCN-PI0\\r\\nSummary Count : 2\\r\\n\\r\\nDestination/Mask    Proto   Pre  Cost        Flags NextHop         Interface\\r\\n\\r\\n        0.0.0.0/0   IBGP    255  0             RD  240E:188:9::1004:0 SRv6 BE\\t\\t\\t\\r\\n                    IBGP    255  0             RD  240E:188:9:0:100:0:1004:0 SRv6 BE\\r\\n<TJ-XQ-YLQ-B-3.STN.CX600-X8A>\\r\\n<TJ-XQ-YLQ-B-3.STN.CX600-X8A>\"\n" +
                "\t},\n" +
                "\t\"resultDesc\": \"{\\\"display ip routing-table vpn-instance MCN-PI0 221.238.230.201\\\\ndisplay ip routing-table vpn-instance MCN-PI0 221.238.230.145\\\\n\\\":\\\"display ip routing-table vpn-instance MCN-PI0 221.238.230.201\\\\r\\\\nRoute Flags: R - relay, D - download to fib, T - to vpn-instance, B - black hole route\\\\r\\\\n------------------------------------------------------------------------------\\\\r\\\\nRouting Table : MCN-PI0\\\\r\\\\nSummary Count : 1\\\\r\\\\n\\\\r\\\\nDestination/Mask    Proto   Pre  Cost        Flags NextHop         Interface\\\\r\\\\n\\\\r\\\\n221.238.230.201/32  Direct  0    0             D   127.0.0.1       Eth-Trunk11.1283\\\\t\\\\t\\\\t\\\\r\\\\n<TJ-DL-XSW2-B-6.STN.CX600-X8A>display ip routing-table vpn-instance MCN-PI0 221.238.230.145\\\\r\\\\nRoute Flags: R - relay, D - download to fib, T - to vpn-instance, B - black hole route\\\\r\\\\n------------------------------------------------------------------------------\\\\r\\\\nRouting Table : MCN-PI0\\\\r\\\\nSummary Count : 1\\\\r\\\\n\\\\r\\\\nDestination/Mask    Proto   Pre  Cost        Flags NextHop         Interface\\\\r\\\\n\\\\r\\\\n221.238.230.145/32  Direct  0    0             D   127.0.0.1       Eth-Trunk11.1283\\\\t\\\\t\\\\t\\\\r\\\\n<TJ-DL-XSW2-B-6.STN.CX600-X8A>\\\\r\\\\n<TJ-DL-XSW2-B-6.STN.CX600-X8A>\\\"}\"\n" +
                "}";
        JSONObject jsonObject = JSONObject.parseObject(a);
        System.out.println(jsonObject);
        String result = "";
        JSONObject resultData = jsonObject.getJSONObject("resultData");
        Iterator<String> iterator = resultData.keySet().iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            result += resultData.getString(key)+"\r\n";
        }
        System.out.println(result);
    }
}
