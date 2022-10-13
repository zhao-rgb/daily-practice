package com.zxl.dailypractice.project.service.Impl;

import com.zxl.dailypractice.project.service.FileService;
import com.zxl.dailypractice.project.util.FileReturn;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: zhaoxl
 * @date: 2022/10/12
 * @desc:
 **/
@Service
public class FileServiceImpl implements FileService {
    private static final Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    @Override
    public FileReturn uploadFile(MultipartFile multipartFile) {
        String filePath = "E:\\test";
        String fileName = String.valueOf(System.currentTimeMillis());
        File file = new File(filePath + File.separator + fileName);
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            IOUtils.copy(multipartFile.getInputStream(),fileOutputStream);
            System.out.println("===========file upload success=======");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
                logger.error("文件关闭错误",e);
            }
        }

        return new FileReturn<>(1,"文件上传成功",file);
    }
}
