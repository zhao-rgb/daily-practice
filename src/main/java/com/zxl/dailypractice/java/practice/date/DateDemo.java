package com.zxl.dailypractice.java.practice.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

/**
 * @author zhao
 * @className DateDemo
 * @Description TODO
 * @Date 2022/4/6
 * @Version 1.0
 **/
public class DateDemo {
    public static void main(String[] args) throws ParseException {
        // Date转String
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = format.format(date);
        System.out.println(s);

        // String转Data
        System.out.println(format.parse(s));

        //java 8 以后
        //获取当前时间
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        System.out.println(year+","+month+","+day);

        //计算两个⽇期之间的天数和⽉数
        Period period = Period.between(LocalDate.of(2018, 1, 5),LocalDate.of(2018, 2, 5));
        System.out.println(period);

    }
}
