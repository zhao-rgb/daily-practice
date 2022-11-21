package com.zxl.dailypractice.project.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.zxl.dailypractice.project.controller.req.GetsubTaskListReq;
import com.zxl.dailypractice.project.mapper.MeetingMapper;
import com.zxl.dailypractice.project.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: zhaoxl
 * @date: 2022/11/17
 * @desc:
 **/
@RestController
@Slf4j
@Api(tags = "biz测试项目")
public class BizController {

    @Autowired
    private MeetingMapper meetingMapper;

    @ApiOperation("分页")
    @PostMapping ("/fen")
    public ResponseResult hello(@RequestBody GetsubTaskListReq getsubTaskListReq){
        Map<String, Object> map = new HashMap<>();
        PageHelper.startPage(getsubTaskListReq.getPageNum(),getsubTaskListReq.getPageSize());
        List<GetsubTaskListReq> getsubTaskListResps = new ArrayList<>();

        GetsubTaskListReq getsubTaskListReq1 = new GetsubTaskListReq();
        getsubTaskListReq1.setAccessnum("12s2");
        GetsubTaskListReq getsubTaskListReq2 = new GetsubTaskListReq();
        getsubTaskListReq2.setAccessnum("s2jis2hs2");
        getsubTaskListResps.add(getsubTaskListReq1);
        getsubTaskListResps.add(getsubTaskListReq2);
        //返回报文format  start
        JSONArray jsonArray = JSONArray.parseArray(JSONObject.toJSONString(getsubTaskListResps));

        map.put("records", jsonArray);
        return ResponseResult.success(map);
    }
}
