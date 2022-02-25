package com.algorithm.study.linkedlist;

import java.util.HashMap;

/**
 * 19. 删除链表的倒数第 N 个结点
 */
public class RemoveNthFromEnd {

    public static void main(String[] args) {
        MyLinkedList01 list = new MyLinkedList01();
        list.addAtTail(1);
        list.addAtTail(2);
        list.addAtTail(3);
        list.addAtTail(4);
        list.addAtTail(5);
        ListNode.loop(list.head);
        ListNode.loop(new RemoveNthFromEnd().removeNthFromEnd02(list.head,6));
    }

    /**
     * 解法一：哈希表
     */
    public ListNode removeNthFromEnd01(ListNode head, int n) {

        HashMap<Integer, ListNode> indexMap = new HashMap<>();

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // -1 0 1 2 3 4
        ListNode cur = dummy;
        int index = 0;
        while (cur != null) {
            indexMap.put(index++, cur);
            cur = cur.next;
        }

        ListNode pre = indexMap.get(index - n - 1);
        pre.next = pre.next.next;

        return dummy.next;
    }

    /**
     * 解法二：双指针
     */
    public ListNode removeNthFromEnd02(ListNode head, int n) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        int count = 0;
        while (count < n) {
            fast = fast.next;
            count++;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}
