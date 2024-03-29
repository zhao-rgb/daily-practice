package com.zxl.dailypractice.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.zxl.dailypractice.project.controller.req.GetsubTaskListReq;
import com.zxl.dailypractice.project.controller.req.UpdateAlarmSubscribeRuleFilterReq;
import com.zxl.dailypractice.project.controller.req.UpdateAlarmSubscribeRuleReq;
import com.zxl.dailypractice.project.controller.resp.GetAlarmSubscribeRule2RedisResp;
import com.zxl.dailypractice.project.entity.Meetings;
import com.zxl.dailypractice.project.mapper.MeetingMapper;
import com.zxl.dailypractice.project.service.FileService;
import com.zxl.dailypractice.project.util.ExcelPageUtils;
import com.zxl.dailypractice.project.util.FileReturn;
import com.zxl.dailypractice.project.util.ResponseResult;
import com.zxl.dailypractice.project.util.ZipUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author: zhaoxl
 * @date: 2022/10/10
 * @desc:
 **/
@RestController
@Slf4j
@Api(tags = "会议项目")
public class MeetingController {
    //swagger 地址：  http://localhost:8081/swagger-ui/index.html
    //swagger 地址：  http://localhost:8081/doc.html
    @Autowired
    private MeetingMapper meetingMapper;

    @Autowired
    private FileService fileService;

    @Autowired
    private RestTemplate restTemplate;


    // 查询全部部门
    @ApiOperation("查询全部部门")
    @GetMapping("/meetingz")
    public ResponseResult hello(){
        String cfgdeployBody = "";
        List<Meetings> departments = meetingMapper.getDepartments();
//        for (Meetings a : departments){
//            cfgdeployBody = getCfgdeployBody(a);
//        }
        return ResponseResult.success(departments);
    }

    @ApiOperation("调用接口")
    @GetMapping("/callHello")
    public ResponseResult CallHello(){
        ResponseResult hello = hello();
        JSONObject jsonObject = JSONObject.parseObject(hello.toString());
        List<Meetings> pmColFluxDay = null;
        if("1".equals(jsonObject.getString("code"))){
             pmColFluxDay = JSONObject.parseArray(jsonObject.getString("data"),Meetings.class);
        } else {
            System.out.println("调用/api/arpt/pmColFluxDay异常");
        }
        return ResponseResult.success(pmColFluxDay);
    }

    // 测试Map
    @ApiOperation("测试Map")
    @PostMapping("/test/map")
    public GetAlarmSubscribeRule2RedisResp hhhtest(@RequestBody UpdateAlarmSubscribeRuleReq req){
        //封装redis存储对象
        GetAlarmSubscribeRule2RedisResp rule2RedisResp = new GetAlarmSubscribeRule2RedisResp();
        BeanUtils.copyProperties(req,rule2RedisResp);
        if(req.getFilterList()!=null&&req.getFilterList().size()>0){
            List<Map<String,Object>> objects = new ArrayList<>();
            Map<String,Object> paraMap;
            for (UpdateAlarmSubscribeRuleFilterReq updateReq : req.getFilterList()) {
                paraMap = new HashMap<>();
                paraMap.put("fillterName",updateReq.getFilterName());
                paraMap.put("filterType",updateReq.getFilterType());
                paraMap.put("filterExpr",updateReq.getFilterExpr());
                paraMap.put("isDelay",updateReq.getIsDelay());
                paraMap.put("delayTime",updateReq.getDelayTime());
                objects.add(paraMap);
            }
            rule2RedisResp.setFilterList(objects);
        }
        return rule2RedisResp;
    }

    @ApiOperation("上传文件")
    @RequestMapping(value = "/upload/file",method = RequestMethod.POST)
    public FileReturn uploadFile(@RequestParam("file") MultipartFile multipartFile,
                                 @RequestParam("de") String de){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        String token = request.getHeader("zy_token");
        System.out.println(token);
        System.out.println(de);
        String fileSuffix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
        System.out.println(fileSuffix);
        return fileService.uploadFile(multipartFile);
    }

