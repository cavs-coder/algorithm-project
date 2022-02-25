package com.algorithm.study.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * 142. 环形链表 II
 */
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {

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
}
