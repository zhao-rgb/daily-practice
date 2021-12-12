package com.zxl.dailypractice.commonClass.Date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhao
 * @className DateDemo
 * @Description TODO
 * @Date 2021/12/4
 * @Version 1.0
 **/
//Date 编程实例     https://www.lanqiao.cn/courses/1230/learning/?id=9468
public class DateDemo {
    public static void main(String[] args) {
        String strDate,strTime;
        Date objDate = new Date();
        System.out.println("今天的日期是：" + objDate);
        long time = objDate.getTime();
        System.out.println("自1970年1月1日起以毫秒为单位的时间（GMT）：" + time);
        strDate = objDate.toString();
        //提取 GMT 时间
        strTime = strDate.substring(11,(strDate.length() - 4 ));
        //按小时、分钟和秒提取时间
        strTime = "时间：" + strTime.substring(0, 8);
        System.out.println(strTime);
        //格式化时间
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(objDate));
    }
}
