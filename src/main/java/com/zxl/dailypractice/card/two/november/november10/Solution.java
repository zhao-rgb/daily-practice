package com.zxl.dailypractice.card.two.november.november10;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: zhaoxl
 * @date: 2022/11/10
 * @desc:
 **/
public class Solution {
    public static void main(String[] args) {
//        List<Map<String, Object>> resultMapList = new ArrayList<Map<String, Object>>();
//        Map<String, Object> dataMap = new HashMap<String, Object>();
//        String colenname = "olt_devip,accessnum,olt_devname,bas_devname,bas_devip,bas_portname,vlanid,bandwidth,ipv4,ipv4_mask,ipv4_buss,ipv6,ipv6_mask,ipv6_buss";
//        String[] split = colenname.split(",");
//        String colcnname = "Olt设备IP,1,专线接入号,Olt设备名称,Bas/SR设备名称,Bas/SR设备IP,Bas/SR端口名称,带宽,Ipv4地址,Ipv4掩码,Ipv4业务地址,Ipv6地址,Ipv6掩码,Ipv6业务地址";
//        String[] split1 = colcnname.split(",");
//        if(split.length == split1.length){
//            for (int i = 0; i < split.length; i++) {
//                dataMap = new HashMap<String, Object>();
//                dataMap.put("colenname", split[i]);
//                dataMap.put("colcnname", split1[i]);
//                resultMapList.add(dataMap);
//            }
//        }else {
//            System.out.println("列表对应不了");
//        }
//        System.out.println(resultMapList);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date());
        System.out.println(format);
    }
}
