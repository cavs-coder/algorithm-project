package com.algorithm.study.array._3_sliding_window;

/**
 * 209. 长度最小的子数组
 *  // TODO: 2022/02/18 14:08 滑动窗口法无思路
 *
 *  滑动窗口: 不断地调节子序列的起始位置和终止位置，从而得到想要的结果。
 *  时间复杂度: 每个元素在滑动窗口进来时操作一次，出去时操作一个。所以是两个循环，为 2n，即O(n)
 *
 *  滑动窗口是双指针法的一种特殊运用
 */
public class MinSubArrayLen {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println(new MinSubArrayLen().minSubArrayLen01(target, nums));
        System.out.println(new MinSubArrayLen().minSubArrayLen02(target, nums));
    }

    /**
     * 暴力法
     */
    public int minSubArrayLen01(int target, int[] nums) {

        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    int currentLen = j - i + 1;
                    minLen = currentLen < minLen ? currentLen : minLen;
                    break;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    /**
     * 滑动窗口法
     */
    public int minSubArrayLen02(int target, int[] nums) {

        int l = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum >= target) {
                sum -= nums[l];
                int currentLen = r - l + 1;
                minLen = currentLen < minLen ? currentLen : minLen;
                l++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

}
