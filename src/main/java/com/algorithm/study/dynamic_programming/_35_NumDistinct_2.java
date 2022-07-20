package com.algorithm.study.dynamic_programming;

/**
 * 115. 不同的子序列
 * dp优化时间复杂度：时间复杂度O(n*m)，空间复杂度O(n)
 *
 * 输入：s = "babgbag", t = "bag"
 * 输出：5
 * t是s的子序列，s能组成多少个这样的t
 *
 * dp[j]：截取下标[0,i-1]的s，截取下标[0,j-1]的t，t在s中出现的个数。
 *  需要将dp[j]均初始化为1
 *
 *  滚动数组需要使用逆序，虽然说依赖dp[i-1][j-1]，但是也能逆序，因为第i行的数据都是依赖第i-1行，所以第i行数据的计算结果，
 *  在第i-1行数据生成就已经注定了，和正序逆序并没有关系。
 *
 *  至于dp[0]=0，其实当s与t最初某个值x比较相等时，s和t同时去掉该值x，dp[j-1]至少需要为1，所以dp[0] = 1。
 *
 *  举例推导：s = "babgbag", t = "bag"
 *      b   a   g
 *   1  0   0   0
 * b 1  1   0   0
 * a 1  1   1   0
 * b 1  2   1   0
 * g 1  2   1   1
 * b 1  3   1   1
 * a 1  3   4   1
 * g 1  3   4   5
 *
 */
public class _35_NumDistinct_2 {

    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m < n) return 0;
        int[] dp = new int[t.length() + 1];
        char[] sCh = s.toCharArray();
        char[] tCh = t.toCharArray();
        dp[0] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = n; j >= 1; j--) {
                if (sCh[i - 1] == tCh[j - 1]) {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }

        return dp[n];
    }
}
