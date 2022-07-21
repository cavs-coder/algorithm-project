package com.algorithm.study.dynamic_programming;

/**
 * 5. 最长回文子串
 *    (647. 回文子串变形题)
 * dp：时间复杂度O(n^2)，空间复杂度O(n^2)
 */
public class _39_LongestPalindrome_2 {

    public String longestPalindrome(String s) {
        char[] sCh = s.toCharArray();
        int l = sCh.length;
        int[][] dp = new int[l][l];
        int len = -1;
        int start = -1;
        for (int j = 0; j < l; j++) {
            for (int i = 0; i <= j; i++) {
                if (sCh[j] == sCh[i] && ((j - i <= 2) || dp[i + 1][j - 1] == 1)) {
                    dp[i][j] = 1;
                    if (j - i + 1 > len) {
                        len = j - i + 1;
                        start = i;
                    }
                }
            }
        }
        return new String(sCh, start, len);
    }
}
