package com.algorithm.study.greedy;

/**
 * 53. 最大子数组和
 * 暴力法超时
 */
public class _03_MaxSubArray_1 {

    //-2,1,-3,4,-1,2,1,-5,4
    public int maxSubArray1(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    public int maxSubArray2(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum;
        for (int i = 0; i < nums.length; i++) {
            if ((i < nums.length - 1) && nums[i] <= 0 && nums[i + 1] > 0) {
                continue;
            }
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}
