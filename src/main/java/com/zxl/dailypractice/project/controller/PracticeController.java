package com.zxl.dailypractice.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.zxl.dailypractice.project.controller.req.CreateAlarmAttrReq;
import com.zxl.dailypractice.project.entity.Meetings;
import com.zxl.dailypractice.project.mapper.MeetingMapper;
import com.zxl.dailypractice.project.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: zhaoxl
 * @date: 2023/1/18
 * @desc:
 **/
@RestController
@Slf4j
@Api(tags = "练习demo")
public class PracticeController {

    @Autowired
    private MeetingMapper meetingMapper;

    @ApiOperation("list按照对象的某个属性排序")
    @PostMapping("/list/compare")
    public List<Meetings> json(){
        List<Meetings> departments = meetingMapper.getDepartments();
        departments = departments.stream().sorted(Comparator.comparing(Meetings::getId))
                .collect(Collectors.toList());
        return departments;
    }

    @ApiOperation("告警")
    @PostMapping("/serv/createAlarm")
    public ResponseResult createAlarm(@RequestBody List<CreateAlarmAttrReq> list){
        log.info("requestBody:"+ JSONObject.toJSONString(list));
        Map<String,Object> dataMap = new HashMap<>();
        for (CreateAlarmAttrReq attr : list) {
            dataMap.put(attr.getAttributeCode(),attr.getAttributeValue());
        }
        return ResponseResult.success(dataMap);
    }


    @ApiOperation("测试url")
    @PostMapping("/url")
    public ResponseResult testurl(@RequestBody List<CreateAlarmAttrReq> list, HttpServletRequest request){
        log.info("requestBody:"+ JSONObject.toJSONString(list));
        String requestedURL = request.getRequestURL().toString();
        return ResponseResult.success(requestedURL);
    }

}
