package com.zxl.dailypractice.card.three.august.august11;

import java.io.*;

/**
 * @author: zhaoxl
 * @date: 2023/8/11
 * @desc:
 **/
public class Solution {

    public static void main(String[] args) throws IOException {
        String inputFile = "D:\\my\\4.png";
        String my = "hello";
        String name = "syp.jpg";
        String fileKey = my + File.separator + name;

        try (FileInputStream inputStream = new FileInputStream(inputFile)) {
            uploadFileStream(inputStream, fileKey);
        }
    }

    public static void uploadFileStream(InputStream inputStream, String fileKey) throws IOException {
        String storageLocation = "D:\\works";
        String filePath = storageLocation + File.separator + fileKey;

        String filePath1 = filePath.substring(0, filePath.lastIndexOf(File.separator));
        System.out.println("Folder path: " + filePath1);

        File folder = new File(filePath1);
        if (!folder.exists()) {
            if (folder.mkdirs()) {
                System.out.println("Folder created successfully.");
            } else {
                System.out.println("Failed to create folder.");
            }
        }

        try (OutputStream outputStream = new FileOutputStream(filePath)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }
    }

}
