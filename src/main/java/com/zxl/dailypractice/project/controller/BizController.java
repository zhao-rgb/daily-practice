package com.zxl.dailypractice.project.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.zxl.dailypractice.project.constant.TestEnum;
import com.zxl.dailypractice.project.controller.req.GetsubTaskListReq;
import com.zxl.dailypractice.project.mapper.MeetingMapper;
import com.zxl.dailypractice.project.util.IpUtil;
import com.zxl.dailypractice.project.util.RedisUtil;
import com.zxl.dailypractice.project.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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

    @Autowired
    private RedisUtil redis;

    @ApiOperation("分页")
    @PostMapping ("/fen")
    public ResponseResult hello(@RequestBody GetsubTaskListReq getsubTaskListReq){
        Map<String, Object> map = new HashMap<>();
        //list使用hutools
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

    @ApiOperation("test")
    @PostMapping ("/test")
    public ResponseResult test(){
        log.info("hello");
        List<Map<String, Object>> departmentz = meetingMapper.getDepartmentz();
        return ResponseResult.success(departmentz);
    }

    @ApiOperation("test1")
    @PostMapping ("/test1")
    public ResponseResult test1(){
        log.info(TestEnum.TASK_APPLY.getCode());
        return ResponseResult.success(meetingMapper.getDepartmentzo());
    }

    @ApiOperation("redis")
    @PostMapping ("/redis")
    public ResponseResult redis(String userId, HttpServletRequest request){
        String userIp = IpUtil.getRequestIp(request);
        redis.setnx("REDIS:"+userId+":"+userIp,userIp);
        redis.increment("REDIS_COUNT:"+userId,1);
        return ResponseResult.success();
    }

    @ApiOperation("download")
    @PostMapping ("/download")
    void download(HttpServletRequest req, HttpServletResponse resp) {
        File file2=new File("E:\\Unitehcs\\hello.txt");
        //获取文件名
        String fileName="hello";
        if(file2.exists()){
            FileInputStream in=null;
            HttpServletResponse response=resp;
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/octet-stream;charset=utf-8");
            response.setHeader("Content-disposition","attachment;filename="+fileName);
            try{
                in=new FileInputStream(file2);
                byte[]a=new byte[1024];
                int b;
                while ((b=in.read(a))!=-1){
                    response.getOutputStream().write(a,0,b);
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if(null!=in){
                    try{
                        in.close();
                    }catch (IOException e2){
                        log.info("关闭输入流错误");
                    }
                    try{
                        response.getOutputStream().close();
                    }catch (IOException e){
                        log.info("输出流关闭错误");
                    }
                }
            }
        }else {
            try {
                resp.getWriter().println("查不到文件");
            }catch (IOException e){
                log.info("resp返回前端信息异常");
            }
        }
    }
}
