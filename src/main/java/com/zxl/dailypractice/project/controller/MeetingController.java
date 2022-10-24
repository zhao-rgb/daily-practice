package com.zxl.dailypractice.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.zxl.dailypractice.project.entity.Meetings;
import com.zxl.dailypractice.project.mapper.MeetingMapper;
import com.zxl.dailypractice.project.service.FileService;
import com.zxl.dailypractice.project.util.FileReturn;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

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
    public String hello(){
        String cfgdeployBody = "";
        List<Meetings> departments = meetingMapper.getDepartments();
        for (Meetings a : departments){
            cfgdeployBody = getCfgdeployBody(a);
        }
        return cfgdeployBody;
    }

    @ApiOperation("上传文件")
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public FileReturn uploadFile(@RequestParam("file") MultipartFile multipartFile,
                                 @RequestParam("de") String de){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        String token = request.getHeader("zy_token");
        System.out.println(token);
        System.out.println(de);
        return fileService.uploadFile(multipartFile);
    }

    @ApiOperation("token加表单请求")
    @RequestMapping( value = "/hhh",method = RequestMethod.POST)
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
