package com.algorithm.study.array._3_sliding_window;

/**
 * 209. 长度最小的子数组 medium
 *  // TODO: 2022/02/18 14:08 滑动窗口法无思路
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
