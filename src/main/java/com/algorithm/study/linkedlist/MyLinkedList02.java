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
        head = new ListNode(-1);
        tail = new ListNode(-1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        ListNode cur = head;
        // 0 1 2 3 4 5
        // 0 1 2 3 4 5 6
        if (index <= (size - 1) / 2) {
            for (int i = 0; i <= index; i++) {
                cur = cur.next;
            }
        } else {
            cur = tail;
            for (int i = size - 1; i >= index; i--) {
                cur = cur.prev;
            }
        }

        return cur.val;
    }

    public void addAtHead(int val) {
        ListNode toAdd = new ListNode(val);
        toAdd.next = head.next;
        head.next.prev = toAdd;
        head.next = toAdd;
        toAdd.prev = head;

        size++;
    }

    public void addAtTail(int val) {
        ListNode toAdd = new ListNode(val);
        toAdd.prev = tail.prev;
        tail.prev.next = toAdd;
        toAdd.next = tail;
        tail.prev = toAdd;

        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        index = Math.max(index, 0);

        ListNode pre = head;
        // 0 1 2 3 4 5
        // 0 1 2 3 4 5 6
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        ListNode toAdd = new ListNode(val);
        toAdd.next = pre.next;
        pre.next.prev = toAdd;
        pre.next = toAdd;
        toAdd.prev = pre;

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
        pre.next.prev = pre;

        size--;
    }
}
