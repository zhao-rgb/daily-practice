package com.zxl.dailypractice.card.three.january.january9;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author: zhaoxl
 * @date: 2023/1/9
 * @desc:
 **/
public class Solution {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("orderId", "orderId");
        jsonObject.put("endTime", "endTime");
        String busiParams = JSON.toJSONString(jsonObject);
        System.out.println(busiParams);
        String busiParams1 = jsonObject.toString();
        System.out.println(busiParams1);
        System.out.println(jsonObject);

        int taskid = 640569;
        String s = Integer.toString(taskid);
        System.out.println(s);
        System.out.println("hello");

//        //割接状态更改
//        GetsubTaskListReq getsubTaskListReq = new GetsubTaskListReq();
//        getsubTaskListReq.setTaskid(req.getTaskid());
//        RestPageRequest.Page pageReq = new RestPageRequest.Page();
//        pageReq.setPageNum(1);
//        pageReq.setPageSize(500);
//        getsubTaskListReq.setPage(pageReq);
//        Map<String, Object> map = getsubTaskList(getsubTaskListReq);
//        logger.info(map.get("records").toString());
//
////        List<GetsubTaskListResp> getsubTaskListResps = new ArrayList<>();
////        if (map.get("records") )
//        JSONArray records = JSONArray.parseArray(map.get("records").toString());
//        for (Object a : records){
//            JSONObject jsonObject = JSONObject.parseObject(a.toString());
//            String newexecutestatus = jsonObject.getString("newexecutestatus");
//            logger.info(newexecutestatus);
//        }
//        return RestResponse.ok();
    }
}
