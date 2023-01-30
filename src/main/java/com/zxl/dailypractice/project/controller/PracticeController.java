package com.zxl.dailypractice.project.controller;

import com.zxl.dailypractice.project.entity.Meetings;
import com.zxl.dailypractice.project.mapper.MeetingMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
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

}
