package com.algorithm.study.greedy;

/**
 * 45. 跳跃游戏 II
 * 贪心：时间复杂度O(n),空间复杂的O(1)
 * 局部最优：走这一步的索引开始，到当前最远覆盖距离的区间范围，获取下一步最大的覆盖距离
 * 全局最优：未走到终点的情况下，每次走到当前覆盖最远距离就步数加1。即根据局部最优得出的下一步最远覆盖距离来推出总步数
 */
public class _06_Jump_1 {

    public int jump(int[] nums) {
        //步数
        int count = 0;
        //当前步最远覆盖距离
        int curDistance = 0;
        //下一步最远覆盖距离
        int nextDistance = 0;

        for (int i = 0; i < nums.length; i++) {
            //从走这一步的索引开始，到当前最远覆盖距离的区间范围，求得最大的下一步
            nextDistance = Math.max(nextDistance, i + nums[i]);
            //当i走到终点时，若是正好等于当前最远覆盖距离，就不加步数了（已到终点，不用再走）
            if (i == curDistance && i != nums.length - 1) {
                //走到当前最远的覆盖距离的时候，走下一步，并将值更换成下一步最远的覆盖距离
                count++;
                curDistance = nextDistance;

                //优化：如果下一步已经可以到达终点，提前结束
                if (nextDistance >= nums.length - 1) {
                    break;
                }
            }
        }

        return count;
    }
}
