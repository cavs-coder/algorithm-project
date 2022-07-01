package com.algorithm.study.greedy;

/**
 * 376. 摆动序列
 * 1、贪心：局部最优推出全局最优
 */
public class _02_WiggleMaxLength_1 {

    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        //之前一对差值
        int preDiff = 0;
        //当前一对差值
        int curDiff = 0;
        //默认最右边有一个峰值
        int result = 1;

        for (int i = 1; i < nums.length; i++) {
            curDiff = nums[i] - nums[i - 1];

            //preDiff等于0的时候是初始，当curDiff等于0或者preDiff和curDiff同正(同负)不进入
            if ((preDiff <= 0 && curDiff > 0) || (preDiff >= 0 && curDiff < 0)) {
                result++;
                preDiff = curDiff;
            }
        }

        return result;
    }
}
