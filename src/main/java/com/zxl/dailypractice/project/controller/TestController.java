package com.zxl.dailypractice.project.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zxl.dailypractice.project.exception.WformException;
import com.zxl.dailypractice.project.util.ObjectUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhaoxl
 * @date: 2022/10/21
 * @desc:
 **/
@RestController
@Slf4j
@Api(tags = "测试json")
public class TestController {

    // 是否大数据导出
    private static boolean moredataout = false;
    // 约定最大数据条数为大数据导出
    private static final int moredatalimit = 2500;
    private static final int limitoutdata = 65535;

    @ApiOperation("json")
    @PostMapping("/testJson")
    public String json(@RequestBody JSONObject obj){
        String filename = obj.getString("filename");
        System.out.println(filename);
        for (Object headers : obj.getJSONArray("headers")) {
            System.out.print(headers);
        }
        JSONArray data = obj.getJSONArray("data");
        for (int i = 0; i < data.size(); i++) {
            for (Object o : data.getJSONArray(i)) {
                System.out.println(o);
            }
        }

//        {
//            "filename": "流量流向全局矩阵统计",
//                "headers": ["本省IDC", "本省B2B-CDN", "本省OTT-CDN", "本省cache", "本省集客", "本省家客", "本省手机", "外省IDC", "外省集客", "外省家客", "外省手机", "外省其他", "外网", "国际", "汇总"],
//            "data": [
//		["本省IDC", "2.00", "3.00", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "5.00"],
//		["本省B2B-CDN", "4.00", "3.00", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "7.00"],
//		["本省OTT-CDN", "0", "0", "4", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "4.00"],
//		["本省cache", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0.00"],
//		["本省集客", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0.00"],
//		["本省家客", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0.00"],
//		["本省手机", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0.00"],
//		["外省IDC", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0.00"],
//		["外省集客", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0.00"],
//		["外省家客", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0.00"],
//		["外省手机", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0.00"],
//		["外省其他", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0.00"],
//		["外网", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0.00"],
//		["国际", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0.00"],
//		["汇总", "6.00", "6.00", "4.00", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", "16.00"]
//	],
//            "color": "rgba(231, 60, 17, 1)",
//                "value": "3.1"
//        }
        return null;
    }

    @RequestMapping(value = "/GlobalFlowMatrixExport", method = RequestMethod.POST)
    @ResponseBody
    public void globalFlowMatrixExport(HttpServletRequest request,
                                       HttpServletResponse response,
                                       @RequestBody JSONObject obj) throws Exception{
        String filename = obj.getString("filename"); //excel文件名称
        String headers = obj.getString("headers");
        String data = obj.getString("data");
        String color = obj.getString("color");
        String value = obj.getString("value");
        String webappPath = request.getSession().getServletContext().getRealPath("/");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("headers", headers);
        map.put("data",data);
        map.put("color",color);
        map.put("value",value);
        map.get("headers");
        int datalength = 16;
        try {
            File f = matrixExport(webappPath,filename,0,datalength , map);
            downLoadFile(f, f.getName(), response, null);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            log.error("程序出现异常",e);;
        }
    }

