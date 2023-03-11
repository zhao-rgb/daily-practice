package com.zxl.dailypractice.project.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.unitechs.framework.elasticsearch.client.EsTemplate;
import com.unitechs.framework.elasticsearch.domain.request.QueryDocumentByDslRequest;
import com.unitechs.framework.elasticsearch.domain.request.QueryDocumentRequest;
import com.unitechs.framework.elasticsearch.domain.response.QueryDocumentResponse;
import com.zxl.dailypractice.card.three.february.february27.GetVBASUserDataResp;
import com.zxl.dailypractice.project.constant.ResourceConstant;
import com.zxl.dailypractice.project.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

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
        int pageNum = 1;
        int pageSize = 8;
        int startNumNew = pageSize * (pageNum-1);
        int pageSizeNew = pageSize;
        if(pageNum==1){//第一页时
            pageSizeNew = pageSize;
        }else{
            startNumNew = startNumNew-1;
        }
        System.out.println("--------------startNumNew="+startNumNew+",pageSizeNew="+pageSizeNew);
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String now = time.format(formatter);
        String indexName = "pm_col_brasippool" + now;
        String sql = "select * from " + indexName + " limit " + startNumNew + "," + pageSizeNew;
        log.info("===============sql语句为：" + sql);

        indexName = "am_ala_alarmsummary_*";
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
                    String v4T = source.getString("k_CORRELATION_FLAG");
                    System.out.println(v4T);
                }
            }
        }
        return ResponseResult.success(data);
    }


    @ApiOperation("ES测试1")
    @RequestMapping(value = "/test/es1",method = RequestMethod.POST)
    public ResponseResult testes1(HttpServletResponse response) throws Exception{
        String data = "{\n" +
                "\t\"took\": 12,\n" +
                "\t\"timed_out\": false,\n" +
                "\t\"_shards\": {\n" +
                "\t\t\"total\": 2,\n" +
                "\t\t\"successful\": 2,\n" +
                "\t\t\"skipped\": 0,\n" +
                "\t\t\"failed\": 0\n" +
                "\t},\n" +
                "\t\"hits\": {\n" +
                "\t\t\"total\": 94,\n" +
                "\t\t\"max_score\": 0.0,\n" +
                "\t\t\"hits\": [{\n" +
                "\t\t\t\"_index\": \"pm_col_vbras_userstatics_20230227\",\n" +
                "\t\t\t\"_type\": \"_doc\",\n" +
                "\t\t\t\"_id\": \"H0F4joYBSGy_8rwqVAG3\",\n" +
                "\t\t\t\"_score\": 0.0,\n" +
                "\t\t\t\"_source\": {\n" +
                "\t\t\t\t\"k_devid\": \"bbf0173b-621c-11ec-9245-002590c110c8\",\n" +
                "\t\t\t\t\"t_ctime\": \"2023-02-27 00:00:00\",\n" +
                "\t\t\t\t\"t_rtime\": \"2023-02-27 00:01:45\",\n" +
                "\t\t\t\t\"k_itemcode\": \"CPUserTypeDomainUserNum\",\n" +
                "\t\t\t\t\"k_domain\": \"internet\",\n" +
                "\t\t\t\t\"k_usertype\": \"pppox\",\n" +
                "\t\t\t\t\"k_upid\": \"\",\n" +
                "\t\t\t\t\"s_usernum\": \"807362\",\n" +
                "\t\t\t\t\"d_usernum\": \"807362\"\n" +
                "\t\t\t}\n" +
                "\t\t}, {\n" +
                "\t\t\t\"_index\": \"pm_col_vbras_userstatics_20230227\",\n" +
                "\t\t\t\"_type\": \"_doc\",\n" +
                "\t\t\t\"_id\": \"IkSLjoYBSGy_8rwqjnR6\",\n" +
                "\t\t\t\"_score\": 0.0,\n" +
                "\t\t\t\"_source\": {\n" +
                "\t\t\t\t\"k_devid\": \"bbf0173b-621c-11ec-9245-002590c110c8\",\n" +
                "\t\t\t\t\"t_ctime\": \"2023-02-27 00:20:00\",\n" +
                "\t\t\t\t\"t_rtime\": \"2023-02-27 00:22:43\",\n" +
                "\t\t\t\t\"k_itemcode\": \"CPUserTypeDomainUserNum\",\n" +
                "\t\t\t\t\"k_domain\": \"internet\",\n" +
                "\t\t\t\t\"k_usertype\": \"pppox\",\n" +
                "\t\t\t\t\"k_upid\": \"\",\n" +
                "\t\t\t\t\"s_usernum\": \"807196\",\n" +
                "\t\t\t\t\"d_usernum\": \"807196\"\n" +
                "\t\t\t}\n" +
                "\t\t}, {\n" +
                "\t\t\t\"_index\": \"pm_col_vbras_userstatics_20230227\",\n" +
                "\t\t\t\"_type\": \"_doc\",\n" +
                "\t\t\t\"_id\": \"3UWTjoYBSGy_8rwqex5u\",\n" +
                "\t\t\t\"_score\": 0.0,\n" +
                "\t\t\t\"_source\": {\n" +
                "\t\t\t\t\"k_devid\": \"bbf0173b-621c-11ec-9245-002590c110c8\",\n" +
                "\t\t\t\t\"t_ctime\": \"2023-02-27 00:30:00\",\n" +
                "\t\t\t\t\"t_rtime\": \"2023-02-27 00:31:31\",\n" +
                "\t\t\t\t\"k_itemcode\": \"CPUserTypeDomainUserNum\",\n" +
                "\t\t\t\t\"k_domain\": \"internet\",\n" +
                "\t\t\t\t\"k_usertype\": \"pppox\",\n" +
                "\t\t\t\t\"k_upid\": \"\",\n" +
                "\t\t\t\t\"s_usernum\": \"807137\",\n" +
                "\t\t\t\t\"d_usernum\": \"807137\"\n" +
                "\t\t\t}\n" +
                "\t\t}, {\n" +
                "\t\t\t\"_index\": \"pm_col_vbras_userstatics_20230227\",\n" +
                "\t\t\t\"_type\": \"_doc\",\n" +
                "\t\t\t\"_id\": \"Aku4joYBSGy_8rwqJ2Qh\",\n" +
                "\t\t\t\"_score\": 0.0,\n" +
                "\t\t\t\"_source\": {\n" +
                "\t\t\t\t\"k_devid\": \"bbf0173b-621c-11ec-9245-002590c110c8\",\n" +
                "\t\t\t\t\"t_ctime\": \"2023-02-27 01:10:00\",\n" +
                "\t\t\t\t\"t_rtime\": \"2023-02-27 01:11:36\",\n" +
                "\t\t\t\t\"k_itemcode\": \"CPUserTypeDomainUserNum\",\n" +
                "\t\t\t\t\"k_domain\": \"internet\",\n" +
                "\t\t\t\t\"k_usertype\": \"pppox\",\n" +
                "\t\t\t\t\"k_upid\": \"\",\n" +
                "\t\t\t\t\"s_usernum\": \"807732\",\n" +
                "\t\t\t\t\"d_usernum\": \"807732\"\n" +
                "\t\t\t}\n" +
                "\t\t}, {\n" +
                "\t\t\t\"_index\": \"pm_col_vbras_userstatics_20230227\",\n" +
                "\t\t\t\"_type\": \"_doc\",\n" +
                "\t\t\t\"_id\": \"ik7KjoYBSGy_8rwqimc5\",\n" +
                "\t\t\t\"_score\": 0.0,\n" +
                "\t\t\t\"_source\": {\n" +
                "\t\t\t\t\"k_devid\": \"bbf0173b-621c-11ec-9245-002590c110c8\",\n" +
                "\t\t\t\t\"t_ctime\": \"2023-02-27 01:30:00\",\n" +
                "\t\t\t\t\"t_rtime\": \"2023-02-27 01:31:37\",\n" +
                "\t\t\t\t\"k_itemcode\": \"CPUserTypeDomainUserNum\",\n" +
                "\t\t\t\t\"k_domain\": \"internet\",\n" +
                "\t\t\t\t\"k_usertype\": \"pppox\",\n" +
                "\t\t\t\t\"k_upid\": \"\",\n" +
                "\t\t\t\t\"s_usernum\": \"809008\",\n" +
                "\t\t\t\t\"d_usernum\": \"809008\"\n" +
                "\t\t\t}\n" +
                "\t\t}, {\n" +
                "\t\t\t\"_index\": \"pm_col_vbras_userstatics_20230227\",\n" +
                "\t\t\t\"_type\": \"_doc\",\n" +
                "\t\t\t\"_id\": \"V03CjoYBSGy_8rwqVkZU\",\n" +
                "\t\t\t\"_score\": 0.0,\n" +
                "\t\t\t\"_source\": {\n" +
                "\t\t\t\t\"k_devid\": \"bbf0173b-621c-11ec-9245-002590c110c8\",\n" +
                "\t\t\t\t\"t_ctime\": \"2023-02-27 01:20:00\",\n" +
                "\t\t\t\t\"t_rtime\": \"2023-02-27 01:22:31\",\n" +
                "\t\t\t\t\"k_itemcode\": \"CPUserTypeDomainUserNum\",\n" +
                "\t\t\t\t\"k_domain\": \"internet\",\n" +
                "\t\t\t\t\"k_usertype\": \"pppox\",\n" +
                "\t\t\t\t\"k_upid\": \"\",\n" +
                "\t\t\t\t\"s_usernum\": \"808388\",\n" +
                "\t\t\t\t\"d_usernum\": \"808388\"\n" +
                "\t\t\t}\n" +
                "\t\t}, {\n" +
                "\t\t\t\"_index\": \"pm_col_vbras_userstatics_20230227\",\n" +
                "\t\t\t\"_type\": \"_doc\",\n" +
                "\t\t\t\"_id\": \"DFXujoYBSGy_8rwq3v0a\",\n" +
                "\t\t\t\"_score\": 0.0,\n" +
                "\t\t\t\"_source\": {\n" +
                "\t\t\t\t\"k_devid\": \"bbf0173b-621c-11ec-9245-002590c110c8\",\n" +
                "\t\t\t\t\"t_ctime\": \"2023-02-27 02:10:00\",\n" +
                "\t\t\t\t\"t_rtime\": \"2023-02-27 02:11:31\",\n" +
                "\t\t\t\t\"k_itemcode\": \"CPUserTypeDomainUserNum\",\n" +
                "\t\t\t\t\"k_domain\": \"internet\",\n" +
                "\t\t\t\t\"k_usertype\": \"pppox\",\n" +
                "\t\t\t\t\"k_upid\": \"\",\n" +
                "\t\t\t\t\"s_usernum\": \"810146\",\n" +
                "\t\t\t\t\"d_usernum\": \"810146\"\n" +
                "\t\t\t}\n" +
                "\t\t}, {\n" +
                "\t\t\t\"_index\": \"pm_col_vbras_userstatics_20230227\",\n" +
                "\t\t\t\"_type\": \"_doc\",\n" +
                "\t\t\t\"_id\": \"EFf3joYBSGy_8rwq8XTk\",\n" +
                "\t\t\t\"_score\": 0.0,\n" +
                "\t\t\t\"_source\": {\n" +
                "\t\t\t\t\"k_devid\": \"bbf0173b-621c-11ec-9245-002590c110c8\",\n" +
                "\t\t\t\t\"t_ctime\": \"2023-02-27 02:20:00\",\n" +
                "\t\t\t\t\"t_rtime\": \"2023-02-27 02:21:27\",\n" +
                "\t\t\t\t\"k_itemcode\": \"CPUserTypeDomainUserNum\",\n" +
                "\t\t\t\t\"k_domain\": \"internet\",\n" +
                "\t\t\t\t\"k_usertype\": \"pppox\",\n" +
                "\t\t\t\t\"k_upid\": \"\",\n" +
                "\t\t\t\t\"s_usernum\": \"810008\",\n" +
                "\t\t\t\t\"d_usernum\": \"810008\"\n" +
                "\t\t\t}\n" +
                "\t\t}, {\n" +
                "\t\t\t\"_index\": \"pm_col_vbras_userstatics_20230227\",\n" +
                "\t\t\t\"_type\": \"_doc\",\n" +
                "\t\t\t\"_id\": \"OVgBj4YBSGy_8rwqa_0F\",\n" +
                "\t\t\t\"_score\": 0.0,\n" +
                "\t\t\t\"_source\": {\n" +
                "\t\t\t\t\"k_devid\": \"bbf0173b-621c-11ec-9245-002590c110c8\",\n" +
                "\t\t\t\t\"t_ctime\": \"2023-02-27 02:30:00\",\n" +
                "\t\t\t\t\"t_rtime\": \"2023-02-27 02:31:48\",\n" +
                "\t\t\t\t\"k_itemcode\": \"CPUserTypeDomainUserNum\",\n" +
                "\t\t\t\t\"k_domain\": \"internet\",\n" +
                "\t\t\t\t\"k_usertype\": \"pppox\",\n" +
                "\t\t\t\t\"k_upid\": \"\",\n" +
                "\t\t\t\t\"s_usernum\": \"810198\",\n" +
                "\t\t\t\t\"d_usernum\": \"810198\"\n" +
                "\t\t\t}\n" +
                "\t\t}]\n" +
                "\t}\n" +
                "}";
        List<GetVBASUserDataResp> resp = new ArrayList<>();
        JSONObject object = JSONObject.parseObject(data);
        JSONObject hits = (JSONObject) object.get("hits");
        JSONArray array = hits.getJSONArray("hits");
        if (array != null && array.size() > 0){
            Map<Object, Integer> timeMap = new HashMap<>();
            for (int i = 0;i < array.size();i++){
                JSONObject source = ((JSONObject) array.get(i)).getJSONObject("_source");
                GetVBASUserDataResp getVBASUserDataResp = new GetVBASUserDataResp();
                if (!source.isEmpty()){
                    String t_ctime = source.getString("t_ctime");
                    String userNum = source.getString("s_usernum");
                    if("user".equals("user")){
                        if (timeMap.containsKey(t_ctime)){
                            timeMap.put(t_ctime,timeMap.get(t_ctime) + Integer.parseInt(userNum));
                        }else {
                            timeMap.put(t_ctime,Integer.parseInt(userNum));
                        }
                    } else {
                        getVBASUserDataResp.setColTime(t_ctime);
                        getVBASUserDataResp.setUserNum(userNum);
                        resp.add(getVBASUserDataResp);
                    }

                }
            }
            if (timeMap.size() != 0){
                for (Object key : timeMap.keySet()) {
                    GetVBASUserDataResp getVBASUserDataResp = new GetVBASUserDataResp();
                    getVBASUserDataResp.setColTime(key.toString());
                    getVBASUserDataResp.setUserNum(String.valueOf(timeMap.get(key)));
                    resp.add(getVBASUserDataResp);
                }
            }
        }

        //返回格式
        JSONObject retrunJson = new JSONObject();
        retrunJson.put("pageSize","pageSize");
        retrunJson.put("pageNum","pageNum");
        retrunJson.put("records",resp);
        int total;
        if(array == null){
            total = 0;
        } else {
            total = Integer.parseInt(hits.getString("total"));
        }
        retrunJson.put("total",total);
        System.out.println(retrunJson);

        //数据
        List<GetVBASUserDataResp> resp1 = new ArrayList<>();
        Object obj = retrunJson.get("records");
        if (obj instanceof List<?>){
            for (Object o : (List<?>) obj){
                resp1.add((GetVBASUserDataResp) o);
            }
        }
        System.out.println("resp数据为："+ resp1);
        Workbook workbook = exportVBASUserListWorkBook(resp);
        String filePath = ResourceConstant.FILE_PATH_RES;
        System.out.println("当前路径为：" + filePath);
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String sysdate = new SimpleDateFormat(ResourceConstant.TIME_FORMAT_BUNCH.YYYYMMDDHHMISS.value).format(new Date());
        String fileName = "exportVBASUserList_" + sysdate + "_" + uuid + ".xls";
        exportToExcel(filePath, fileName,workbook, response);
        return ResponseResult.success(data);
    }

    public static Workbook exportVBASUserListWorkBook(List<GetVBASUserDataResp> som) throws Exception {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("用户数趋势列表导出服务");
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setFontHeightInPoints((short) 11);
        font.setFontName("宋体");
        style.setFont(font);
        //标题
        HSSFRow head = sheet.createRow(0);
        String title = "采集时间,用户数";
        String[] split = title.split(",");
        for (int j = 0; j < split.length; j++) {
            HSSFCell cell = head.createCell(j);
            cell.setCellStyle(style);
            cell.setCellValue(split[j]);
            sheet.setColumnWidth(j, 5000);
        }
        for (int i = 1; i < som.size()+1; i++) {
            head = sheet.createRow(i);
            Field[] fields = som.get(i-1).getClass().getDeclaredFields();
            for (int j = 0; j < fields.length; j++) {
                fields[j].setAccessible(true);
                //获取字段名称
                String value = fields[j].get(som.get(i-1)).toString();
                HSSFCell cell = head.createCell(j);
                cell.setCellStyle(style);
                cell.setCellValue(value);
                sheet.setColumnWidth(j, 5000);
            }
        }
        return workbook;
    }
    public static void exportToExcel(String filePath, String fileName, Workbook workbook,
                                     HttpServletResponse response) throws Exception {
        OutputStream ops = null;
        InputStream myStream=null;
        File downloadFile =null;
        try {
            File fileDir=new File(filePath);
            if (!fileDir.exists()) {// 判断目录是否存在
                fileDir.mkdirs();
            }
            String fileFullName = filePath + fileName;
            downloadFile = new File(fileFullName);
            ops = new FileOutputStream(downloadFile);
            if(workbook==null) {
                throw new Exception("workbook为空");
            }
            workbook.write(ops);
            response.setContentType("application/vnd.ms-excel");
            response.setContentLength((int) downloadFile.length());
            String headerKey = "Content-Disposition";
            String headerValue = String.format("attachment; filename=\"%s\"", "" + fileName);
            response.setHeader(headerKey, headerValue);
            myStream= new FileInputStream(downloadFile);
            IOUtils.copy(myStream, response.getOutputStream());
            response.flushBuffer();
        } catch (Exception e) {
            log.error("exportToExcel方法异常",e);
        } finally {
            if(myStream!=null) {
                try {
                    myStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(ops!=null) {
                ops.close();
            }
        }
    }

    @Bean
    public EsTemplate esTemplate(){
        return new EsTemplate();
    }
}
