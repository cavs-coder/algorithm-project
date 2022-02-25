package com.algorithm.study.linkedlist;

import java.util.HashSet;

/**
 * 160. 相交链表
 */
public class GetIntersectionNode {

    /**
     * 解法一：哈希表
     */
    public ListNode getIntersectionNode01(ListNode headA, ListNode headB) {

        HashSet<ListNode> set = new HashSet<>();
        ListNode curA = headA;
        ListNode curB = headB;

        while (curA != null || curB != null) {
            if (curA != null) {
                if (set.contains(curA)) {
                    return curA;
                }
                set.add(curA);
                curA = curA.next;
            }

            if (curB != null) {
                if (set.contains(curB)) {
                    return curB;
                }
                set.add(curB);
                curB = curB.next;
            }
        }

        return null;
    }

    /**
     * 解法二：若相交尾部一定对其
     * 1 2 3 4 5 6 7 1 2 3
     * 1 2 3 1 2 3 4 5 6 7
     */
    public ListNode getIntersectionNode02(ListNode headA, ListNode headB) {

        ListNode curA = headA;
        ListNode curB = headB;

        int lenA = 0;
        while (curA != null) {
            curA = curA.next;
            lenA++;
        }

        int lenB = 0;
        while (curB != null) {
            curB = curB.next;
            lenB++;
        }

        curA = headA;
        curB = headB;
        int len = 0;
        if (lenA > lenB) {
            len = lenA - lenB;
            while (len > 0) {
                curA = curA.next;
                len--;
            }
        } else {
            len = lenB - lenA;
            while (len > 0) {
                curB = curB.next;
                len--;
            }
        }

        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }

        return null;
    }
}
