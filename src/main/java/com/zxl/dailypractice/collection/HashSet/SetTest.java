package com.zxl.dailypractice.collection.HashSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhao
 * @className SetTest
 * @Description TODO
 * @Date 2021/12/3
 * @Version 1.0
 **/
public class SetTest {
    public List<Student> students;
    public SetTest() {
        students = new ArrayList<Student>();
    }

    /*
     * 用于往students中添加学生
     */
    public void testAdd() {
        //创建一个学生对象，并通过调用add方法，添加到学生管理List中
        Student st1 = new Student("1", "张三");
        students.add(st1);

        //添加到List中的类型均为Object，所以取出时还需要强转

        Student st2 = new Student("2","李四");
        students.add(st2);

        Student[] student = {new Student("3", "王五"),new Student("4", "马六")};
        students.addAll(Arrays.asList(student));

        Student[] student2 = {new Student("5", "周七"),new Student("6", "赵八")};
        students.addAll(Arrays.asList(student2));

    }

    /**
     * 通过for each 方法访问集合元素
     */
    public void testForEach() {
        System.out.println("有如下学生（通过for each）：");
        for(Object obj:students){
            Student st = (Student)obj;
            System.out.println("学生：" + st.id + ":" + st.name);
        }
    }

    public static void main(String[] args) {
        SetTest st = new SetTest();
        st.testAdd();
        st.testForEach();
        PD pd = new PD("1","张老师");
        System.out.println("请：" + pd.name + "选择小组成员！");
        //创建一个 Scanner 对象，用来接收从键盘输入的学生 ID
        Scanner console = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入学生 ID");
            String studentID = console.next();
            for (Student s:st.students){
                if (s.id.equals(studentID)){
                    pd.students.add(s);
                }
            }
        }
        st.testForEachForSer(pd);
        // 关闭 Scanner 对象
        console.close();
    }


    //打印输出，老师所选的学生！Set里遍历元素只能用foreach 和 iterator
    //不能使用 get() 方法，因为它是无序的，不能想 List 一样查询具体索引的元素
    public void testForEachForSer(PD pd){
        for(Student s: pd.students) {
            System.out.println("选择了学生：" + s.id + ":" + s.name);
        }
    }
}