    @ApiOperation("token加表单请求")
    @RequestMapping( value = "/use/tokenRequest",method = RequestMethod.POST)
    public JSONObject predictProfile() throws Exception{
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<>();
        paramMap.add("de", "deeee");
        File excelFile = new File("E:\\test\\ES_search.txt");

        byte[] bytesArray = new byte[(int) excelFile.length()];

        FileInputStream fis = new FileInputStream(excelFile);
        fis.read(bytesArray);
        fis.close();
        ByteArrayResource contentsAsResource = new ByteArrayResource(bytesArray) {
            @Override
            public String getFilename() {
                return "file";
            }
        };
        paramMap.add("file", contentsAsResource);
        HttpHeaders headers = new HttpHeaders();
        headers.set("zy_token","token9t");
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<MultiValueMap> entity = new HttpEntity<>(paramMap, headers);
        String aiUrl = "http://localhost:8081";
        JSONObject predictProfile = restTemplate.
                exchange(aiUrl+"/upload",
                        HttpMethod.POST,entity,JSONObject.class).getBody();
        return predictProfile;
    }

    @ApiOperation("导出excel带标题")
    @PostMapping("/exportTitle")
    public void exportTitle(HttpServletResponse response) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        String format = sdf.format(new Date());
        List<GetsubTaskListReq> getsubTaskListResps = new ArrayList<>();
        GetsubTaskListReq getsubTaskListReq1 = new GetsubTaskListReq();
        getsubTaskListReq1.setAccessnum("1");
        getsubTaskListReq1.setStep("1");
        GetsubTaskListReq getsubTaskListReq2 = new GetsubTaskListReq();
        getsubTaskListReq2.setAccessnum("2");
        getsubTaskListReq2.setStep("2");
        GetsubTaskListReq getsubTaskListReq3 = new GetsubTaskListReq();
        getsubTaskListReq3.setAccessnum("3");
        getsubTaskListReq3.setStep("3");
        getsubTaskListResps.add(getsubTaskListReq1);
        getsubTaskListResps.add(getsubTaskListReq2);
        getsubTaskListResps.add(getsubTaskListReq3);

        for (GetsubTaskListReq c : getsubTaskListResps){
            //按照一个设备+巡检项，生成一个txt文件
            writeContent(c.getAccessnum() + "_" + c.getStep(), c.getStep(),format);
        }
        List<List<String>> exprotList = new ArrayList<>();
        List<String> cellList = new ArrayList<>();
        cellList.add("entiy.getNodename()");
        cellList.add("entiy.getDevname()");
        cellList.add("entiy.getMgmtip()");
        cellList.add("entiy.getHealthscore()");
        exprotList.add(cellList);
        List<String> titleList = new ArrayList<>();
        titleList.add("节点");
        titleList.add("设备名称");
        titleList.add("设备IP");
        titleList.add("健康指数:hello,zxl");
//        String filePath = this.getClass().getClassLoader().getResource("").getPath() + "/temp/";
        String filePath = System.getProperty("user.dir") + "/itep/var/tmp/rcheck/detaillog/" + format + "/";
        System.out.println(filePath);
        String fileName = "rcheckMatrixinfo.xlsx";
//        ExcelPageUtils.createExcel(exprotList, titleList.toArray(new String[titleList.size()]), 40, filePath,
//                fileName, response);
        ExcelPageUtils.createExcelNoresponse(exprotList, titleList.toArray(new String[titleList.size()]), 40, filePath,
                fileName);
        //任务32146
        saveZip(filePath,response);
    }

    public void writeContent(String fileName1,String data,String uuid){
        String filePath = System.getProperty("user.dir") + "/itep/var/tmp/rcheck/detaillog/" + uuid + "/";
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        String fileName = fileName1 + ".txt";
        try {
            FileWriter fileWriter = new FileWriter(filePath + fileName);
            fileWriter.write(data==null?"":data);
            fileWriter.close();
            log.info("Successfully wrote to the file.");
        } catch (IOException e) {
            log.info("An error occurred while writing to the file.");
            log.info(e.getMessage());
        }
    }

    public void saveZip(String filepath,HttpServletResponse response) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        String format = sdf.format(new Date());
        String filePath = System.getProperty("user.dir") + "/itep/var/tmp/rcheck/saveZip/";
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        String fileName = format + "rcheckMatrixinfo.zip";
        FileOutputStream fos1 = new FileOutputStream(filePath + fileName);
        ZipUtil.toZip(filepath, fos1, true);
        //下载
        ZipUtil.downloadZip(new File(filePath + fileName), response);
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

    @Bean
    public RestTemplate restTemplate() {
        //复杂构造函数的使用
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(3000000);// 设置超时
        requestFactory.setReadTimeout(30000000);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(requestFactory);
        return restTemplate;
    }


}
