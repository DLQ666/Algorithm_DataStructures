package com.dlq.demo1;


/**
 *@program: Algorithm_DataStructures
 *@description:
 *@author: Hasee
 *@create: 2021-05-23 14:00
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
