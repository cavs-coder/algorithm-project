package com.algorithm.study.dynamic_programming;

import java.util.Arrays;

/**
 * 416. 分割等和子集
 * dp：时间复杂度O(n^target)，空间复杂度(target)
 *      举例推导验证：
 *          weight=value={1,5,11,5}，w=(1+5+11+5)/2=11
 *          横纵坐标  0   1    2    3    4    5    6    7    8    9    10    11
 *
 *               0   0   1    1    1    1     1   1    1    1    1     1     1
 *               1   0   1    1    1    1     5   6    6    6    6     6     6
 *               2   0   1    1    1    1     5   6    6    6    6     6     11
 *               3   0   1    1    1    1     5   6    6    6    6     10     11
 */
public class _9_CanPartition_1 {

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) return false;
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < n; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                if (dp[j] == target) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {14, 9, 8, 4, 3, 2};
        System.out.println(new _9_CanPartition_1().canPartition(nums));
    }
}
