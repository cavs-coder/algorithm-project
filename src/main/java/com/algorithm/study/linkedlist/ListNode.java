package com.algorithm.study.linkedlist;

public class ListNode {
    public int val;
    public ListNode prev;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public static void loop(ListNode listNode) {
        if (listNode == null) {
            return;
        }

        ListNode cur = listNode;
        StringBuilder builder = new StringBuilder(cur.val + "");
        while (cur.next != null) {
            builder.append(" ==> ").append(cur.next.val);
            cur = cur.next;
        }
        System.out.println(builder.toString());
    }
}
