package com.algorithm.study.stack_queue;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 */
public class TopKFrequent {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3, 8, 8, 8, 8, 8, 5, 5, 5, 5, 9, 9, 0, 7, 7, 7, 7, 7, 7};
        int k = 5;
        System.out.println(Arrays.toString(new TopKFrequent().topKFrequent(nums, k)));
    }

    /**
     * 构建小顶堆优先队列
     */
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        Set<Map.Entry<Integer, Integer>> entries = frequency.entrySet();
        //构建小顶堆优先队列
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        for (Map.Entry<Integer, Integer> entry : entries) {
            priorityQueue.offer(entry);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        //频率小的放后面
        int[] res = new int[k];
        for (int i = k-1; i >=0; i--) {
            res[i] = priorityQueue.poll().getKey();
        }

        return res;
    }
}
