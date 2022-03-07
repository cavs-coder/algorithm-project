package com.algorithm.study.stack_queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1047. 删除字符串中的所有相邻重复项
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        String s = "dabbaca";
        System.out.println(new RemoveDuplicates().removeDuplicates03(s));
    }

    /**
     * LinkedList作为栈
     */
    public String removeDuplicates01(String s) {

        if (s.length() == 1) {
            return s;
        }

        Deque<Character> deque = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (deque.isEmpty() || deque.peekLast() != ch) {
                deque.addLast(ch);
            } else {
                deque.pollLast();
            }
        }

        StringBuilder builder = new StringBuilder();
        for (Character ch : deque) {
            builder.append(ch);
        }

        return builder.toString();
    }

    /**
     * StringBuilder作为栈
     */
    public String removeDuplicates02(String s) {

        if (s.length() == 1) {
            return s;
        }

        StringBuilder builder = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (builder.length() == 0 || builder.charAt(builder.length() - 1) != ch) {
                builder.append(ch);
            } else {
                builder.deleteCharAt(builder.length() - 1);
            }
        }

        return builder.toString();
    }

    /**
     * 双指针
     */
    public String removeDuplicates03(String s) {

        if (s.length() == 1) {
            return s;
        }

        char[] chars = s.toCharArray();
        int slow = -1;
        for (int fast = 0; fast < chars.length; fast++) {
            if (slow >= 0 && chars[slow] == chars[fast]) {
                slow--;
            } else {
                chars[++slow] = chars[fast];
            }
        }

        return String.valueOf(chars, 0, slow + 1);
    }
}
