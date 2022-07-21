package com.algorithm.study.dynamic_programming;

/**
 * 516. 最长回文子序列
 *
 * dp：时间复杂度O(n^2)，空间复杂度O(n^2)
 *
 * dp[i][j]：下标i到下标j的s，即s[i,j]最长的回文子序列长度
 *
 * sCh[i] == sCh[j]，即为下标i+1到下标j-1的s最长的回文子序列长度加上2个元素，即dp[i][j] = dp[i+1][j-1] + 2
 * sCh[i] != sCh[j]，s[i,j]被分为s[i+1,j]和s[i,j-1]两个部分，比较哪一个回文子序列长度长，即dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1])
 *
 * 可以dp[i][j]依赖于左下方的dp[i+1][j-1] ，依赖于正下方的dp[i+1][j]，依赖于正左边的dp[i][j-1]，所以遍历顺序i应从下往上，j从左往右并且j>=i+1,
 * 这样一来，第一个右上方dp[n-2][n-1]才有值。
 *
 * 子序列长度斜对角线[0,0]==>[n-1,n-1]的直线，元素都一一对应，dp[i][j]==>i==j==>dp[i][i]，它们的序列长度初始化为1，即dp[i][i] = 1，
 *  这样初始化，[0,1]==>[n-2,n-1]的第二条斜线才能顺利推进取得到值。
 *
 *  本题最重要的是初始化dp[i][i] = 1，然后是遍历顺序 i逆序，j正序并且j=i+1，保证[0,1]==>[n-2,n-1]的第二条斜线，以及后续第n条斜线才能顺利推进取得到值。
 *
 *  举例推导：bbbab
 *        0  1  2  3  4
 *        b  b  b  a  b
 *  0 b   1  2  3  3  4
 *  1 b      1  2  2  3
 *  2 b         1  1  3
 *  3 a            1  1
 *  4 b               1
 *
 */
public class _40_LongestPalindromeSubseq_1 {

    public int longestPalindromeSubseq(String s) {
        char[] sCh = s.toCharArray();
        int n = sCh.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (sCh[i] == sCh[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }
}
