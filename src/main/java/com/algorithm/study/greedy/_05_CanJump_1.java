package com.algorithm.study.greedy;

/**
 * 55. 跳跃游戏
 * 贪心：时间复杂度O(n),空间复杂度O(1)
 * 不用去管每一步是怎么跳的，只要知道当前索引的最大覆盖范围能不能大于等于最后一个元素的索引，
 * 并且当前索引在此前得出的索引覆盖范围内就行了。
 *
 * 贪心：局部最优：从头遍历，每次跳最大，得当前位置产生的最大覆盖范围。
 *      全局最优：对比每个索引产生的最大覆盖范围，判断最终能否覆盖终点。
 */
public class _05_CanJump_1 {

    public boolean canJump(int[] nums) {
        //能覆盖的最大索引
        int coverIndex = 0;
        for (int i = 0; i <= coverIndex; i++) {
            //当前索引下最远的覆盖距离，超过之前索引的最远覆盖距离，就更新
            coverIndex = Math.max(coverIndex, i + nums[i]);
            if (coverIndex >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
