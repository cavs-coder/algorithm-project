package com.algorithm.study.linkedlist;

/**
 * 707. 设计链表 medium
 * 双链表
 */
public class MyLinkedList02 {

    public static void main(String[] args) {
        MyLinkedList02 myLinkedList = new MyLinkedList02();
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
    ListNode tail;

    public MyLinkedList02() {
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        ListNode dummyHead = new ListNode(-1);
        ListNode dummyTail = new ListNode(-1);
        dummyHead.next = head;
        head.prev = dummyHead;
        tail.next = dummyTail;
        dummyTail.prev = tail;

        ListNode cur = dummyHead;
        if (index < (size - 1) / 2) {
            for (int i = 0; i <= index; i++) {
                cur = cur.next;
            }
        } else {        // 0 1 2 3 4 5 6 7 8
            cur = dummyTail;
            for (int i = size - 1; i >= index; i--) {
                cur = cur.prev;
            }
        }

        head = dummyHead.next;
        head.prev = null;
        tail = dummyTail.prev;
        tail.next = null;

        return cur.val;
    }

    public void addAtHead(int val) {

    }

    public void addAtTail(int val) {

    }

    public void addAtIndex(int index, int val) {

    }

    public void deleteAtIndex(int index) {

    }
}
