package com.zxl.dailypractice.card.three.march.march2;

/**
 * @author: zhaoxl
 * @date: 2023/3/2
 * @desc:
 **/
public class Solution {
    public static void main(String[] args) {
        String indexName = "hh";
        String dd = "hh";
        String xx = "hh";
        String hh = "hh";
        String qq = "hh";
        String sql = "select * from " + indexName + " where t_ctime>= '"
                + dd + "'" + " and t_ctime<= '"+ xx + "'" + " and k_devid = '"+
                hh + "'" + " and k_domain = '"+ qq + "'" + " and k_itemcode = 'CPDomainUserNum' order by t_ctime limit 10000";
        System.out.println(sql);



        String sql1 = "select * from " + indexName + " where t_ctime>= '"
                + dd + "'" + " and t_ctime<= '"+ xx + "'" + " and k_devid = '"+
                hh + "'" + " and k_upid = '"+ qq + "'"+ " and k_domain = '"+ dd + "'"+ "and k_itemcode = 'UPDomainUserNum' order by t_ctime limit 10000";
        System.out.println(sql1);
    }
}
