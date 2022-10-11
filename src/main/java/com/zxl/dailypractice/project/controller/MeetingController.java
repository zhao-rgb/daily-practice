package com.zxl.dailypractice.project.controller;

import com.zxl.dailypractice.project.entity.Meetings;
import com.zxl.dailypractice.project.mapper.MeetingMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: zhaoxl
 * @date: 2022/10/10
 * @desc:
 **/
@RestController
@Slf4j
public class MeetingController {
    @Autowired
    private MeetingMapper meetingMapper;

    // 查询全部部门
    @GetMapping("/meeting")
    public List<Meetings> getDepartments(){
        return meetingMapper.getDepartments();
    }

    // 查询全部部门
    @GetMapping("/meetingz")
    public String hello(){
        String cfgdeployBody = "";
        List<Meetings> departments = meetingMapper.getDepartments();
        for (Meetings a : departments){
            cfgdeployBody = getCfgdeployBody(a);
        }
        return cfgdeployBody;
    }


    public static String getCfgdeployBody(Meetings meetings) {
        String paradef = meetings.getSubject();
        log.info("paradef={}", paradef);

        String body = "2";
        String code = "";
        String key = "";
        if (StringUtils.isNotBlank(paradef)) {
            body += "\"" + key + "\"" + ":\"" + dealNullStr(code) + "\",";
            if (body == null){
                body = body.substring(0, body.length() - 1);   //去掉末尾的逗号,
                return body;
            }
        }
        return "body2s2s2";
    }

    public static String dealNullStr(String str) {
        return StringUtils.isBlank(str) ? "" : str;
    }
}
