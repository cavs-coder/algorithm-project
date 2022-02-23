package com.algorithm.study.linkedlist;

/**
 * 203. 移除链表元素
 */
public class RemoveElements {

    public static void main(String[] args) {

    }

    //[1,2,6,3,4,5,6]
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;

        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }

        return dummy.next;
    }
}
