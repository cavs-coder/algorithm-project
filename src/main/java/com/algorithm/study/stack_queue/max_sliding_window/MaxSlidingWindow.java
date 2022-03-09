package com.algorithm.study.stack_queue.max_sliding_window;

import java.util.Arrays;

/**
 * 239. 滑动窗口最大值
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {
        int[] nums = {-7, -8, 7, 5, 7, 1, 6, 0};
        int k = 4;
        System.out.println(Arrays.toString(new MaxSlidingWindow().maxSlidingWindow02(nums, k)));
    }

    /**
     * 1、超时 O(n^2)
     */
    public int[] maxSlidingWindow01(int[] nums, int k) {

        //1,3,-1,-3,5,3,6,7    3
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = k - 1; i < nums.length; i++) {
            int maxSum = Integer.MIN_VALUE;
            for (int j = i - k + 1; j <= i; j++) {
                maxSum = Math.max(maxSum, nums[j]);
            }
            res[index++] = maxSum;
        }

        return res;
    }

    /**
     * 2、自己实现单调队列
     */
    public int[] maxSlidingWindow02(int[] nums, int k) {

        //-7, -8, 7, 5, 7, 1, 6, 0    4
        MyQueue queue = new MyQueue();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        //初始化窗口
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        res[index++] = queue.peek();
        System.out.println(queue.deque);
        for (int i = k; i < nums.length; i++) {
            queue.poll(nums[i - k]);
            queue.add(nums[i]);
            res[index++] = queue.peek();
            System.out.println(queue.deque);
        }

        return res;
    }
}
