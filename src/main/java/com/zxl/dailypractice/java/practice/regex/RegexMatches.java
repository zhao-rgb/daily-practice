package com.zxl.dailypractice.java.practice.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhao
 * @className RegexMatches
 * @Description TODO
 * @Date 2022/3/17
 * @Version 1.0
 **/
//正则  https://www.twle.cn/l/yufei/java/java-basic-regular-expressions.html
public class RegexMatches {
    private static String REGEX = "a*b";
    private static String INPUT = "aabfooaabfooabfoob";
    private static String REPLACE = "-";
    public static void main(String[] args) {
        Pattern p = Pattern.compile(REGEX);
        // 获取 matcher 对象
        Matcher m = p.matcher(INPUT);
        StringBuffer sb = new StringBuffer();
        while(m.find()){
            m.appendReplacement(sb,REPLACE);
        }
        m.appendTail(sb);
        System.out.println(sb.toString());
    }
}
