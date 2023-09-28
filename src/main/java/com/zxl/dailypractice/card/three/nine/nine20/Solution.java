package com.zxl.dailypractice.card.three.nine.nine20;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author: zhaoxl
 * @date: 2023/9/20
 * @desc:
 **/
public class Solution {
    public static void main(String[] args) {
//        String a = "22110121095307565000227280000920,23030231112846542000072031222209,23080122151108353000178700010016,23080122163311923000413700010010,23080122230057714000465700010013,23080122231519622000535700010015,23080122231645097000372700010015,23080122231811469000547700010011,23080122232531378000398700010018,23080122233637645000457700010014,23080123151555159000601700010011,23080129181555632000251700010015,23080129181743474000262700010016,23080130170739995000385700010011,23090113210608073000009280000922,23090114171433642000123280000926,23090119170648237000051280000929,23090119171608044000066280000922";
//        String[] split = a.split(",");
//        System.out.println(split.length);
//
//        List<String> parkIds = List.of("park1", "park2", "park3");
//
//        // 使用 String.join 将 List 中的元素转换为一个逗号分隔的字符串
//        String parkIdsString = String.join(",", parkIds);
//
//        System.out.println(parkIdsString);

//        double parkScoreSum = Double.parseDouble("5");
//        String utilizationSum = "25.6";
//        String turnoverSum = "0.13";
//        double parkingIndex = parkScoreSum / 5 * (Double.parseDouble("60")/100) +
//                (1 - Double.parseDouble(utilizationSum)/100 < 0 ? 0 : (1 - Double.parseDouble(utilizationSum)/100) * (Double.parseDouble("30")/100))
//                + Double.parseDouble(turnoverSum) * (Double.parseDouble("10")/100);
//        System.out.println(new DecimalFormat("#.##").format(parkingIndex));
//        System.out.println(1 - Double.parseDouble(utilizationSum)/100);
//        System.out.println((1 - Double.parseDouble(utilizationSum)/100) * (Double.parseDouble("30")/100));

//        double parkGap = Double.parseDouble("83.4");
//        System.out.println(String.valueOf(Math.round(parkGap)));
        String a = "0.005";
        System.out.println(Double.parseDouble(a));

        // 获取今天的日期
        LocalDate today = LocalDate.now();

        // 创建日期格式化器
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        // 格式化今天的日期
        String formattedDate = today.format(formatter);
        System.out.println(formattedDate);
    }
}
