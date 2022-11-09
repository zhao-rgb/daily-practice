package com.zxl.dailypractice.project.util;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @author liwen
 * @since 2019/6/18
 */
public class FileUtil{

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

    public static boolean exists(String fileFullPath) {
        return (new File(fileFullPath)).exists();
    }

    public static void saveFileDoNotCloseStream(InputStream inputStream,String filePath, String fileName) throws Exception {
    	File file=new File(filePath+fileName);
    	FileUtils.copyInputStreamToFile(inputStream,file);
    }
}
