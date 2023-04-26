package com.zxl.dailypractice.project.util;

import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.hssf.util.Region;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * @author: zhaoxl
 * @date: 2023/2/17
 * @desc:
 **/
public class ExcelPageUtils {
    /**
     * 支持分页和多表头
     * @param exprotList 导出的数据
     * @param titles 表头
     * @param sheetSize 每Sheet页数据量
     * @param filePath
     * @param fileName
     * @param response
     */
    public static void createExcel(List<List<String>> exprotList, String[] titles, int sheetSize,
                                   String filePath, String fileName, HttpServletResponse response){
        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = null;
        HSSFCellStyle style = null;
        for (int i = 0, index = 2,sheetIndex = 0; i < exprotList.size(); i++, index++) {
            if(i%sheetSize==0){
                sheetIndex++;
                // 生成一个表格
                sheet = workbook.createSheet("第"+sheetIndex+"页");
                style = setStyle(workbook,sheet,titles);
                index = 2;	//新建sheet页之后，index对应的行数要从第三行开始
            }
            HSSFRow row = sheet.createRow(index);
            for (int j = 0; j < exprotList.get(i).size(); j++) {
                HSSFCell cell = row.createCell(j);
                cell.setCellStyle(style);
                HSSFRichTextString richString = new HSSFRichTextString(exprotList.get(i).get(j));
                cell.setCellValue(richString);
            }
        }
        OutputStream out = null;
        InputStream myStream = null;
        try {
            File fileDir = new File(filePath);
            if (!fileDir.exists()) {// 判断目录是否存在
                fileDir.mkdirs();
            }
            String fileFullName = filePath + fileName;
            File file = new File(fileFullName);
            out = new FileOutputStream(file);
            workbook.write(out);
            if (response != null) {
                response.setContentType("application/vnd.ms-excel");
                response.setContentLength((int) file.length());
                String headerKey = "Content-Disposition";
                String headerValue = String.format("attachment; filename=\"%s\"", "" + fileName);
                response.setHeader(headerKey, headerValue);
                myStream = new FileInputStream(file);
                IOUtils.copy(myStream, response.getOutputStream());
                response.flushBuffer();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static HSSFCellStyle setStyle(HSSFWorkbook workbook,HSSFSheet sheet,String[] titles){
        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth(15);
        // 生成一个样式
        HSSFCellStyle style = workbook.createCellStyle();
        // 设置这些样式
        style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 生成一个字体
        HSSFFont font = workbook.createFont();
        font.setColor(HSSFColor.VIOLET.index);
        font.setFontHeightInPoints((short) 12);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 把字体应用到当前的样式
        style.setFont(font);
        // 生成并设置另一个样式
        HSSFCellStyle style2 = workbook.createCellStyle();
        style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
        style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        // 生成另一个字体
        HSSFFont font2 = workbook.createFont();
        font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        // 把字体应用到当前的样式
        style2.setFont(font2);
        // 产生表格标题行
        HSSFRow row = sheet.createRow(0);
        HSSFRow row2 = sheet.createRow(1);
        for(int i = 0, n = 0; i < titles.length; i++){//i是titles的索引，n是Excel的索引
            HSSFCell cell1 = row.createCell(n);
            cell1.setCellStyle(style);
            HSSFRichTextString text = null;
            if(titles[i].contains(":")){//双标题
                String[] temp = titles[i].split(":");
                text = new HSSFRichTextString(temp[0]);
                String[] tempSec = temp[1].split(",");
                sheet.addMergedRegion(new Region(0, (short) n, 0, (short) (n + tempSec.length -1)));
                int tempI = n;
                for(int j = 0; j < tempSec.length -1; j++){
                    HSSFCell cellT = row.createCell(++tempI);
                    cellT.setCellStyle(style);
                }
                for(int j = 0; j < tempSec.length; j++){
                    HSSFCell cell2 = row2.createCell(n++);
                    cell2.setCellStyle(style);
                    cell2.setCellValue(new HSSFRichTextString(tempSec[j]));
                }
            }else{//单标题
                HSSFCell cell2 = row2.createCell(n);
                cell2.setCellStyle(style);
                text = new HSSFRichTextString(titles[i]);
                sheet.addMergedRegion(new Region(0, (short) n, 1, (short) n));
                n++;
            }
            cell1.setCellValue(text);
        }
        return style2;
    }

    public static void createExcelNoresponse(List<List<String>> exprotList, String[] titles, int sheetSize,
                                             String filePath,String fileName){
        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = null;
        HSSFCellStyle style = null;
        for (int i = 0, index = 2,sheetIndex = 0; i < exprotList.size(); i++, index++) {
            if(i%sheetSize==0){
                sheetIndex++;
                // 生成一个表格
                sheet = workbook.createSheet("第"+sheetIndex+"页");
                style = setStyle(workbook,sheet,titles);
                index = 2;	//新建sheet页之后，index对应的行数要从第三行开始
            }
            HSSFRow row = sheet.createRow(index);
            for (int j = 0; j < exprotList.get(i).size(); j++) {
                HSSFCell cell = row.createCell(j);
                cell.setCellStyle(style);
                HSSFRichTextString richString = new HSSFRichTextString(exprotList.get(i).get(j));
                cell.setCellValue(richString);
            }
        }
        OutputStream out = null;
        InputStream myStream = null;
        try {
            File fileDir = new File(filePath);
            if (!fileDir.exists()) {// 判断目录是否存在
                fileDir.mkdirs();
            }
            String fileFullName = filePath + fileName;
            File file = new File(fileFullName);
            out = new FileOutputStream(file);
            workbook.write(out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
