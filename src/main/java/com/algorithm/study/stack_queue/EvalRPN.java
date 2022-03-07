package com.algorithm.study.stack_queue;

import java.util.*;

/**
 * 150. 逆波兰表达式求值
 */
public class EvalRPN {

    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(new EvalRPN().evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {

        Set<String> set = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        Deque<String> deque = new LinkedList<>();
        for (int i = 0; i < tokens.length; i++) {
            String val = tokens[i];
            if (set.contains(val)) {
                int two = Integer.parseInt(deque.pop());
                int one = Integer.parseInt(deque.pop());
                val = calculate(one, two, val) + "";
                System.out.println("val: " + val + ", one: " + one + ", two: " + two + ", tokens[i]: " + tokens[i]);
            }
            deque.push(val);
        }

        return Integer.parseInt(deque.peek());
    }

    public int calculate(int a, int b, String val) {

        switch (val) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                return Integer.MIN_VALUE;
        }
    }
}
