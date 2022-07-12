package com.algorithm.study.dynamic_programming;

/**
 * 213. 打家劫舍 II
 * 打家劫舍I进阶，房屋成一个圆环，所以，第一间和最后一间不能一起偷，所以可以取两个区间比大小。
 * 房屋下标[0,n-2]的偷窃最大金额，与房屋下标[1,n-1]的偷窃最大金额作比较。
 *
 * dp：时间复杂度O(n)，空间复杂度O(1)
 */
public class _20_Rob2_1 {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(rob1(nums, 0, n - 2), rob1(nums, 1, n - 1));
    }

    public int rob1(int[] nums, int start, int end) {
        if (start == end) return nums[start];
        int a = nums[start];
        int b = Math.max(nums[start], nums[start + 1]);
        int c;
        for (int i = start + 2; i <= end; i++) {
            c = Math.max(a + nums[i], b);
            a = b;
            b = c;
        }

        return b;
    }
}
