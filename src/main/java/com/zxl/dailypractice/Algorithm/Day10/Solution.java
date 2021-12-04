package com.zxl.dailypractice.Algorithm.Day10;

/**
 * @author zhao
 * @className Solution
 * @Description TODO
 * @Date 2021/11/29
 * @Version 1.0
 **/
public class Solution {
    //合并两个有序链表         https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/he-bing-liang-ge-you-xu-lian-biao-by-leetcode-solu/
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        } else if(list2 == null){
            return list1;
        } else if (list1.val < list2.val){
            list1.next = mergeTwoLists(list1.next,list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1,list2.next);
            return list2;
        }
    }

    //反转链表         https://leetcode-cn.com/problems/reverse-linked-list/solution/shi-pin-jiang-jie-die-dai-he-di-gui-hen-hswxy/
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        ListNode head1 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(7);
        head1.next = node3;
        node3.next = node4;
        Solution solution = new Solution();
        ListNode listNode = solution.mergeTwoLists(head, head1);
        solution.output(listNode);
        System.out.println();

        ListNode listNode1 = solution.reverseList(head);
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
}

class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val,ListNode next) {
        this.val = val;
        this.next = next;
    }
}
