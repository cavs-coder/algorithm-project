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
        head = new ListNode(-1);
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        ListNode cur = head;
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
        index = Math.max(index, 0);

        ListNode pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        ListNode toAdd = new ListNode(val);
        toAdd.next = pre.next;
        pre.next = toAdd;

        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        ListNode pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        pre.next = pre.next.next;

        size--;
    }
}
