package com.dlq.demo1;

/**
 *@program: Algorithm_DataStructures
 *@description: 反转链表
 *@author: Hasee
 *@create: 2021-05-23 13:52
 */
public class ReverseLinkedList {
    //迭代
    public static ListNode iterate(ListNode head) {
        ListNode prev = null, next;
        ListNode curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        System.out.println(iterate(node1));
    }
}
