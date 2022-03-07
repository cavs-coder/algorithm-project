package com.algorithm.study.stack_queue;

import java.util.*;

/**
 * 20. 有效的括号
 */
public class IsValid {

    public static void main(String[] args) {
        String s = "{[]}";
        System.out.println(new IsValid().isValid(s));
    }

    public boolean isValid(String s) {

        if (s.length() % 2 == 1) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Deque<Character> deque = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (map.containsKey(ch)) {
                if (deque.isEmpty() || deque.peekLast() != map.get(ch)) {
                    return false;
                }
                deque.pollLast();
            } else {
                deque.addLast(ch);
            }
        }

        return deque.isEmpty();
    }
}
