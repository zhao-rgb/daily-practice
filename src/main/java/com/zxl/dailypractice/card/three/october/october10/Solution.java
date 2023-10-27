package com.zxl.dailypractice.card.three.october.october10;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: zhaoxl
 * @date: 2023/10/10
 * @desc:
 **/
public class Solution {
    public static void main(String[] args) {
        String logMessage = "2023-10-10 14:36:19.933 [TID: N/A] [XNIO-1 task-1] ERROR c.b.p.o.s.b.y.InformationReportAspect -parameterValues:EnterRecordModel(parkCode=222, parkId=, tenantId=, orderId=20231008070903261000001072016703, areaId=1, plate=苏CD90792, plateColor=0, channelId=2, authType=00, carType=00, enterTime=2023-10-10 10:55:55, enterImageName=https://img0.baidu.com/it/u=3663508195,2907650417&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500, enterEvent=00, dutyOfficer=赵肖龙, dutyOfficerId=1, source=00, authTypeId=auth_type_01, authTypeName=临停小车, authStatus=)";

        String parkCode = extractParkCode(logMessage);
        System.out.println("parkCode: " + parkCode);
    }

    public static String extractParkCode(String logMessage) {
        String regex = "parkCode=(\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(logMessage);

        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return null; // 如果未找到匹配的parkCode，返回null或适当的默认值
        }
    }
}
