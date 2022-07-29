package com.zxl.dailypractice.promblem.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.HashMap;

/**
 * @author: zhaoxl
 * @date: 2022/7/27
 * @desc:
 **/
public class MyJson {
    public static void main(String[] args) {

        //自定义JSON字符串
        String json = "{\"name\":\"卢本伟\",\"age\":24,\"语录\":[{\"骚话1\":\"可以，不跟你多bb\",\"骚话2\":\"表面兄弟\"},{\"骚话3\":\"卢本伟牛逼\",\"骚话4\":\"给阿姨倒一杯卡布奇诺\"}]}";

        //JSON字符串转换成JSONObject对象
        JSONObject jo = JSON.parseObject(json);
        System.out.println("初始JSONObject:\n" + jo + "\n");

        //JSONObject对象取得some对应的JSONArray数组
        JSONArray jsarr = jo.getJSONArray("语录");
        System.out.println("JSONObject里面的JSONArray:\n" + jsarr + "\n");

        //JSONArray对象通过getJSONObject(index)方法取得数组里面的JSONObject对象
        JSONObject ao = jsarr.getJSONObject(0);
        System.out.println("JSONObject里面的JSONArray里面的第一个JSONObject：\n" + ao + "\n");

        //JSONobject对象通过key直接取得String的值
        String str = ao.getString("骚话1");
        System.out.println("JSONObject里面的JSONArray里面的第一个JSONObject里的键值对对Key取值：\n" + str + "\n");

        System.out.println("=====================JSON字符串转换成map=========================");
        //Json字符串转换成map
        HashMap<String, Object> map = JSON.parseObject(String.valueOf(jo), new TypeReference<HashMap<String, Object>>() {});
        System.out.println(map.get("语录"));
        System.out.println(map.get("name"));
//        List<Student> list=new ArrayList<>();
//        Student student=new Student("bob",24);
//        Student student12=new Student("lily", 23);
//        list.add(student);
//        list.add(student12);
//        System.out.println("*******javaBean  to jsonString*******");
//        String str1= JSON.toJSONString(student);
//        System.out.println(str1);
//        System.out.println(list);
//        System.out.println(JSON.toJSONString(list));
//        System.out.println("--------------");
//
//        System.out.println("******jsonString to javaBean*******");
//        //Student stu1=JSON.parseObject(str1,new TypeReference<Student>(){});
//        Student stu1=JSON.parseObject(str1,Student.class);
//        System.out.println(stu1);
//        System.out.println("--------------");
//
//        System.out.println("******javaBean to jsonObject******");
//        JSONObject jsonObject1=(JSONObject)JSON.toJSON(student);
//        System.out.println(jsonObject1.getString("name"));
//        System.out.println();
////
////        System.out.println("******jsonObject to javaBean******");
////        Student student2=JSON.toJavaObject(jsonObject1, Student.class);
////        System.out.println(student2);
////        System.out.println();
////
//        System.out.println("*******javaBean to jsonArray******");
//        List<Student> stulist=new ArrayList<>();
//        for(int i=0;i<5;i++){
//            stulist.add(new Student("student"+i, i));
//
//        }
//        JSONArray jsonArrays=(JSONArray)JSON.toJSON(stulist);
//        for(int i=0;i<jsonArrays.size();i++){
//            System.out.println(jsonArrays.getJSONObject(i));
//        }
//        System.out.println("-----------");
//
//        System.out.println("*****jsonArry to javalist******");
//        List<Student> myList=new ArrayList<>();
//        for(int i=0;i<jsonArrays.size();i++){
//
//            Student student3=JSON.toJavaObject(jsonArrays.getJSONObject(i), Student.class);
//            myList.add(student3);
//        }
//        for(Student stu:myList){
//            System.out.println(stu);
//        }
//        System.out.println("-------------");
////
////        System.out.println("*****jsonObject to jsonString*****");
////        String str4=JSON.toJSONString(jsonObject1);
////        System.out.println(str4);
////        System.out.println();
////
////        System.out.println("*******jsonString to jsonObject*****");
////        JSONObject jso1=JSON.parseObject(str1);
////        System.out.println(jso1.getString("name"));
////        System.out.println();
////
//        System.out.println("*****jsonString to jsonArray*****");
//        JSONArray jArray=JSON.parseArray(JSON.toJSONString(stulist));
//        for(int i=0;i<jArray.size();i++){
//            System.out.println(jArray.getJSONObject(i));
//        }
//        System.out.println();
    }
}
