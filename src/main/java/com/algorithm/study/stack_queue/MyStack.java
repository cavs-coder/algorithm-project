package com.algorithm.study.stack_queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 225. 用队列实现栈
 */
public class MyStack {

    Deque<Integer> que;
    public MyStack() {
        que = new ArrayDeque<>();
    }

    public void push(int x) {
        que.addLast(x);
    }

    public int pop() {
       return que.pollLast();
    }

    public int top() {
        return que.peekLast();
    }

    public boolean empty() {
        return que.isEmpty();
    }
}
