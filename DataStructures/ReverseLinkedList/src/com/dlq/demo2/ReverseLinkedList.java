package com.dlq.demo2;

import com.dlq.demo1.ListNode;

/**
 *@program: Algorithm_DataStructures
 *@description: 反转链表---递归
 *@author: Hasee
 *@create: 2021-05-27 23:37
 */
public class ReverseLinkedList {
    //递归
    public static ListNode recursion(ListNode head){
        //头节点本身是个空，那么传进来的链表本身就是个空 无需反转   或者
        // 头节点的下一个节点为空 那么就是最后一个节点
        if (head == null || head.next == null){
            return head;
        }
        //找到最后一个元素
        ListNode new_head = recursion(head.next);
        head.next.next = head;
        head.next = null;
        return new_head;
    }


    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        System.out.println(recursion(node1));
    }
}
