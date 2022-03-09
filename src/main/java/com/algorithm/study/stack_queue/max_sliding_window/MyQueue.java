package com.algorithm.study.stack_queue.max_sliding_window;

import java.util.Deque;
import java.util.LinkedList;

public class MyQueue {

    public Deque<Integer> deque;

    MyQueue() {
        deque = new LinkedList<>();
    }

    public void poll(int val) {
        if (!deque.isEmpty() && deque.peekFirst() == val) {
            deque.pollFirst();
        }
    }

    public void add(int val) {
        while (!deque.isEmpty() && deque.peekLast() < val) {
            deque.pollLast();
        }

        deque.addLast(val);
    }

    public int peek() {
        return deque.peek();
    }
}
