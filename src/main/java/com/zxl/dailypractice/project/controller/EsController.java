package com.zxl.dailypractice.project.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.unitechs.framework.elasticsearch.client.EsTemplate;
import com.unitechs.framework.elasticsearch.domain.request.QueryDocumentByDslRequest;
import com.unitechs.framework.elasticsearch.domain.response.QueryDocumentResponse;
import com.zxl.dailypractice.project.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author: zhaoxl
 * @date: 2022/10/14
 * @desc:
 **/
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

    @Bean
    public EsTemplate esTemplate(){
        return new EsTemplate();
    }
}
