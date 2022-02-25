package com.algorithm.study.linkedlist;

/**
 * 206. 反转链表
 */
public class ReverseList {

    public static void main(String[] args) {
        MyLinkedList01 list = new MyLinkedList01();
        list.addAtTail(1);
        list.addAtTail(2);
        list.addAtTail(3);
        list.addAtTail(4);
        list.addAtTail(5);
        ListNode.loop(list.head);
        ListNode.loop(new ReverseList().reverseList(list.head));
    }

    /**
     * 双指针法：pre与cur指针，temp暂存后续节点
     */
    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        ListNode temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        return pre;
    }
}
