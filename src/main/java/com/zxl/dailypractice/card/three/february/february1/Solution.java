package com.zxl.dailypractice.card.three.february.february1;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: zhaoxl
 * @date: 2023/1/30
 * @desc:
 **/
public class Solution {
    public static void main(String[] args) throws Exception {
        try {
            Map<String, Object> input1 = new HashMap<>();
            input1.put("orderId", "1234567");
            input1.put("classify", "hs2hs2");
            input1.put("neName", "xhaoxial");
            input1.put("opDetails", "zxl");
            input1.put("opType", "2");
            input1.put("opTitle", "zxl");
            input1.put("cutType", "hellos2jj");

            CoverList cover = new CoverList();
            cover.setNeName("hello");
            List<CoverList> coverList = new ArrayList<>();
            coverList.add(cover);
            input1.put("coverList", coverList);

            IcutWSReq icutWSReq1 = JSONObject.parseObject(JSONObject.toJSONString(input1), IcutWSReq.class);
            System.out.println(icutWSReq1);
            chencktIcut(icutWSReq1);
            System.out.println(icutWSReq1.getOpType());
        } catch (Exception e) {
            System.out.println("shib");
        }

    }

    public static void chencktIcut(IcutWSReq req) throws Exception{
        if (StringUtils.isBlank(req.getOrderId())){
            System.out.println("orderId为空");
        }
        if (StringUtils.isBlank(req.getClassify())){
            System.out.println("classify为空");
        }
        if (StringUtils.isBlank(req.getNeName())){
            System.out.println("neName为空");
        }
        if (StringUtils.isBlank(req.getOpDetails())){
            System.out.println("opDetails为空");
        }

        if (StringUtils.isBlank(req.getCutType())){
            System.out.println("cutType为空");
        }
        if (StringUtils.isBlank(req.getOpType())){
            System.out.println("opType为空");
        }
        if (StringUtils.isBlank(req.getOpTitle())){
            System.out.println("opTitle为空");
        }
        if (req.getCoverList().size() > 0){
            for (CoverList coverList : req.getCoverList()){
                if (StringUtils.isBlank(coverList.getNeName())){
                    System.out.println("coverList中的neName为空");
                }
            }
        }
    }
}
