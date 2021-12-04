package com.zxl.dailypractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhao
 * @className StudentSystem
 * @Description TODO
 * @Date 2021/11/17
 * @Version 1.0
 **/
public class StudentSystem {
    private static List<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        while(true){
            //用输入语句完成编写
            System.out.println("学生信息管理系统");
            System.out.println("1,添加学生记录");
            System.out.println("2,删除指定学生");
            System.out.println("3,修改指定学生");
            System.out.println("4,查询指定学生");
            System.out.println("5,显示所有学生");
            System.out.println("6,退出");
            System.out.println("请输入你的选择: ");
            //用Scanner语句输入语句
            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();
            //用switch语句完成选择操作
            switch (i) {
                case 1:
                    insertStudent(studentList);
                    break;
                case 2:
                    deleteStudent(studentList);
                    break;
                case 3:
                    modifyStudent(studentList);
                    break;
                case 4:
                    searchStudent(studentList);
                    break;
                case 5:
                    displayStudent(studentList);
                    break;
                case 6:
                    System.out.println("谢谢使用");
                    System.exit(0);//JVM退出
                default:
                    System.out.println("请输入正确的指令");
            }
        }

    }


    /**
     * 增加学生信息
     * @param list
     */
    private static void insertStudent(List<Student> list) {
        Scanner scanner=new Scanner(System.in);
        Student student1=new Student();
        System.out.println("请输入学号");
        //输入学号
        while (true) {
            String s = scanner.nextLine();
            boolean flag=false;
            for (Student student : list) {
                if (student.getId().equals(s)) {
                    flag=true;
                }
            }
            if (flag) {
                System.out.println("学号已存在,请重新输入");
                continue;
            }
            student1.setId(s);
            break;
        }
        //输入姓名
        System.out.println("请输入姓名: ");
        String name=scanner.nextLine();
        //输入性别
        System.out.println("请输入性别: ");
        String gender=scanner.nextLine();
        //输入年龄
        System.out.println("请输入年龄: ");
        String age=scanner.nextLine();
        //输入专业
        System.out.println("请输入专业: ");
        String zy = scanner.nextLine();
        //输入分数
        System.out.println("请输入分数: ");
        String score = scanner.nextLine();
        student1.setName(name);
        student1.setGender(gender);
        student1.setAge(age);
        student1.setZy(zy);
        student1.setScore(score);
        list.add(student1);
        System.out.println("添加学生成功");
    }


    /**
     * 删除学生信息
     * @param studentList
     */
    private static void deleteStudent(List<Student> studentList) {
        if (studentList.size() == 0) {
            System.out.println("请先添加数据然后再删除");
            return;
        }
        System.out.println("1,按学号删除指定学生的信息");
        System.out.println("2,按姓名删除指定学生的信息");
        System.out.println("3,按专业删除指定学生的信息");
        //用Scanner语句输入语句
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        switch (i) {
            case 1:
                System.out.println("请输入要删除学生的学号: ");
                Scanner scanner1 = new Scanner(System.in);
                String id = scanner1.nextLine();
                for (Student student : studentList) {
                    if (student.getId().equals(id)) {
                        studentList.remove(student);
                        System.out.println("删除成功");
                        return;
                    }
                }
                System.out.println("不存在该学生,请回到主页面确认学生信息后再来删除");
                break;
            case 2:
                System.out.println("请输入要删除学生的姓名: ");
                String name = scanner.nextLine();
                for (Student student : studentList) {
                    if (student.getName().equals(name)) {
                        studentList.remove(student);
                        System.out.println("删除成功");
                        return;
                    }
                }
                System.out.println("不存在该学生,请回到主页面确认学生信息后再来删除");
                break;
            case 3:
                System.out.println("请输入要删除学生的专业: ");
                String zy = scanner.nextLine();
                for (Student student : studentList) {
                    if (student.getZy().equals(zy)) {
                        studentList.remove(student);
                        System.out.println("删除成功");
                        return;
                    }
                }
                System.out.println("不存在该学生,请回到主页面确认学生信息后再来删除");
                break;
            default:
                System.out.println("请输入正确的指令");
        }
    }


    /**
     * 修改学生信息
     * @param studentList
     */
    private static void modifyStudent(List<Student> studentList) {
        if (studentList.size() == 0) {
            System.out.println("请先添加数据然后再修改");
            return;
        }
        Scanner scanner=new Scanner(System.in);
        //输入姓名
        System.out.println("请输入要修改学生的姓名: ");
        String name=scanner.nextLine();
        for(Student student : studentList){
            if(student.getName().equals(name)){
                //输入学号
                System.out.println("请输入要修改成的学号: ");
                String id=scanner.nextLine();
                //输入性别
                System.out.println("请输入要修改成的性别: ");
                String gender=scanner.nextLine();
                //输入年龄
                System.out.println("请输入要修改成的年龄: ");
                String age=scanner.nextLine();
                //输入专业
                System.out.println("请输入要修改成的专业: ");
                String zy=scanner.nextLine();
                //输入分数
                System.out.println("请输入要修改成的分数: ");
                String score=scanner.nextLine();
                for (Student student1 : studentList) {
                    if (student1.getName().equals(name)) {
                        student1.setId(id);
                        student1.setName(name);
                        student1.setGender(gender);
                        student1.setAge(age);
                        student1.setZy(zy);
                        student1.setScore(score);
                        System.out.println("修改学生信息成功");
                        return;
                    }
                }
            }
        }
        System.out.println("姓名输入错误,请回到主页面认真查看后重新修改");
    }


    /**
     * 按专业查询学生信息
     * @param studentList
     */
    private static void searchStudent(List<Student> studentList) {
        if (studentList.size() == 0) {
            System.out.println("请先添加数据然后再查询");
            return;
        }
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入要查询学生的专业: ");
        String s = scanner.nextLine();
        System.out.println("学号\t\t姓名\t\t性别\t\t年龄\t\t专业\t\t分数");
        for (Student student : studentList) {
            if (student.getZy().equals(s)) {
                System.out.println(student.getId()+"\t\t\t"+student.getName()+"\t\t"+student.getGender()+"\t\t\t"
                        +student.getAge()+"\t\t\t"+student.getZy()+"\t\t"+student.getScore());
                return;
            }
        }
        System.out.println("不存在该专业学生,请回到主页面确认学生信息后再来删除");
    }


    /**
     * 显示所有学生信息
     * @param studentList
     */
    private static void displayStudent(List<Student> studentList) {
        if (studentList.size() == 0) {
            System.out.println("暂无信息,请先添加学生信息");
            return;
        }
        System.out.println("学号\t\t姓名\t\t性别\t\t年龄\t\t专业\t\t分数");
        for (Student student : studentList) {
            System.out.println(student.getId()+"\t\t\t"+student.getName()+"\t\t"+student.getGender()+"\t\t\t"
                    +student.getAge()+"\t\t\t"+student.getZy()+"\t\t"+student.getScore());
        }
    }




}
