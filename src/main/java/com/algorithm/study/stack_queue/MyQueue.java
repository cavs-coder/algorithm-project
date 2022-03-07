package com.algorithm.study.stack_queue;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 */
public class MyQueue {

    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        dumpStackIn();
        return stackOut.pop();
    }

    public int peek() {
        dumpStackIn();
        return stackOut.peek();
    }

    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    private void dumpStackIn() {
        if (!stackOut.isEmpty()) {
            return;
        }

        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
    }
}
