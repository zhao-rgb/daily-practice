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

//        //割接状态更改  将object转成list对象
//        GetsubTaskListReq getsubTaskListReq = new GetsubTaskListReq();
//        getsubTaskListReq.setTaskid(req.getTaskid());
//        RestPageRequest.Page pageReq = new RestPageRequest.Page();
//        pageReq.setPageNum(1);
//        pageReq.setPageSize(500);
//        getsubTaskListReq.setPage(pageReq);
//        Map<String, Object> map = getsubTaskList(getsubTaskListReq);
//        List<GetsubTaskListResp> getsubTaskListResps = new ArrayList<GetsubTaskListResp>();
//        logger.info("map" + map.get("records").toString());
//        Object obj = map.get("records");
//        if (obj instanceof List<?>){
//            for (Object o : (List<?>) obj){
//                getsubTaskListResps.add((GetsubTaskListResp) o);
//            }
//        }
//        logger.info("----------------");
//        logger.info("getsubTaskListResps"+getsubTaskListResps);
    }
}
