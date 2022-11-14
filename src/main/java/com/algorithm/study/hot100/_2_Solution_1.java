package com.algorithm.study.hot100;

import com.algorithm.study.linkedlist.ListNode;

/**
 * @author fuguangwei
 * @date 2022-11-14
 */
public class _2_Solution_1 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(-1);
        int val = -1;
        ListNode cur = sentinel;
        boolean carry = false;
        while (l1 != null && l2 != null) {
            val = carry ? l1.val + l2.val + 1 : l1.val + l2.val;
            if (val >= 10) {
                val -= 10;
                carry = true;
            } else {
                carry = false;
            }
            l1 = l1.next;
            l2 = l2.next;
            cur.next = new ListNode(val);
            cur = cur.next;
        }
        while (l1 != null) {
            val = carry ? l1.val + 1 : l1.val;
            if (val >= 10) {
                val -= 10;
                carry = true;
            } else {
                carry = false;
            }
            cur.next = new ListNode(val);
            cur = cur.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            val = carry ? l2.val + 1 : l2.val;
            if (val >= 10) {
                val -= 10;
                carry = true;
            } else {
                carry = false;
            }
            cur.next = new ListNode(val);
            cur = cur.next;
            l2 = l2.next;
        }
        if (carry) {
            cur.next = new ListNode(1);
        }

        return sentinel.next;
    }
}
