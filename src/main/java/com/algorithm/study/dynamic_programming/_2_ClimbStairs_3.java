package com.algorithm.study.dynamic_programming;

/**
 * 70. 爬楼梯
 * 完全背包，nums可以随意设置，不被拘泥于跳一格两格。
 * 需要先遍历背包，再遍历物品，因为爬楼梯方法属于排列问题。
 *
 * 假设n = 4, nums = {1,2}
 *
 *      1   2  物品j
 *  0   1
 *  1   1
 *  2   2
 *  3   3
 *  4   5
 *  背包i
 *  dp = {1,1,2,3,5}
 *
 *  初始化dp[0] = 1，因为后续要在其上递推，或者说i==nums[j]时，dp[i-nums[j]]==1，
 *  此时nums[j]被选中加入下标为i-nums[j]位置的各个排列中的尾巴，它至少有一种方法，就是(nums[j])的排列。
 *
 *  递推公式：dp[i] += dp[i - nums[j]]; 即 dp[i] = dp[i] + dp[i - nums[j]]
 *                                                 排列
 * j=0     dp[0] = 1                                ()
 * j=1     dp[1] = dp[1] + dp[0] = 0 + 1 = 1   ===> (1)     i=0,nums[0]=1,拿到dp[0]所有排列()，尾巴加个nums[0]，即(1)
 * j=2     dp[2] = dp[2] + dp[1] = 0 + 1       ===> (1,1)   i=0,nums[0]=1,拿到dp[1]所有排列(1)，尾巴加个nums[0]，即(1,1)
 *                       + dp[0]     + 1            (2)     i=1,nums[1]=2,拿到dp[0]所有排列()，尾巴加个nums[1]，即(2)
 *                               = 2
 * j=3     dp[3] = dp[3] + dp[2] = 0 + 2       ===> (1,1,1),(2,1)   i=0,nums[0]=1,拿到dp[2]所有排列(1,1),(2)，尾巴加个nums[0]，即(1,1,1),(2,1)
 *                       + dp[1]     + 1            (1,2)           i=1,nums[1]=2,拿到dp[1]所有排列(1)，尾巴加个nums[1]，即(1,2)
 *                               = 3
 * j=4     dp[4] = dp[4] + dp[3] = 0 + 3       ===> (1,1,1,1),(2,1,1),(1,2,1)   i=0,nums[0]=1,拿到dp[3]所有排列(1,1,1),(2,1),(1,2)，尾巴加个nums[0]，即(1,1,1,1),(2,1,1),(1,2,1)
 *                       + dp[2]     + 2       ===> (1,1,2),(2,2)               i=1,nums[1]=2,拿到dp[2]所有排列(1,1),(2)，尾巴加个nums[1]，即(1,1,2),(2,2)
 *                               = 5
 */
public class _2_ClimbStairs_3 {

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int[] nums = {1,2};
        for(int i = 0; i <= n; i++){
            for(int j = 0; j < nums.length; j++){
                if(i < nums[j]) continue;
                dp[i] += dp[i - nums[j]];
            }
        }

        return dp[n];
    }
}
