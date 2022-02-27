package com.algorithm.study.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * 142. 环形链表 II
 */
public class DetectCycle {

    /**
     * 解法一：哈希表
     */
    public ListNode detectCycle01(ListNode head) {

        Set<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (set.contains(cur)) {
                return cur;
            }
            set.add(cur);
            cur = cur.next;
        }

        return null;
    }

    /**
     * 解法二：快慢指针 + 数学推导：是环形链表时：
     * 首先慢指针走1步，快指针走2步，快指针先进环，等慢指针进环后，每一次循环，快指针都逼近慢指针1步，最终相遇。
     * <p>
     * 1、快指针路程是慢指针2倍：f = 2*s
     * 2、相交时快指针比慢指针多走n圈：f = s + n*b、所以 s = n*b
     * 3、交点前路程为 a，环形链表起始位置：a + n*b
     * 4、快慢指针第一次相交后，慢指针已走 s = n*b，慢指针再走 a 步就达到环形链表起始位置，
     * 将快指针重置为 head、也走 a 步，两指针首次相交即为环形链表起始位置。
     */
    public ListNode detectCycle02(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }

                return fast;
            }
        }
        return null;
    }
}
