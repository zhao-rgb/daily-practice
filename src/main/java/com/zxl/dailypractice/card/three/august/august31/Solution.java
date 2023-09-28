package com.zxl.dailypractice.card.three.august.august31;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author: zhaoxl
 * @date: 2023/8/31
 * @desc:
 **/
@Slf4j
public class Solution {
    public static void main(String[] args) {
        postRequest("https://hsh-test.mideazy.com/api/service/service-md/add", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0aGlyZGFjY291bnQtaHRqIiwianRpIjoiMTIwNDgzIiwiaWF0IjoxNjkzNDc5OTEwfQ.wazjTD6UTIlBZiuM9V_xHbvPAxpTN90qQXXp1EKEXE0", "K0038", "佛山美的花湾城车场平台通讯连接中断，断开时间 2023-08-31 17:47:22", "wu");

    }

    public static String postRequest(String url, String token, String projectId, String remarks, String equipName) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            URIBuilder uriBuilder = new URIBuilder(url);

            JSONObject param = new JSONObject();
            param.put("isOwner", "1");
            param.put("type", "1");
            param.put("serviceClassTypeName", "工程");
            param.put("areaId", "1");
            param.put("ownerType", "2");
            param.put("projectId", projectId);
            param.put("addType", "4");
            param.put("remarks", remarks);
            param.put("orderSourceFrom", "110");
//            param.put("equipName", equipName);

            StringEntity stringEntity = new StringEntity(param.toString(), "UTF-8");

            HttpPost httpPost = new HttpPost(uriBuilder.build());
            httpPost.setEntity(stringEntity);
            httpPost.setHeader("Content-Type", "application/json");
            httpPost.setHeader("token", token);

            log.info("请求参数为: {}", param);

            HttpResponse response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            log.info("返回状态码: {}", statusCode);

            HttpEntity resEntity = response.getEntity();
            if (statusCode == HttpStatus.SC_OK && resEntity != null) {
                String responseJson = EntityUtils.toString(resEntity);
                JSONObject responseObject = JSONObject.parseObject(responseJson);
                String code = responseObject.getString("code");
                log.info("返回结果为: {}", responseJson);
                log.info("返回结果code为: {}", code);
                if ("succ".equals(code)) {
                    log.info("请求成功");
                    return code;
                } else {
                    log.info("请求失败");
                    return null;
                }
            } else {
                log.error("请求失败，状态码: {}", statusCode);
                if (resEntity != null) {
                    log.error("错误详情: {}", EntityUtils.toString(resEntity));
                }
                return null;
            }
        } catch (Exception e) {
            log.error("请求发生异常: {}", e.getMessage());
            return null;
        }
    }

}
