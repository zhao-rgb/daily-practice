package com.zxl.dailypractice.card.two.September.September27;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;

/**
 * @author: zhaoxl
 * @date: 2022/9/27
 * @desc:
 **/
public class Solution {
    public static void main(String[] args) throws Exception {
        String fileContent = "hhw2sj2s22si2s";
        String filePath ="/files/";
        String fileName = ".txt";
        saveFile(fileContent.getBytes(),filePath,fileName);
        File file = new File(filePath + fileName);
        MultipartFile cMultiFile = getMultipartFile(file);
        System.out.println(cMultiFile);
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

    public static MultipartFile getMultipartFile(File file) {
        FileItem item = new DiskFileItemFactory().createItem("file"
                , MediaType.MULTIPART_FORM_DATA_VALUE
                , true
                , file.getName());
        try (InputStream input = new FileInputStream(file);
             OutputStream os = item.getOutputStream()) {
            // 流转移
            IOUtils.copy(input, os);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid file: " + e, e);
        }

        return new CommonsMultipartFile(item);
    }
}
