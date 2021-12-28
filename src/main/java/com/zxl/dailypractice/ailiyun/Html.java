package com.zxl.dailypractice.ailiyun;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhao
 * @className Html
 * @Description TODO
 * @Date 2021/12/28
 * @Version 1.0
 **/
//HTML拆分   https://developer.aliyun.com/learning/course/20/detail/372?spm=a2c6h.21258778.0.0.189b11a6dXgboP
public class Html {
    public static void main(String[] args) {
        String str = "<font face=\"Arial,Serif\" size=\"+2\" color=\"red\">";
        String regex = "\\w+=\"[a-zA-Z0-9,\\+]+\"";
        Matcher matcher = Pattern.compile(regex).matcher(str);
        while (matcher.find()){
            String temp = matcher.group(0);
            String[] result = temp.split("=");
            System.out.println(result[0] +"\t"+result[1].replaceAll("\"",""));
        }
    }
}
