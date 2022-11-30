package com.zxl.dailypractice.card.two.november.november28;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: zhaoxl
 * @date: 2022/11/28
 * @desc:
 **/
public class Solution {
    public static void main(String[] args) {
        String cfgdeployBodyz = getCfgdeployBodyz();
        System.out.println(cfgdeployBodyz);
    }

    private static String getCfgdeployBodyz() {

        String paradef = "{\"preconf_aleaf\":{\"type\":\"string\",\"description\":\"Aleaf设备\",\"required\":true,\"value\":\"$aleaf1_devip\"},\"aleaf_portname\":{\"type\":\"string\",\"description\":\"Aleaf端口名称\",\"required\":true,\"value\":\"$aleaf1_portname\"},\"ipv4\":{\"type\":\"string\",\"description\":\"ipv4\",\"required\":false,\"value\":\"\"},\"ipv6\":{\"type\":\"string\",\"description\":\"ipv6\",\"required\":false,\"value\":\"\"},\"vlanid\":{\"type\":\"string\",\"description\":\"vlanid\",\"required\":false,\"value\":\"\"}}\n"         ;
        String body = "";
        if (StringUtils.isNotBlank(paradef)) {
            JSONObject jsonObject = JSONObject.parseObject(paradef);
            for (String key : jsonObject.keySet()) {
                JSONObject childObject = jsonObject.getJSONObject(key);

                String code = childObject.getString("value");
                if (code.contains("$")) {
//                    code = code.substring(1);
//                    GlobeCfg value = cmUniNetCutOverTaskDetailMapper.getValue(taskid, code);
//                    if (value != null) {
//                        code = value.getValue();
//                    } else {
//                        code = "";
//                    }
                } else {
                    if ("ipv4".equals(key)) {
                        code = "hello";
                    } else {
                        code = "";
                    }

                }
                body += "\"" + key + "\"" + ":\"" + dealNullStr(code) + "\",";
            }
            if (body != null && body.length() > 0) {
                body = body.substring(0, body.length() - 1);   //去掉末尾的逗号,
                return body;
            }
        }
        return body;
    }

    private static String dealNullStr(String str) {
        return StringUtils.isBlank(str) ? "" : str;
    }
}

