package com.zxl.dailypractice.card.two.october.october10;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: zhaoxl
 * @date: 2022/10/9
 * @desc:
 **/
@Slf4j
public class Solution {
    public static void main(String[] args) {
        Student student = new Student();
//        student.setTaskid("1");
//        student.setSeq(2);
//        student.setOriginalFileName("/len");
//
//        StuResp stuResp = new StuResp();
//        BeanUtils.copyProperties(student,stuResp);
//        stuResp.setFileDownloadUrl("hhhh");
//        System.out.println(stuResp);
//        System.out.println(stuResp.getTaskid());
//        String a = "";
//        if (StringUtils.isNotBlank(a)){
//            System.out.println("jj");
//        }
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
//        String format = sdf.format(new Date());
//        System.out.println(format);


        String cfgdeployBody = getCfgdeployBody(student);
        System.out.println(cfgdeployBody);

    }

    public static String getCfgdeployBody(Student student) {

        String paradef = "2s2";
        log.info("paradef={}", paradef);



        System.out.println(paradef);
        String body = "2";
        String code = "";
        String key = "";
        if (StringUtils.isNotBlank(paradef)) {
            body += "\"" + key + "\"" + ":\"" + dealNullStr(code) + "\",";
            if (body == null){
                body = body.substring(0, body.length() - 1);   //去掉末尾的逗号,
                return body;
            }
        }
        return "body2s2s2";
    }

    public static String dealNullStr(String str) {
        return StringUtils.isBlank(str) ? "" : str;
    }
}
