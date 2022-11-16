package com.algorithm.study.hot100;

import com.algorithm.study.linkedlist.ListNode;

/**
 * @author fuguangwei
 * @date 2022-11-14
 */
public class _2_AddTwoNumbers_2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(-1);
        ListNode cur = sentinel;
        int carry = 0;
        int v1;
        int v2;
        int sum;
        while (l1 != null || l2 != null) {
            v1 = l1 != null ? l1.val : 0;
            v2 = l2 != null ? l2.val : 0;
            sum = v1 + v2 + carry;

            carry = sum / 10;
            sum = sum % 10;

            cur.next = new ListNode(sum);
            cur = cur.next;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        if (carry == 1) {
            cur.next = new ListNode(carry);
        }

        return sentinel.next;
    }
}
