package com.zxl.dailypractice.card.two.September.September20;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhaoxl
 * @date: 2022/9/20
 * @desc:
 **/
public class Solution {

    public static List<String> readCsvByBufferedReader(String filePath) {
        File csv = new File(filePath);
        csv.setReadable(true);
        csv.setWritable(true);
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            isr = new InputStreamReader(new FileInputStream(csv), "UTF-8");
            br = new BufferedReader(isr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String line = "";
        List<String> records = new ArrayList<>();
        try {
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                records.add(line);
            }
            System.out.println("csv表格读取行数：" + records.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }
    public static void main(String[] args) {
        List<String> strings = readCsvByBufferedReader("E:\\Unitehcs\\data.csv");
        System.out.println(strings);
    }
}
