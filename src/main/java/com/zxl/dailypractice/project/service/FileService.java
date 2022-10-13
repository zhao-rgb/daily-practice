package com.zxl.dailypractice.project.service;

import com.zxl.dailypractice.project.util.FileReturn;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author: zhaoxl
 * @date: 2022/10/12
 * @desc:
 **/
public interface FileService {
    public FileReturn uploadFile(MultipartFile multipartFile);
}
