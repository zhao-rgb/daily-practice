package com.zxl.dailypractice.project.mapper;

import com.zxl.dailypractice.project.entity.Meetings;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: zhaoxl
 * @date: 2022/10/10
 * @desc:
 **/
@Mapper
@Repository
public interface MeetingMapper {
    // 获取所有部门信息
    List<Meetings> getDepartments();
}
