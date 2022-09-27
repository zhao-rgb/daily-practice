package com.zxl.dailypractice.card.two.September.September26;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: zhaoxl
 * @date: 2022/9/26
 * @desc:
 **/
public class Solution {
    public static void main(String[] args) {
        String alaid ="2,3,4";
        String[] ala =alaid.split(",");
        StringBuffer a=new StringBuffer();
        for(String id:ala){
            a.append("'").append(id).append("'").append(",");
        }
        String typeid=a.deleteCharAt(a.length() - 1).toString();
        System.out.println(typeid);

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String index = sdf.format(date);

        String alaSql = String.format("select k_RESID from pm_col_flux_%s "
                + "where k_NET = 'IPNET' and l_ALARMSTATUS = 1 and k_ALARMTYPEID in ("+typeid+") group by k_RESID limit 10000",index);
        System.out.println(alaSql);

        int alaNum = 10,tolNum = 30;
        float ratio =(float)alaNum/tolNum*100;
        DecimalFormat d=new DecimalFormat("0.00");
        String format = d.format(ratio);
        System.out.println(format);
    }
}
