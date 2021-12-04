package com.zxl.dailypractice.Algorithm.Day5;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2021/11/22
 * @Version 1.0
 **/
public class Solution {
    // 链表的中间结点     https://leetcode-cn.com/problems/middle-of-the-linked-list/
    public ListNode middleNode(ListNode head) {
//        ListNode[]  a = new ListNode[100];
//        int t = 0;
//        while (head != null){
//            a[t++] = head;
//            head = head.next;
//        }
//        return a[t/2];
        ListNode slow = head,fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static class ListNode {        //类名 ：Java类就是一种自定义的数据结构
        int val;            //数据 ：节点数据
        ListNode next;      //对象 ：引用下一个节点对象。在Java中没有指针的概念，Java中的引用和C语言的指针类似
        ListNode(int val){  //构造方法 ：构造方法和类名相同
            this.val=val;     //把接收的参数赋值给当前类的val变量
        }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        head.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        Solution solution = new Solution();
        ListNode listNode = solution.middleNode(head);
        System.out.println(listNode.val);


        ListNode listNode1 = solution.removeNthFromEnd(head, 2);
        solution.output(listNode1);
    }

    //输出语句
    private void output(ListNode ln){
        if(null == ln){
            return;
        }
        ListNode tmp = ln;
        while(null!=tmp){
            System.out.print(tmp.val);
            if(null!=tmp.next){
                System.out.print(" , ");
            }
            tmp = tmp.next;
        }
    }

    //删除链表的倒数第 N 个结点      https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/shan-chu-lian-biao-de-dao-shu-di-nge-jie-dian-b-61/
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int traverse = traverse(head,n);
        if(traverse == n){
            return head.next;
        }
        return head;
    }

    private int traverse(ListNode node,int n){
        if(node==null){
            return 0;
        }
        int num = traverse(node.next,n);
        if(num == n){
            node.next = node.next.next;
        }
        return num+1;
    }
}
