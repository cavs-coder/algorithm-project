package com.algorithm.study.linkedlist;

/**
 * 707. 设计链表 medium
 * 单链表
 */
public class MyLinkedList01 {

    public static void main(String[] args) {
        MyLinkedList01 myLinkedList = new MyLinkedList01();
        myLinkedList.addAtHead(1);
        ListNode.loop(myLinkedList.head);
        myLinkedList.addAtTail(3);
        ListNode.loop(myLinkedList.head);
        myLinkedList.addAtIndex(1, 2);
        ListNode.loop(myLinkedList.head);
        int i = myLinkedList.get(1);
        System.out.println(i);
        myLinkedList.deleteAtIndex(1);
        ListNode.loop(myLinkedList.head);
        int b = myLinkedList.get(1);
        System.out.println(b);
    }

    int size;
    ListNode head;

    public MyLinkedList01() {
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }

        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }

        if (index < 0) {
            index = 0;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        ListNode toAdd = new ListNode(val);
        toAdd.next = pre.next;
        pre.next = toAdd;
        size++;

        head = dummy.next;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        pre.next = pre.next.next;
        size--;

        head = dummy.next;
    }
}