    public File matrixExport(String webappPath,String wintitle, Integer start, Integer limit, Map<String, Object> map) {

        if (limit > limitoutdata) {
            throw new WformException("你导出的EXCEL数据条数大于" + limitoutdata
                    + "条,最大只能导出：" + limitoutdata + "条数据!");
        }
        // 如果已经有人在下载大文件的EXCEL 那么就通知 等待一段时间后再下载
        if (limit > moredatalimit && moredataout) {
            throw new WformException(
                    "有人正在导出大数据Excel,请等待20-30秒后再导出。或者减小导出数据条数到" + moredatalimit);
        } else if (limit > moredatalimit) {
            moredataout = true;
        }

        try {
            File file = new File(webappPath+File.separator+"excel");
            log.info(file.getAbsolutePath());
            if(!file.exists()){
                file.mkdirs();
            }
            String filename = webappPath+File.separator+"excel"+File.separator+wintitle + ".xlsx";
            StringBuffer filepath = new StringBuffer();
            filepath.append(filename);
            try(XSSFWorkbook wwb = new XSSFWorkbook() ) {
                Sheet ws = wwb.createSheet("sheet1");
                String header = ((String) map.get("headers")).substring(1, ((String) map.get("headers")).length()-1);
                String replace = header.replace("\"", "");
                String[] split = replace.split(",");
                int row = 0;
                //第一行数据
                if(null!=split) {
                    ws.createRow(row);
                    for (int i=0;i<split.length;i++) {
                        ws.getRow(0).createCell(0).setCellValue("目的\\源");
                        ws.getRow(row).createCell(i+1).setCellValue(split[i]);
                    }
                }
                String data = ((String) map.get("data")).substring(1, ((String) map.get("data")).length()-1);
                String replace1 = data.replace("[", "")
                        .replace("]", "")
                        .replace("\"","")
                        .replace("\"\"","0");
                String[] dataArray = replace1.split(",");
                if(null!=dataArray) {
                    for (int i = 0; i < 15; i++) {
                        row++;
                        ws.createRow(row);
                        for (int j = 0; j < 16; j++) {
                            ws.getRow(row).createCell(j).setCellValue(dataArray[i*16+j]);
                            //配置颜色  https://www.nuomiphp.com/eplan/20185.html
                            String color1 = (String) map.get("color");
                            String replace2 = color1.replace("rgba(", "")
                                    .replace(")", "")
                                    .replace(" ","");
                            String[] color = replace2.split(",");
                            if (i!=14 && j!=15 && j!=0){
                                double value = Double.parseDouble((String) map.get("value"));
                                double i1 = Double.parseDouble(dataArray[i*16+j]);
                                if (i1>value){
                                    Cell cell =  ws.getRow(row).getCell(j);
                                    CellStyle style = wwb.createCellStyle();
                                    XSSFColor colors = new XSSFColor(new java.awt.Color(
                                            Integer.parseInt(color[0])
                                            , Integer.parseInt(color[1])
                                            , Integer.parseInt(color[2])));
                                    ((XSSFCellStyle) style).setFillForegroundColor(colors);
                                    style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
                                    cell.setCellStyle(style);
                                }
                            }
                        }
                    }
                }
                File f = new File(filename);
                FileOutputStream out = new FileOutputStream(filename);
                wwb.write(out);
                out.close();
                // 关闭Excel工作薄对象
                wwb.close();
                return f;
            } catch (Exception e) {
                log.info("Excel导出出错[{}]",e);
                return null;
            }
        } catch (Exception e) {
            throw new WformException("导出Excel出错!");
        } finally {
            if (limit > moredatalimit && moredataout) {
                moredataout = false;
            }
        }
    }

    public static void downLoadFile(File file, String fileName,
                                    HttpServletResponse response, String downType)
            throws WformException {
        if (ObjectUtil.isEmpty(file)) {
            throw new WformException("文件下载不存在!");
        }
        // application/msword word
        // application/pdf pdf
        // application/vnd.ms-excel" excel
        if (ObjectUtil.isEmpty(downType)) {
            downType = "application/x-download";
        }
        response.setContentType(downType);
        FileInputStream fis = null;
        ServletOutputStream out = null;
        try {
            // 文件名称编码
            String formName = URLEncoder.encode(fileName, "UTF-8");
            response.addHeader("Content-Disposition", "attachment;filename=" + formName);
            if (file.exists()){
                fis = new FileInputStream(file);
                byte[] in_ = new byte[1024];
                try {
                    out = response.getOutputStream();
                    int c;
                    while ((c = fis.read(in_)) != -1) {
                        out.write(in_, 0, c);
                    }

                } catch (IOException e) {
                    throw new WformException("文件下载失败!");
                }
            }

        } catch (FileNotFoundException e) {
            throw new WformException("文件不存在!");
        } catch (Exception e1) {
            throw new WformException("文件下载失败!");
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    log.error("关闭FileInputStream异常", e);
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    log.error("关闭ServletOutputStream异常", e);
                }
            }
        }
    }
}
