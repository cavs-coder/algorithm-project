package com.algorithm.study.dynamic_programming;

/**
 * 494. 目标和
 * 滚动数组
 * 关键点：x+y=sum, x-y=target  ===> x=(target+sum)/2
 * dp：时间复杂度O(n*bagSize)，空间复杂度O(bagSize)
 *
 * 当元素nums[i]=0时，dp[j] = dp[j - nums[i]] + dp[j] ==>dp[j] = dp[j - 0] + dp[j]，
 * 计算两次dp[j]，第一个dp[j-0]代表将当前0计算进入此前的组合，组合个数不变。第二个dp[j]代表不将0加入此前组合。
 * 比如i=1，nums[1]=1，j=3时dp[j]=1，此时组合为(3)；当i=2，nums[2]=0，j=3时，组合个数为(3,0)和(3)，dp[j]=2
 *
 * nums={3,1,0,2},target = 2
 *        0  1  2  3  4
 *   0   [1, 0, 0, 1, 0]
 *   1   [1, 1, 0, 1, 1]
 *   2   [2, 2, 0, 2, 2]
 *   3   [2, 2, 2, 4, 2]
 *
 *   i=2时，nums[i]=0，dp[2][0]=2，解释为：dp[0]+dp[0] = 1+1 =2，即0不加入之前组合，什么都不装()，和0加入之前组合，装一个0,(0)。
 */
public class _11_FindTargetSumWays_1 {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //说明x不为整数，不合题意
        if ((target + sum) % 2 == 1) return 0;
        if (Math.abs(target) > sum) return 0;

        int bagSize = (target + sum) / 2;
        //dp[j]表示填满容积为j的背包，有dp[j]种组合
        int[] dp = new int[bagSize + 1];

        //初始化，因为dp[j]依赖于dp[j - nums[i]]，都会用到dp[0]，若是初始化为0，则后续结果都将为0，所以要初始化为1
        //解释为:装满容量为0的背包，只有一种装法，那就是什么都不装。
        dp[0] = 1;

        for (int i = 0; i < nums.length; i++) {
            dp[0] = 1;
            for (int j = bagSize; j >= nums[i]; j--) {
                //dp[j]为计算当前nums[i]时，此前已有等于j的组合个数
                //dp[j - nums[i]]则为计算当前nums[i]时，等于j的组合个数。只要在已有组合上都加上一个值nums[i]，组合个数不变，还是dp[j - nums[i]]
                dp[j] = dp[j - nums[i]] + dp[j];
            }
        }

        return dp[bagSize];
    }
}
