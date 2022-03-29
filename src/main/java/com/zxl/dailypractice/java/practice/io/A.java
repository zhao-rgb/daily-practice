package com.zxl.dailypractice.java.practice.io;

import java.io.*;
import java.util.HashMap;

/**
 * @author zhao
 * @className A
 * @Description TODO
 * @Date 2022/3/28
 * @Version 1.0
 **/
public class A {
    public static void findStringInFile(String path,String subString) throws IOException {
        File file = new File(path);
        InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(read);
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            if (line.contains(subString)) {
                System.out.println(line + "在文件中");
            }
        }
    }

    public static void hitRat() {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer,Integer>();
        for (int i = 0; i < 10; i++) {
            hashMap.put(i, (int) (Math.random()*10));
        }
        System.out.println(hashMap);
    }


}
