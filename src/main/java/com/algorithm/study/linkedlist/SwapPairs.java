package com.algorithm.study.linkedlist;

/**
 * 24. 两两交换链表中的节点
 */
public class SwapPairs {

    public static void main(String[] args) {
        MyLinkedList01 list = new MyLinkedList01();
        list.addAtTail(1);
        list.addAtTail(2);
        list.addAtTail(3);
        list.addAtTail(4);
        list.addAtTail(5);
        ListNode.loop(list.head);
        ListNode.loop(new SwapPairs().swapPairs(list.head));
    }

    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = head;
        ListNode temp;
        while (pre.next != null && pre.next.next != null) {
            temp = cur.next.next;
            pre.next = cur.next;
            cur.next.next = cur;
            cur.next = temp;
            pre = cur;
            cur = temp;
        }
        return dummy.next;
    }
}
