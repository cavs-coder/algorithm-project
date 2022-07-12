package com.algorithm.study.dynamic_programming;

/**
 * 198. 打家劫舍
 * 优化空间复杂度
 * dp：时间复杂度O(n)，空间复杂度O(1)
 * dp[i]表示，偷窃下标[0,i]的房屋，最多可以偷窃的最大金额为dp[i]
 * 状态转移公式：连续偷窃相邻两间房有警报，所以，取i-2的dp[i-2]+当前下标i房屋金额nums[i]，与dp[i-1]两者的更大值。
 *              dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1])
 *
 * 举例推导：[2,7,9,3,1]
 *      0   1   2   3   4
 *      2   7   11  11  12
 */
public class _19_Rob_2 {

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        int a = nums[0];
        int b = Math.max(nums[0], nums[1]);
        int c;
        for (int i = 2; i < nums.length; i++) {
            c = Math.max(a + nums[i], b);
            a = b;
            b = c;
        }
        return b;
    }
}
