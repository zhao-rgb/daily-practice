package com.zxl.dailypractice.card.three.october.october7;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Random;

/**
 * @author: zhaoxl
 * @date: 2023/10/7
 * @desc:
 **/
public class Solution {
    public static void main(String[] args) {
//        // 获取当前日期
//        Date currentDate = new Date();
//        // 创建 SimpleDateFormat 对象来格式化日期
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        // 格式化当前日期的开始时间
//        String enterStartTime = dateFormat.format(currentDate) + " 00:00:00";
//        // 格式化当前日期的结束时间
//        String enterEndTime = dateFormat.format(currentDate) + " 23:59:59";
//        System.out.println(enterStartTime);
        // 获取当前日期
//        LocalDate currentDate = LocalDate.now();
//
//        // 创建一个日期格式化器，用于将日期格式化为"yyyy-MM-dd"
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//
//        // 打印过去7天的日期
//        for (int i = 0; i < 7; i++) {
//            String formattedDate = currentDate.minusDays(i + 1).format(formatter);
//            System.out.println(formattedDate.replace("-", ""));
//        }
//
//
//        // 获取当前时间戳
//        long timestamp = System.currentTimeMillis();
//
//        // 打印当前时间戳
//        System.out.println("当前时间戳：" + timestamp);

        // 创建两个 BigDecimal 对象
        BigDecimal dividend = new BigDecimal("10.5");
        BigDecimal divisor = new BigDecimal("2.5");

        // 执行除法操作
        BigDecimal result = dividend.divide(divisor, 2, BigDecimal.ROUND_HALF_UP);

        // 输出结果
        System.out.println("Result of division: " + result);

        double v = 0.2;
        double b = 0.7;
        System.out.println(new DecimalFormat("#.##").format(8/7));
        System.out.println(String.valueOf(new Random().nextInt(131) + 20));
    }


}
