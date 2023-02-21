package com.zxl.dailypractice.project.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.unitechs.framework.elasticsearch.client.EsTemplate;
import com.unitechs.framework.elasticsearch.domain.request.QueryDocumentByDslRequest;
import com.unitechs.framework.elasticsearch.domain.request.QueryDocumentRequest;
import com.unitechs.framework.elasticsearch.domain.response.QueryDocumentResponse;
import com.zxl.dailypractice.project.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author: zhaoxl
 * @date: 2022/10/14
 * @desc:
 **/
@Slf4j
@RestController
@Api(tags = "熟悉ES")
public class EsController {
    @Autowired
    private EsTemplate esTemplate;

    @ApiOperation("ES查询")
    @RequestMapping(value = "/es",method = RequestMethod.POST)
    public ResponseResult es() throws IOException {
        String dsl = "{\n" +
                "  \"query\": {\n" +
                "    \"match\": {\n" +
                "      \"k_devname\": \"huaweine40\"\n" +
                "    }\n" +
                "  }\n" +
                "}";
        QueryDocumentByDslRequest<JSONObject> search =
                new QueryDocumentByDslRequest<>("pm_col_dev_*", "", dsl,
                        JSONObject.class);
        QueryDocumentResponse<JSONObject> jsonObjectQueryDocumentResponse =
                esTemplate.queryDocumentByDSL(search);
        String jsonString = jsonObjectQueryDocumentResponse.getJsonString();
        JSONArray jsonArray = JSONObject.parseObject(jsonString).getJSONObject("hits").getJSONArray("hits");
        for (int i = 0; i < jsonArray.size(); i++) {
            System.out.println(jsonArray.get(i));
            System.out.println(jsonArray.getJSONObject(i).getJSONObject("_source").get("d_memr"));
        }
        return ResponseResult.success(jsonObjectQueryDocumentResponse);
    }

    @ApiOperation("ES测试")
    @RequestMapping(value = "/test/es",method = RequestMethod.POST)
    public ResponseResult testes() throws Exception{
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String now = time.format(formatter);
        String indexName = "pm_col_brasippool" + now;
        String sql = "select * from " + indexName + " limit 10000";
        log.info("===============sql语句为：" + sql);

        indexName = "am_ala_alarmsummary_20230217";
        log.info("esSearchIndex:{}",indexName);
        QueryDocumentRequest<JSONObject> queryDocumentRequest = new QueryDocumentRequest<JSONObject>(indexName,"_doc",sql,JSONObject.class);
        QueryDocumentResponse<JSONObject> jsonObjectQueryDocumentResponse = esTemplate.queryDocument(queryDocumentRequest);
        String data = jsonObjectQueryDocumentResponse.getJsonString();
        log.info("====================data:" + data);
        JSONObject object = JSONObject.parseObject(data);
        JSONObject hits = (JSONObject) object.get("hits");
        JSONArray array = hits.getJSONArray("hits");
        if (array != null && array.size() > 0){
            for (int i = 0;i < array.size();i++){
                JSONObject source = ((JSONObject) array.get(i)).getJSONObject("_source");
                if (!source.isEmpty()){
                    String v4T = source.getString("k_ALARMCLASS");
                    System.out.println(v4T);
                }
            }
        }
        return ResponseResult.success(data);
    }

    @Bean
    public EsTemplate esTemplate(){
        return new EsTemplate();
    }
}
