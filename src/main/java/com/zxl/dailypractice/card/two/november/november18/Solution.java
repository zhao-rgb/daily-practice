package com.zxl.dailypractice.card.two.november.november18;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: zhaoxl
 * @date: 2022/11/18
 * @desc:
 **/
public class Solution {

    public static void main(String[] args) {
        String cfgdeployBody = getCfgdeployBody();
        System.out.println(cfgdeployBody);
    }

    private static String getCfgdeployBody() {
//        String paradef = "{\"portname\":{\"type\":\"string\",\"description\":\"端口名称\",\"required\":true,\"value\":\"$aaa\"},\"cost\":{\"type\":\"string\",\"description\":\"cost值\",\"required\":true,\"value\":\"$bbb\"}}";
        String paradef = "";
        String body = "";
        if (StringUtils.isNotBlank(paradef)) {
            JSONObject jsonObject = JSONObject.parseObject(paradef);
            for (String key : jsonObject.keySet()) {
                JSONObject childObject = jsonObject.getJSONObject(key);

                String code = childObject.getString("value");
//                if (code.contains("$")) {
//                    code = code.substring(1);
//                    GlobeCfg value = cmUniNetCutOverTaskDetailMapper.getValue(taskid, code);
//                    if (value != null) {
//                        code = value.getValue();
//                    } else {
//                        code = "";
//                    }
//                }
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
