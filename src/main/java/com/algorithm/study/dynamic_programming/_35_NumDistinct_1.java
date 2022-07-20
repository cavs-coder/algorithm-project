package com.algorithm.study.dynamic_programming;

/**
 * 115. 不同的子序列
 * dp：时间复杂度O(n*m)，空间复杂度O(n*m)
 *
 * 输入：s = "babgbag", t = "bag"
 * 输出：5
 * t是s的子序列，s能组成多少个这样的t
 *
 * dp[i][j]：截取下标[0,i-1]的s，截取下标[0,j-1]的t，t在s中出现的个数。
 *
 * 举例 ：s=abcc,t=abc
 * 为什么dp[i][j]不比较s[i] != t[j]，反而比较s[i-1] != t[j-1]，因为dp[i][j]初始化为dp[s.length+1][t.length+1]，前面多了一行一列。
 *
 * 一：若是当前s[i-1] != t[j-1]，说明刚遍历到的s元素s[i-1]影响不到 此时的子序列即[0,j-1]的t 在s中的个数,
 *      比如比较abcd与abc，i=4，j=3时：
 *      s[i-1]=s[3]=d不必参与组成子序列，所以计算s=abc有多少个t=abc，此个数即等于：s=abcd有多少个t=abc
 *      所以取前一步旧的s中t的个数，即dp[i][j] = dp[i-1][j]。
 *
 * 二：若是当前s[i-1] == t[j-1]，则分两种情况，比如比较abcc与abc，i=4，j=3时：
 *      1、当前s[i-1]不参与t组成的子序列，则应该去除s[i-1]，即去除s下标4-1=3处的c，
 *         计算abc中有多少个abc，假设存在，则t=abc最后一个c一定是在s=abc中已经有出现过，这是前一步旧的s中t的个数。
 *         此部分的t对应s的种类为：dp[i-1][j]
 *      2、当前s[i-1]要参与t组成的子序列，则应该同时去除s[i-1]与t[i-1]，即去除s下标4-1=3处的c，与t下标3-1=2处的c，
 *         计算abc中有多少个ab，此个数等于两者同时加c的个数，此个数为：dp[i-1][j-1]。此时t=abc的c对应的是s=abcc中新增的i=3的c，
 *         这里t对应s的种类都是新增的。
 *      所以应该用 前一步旧的s中t的个数 + 新增的t对应s的种类，即：dp[i][j] = dp[i-1][j] + dp[i-1][j-1]
 *
 *  初始化：dp[i][0]表示t为空字符串""，可以理解为s中含空串个数都为1，dp[i][0] = 1，
 *         其实当s与t最初某个值x比较相等时，s和t同时去掉该值x，dp[i-1][j-1]至少需要为1，所以dp[i][0] = 1。
 *         而dp[0][j]在j范围[1,t.length]中，表示s为空串，组成不了t，所以dp[0][j] = 0
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
public class _35_NumDistinct_1 {

    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m < n) return 0;
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        char[] sCh = s.toCharArray();
        char[] tCh = t.toCharArray();
        for (int i = 0; i <= m; i++) dp[i][0] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (sCh[i - 1] == tCh[j - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }
}
