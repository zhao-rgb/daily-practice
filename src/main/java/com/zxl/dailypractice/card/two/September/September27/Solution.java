package com.zxl.dailypractice.card.two.September.September27;


import com.zxl.dailypractice.card.two.September.September28.MultipartFileDto;
import org.apache.http.entity.ContentType;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author: zhaoxl
 * @date: 2022/9/27
 * @desc:
 **/
//生成文件
public class Solution {
    public static void main(String[] args) throws Exception {
        System.getProperty("user.home");
        String fileContent = "xxx";
        String filePath = System.getProperty("user.dir") +"/files/";
        String fileName = "dd.txt";
        saveFile(fileContent.getBytes(),filePath,fileName);
        File excelFile = new File(filePath + fileName);
        FileInputStream fileInputStream = new FileInputStream(excelFile);
        MultipartFile multipartFile = new MultipartFileDto(filePath,
                filePath,
                ContentType.APPLICATION_OCTET_STREAM.toString(),
                fileInputStream);
        System.out.println(multipartFile.getSize());

    }

    public static void saveFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
    }

}
