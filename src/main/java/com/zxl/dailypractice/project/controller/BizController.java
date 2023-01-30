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
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
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

    @ApiOperation("list分页")
    @PostMapping ("/list/paging")
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

    @ApiOperation("部门test")
    @PostMapping ("/departmentz/test")
    public ResponseResult test(){
        log.info("hello");
        List<Map<String, Object>> departmentz = meetingMapper.getDepartmentz();
        return ResponseResult.success(departmentz);
    }

    @ApiOperation("enum使用")
    @PostMapping ("/enum/test")
    public ResponseResult test1(){
        log.info(TestEnum.TASK_APPLY.getCode());
        return ResponseResult.success(meetingMapper.getDepartmentzo());
    }

    @ApiOperation("redis测试")
    @PostMapping ("/redis")
    public ResponseResult redis(String userId, HttpServletRequest request){
        String userIp = IpUtil.getRequestIp(request);
        redis.setnx("REDIS:"+userId+":"+userIp,userIp);
        redis.increment("REDIS_COUNT:"+userId,1);
        return ResponseResult.success();
    }

    //读取文件内容
    @ApiOperation("readdownload")
    @PostMapping ("/read/download")
    void readdownload(HttpServletRequest req, HttpServletResponse resp) {
        File file2=new File("E:\\Unitehcs\\data.csv");
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

    //下载文件方法1
    @ApiOperation("download")
    @PostMapping ("/download/one")
    void download(HttpServletRequest req, HttpServletResponse resp){
        File file=new File("E:\\Unitehcs\\ZJ_ipranPortInfo_all_20221212040230.json.gz");
        downloadZip(file,resp);
    }

    //下载文件方法2
    @ApiOperation("downloadz")
    @PostMapping ("/download/two")
    public ResponseEntity<byte[]> downloadz(HttpServletRequest req, HttpServletResponse resp){
        File file=new File("E:\\Unitehcs\\workfile\\12月\\30518\\ZJ_ipranPortInfo_all_20221212040230.json.gz");
        byte[] fileData = downloadFile(file);
        String filename = "XZ_ipranDeviceInfo_all_20230116081405.json.gz";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=" + filename);
        headers.setContentLength(fileData.length);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        HttpStatus statusCode = HttpStatus.OK;
        return new ResponseEntity<>(fileData, headers, statusCode);
    }

    public byte[] downloadFile(File file) {
        InputStream inputStream = null;
        try {
            inputStream = new BufferedInputStream(new FileInputStream(file));;
            ByteArrayOutputStream  byteOutputStream = new ByteArrayOutputStream();
            IOUtils.copy(inputStream, byteOutputStream);
            return byteOutputStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("下载文件异常", e);
        } finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    log.error("关闭下载文件输入流异常", e);
                }
            }
        }
    }

    public static HttpServletResponse downloadZip(File file, HttpServletResponse response) {
        try {
            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(file.getPath()));
            // 清空response
            response.reset();
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            // 如果输出的是中文名的文件，在此处就要用URLEncoder.encode方法进行处理
            response.setHeader("Content-Disposition",
                    "attachment;filename=" + URLEncoder.encode(file.getName(), "UTF-8"));

            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = fis.read(buffer)) != -1) {
                toClient.write(buffer, 0, len);
                toClient.flush();
            }
            fis.close();
            toClient.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {

        }
        return response;
    }
}
