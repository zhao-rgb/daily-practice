package com.zxl.dailypractice.card.two.october.october27;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhaoxl
 * @date: 2022/10/27
 * @desc:
 **/
//数组元素积的符号   https://leetcode.cn/problems/sign-of-the-product-of-an-array/
public class Solution {
    public int arraySign(int[] nums) {
        int sign = 1;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            }
            if (num < 0) {
                sign = -sign;
            }
        }
        return sign;
    }

    public static void main(String[] args) {
//        String s = "{\"code\":\"0000\",\"data\":{\"pageNum\":1,\"pageSize\":20,\"pages\":1,\"records\":[{\"PathMatrixPingJitter\":\"100,50,10\",\"PathMatrixPkgLossRatio\":\"80,30,10\",\"PathMatrixTimeDelay\":\"1000,500,100\",\"createUser\":\"sunli2022\",\"openDate\":\"2022-08-24 15:55:52\",\"viewId\":\"2d141455-2382-11ed-8d52-0050568ff5b9\",\"viewName\":\"\\u77E9\\u96351\",\"viewPathList\":[{\"aDevId\":\"3029301b-4b16-4333-9d24-d1a5a1328594\",\"aPointName\":\"\\u6D4B\\u8BD5\\u8BBE\\u590787_cliping\",\"bDevId\":\"3029301b-4b16-4333-9d24-d1a5a1328594\",\"bPointName\":\"\\u6D4B\\u8BD5\\u8BBE\\u590787_cliping\",\"coordinate\":\"1,1\",\"pathId\":\"\"},{\"aDevId\":\"3029301b-4b16-4333-9d24-d1a5a1328594\",\"aPointName\":\"\\u6D4B\\u8BD5\\u8BBE\\u590787_cliping\",\"bDevId\":\"40fddd04-13cd-44ba-b481-62224deee38d\",\"bPointName\":\"\\u6D4B\\u8BD5\\u8BBE\\u590771_snmpping\",\"coordinate\":\"1,2\",\"pathId\":\"f960fb99-2449-11ed-8d52-0050568ff5b9\"},{\"aDevId\":\"ad1835a9-a114-4266-8624-d161607779e6\",\"aPointName\":\"\\u6D4B\\u8BD5\\u8BBE\\u5907100_snmpping\",\"bDevId\":\"3029301b-4b16-4333-9d24-d1a5a1328594\",\"bPointName\":\"\\u6D4B\\u8BD5\\u8BBE\\u590787_cliping\",\"coordinate\":\"2,1\",\"pathId\":\"2d53c216-2382-11ed-8d52-0050568ff5b9\"},{\"aDevId\":\"ad1835a9-a114-4266-8624-d161607779e6\",\"aPointName\":\"\\u6D4B\\u8BD5\\u8BBE\\u5907100_snmpping\",\"bDevId\":\"40fddd04-13cd-44ba-b481-62224deee38d\",\"bPointName\":\"\\u6D4B\\u8BD5\\u8BBE\\u590771_snmpping\",\"coordinate\":\"2,2\",\"pathId\":\"f97833c2-2449-11ed-8d52-0050568ff5b9\"}]}],\"total\":1},\"msg\":\"\",\"tip\":\"\\u6210\\u529F\"}";
//        JSONArray jsonArray = JSONObject.parseObject(s).getJSONObject("data").getJSONArray("records");
//        if (jsonArray != null && jsonArray.size() > 0) {
//            for (int i = 0; i < jsonArray.size(); i++) {
//                JSONArray viewPathList = jsonArray.getJSONObject(i).getJSONArray("viewPathList");
//                if (viewPathList != null && viewPathList.size() > 0){
//                    for (int j = 0; j < viewPathList.size(); j++) {
//                        String pathId = viewPathList.getJSONObject(j).getString("pathId");
//                        System.out.println(pathId);
//                    }
//                }
//            }
//        }

//        Map<String, Object> a = null;
//        List<Map<String, Object>> datalist = new ArrayList<>();
//        Map<String, Object> resultMap = a;
//        System.out.println(datalist.add(resultMap));

        Map<String, String[]> stringStringHashMap = new HashMap<>();
        String colenname = "赵肖了,dd,zz,wqy";
        String[] split = colenname.split(",");
        stringStringHashMap.put("colenname",split);
        System.out.println(stringStringHashMap);
    }
}
